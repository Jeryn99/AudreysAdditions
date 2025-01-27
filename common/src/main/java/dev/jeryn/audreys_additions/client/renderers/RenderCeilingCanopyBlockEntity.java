package dev.jeryn.audreys_additions.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.client.models.furniture.FoodMachineModel;
import dev.jeryn.audreys_additions.common.blockentity.CeilingCanopyBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.FoodMachineBlockEntity;
import dev.jeryn.audreys_additions.common.blocks.CeilingCanopyBlock;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import whocraft.tardis_refined.client.model.GenericModel;

public class RenderCeilingCanopyBlockEntity implements BlockEntityRenderer<CeilingCanopyBlockEntity>, BlockEntityRendererProvider<CeilingCanopyBlockEntity> {

    private static final ResourceLocation CEILING_CANOPY = new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/ceiling_canopy.png");
    private static final ResourceLocation CEILING_CANOPY_HANGING = new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/ceiling_canopy_hanging.png");
    private static final ResourceLocation CEILING_CANOPY_EMISSIVE = new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/ceiling_canopy_emissive.png");

    private final GenericModel ceilingCanopy, ceilingCanopyHanging;

    public RenderCeilingCanopyBlockEntity(Context context) {
        ceilingCanopy = new GenericModel(context.bakeLayer(AUDModelRegistry.CEILING_CANOPY));
        ceilingCanopyHanging = new GenericModel(context.bakeLayer(AUDModelRegistry.CEILING_CANOPY_HANGING));
    }

    @Override
    public void render(CeilingCanopyBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 1.5, 0.5D);

        BlockState blockstate = blockEntity.getBlockState();
        poseStack.mulPose(Axis.ZP.rotationDegrees(180));
        poseStack.mulPose(Axis.YP.rotationDegrees(blockstate.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot()));

        if(blockEntity.getBlockState().getValue(CeilingCanopyBlock.HANGING)) {
            poseStack.translate(0,1, 0);
            ceilingCanopyHanging.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(CEILING_CANOPY_HANGING)), packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
            ceilingCanopyHanging.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucentEmissive(CEILING_CANOPY_EMISSIVE)), packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        } else {
            ceilingCanopy.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(CEILING_CANOPY)), packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
            ceilingCanopy.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucentEmissive(CEILING_CANOPY_EMISSIVE)), packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        }

        poseStack.popPose();
    }


    @Override
    public BlockEntityRenderer<CeilingCanopyBlockEntity> create(Context context) {
        return new RenderCeilingCanopyBlockEntity(context);
    }
}