package dev.jeryn.audreys_additions.common.blockentity;

import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class DyeableBlockEntity extends BlockEntity {

    private int colour = -1;

    public DyeableBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);

        colour = AudBlocks.ARMCHAIR.get() == blockState.getBlock() ? DyeColor.RED.getTextColor() : DyeColor.WHITE.getTextColor();

    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }


    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag);
        return tag;
    }


    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
        this.sendUpdates();
    }

    public void saveDye(CompoundTag tag) {
        tag.putInt("DyeColour", colour);
    }

    public void loadDye(CompoundTag tag) {
        if (tag.contains("DyeColour")) {
            this.colour = tag.getInt("DyeColour");
            if (level != null && level.isClientSide) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 8);
            }
        }
    }

    public void sendUpdates() {
        if (level != null && getBlockState() != null && getBlockState().getBlock() != null) {
            level.updateNeighbourForOutputSignal(worldPosition, getBlockState().getBlock());
            level.sendBlockUpdated(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition), Block.UPDATE_ALL);
        }
        setChanged();
    }

}
