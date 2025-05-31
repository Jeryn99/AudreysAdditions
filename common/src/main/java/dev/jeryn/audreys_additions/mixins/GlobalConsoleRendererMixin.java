package dev.jeryn.audreys_additions.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.CatVariantHolder;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.CatVariant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import whocraft.tardis_refined.client.renderer.blockentity.console.GlobalConsoleRenderer;
import whocraft.tardis_refined.common.blockentity.console.GlobalConsoleBlockEntity;

@Mixin(GlobalConsoleRenderer.class)
public class GlobalConsoleRendererMixin {


    @Inject(
            method = "render(Lwhocraft/tardis_refined/common/blockentity/console/GlobalConsoleBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    private void audreysAdditions$render(
            GlobalConsoleBlockEntity blockEntity,
            float partialTick,
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight,
            int packedOverlay,
            CallbackInfo ci
    ) {
        if (AUDModelRegistry.cat == null ||
                !blockEntity.theme().getPath().contains("human_nature") ||
                blockEntity.pattern().id().getPath().contains("no_cat")) {
            return;
        }

        ResourceLocation catLocation = ((CatVariantHolder) blockEntity).getCatVariant();
        if (catLocation == null || !BuiltInRegistries.CAT_VARIANT.containsKey(catLocation)) {
            catLocation = CatVariant.ALL_BLACK.location();
        }

        CatVariant catVariant = BuiltInRegistries.CAT_VARIANT.get(catLocation);
        if (catVariant == null) return;

        RenderType renderType = RenderType.entityCutout(catVariant.texture());
        AUDModelRegistry.cat.renderCat(
                blockEntity,
                blockEntity.getLevel(),
                poseStack,
                bufferSource.getBuffer(renderType),
                packedLight,
                packedOverlay,
                1f, 1f, 1f, 1f
        );
    }




}
