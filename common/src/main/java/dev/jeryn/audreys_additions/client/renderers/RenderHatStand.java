package dev.jeryn.audreys_additions.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.client.models.GenericHatStandModel;
import dev.jeryn.audreys_additions.common.blockentity.HatstandBlockEntity;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import whocraft.tardis_refined.client.model.GenericModel;

import java.util.Map;
import java.util.Objects;

public class RenderHatStand implements BlockEntityRenderer<HatstandBlockEntity>, BlockEntityRendererProvider<HatstandBlockEntity> {

    private static final Map<Block, ResourceLocation> HATSTAND_TEXTURES = Map.of(
            AudBlocks.HATSTAND_BAMBOO.get(), new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_bamboo.png"),
            AudBlocks.HATSTAND_CHERRY.get(), new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_cherry.png"),
            AudBlocks.HATSTAND_CRIMSON.get(), new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_crimson.png"),
            AudBlocks.HATSTAND_DARK_OAK.get(), new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_dark_oak.png"),
            AudBlocks.HATSTAND_MANGROVE.get(), new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_mangrove.png"),
            AudBlocks.HATSTAND.get(), new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand.png")
    );
    private final GenericHatStandModel hatStandBamboo;
    private final GenericHatStandModel hatStandCherry;
    private final GenericHatStandModel hatStandCrimson;
    private final GenericHatStandModel hatStandDarkOak;
    private final GenericHatStandModel hatStandMangrove;
    private final GenericHatStandModel hatstand;
    private GenericHatStandModel hatStandMain;

    public RenderHatStand(Context context) {
        hatStandBamboo = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_BAMBOO), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {

            }
        });
        hatStandCherry = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_CHERRY), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {

            }
        });
        hatStandCrimson = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_CRIMSON), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {

            }
        });
        hatStandDarkOak = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_DARK_OAK), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {

            }
        });
        hatStandMangrove = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_MANGROVE), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {

            }
        });
        hatstand = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {

            }
        });
    }

    private GenericHatStandModel getModelForBlock(BlockState state) {
        if (state.is(AudBlocks.HATSTAND_BAMBOO.get())) return hatStandBamboo;
        if (state.is(AudBlocks.HATSTAND_CHERRY.get())) return hatStandCherry;
        if (state.is(AudBlocks.HATSTAND_CRIMSON.get())) return hatStandCrimson;
        if (state.is(AudBlocks.HATSTAND_DARK_OAK.get())) return hatStandDarkOak;
        if (state.is(AudBlocks.HATSTAND_MANGROVE.get())) return hatStandMangrove;
        if (state.is(AudBlocks.HATSTAND.get())) return hatstand;
        return hatStandMain;
    }

    private ResourceLocation getTextureForBlock(BlockState state) {
        return HATSTAND_TEXTURES.get(state.getBlock());
    }


    @Override
    public void render(HatstandBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 1.5, 0.5D); // move to center of block

        BlockState state = blockEntity.getBlockState();

        BlockState blockState = blockEntity.getBlockState();
        poseStack.mulPose(Axis.ZP.rotationDegrees(180));
        poseStack.mulPose(Axis.YP.rotationDegrees(blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot()));
        hatStandMain = getModelForBlock(state);
        // Render hatstand model
        hatStandMain.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(Objects.requireNonNull(getTextureForBlock(state)))), packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);

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

            // ===== DEBUG START =====
            hatStandMain.setPositioner(new GenericHatStandModel.Positioner() {
                @Override
                public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {
                    //hello audrey!
                    //negatives are allowed

                    //rotations:
                    //X rotation by 90 degress
                    poseStack.mulPose(Axis.XP.rotationDegrees(90));

                    //Y rotation by 90 degress
                    poseStack.mulPose(Axis.YP.rotationDegrees(90));

                    //Z rotation by 90 degress
                    poseStack.mulPose(Axis.ZP.rotationDegrees(90));

                    //scales:
                    //scale by 1.5F
                    poseStack.scale(1.5F,1.5F,1.5F);

                    //transform:
                    //uhh hard to explain, this goes by X Y Z, will move by 1 in each direction, 1 is _kinda_ a full block
                    poseStack.translate(1,1,1);
                }

                @Override
                public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {

                }

            });
            // ===== DEBUG END =====

            hatStandMain.getPositioner().positionSlot(i, stack, poseStack);


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




    @Override
    public BlockEntityRenderer<HatstandBlockEntity> create(Context context) {
        return new RenderHatStand(context);
    }
}
