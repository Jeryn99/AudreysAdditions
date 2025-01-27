package dev.jeryn.audreys_additions.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
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

public class RenderFoodMachineBlockEntity implements BlockEntityRenderer<FoodMachineBlockEntity>, BlockEntityRendererProvider<FoodMachineBlockEntity> {

    private static final ResourceLocation texture = new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/food_machine.png");
    private static final ResourceLocation lightmap = new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/food_machine_emissive.png");

    private final FoodMachineModel foodMachine;

    public RenderFoodMachineBlockEntity(Context context) {
        foodMachine = new FoodMachineModel(context.bakeLayer(AUDModelRegistry.FOOD_MACHINE));
    }

    @Override
    public void render(FoodMachineBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 1.5, 0.5D);

        BlockState blockstate = blockEntity.getBlockState();
        poseStack.mulPose(Axis.ZP.rotationDegrees(180));
        poseStack.mulPose(Axis.YP.rotationDegrees(blockstate.getValue(BlockStateProperties.ROTATION_16).floatValue() * 22.5F));
        foodMachine.renderToBuffer(blockEntity, poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(texture)), packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        foodMachine.renderToBuffer(blockEntity, poseStack, bufferSource.getBuffer(RenderType.entityTranslucentEmissive(lightmap)), packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        poseStack.popPose();
    }


    @Override
    public BlockEntityRenderer<FoodMachineBlockEntity> create(Context context) {
        return new RenderFoodMachineBlockEntity(context);
    }
}