package dev.jeryn.audreys_additions.common.blockentity;

import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CeilingCanopyBlockEntity extends BlockEntity {

    public CeilingCanopyBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(AudBlockEntities.CEILING_CANOPY.get(), blockPos, blockState);
    }
}
