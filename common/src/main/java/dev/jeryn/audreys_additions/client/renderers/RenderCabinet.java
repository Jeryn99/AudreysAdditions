package dev.jeryn.audreys_additions.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.blockentity.KnossosChairBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.cabinet.CabinetBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import whocraft.tardis_refined.client.model.GenericModel;

public class RenderCabinet implements BlockEntityRenderer<CabinetBlockEntity>, BlockEntityRendererProvider<CabinetBlockEntity> {

    private final GenericModel cabinet;

    public RenderCabinet(Context context) {
        cabinet = new GenericModel(context.bakeLayer(AUDModelRegistry.CABINET_INV));
    }

    @Override
    public void render(CabinetBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 1.5, 0.5D);

        BlockState blockstate = blockEntity.getBlockState();
        poseStack.mulPose(Axis.ZP.rotationDegrees(180));
        poseStack.mulPose(Axis.YP.rotationDegrees(blockstate.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot()));
        String variant = blockEntity.getCurrentVariant();
        ResourceLocation texture = new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/cabinet/"+ variant +".png");
        cabinet.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(texture)), packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        poseStack.popPose();
    }



    @Override
    public BlockEntityRenderer<CabinetBlockEntity> create(Context context) {
        return new RenderCabinet(context);
    }
}