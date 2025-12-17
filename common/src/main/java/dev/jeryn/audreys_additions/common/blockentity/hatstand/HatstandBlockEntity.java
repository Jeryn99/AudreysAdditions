package dev.jeryn.audreys_additions.common.blockentity.hatstand;

import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class HatstandBlockEntity extends BlockEntity {

    private final SimpleContainer inventory = new SimpleContainer(4) {
        @Override
        public boolean stillValid(Player player) {
            return true;
        }
    };

    public HatstandBlockEntity(BlockPos pos, BlockState state) {
        super(AudBlockEntities.HAT_STAND.get(), pos, state);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void sendUpdates() {
        if (level != null && getBlockState() != null && getBlockState().getBlock() != null) {
            level.updateNeighbourForOutputSignal(worldPosition, getBlockState().getBlock());
            level.sendBlockUpdated(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition), Block.UPDATE_ALL);
        }
        setChanged();
    }

    public SimpleContainer getInventory() {
        return inventory;
    }

    // --- Save to NBT ---
    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        inventory.fromTag(tag.getList("clothing", Tag.TAG_COMPOUND));
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundTag = new CompoundTag();
        saveAdditional(compoundTag);
        System.out.println(compoundTag);
        return compoundTag;
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        System.out.println(inventory.createTag());
        tag.put("clothing", inventory.createTag());
    }
}
