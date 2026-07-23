package dev.jeryn.audreys_additions.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.blockentity.KnossosChairBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.cabinet.CabinetBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import whocraft.tardis_refined.client.model.GenericModel;

public class RenderCabinet implements BlockEntityRenderer<CabinetBlockEntity>, BlockEntityRendererProvider<CabinetBlockEntity> {

    private final GenericModel cabinet;
    ModelPart leftDoor;
    ModelPart rightDoor;

    public RenderCabinet(Context context) {
        cabinet = new GenericModel(context.bakeLayer(AUDModelRegistry.CABINET_INV));
        rightDoor = (ModelPart) cabinet.getAnyDescendantWithName("right_door").get();
        leftDoor = (ModelPart) cabinet.getAnyDescendantWithName("left_door").get();
    }

    private static final float[][] SLOT_POSITIONS = {
            {0.234375f, 1.828125f, 0.078125f},
            {-0.234375f, 1.828125f, 0.078125f},
            {0.234375f, 1.359375f, 0.078125f},
            {-0.234375f, 1.359375f, 0.078125f},
            {0.234375f, 0.890625f, 0.078125f},
            {-0.234375f, 0.890625f, 0.078125f},
            {0.234375f, 0.421875f, 0.078125f},
            {-0.234375f, 0.421875f, 0.078125f}
    };

    @Override
    public void render(CabinetBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 1.5, 0.5D);

        BlockState blockstate = blockEntity.getBlockState();
        poseStack.mulPose(Axis.ZP.rotationDegrees(180));
        poseStack.mulPose(Axis.YP.rotationDegrees(blockstate.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot()));
        String variant = blockEntity.getCurrentVariant();
        ResourceLocation texture = new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/cabinet/"+ variant +".png");
        float openProgress = blockEntity.isOpen() ? 1.0F : 0.0F;

        leftDoor.yRot = (float)Math.toRadians(90 * openProgress);
        rightDoor.yRot = (float)Math.toRadians(-90 * openProgress);
        cabinet.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(texture)), packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);

        if (blockEntity.isOpen()) {
            SimpleContainer inventory = blockEntity.getInventory();


            for(int i = 0; i < inventory.getContainerSize(); i++) {
                ItemStack stack = inventory.getItem(i);

                if (!stack.isEmpty()) {
                    poseStack.pushPose();

                    poseStack.translate(
                            SLOT_POSITIONS[i][0]*-1,
                            (SLOT_POSITIONS[i][1]*-1)+1.5f,
                            (SLOT_POSITIONS[i][2]*-1)+0.125f
                    );

                    poseStack.scale(-0.325F,-0.325F,0.325F);

                    renderItem(
                            poseStack,
                            bufferSource,
                            stack,
                            0,0,0
                    );

                    poseStack.popPose();
                }
            }
        }

        poseStack.popPose();
    }

    private void renderItem(PoseStack poseStack, MultiBufferSource buffer, ItemStack stack, float x, float y, float z) {
        Minecraft.getInstance()
                .getItemRenderer()
                .renderStatic(
                        stack,
                        ItemDisplayContext.FIXED,
                        15728880,
                        OverlayTexture.NO_OVERLAY,
                        poseStack,
                        buffer,
                        null,
                        0
                );
    }

    @Override
    public BlockEntityRenderer<CabinetBlockEntity> create(Context context) {
        return new RenderCabinet(context);
    }
}