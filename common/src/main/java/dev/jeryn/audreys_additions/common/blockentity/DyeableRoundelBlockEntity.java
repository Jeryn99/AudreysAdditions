package dev.jeryn.audreys_additions.common.blockentity;

import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class DyeableRoundelBlockEntity extends DyeableBlockEntity {

    public DyeableRoundelBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(AudBlockEntities.DYEABLE_ROUNDEL.get(), blockPos, blockState);
    }
}
