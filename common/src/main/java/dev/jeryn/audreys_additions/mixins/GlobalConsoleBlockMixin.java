package dev.jeryn.audreys_additions.mixins;

import dev.jeryn.audreys_additions.CatVariantHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import whocraft.tardis_refined.common.block.console.GlobalConsoleBlock;
import whocraft.tardis_refined.common.blockentity.console.GlobalConsoleBlockEntity;

import java.util.Optional;

@Mixin(GlobalConsoleBlock.class)
public class GlobalConsoleBlockMixin {

    @Inject(
            method = "onPlace(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Z)V",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl, CallbackInfo ci) {
        BlockEntity self = level.getBlockEntity(blockPos);
        if (self instanceof GlobalConsoleBlockEntity globalConsoleBlockEntity) {
            if (level instanceof ServerLevel) {
                Optional<Holder.Reference<CatVariant>> catVariant = BuiltInRegistries.CAT_VARIANT.getRandom(level.getRandom());
                if (self instanceof CatVariantHolder catVariantHolder) {
                    catVariant.ifPresent(catVariantReference -> catVariantHolder.setCatVariant(catVariantReference.key().location()));
                    globalConsoleBlockEntity.sendUpdates();
                }
            }
        }
    }


}
