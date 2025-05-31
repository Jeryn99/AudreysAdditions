package dev.jeryn.audreys_additions.mixins;

import dev.jeryn.audreys_additions.CatVariantHolder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.animal.CatVariant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import whocraft.tardis_refined.common.blockentity.console.GlobalConsoleBlockEntity;

import java.util.Optional;

@Mixin(GlobalConsoleBlockEntity.class)
public class GlobalConsoleBlockMixin {

    @Inject(
            method = "spawnControlEntities()V",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    public void spawnControlEntities(CallbackInfo ci) {
        GlobalConsoleBlockEntity self = (GlobalConsoleBlockEntity) (Object) this;
        if (self.getLevel() instanceof ServerLevel) {
            Optional<Holder.Reference<CatVariant>> catVariant = BuiltInRegistries.CAT_VARIANT.getRandom(self.getLevel().getRandom());
            if (self instanceof CatVariantHolder catVariantHolder) {
                catVariant.ifPresent(catVariantReference -> catVariantHolder.setCatVariant(catVariantReference.key().location()));
                self.sendUpdates();
                }
            }

    }


}
