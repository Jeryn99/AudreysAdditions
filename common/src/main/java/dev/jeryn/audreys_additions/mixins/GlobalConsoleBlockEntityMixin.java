package dev.jeryn.audreys_additions.mixins;

import dev.jeryn.audreys_additions.CatVariantHolder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import whocraft.tardis_refined.common.blockentity.console.GlobalConsoleBlockEntity;

import java.util.Optional;

@Mixin(GlobalConsoleBlockEntity.class)
public class GlobalConsoleBlockEntityMixin implements CatVariantHolder {

    @Unique
    private ResourceLocation audreysAdditions$catVariantId = CatVariant.ALL_BLACK.location();

    @Unique
    @Override
    public ResourceLocation getCatVariant() {
        return audreysAdditions$catVariantId;
    }

    @Unique
    @Override
    public void setCatVariant(ResourceLocation variant) {
        this.audreysAdditions$catVariantId = variant;
    }

    @Inject(method = "setConsoleTheme(Lnet/minecraft/resources/ResourceLocation;)V", at = @At("HEAD"), remap = false)
    private void setConsoleTheme(ResourceLocation themeId, CallbackInfo ci) {
        GlobalConsoleBlockEntity self = (GlobalConsoleBlockEntity) (Object) this;
        if(self.theme().getNamespace().contains("human_nature")) {
            Level level = self.getLevel();
            if (level instanceof ServerLevel) {
                Optional<Holder.Reference<CatVariant>> catVariant = BuiltInRegistries.CAT_VARIANT.getRandom(self.getLevel().getRandom());
                if (self instanceof CatVariantHolder catVariantHolder) {
                    catVariant.ifPresent(catVariantReference -> catVariantHolder.setCatVariant(catVariantReference.key().location()));
                }
            }
        }
    }

    @Inject(method = "saveAdditional", at = @At("TAIL"))
    private void onSaveAdditional(CompoundTag tag, CallbackInfo ci) {
        if (this.audreysAdditions$catVariantId != null) {
            tag.putString("cat_variant", this.audreysAdditions$catVariantId.toString());
        }
    }

    @Inject(method = "load", at = @At("TAIL"))
    private void onLoad(CompoundTag tag, CallbackInfo ci) {
        if (tag.contains("cat_variant")) {
            this.audreysAdditions$catVariantId = new ResourceLocation(tag.getString("cat_variant"));
        }
    }
}
