package dev.jeryn.audreys_additions.client.models.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.blockentity.KnossosChairBlockEntity;
import dev.jeryn.audreys_additions.blocks.ChairBaseBlock;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import whocraft.tardis_refined.client.model.GenericModel;

public class RenderKnossosChairBlockEntity implements BlockEntityRenderer<KnossosChairBlockEntity>, BlockEntityRendererProvider<KnossosChairBlockEntity> {

    private final GenericModel chair;

    public RenderKnossosChairBlockEntity(Context context) {
        chair = new GenericModel(context.bakeLayer(AUDModelRegistry.KNOSSOS_THRONE));
    }

    @Override
    public void render(KnossosChairBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 1.5, 0.5D);

        BlockState blockstate = blockEntity.getBlockState();
        poseStack.mulPose(Axis.ZP.rotationDegrees(180));
        poseStack.mulPose(Axis.YP.rotationDegrees(blockstate.getValue(BlockStateProperties.ROTATION_16).floatValue() * 22.5F));
        ResourceLocation texture = new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/knossos_throne/"+ blockEntity.getCurrentVariant() +".png");
        chair.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(texture)), packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        poseStack.popPose();
    }



    @Override
    public BlockEntityRenderer<KnossosChairBlockEntity> create(Context context) {
        return new RenderKnossosChairBlockEntity(context);
    }
}