package dev.jeryn.audreys_additions.blockentity;

import dev.jeryn.audreys_additions.blocks.ChairBlock;
import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import dev.jeryn.audreys_additions.entity.ChairEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ChairBlockEntity extends BlockEntity {

    public ChairEntity chairEntity = null;

    public ChairBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(AudBlockEntities.KNOSSOS_THRONE.get(), blockPos, blockState);
    }

    public ChairEntity getChairEntity() {
        return chairEntity;
    }

    public void setChairEntity(ChairEntity chairEntity) {
        this.chairEntity = chairEntity;

        if (level.getBlockState(getBlockPos()).hasProperty(ChairBlock.ROTATION)) {
            Integer rotation = level.getBlockState(getBlockPos()).getValue(ChairBlock.ROTATION);
            this.chairEntity.setYBodyRot(rotation);
        }
    }


}
