package dev.jeryn.audreys_additions.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.blockentity.HatstandBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import whocraft.tardis_refined.client.model.GenericModel;

public class RenderHatStand implements BlockEntityRenderer<HatstandBlockEntity>, BlockEntityRendererProvider<HatstandBlockEntity> {

    private static final ResourceLocation HAT_STAND = new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hat_stand.png");

    private final GenericModel hatStand;

    public RenderHatStand(Context context) {
        hatStand = new GenericModel(context.bakeLayer(AUDModelRegistry.HAT_STAND));
    }

    @Override
    public void render(HatstandBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 1.5, 0.5D); // move to center of block

        BlockState blockState = blockEntity.getBlockState();
        poseStack.mulPose(Axis.ZP.rotationDegrees(180));
        poseStack.mulPose(Axis.YP.rotationDegrees(blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot()));

        // Render hatstand model
        hatStand.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(HAT_STAND)), packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);

        // Render items on the stand
        renderItems(blockEntity, poseStack, bufferSource, packedLight, packedOverlay);

        poseStack.popPose();
    }

    private void renderItems(HatstandBlockEntity blockEntity, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        var itemRenderer = Minecraft.getInstance().getItemRenderer();
        var entityModels = Minecraft.getInstance().getEntityModels();

        // Armor models
        HumanoidModel<LivingEntity> innerModel = new HumanoidModel<>(entityModels.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR));
        HumanoidModel<LivingEntity> outerModel = new HumanoidModel<>(entityModels.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR));

        for (int i = 0; i < 4; i++) {
            ItemStack stack = blockEntity.getInventory().getItem(i);
            if (stack.isEmpty()) continue;

            poseStack.pushPose();

            // Apply position/scale/rotation first
            positionSlot(i, stack, poseStack);

            if (stack.getItem() instanceof ArmorItem armorItem) {
                EquipmentSlot slot = armorItem.getEquipmentSlot();
                HumanoidModel<LivingEntity> armorModel = slot == EquipmentSlot.LEGS ? innerModel : outerModel;

                new HumanoidModel<>(entityModels.bakeLayer(ModelLayers.PLAYER)).copyPropertiesTo(armorModel);

                armorModel.setAllVisible(false);
                switch (slot) {
                    case HEAD -> {
                        armorModel.head.visible = true;
                        armorModel.hat.visible = true;
                    }
                    case CHEST -> {
                        armorModel.body.visible = true;
                        armorModel.leftArm.visible = true;
                        armorModel.rightArm.visible = true;
                    }
                    case LEGS -> {
                        armorModel.body.visible = true;
                        armorModel.leftLeg.visible = true;
                        armorModel.rightLeg.visible = true;
                    }
                    case FEET -> {
                        armorModel.leftLeg.visible = true;
                        armorModel.rightLeg.visible = true;
                    }
                }

                VertexConsumer buffer = bufferSource.getBuffer(RenderType.armorCutoutNoCull(
                        new ResourceLocation("minecraft", "textures/models/armor/" + armorItem.getMaterial().getName() + "_layer_" + (slot == EquipmentSlot.LEGS ? 2 : 1) + ".png")
                ));
                armorModel.renderToBuffer(poseStack, buffer, packedLight, packedOverlay, 1f, 1f, 1f, 1f);

            } else {
                poseStack.mulPose(Axis.XP.rotationDegrees(180));
                itemRenderer.renderStatic(stack, i == 0 ? ItemDisplayContext.HEAD : ItemDisplayContext.GROUND, packedLight, packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), i);
            }

            poseStack.popPose();
        }
    }

    private void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {
        // Slots go from 0 to 3
        poseStack.scale(1.5F, 1.5F, 1.5F);
        poseStack.translate(0, -.5, 0);
        //Any rendering changes go here
        if (slotIndex == 0) {

        }

    }


    @Override
    public BlockEntityRenderer<HatstandBlockEntity> create(Context context) {
        return new RenderHatStand(context);
    }
}
