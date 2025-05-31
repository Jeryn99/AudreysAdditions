package dev.jeryn.audreys_additions.mixins;

import dev.jeryn.audreys_additions.CatVariantHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import whocraft.tardis_refined.common.blockentity.console.GlobalConsoleBlockEntity;

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

    @Inject(method = "tick(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lwhocraft/tardis_refined/common/blockentity/console/GlobalConsoleBlockEntity;)V", at = @At("HEAD"))
    public void tick(Level level, BlockPos blockPos, BlockState blockState, GlobalConsoleBlockEntity blockEntity, CallbackInfo ci) {
        if (blockEntity != null && blockEntity.pattern() != null && blockEntity.pattern().id() != null) {
            if ("human_nature".equals(blockEntity.pattern().id().getPath())) {
                if (!level.isClientSide) {
                    // 1 in 400 chance per tick
                    if (level.random.nextInt(400) == 0) {
                        SoundEvent[] catSounds = new SoundEvent[] {
                                SoundEvents.CAT_AMBIENT,
                                SoundEvents.CAT_STRAY_AMBIENT,
                                SoundEvents.CAT_PURR,
                                SoundEvents.CAT_PURREOW
                        };

                        SoundEvent randomCatSound = catSounds[level.random.nextInt(catSounds.length)];

                        level.playSound(
                                null,
                                blockPos,
                                randomCatSound,
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                        );
                    }
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
