package dev.jeryn.audreys_additions.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.client.models.furniture.AstralMapModel;
import dev.jeryn.audreys_additions.client.models.furniture.FoldOutBedModel;
import dev.jeryn.audreys_additions.common.blockentity.AstralMapBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.FoldOutBedBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class RenderFoldOutBedBlockEntity implements BlockEntityRenderer<FoldOutBedBlockEntity>, BlockEntityRendererProvider<FoldOutBedBlockEntity> {

    public static final ResourceLocation texture = new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/foldout_bed.png");

    private final FoldOutBedModel foldOutBedModel;

    public RenderFoldOutBedBlockEntity(Context context) {
        foldOutBedModel = new FoldOutBedModel(context.bakeLayer(AUDModelRegistry.FOLD_OUT_BED));
    }

    @Override
    public void render(FoldOutBedBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 1.5, 0.5D);

        BlockState blockstate = blockEntity.getBlockState();
        poseStack.mulPose(Axis.ZP.rotationDegrees(180));
        poseStack.mulPose(Axis.YP.rotationDegrees(blockstate.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot()));
        foldOutBedModel.renderToBuffer(blockEntity, poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(texture)), packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        poseStack.popPose();
    }



    @Override
    public BlockEntityRenderer<FoldOutBedBlockEntity> create(Context context) {
        return new RenderFoldOutBedBlockEntity(context);
    }
}