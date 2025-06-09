package dev.jeryn.audreys_additions.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.client.models.furniture.SpecimenJarModel;
import dev.jeryn.audreys_additions.common.blockentity.SpecimenJarBlockEntity;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import dev.jeryn.frame.tardis.Frame;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import whocraft.tardis_refined.client.model.GenericModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RenderSpecimenJar implements BlockEntityRenderer<SpecimenJarBlockEntity>, BlockEntityRendererProvider<SpecimenJarBlockEntity> {

    private final Map<Block, RenderData> renderMap = new HashMap<>();

    public RenderSpecimenJar(Context context) {
        register(context, AudBlocks.SPECIMEN_JAR_ALLAY.get(), AUDModelRegistry.SPECIMEN_JAR_ALLAY, "specimen_jar_allay");
        register(context, AudBlocks.SPECIMEN_JAR_CREEPER.get(), AUDModelRegistry.SPECIMEN_JAR_CREEPER, "specimen_jar_creeper");
        register(context, AudBlocks.SPECIMEN_JAR_DRAGON.get(), AUDModelRegistry.SPECIMEN_JAR_DRAGON, "specimen_jar_dragon");
        register(context, AudBlocks.SPECIMEN_JAR_PIGLIN.get(), AUDModelRegistry.SPECIMEN_JAR_PIGLIN, "specimen_jar_piglin");
        register(context, AudBlocks.SPECIMEN_JAR_SKELETON.get(), AUDModelRegistry.SPECIMEN_JAR_SKELETON, "specimen_jar_skeleton");
        register(context, AudBlocks.SPECIMEN_JAR_VEX.get(), AUDModelRegistry.SPECIMEN_JAR_VEX, "specimen_jar_vex");
        register(context, AudBlocks.SPECIMEN_JAR_WITHERSKELETON.get(), AUDModelRegistry.SPECIMEN_JAR_WITHERSKELETON, "specimen_jar_wither_skeleton");
        register(context, AudBlocks.SPECIMEN_JAR_ZOMBIE.get(), AUDModelRegistry.SPECIMEN_JAR_ZOMBIE, "specimen_jar_zombie");
        register(context, AudBlocks.SPECIMEN_JAR.get(), AUDModelRegistry.SPECIMEN_JAR, "specimen_jar");
    }

    private void register(Context context, Block block, ModelLayerLocation modelLayer, String name) {
        ResourceLocation texture = new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/specimen_jar/" + name + ".png");
        ResourceLocation animation = new ResourceLocation(AudreysAdditions.MODID, "frame/specimen_jar/" + name + ".json");

        renderMap.put(block, new RenderData(
                new SpecimenJarModel(context.bakeLayer(modelLayer)).setAnimation(Objects.equals(name, "specimen_jar") ? null : Frame.loadAnimation(animation)),
                texture
        ));
    }

    @Override
    public void render(SpecimenJarBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        BlockState state = blockEntity.getBlockState();
        RenderData renderData = renderMap.get(state.getBlock());

        if (renderData == null) return;

        poseStack.pushPose();
        poseStack.translate(0.5D, 1.5D, 0.5D);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180));
        poseStack.mulPose(Axis.YP.rotationDegrees(state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot()));

        renderData.model.renderToBuffer(
                blockEntity,
                poseStack,
                bufferSource.getBuffer(RenderType.entityTranslucent(renderData.texture)),
                packedLight,
                OverlayTexture.NO_OVERLAY,
                1f, 1f, 1f, 1f
        );

        poseStack.popPose();

    }

    @Override
    public BlockEntityRenderer<SpecimenJarBlockEntity> create(Context context) {
        return new RenderSpecimenJar(context);
    }

    private static class RenderData {
        final SpecimenJarModel model;
        final ResourceLocation texture;

        RenderData(SpecimenJarModel model, ResourceLocation texture) {
            this.model = model;
            this.texture = texture;
        }
    }
}
