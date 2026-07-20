package dev.jeryn.audreys_additions.common.blockentity;

import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;

public class DyeableRoundelBlockEntity extends DyeableBlockEntity {

    public DyeableRoundelBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(AudBlockEntities.DYEABLE_ROUNDEL.get(), blockPos, blockState);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag);
        return tag;
    }


    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        saveDye(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        loadDye(tag);
    }
}
