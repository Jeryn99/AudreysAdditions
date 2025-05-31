package dev.jeryn.audreys_additions.mixins;

import dev.jeryn.audreys_additions.CatVariantHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
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
import whocraft.tardis_refined.common.capability.tardis.TardisLevelOperator;
import whocraft.tardis_refined.common.tardis.manager.TardisPilotingManager;
import whocraft.tardis_refined.registry.TRDimensionTypes;

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

    @Inject(method = "tick(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lwhocraft/tardis_refined/common/blockentity/console/GlobalConsoleBlockEntity;)V", at = @At("HEAD"))
    public void tick(Level level, BlockPos pos, BlockState state, GlobalConsoleBlockEntity blockEntity, CallbackInfo ci) {
        if (level == null || blockEntity == null || blockEntity.pattern() == null || blockEntity.pattern().id() == null) {
            return;
        }

        if (!(level instanceof ServerLevel serverLevel)) return;
        if (!"human_nature".equals(blockEntity.pattern().id().getPath())) return;
        if (!serverLevel.dimensionTypeId().equals(TRDimensionTypes.TARDIS)) return;

        if (blockEntity.getTicksBooting() == 2) {
            if (blockEntity.getLevel() instanceof ServerLevel) {
                Optional<Holder.Reference<CatVariant>> catVariant = BuiltInRegistries.CAT_VARIANT.getRandom(blockEntity.getLevel().getRandom());
                if (blockEntity instanceof CatVariantHolder catVariantHolder) {
                    catVariant.ifPresent(catVariantReference -> catVariantHolder.setCatVariant(catVariantReference.key().location()));
                    blockEntity.sendUpdates();
                }
            }

            TardisLevelOperator.get(serverLevel).

                    ifPresent(operator ->

                    {
                        TardisPilotingManager pilotingManager = operator.getPilotingManager();
                        boolean isCrashing = pilotingManager.isCrashing();
                        boolean isFlying = pilotingManager.isInFlight();

                        // 1 in 400 chance per tick
                        if (serverLevel.random.nextInt(400) != 0) return;

                        SoundEvent soundToPlay;
                        if (isCrashing) {
                            soundToPlay = SoundEvents.CAT_HISS;
                        } else {
                            SoundEvent[] catIdleSounds = {
                                    SoundEvents.CAT_AMBIENT,
                                    SoundEvents.CAT_STRAY_AMBIENT,
                                    SoundEvents.CAT_PURR,
                                    SoundEvents.CAT_PURREOW
                            };
                            soundToPlay = catIdleSounds[serverLevel.random.nextInt(catIdleSounds.length)];
                        }

                        serverLevel.playSound(
                                null,
                                pos,
                                soundToPlay,
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                        );
                    });

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
