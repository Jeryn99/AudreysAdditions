package dev.jeryn.audreys_additions.common.blockentity;

import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SpecimenJarBlockEntity extends BlockEntity {

    public final AnimationState animation = new AnimationState();

    public SpecimenJarBlockEntity(BlockPos pos, BlockState state) {
        super(AudBlockEntities.SPECIMEN_JAR.get(), pos, state);
    }
}
