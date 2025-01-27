package dev.jeryn.audreys_additions.common.blockentity;

import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AstralMapBlockEntity extends BlockEntity {
    public AstralMapBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(AudBlockEntities.ASTRAL_MAP.get(), blockPos, blockState);
    }
}
