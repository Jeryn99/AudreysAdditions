package dev.jeryn.audreys_additions.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.client.models.furniture.AstralMapModel;
import dev.jeryn.audreys_additions.common.blockentity.AstralMapBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.FoodMachineBlockEntity;
import dev.jeryn.audreys_additions.client.models.furniture.FoodMachineModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class RenderAstralMapBlockEntity implements BlockEntityRenderer<AstralMapBlockEntity>, BlockEntityRendererProvider<AstralMapBlockEntity> {

    public static final ResourceLocation texture = new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/astral_map.png");

    private final AstralMapModel astralMapModel;

    public RenderAstralMapBlockEntity(Context context) {
        astralMapModel = new AstralMapModel(context.bakeLayer(AUDModelRegistry.ASTRAL_MAP));
    }

    @Override
    public void render(AstralMapBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 1.5, 0.5D);

        BlockState blockstate = blockEntity.getBlockState();
        poseStack.mulPose(Axis.ZP.rotationDegrees(180));
        poseStack.mulPose(Axis.YP.rotationDegrees(blockstate.getValue(BlockStateProperties.ROTATION_16).floatValue() * 22.5F));
        astralMapModel.renderToBuffer(blockEntity, poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(texture)), packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        poseStack.popPose();
    }



    @Override
    public BlockEntityRenderer<AstralMapBlockEntity> create(Context context) {
        return new RenderAstralMapBlockEntity(context);
    }
}