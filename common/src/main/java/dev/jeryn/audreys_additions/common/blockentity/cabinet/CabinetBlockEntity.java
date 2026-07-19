package dev.jeryn.audreys_additions.common.blockentity.cabinet;

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

import java.util.Arrays;
import java.util.List;

public class CabinetBlockEntity extends BlockEntity {

    private final SimpleContainer inventory = new SimpleContainer(8) {
        @Override
        public boolean stillValid(Player player) {
            return true;
        }
    };

    private String currentVariant;

    private static final List<String> VARIANTS = Arrays.asList(
            "cabinet",
            "cabinet_acacia",
            "cabinet_bamboo",
            "cabinet_birch",
            "cabinet_cherry",
            "cabinet_crimson",
            "cabinet_dark_oak",
            "cabinet_jungle",
            "cabinet_mangrove",
            "cabinet_oak",
            "cabinet_spruce",
            "cabinet_warped"
    );

    public CabinetBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(AudBlockEntities.CABINET.get(), blockPos, blockState);
        this.currentVariant = VARIANTS.get(0);
}

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }


    private boolean open = false;

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
        sendUpdates();
    }

    public void toggleOpen() {
        this.open = !this.open;
        sendUpdates();
    }


    public String getCurrentVariant() {
        return currentVariant;
    }

    public void cycleVariant() {
        int currentIndex = VARIANTS.indexOf(currentVariant);
        int nextIndex = (currentIndex + 1) % VARIANTS.size();
        this.currentVariant = VARIANTS.get(nextIndex);
        sendUpdates();
        setChanged();
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);

        tag.putString("currentVariant", currentVariant);
        tag.putBoolean("open", open);
        tag.put("items", inventory.createTag());
    }




    @Override
    public void load(CompoundTag tag) {
        super.load(tag);

        inventory.fromTag(tag.getList("items", Tag.TAG_COMPOUND));

        if (tag.contains("currentVariant")) {
            currentVariant = tag.getString("currentVariant");
        }

        open = tag.getBoolean("open");
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



    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundTag = new CompoundTag();
        saveAdditional(compoundTag);
        return compoundTag;
    }

}
