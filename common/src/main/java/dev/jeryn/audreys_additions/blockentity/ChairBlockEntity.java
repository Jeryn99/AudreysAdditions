package dev.jeryn.audreys_additions.blockentity;

import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import dev.jeryn.audreys_additions.entity.ChairEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ChairBlockEntity extends BlockEntity {

    private ChairEntity chairEntity = null;
    private DyeColor colour = DyeColor.RED;

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

    public DyeColor getColour() {
        return colour;
    }

    public void setColour(DyeColor colour) {
        this.colour = colour;
        this.setChanged(); // Mark the block entity as changed
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("Colour", colour.getId());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("Colour")) {
            this.colour = DyeColor.byId(tag.getInt("Colour"));
        }
    }
}
