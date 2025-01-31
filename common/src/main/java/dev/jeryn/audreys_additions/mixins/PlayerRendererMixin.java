package dev.jeryn.audreys_additions.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.jeryn.audreys_additions.client.PlayerPose;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public class PlayerRendererMixin {

    @Inject(method = {"render(Lnet/minecraft/world/entity/LivingEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V"}, at = {@At(value = "HEAD")}, cancellable = true)
    private void audreysAdditions$render(LivingEntity livingEntity, float f, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, CallbackInfo ci) {
        if (livingEntity.isSleeping()) {
            livingEntity.getSleepingPos().ifPresent(sleepingPos -> {
                if (livingEntity.level().getBlockState(sleepingPos).getBlock() == AudBlocks.FOLD_OUT_BED.get()) {
                    poseStack.translate(0, PlayerPose.getPlayerBedOffset(), 0);
                }
            });
        }
    }


}
