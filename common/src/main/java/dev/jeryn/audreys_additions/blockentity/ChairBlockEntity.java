package dev.jeryn.audreys_additions.blockentity;

import dev.jeryn.audreys_additions.blocks.ChairBaseBlock;
import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import dev.jeryn.audreys_additions.entity.ChairEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ChairBlockEntity extends BlockEntity {

    private ChairEntity chairEntity = null;

    public ChairBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(AudBlockEntities.ARMCHAIR.get(), blockPos, blockState);
    }

    public ChairBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    public ChairEntity getChairEntity() {
        return chairEntity;
    }

    public void setChairEntity(ChairEntity chairEntity) {
        this.chairEntity = chairEntity;
    }


    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
    }
}