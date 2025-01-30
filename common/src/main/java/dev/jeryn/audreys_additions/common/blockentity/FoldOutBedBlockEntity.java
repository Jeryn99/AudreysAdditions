package dev.jeryn.audreys_additions.common.blockentity;

import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FoldOutBedBlockEntity extends BlockEntity {

    public final AnimationState FOLDING = new AnimationState();
    public final AnimationState UNFOLDING = new AnimationState();

    boolean isFolding = false;

    public FoldOutBedBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(AudBlockEntities.FOLD_OUT_BED.get(), blockPos, blockState);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag);
        return tag;
    }

    public void sendUpdates() {
        if (level != null && getBlockState() != null && getBlockState().getBlock() != null) {
            level.updateNeighbourForOutputSignal(worldPosition, getBlockState().getBlock());
            level.sendBlockUpdated(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition), 3);
        }
        setChanged();
    }

    public boolean isFolding() {
        return isFolding;
    }

    public void setFolding(boolean folding) {
        isFolding = folding;

        if(isFolding){
            FOLDING.start(12);
        } else {
            UNFOLDING.start(12);
        }
        sendUpdates();
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean("IsFolding", isFolding);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        setFolding(tag.getBoolean("IsFolding"));
    }
}
