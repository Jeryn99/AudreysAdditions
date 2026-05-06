package dev.jeryn.audreys_additions.common.blockentity.cabinet;

import dev.jeryn.audreys_additions.common.registry.AudMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

class CabinetInvWrapper extends SimpleContainer {
    private final CabinetBlockEntity blockEntity;

    public CabinetInvWrapper(CabinetBlockEntity be) {
        super(8);
        this.blockEntity = be;
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        super.setItem(slot, stack);
        if (blockEntity == null) return;
        blockEntity.getInventory().setItem(slot, stack);
        blockEntity.sendUpdates();
    }

    @Override
    public ItemStack removeItem(int slot, int count) {
        ItemStack removed = super.removeItem(slot, count);
        if (!removed.isEmpty() && blockEntity != null) {
            blockEntity.getInventory().setItem(slot, getItem(slot));
            blockEntity.sendUpdates();
        }
        return removed;
    }

}

public class CabinetMenu extends AbstractContainerMenu {

    public static final int ARMOR_START = 0;
    public static final int ARMOR_END = 8;

    public static final int INV_START = 8;

    public static final int HOTBAR_END = 40;

    private final ContainerLevelAccess access;
    private final CabinetInvWrapper inventoryWrapper;
    private final CabinetBlockEntity be;

    // ------- CLIENT CONSTRUCTOR -------
    public CabinetMenu(int id, Inventory inv, FriendlyByteBuf buf) {
        this(id, inv, ContainerLevelAccess.create(inv.player.level(), buf.readBlockPos()));
    }

    public CabinetMenu(int id, Inventory inventory) {
        this(id, inventory, ContainerLevelAccess.NULL);
    }

    public CabinetMenu(int id, Inventory playerInv, ContainerLevelAccess access) {
        super(AudMenus.CABINET.get(), id);
        this.access = access;

        be = access.evaluate(
                (level, pos) -> {
                    var entity = level.getBlockEntity(pos);
                    if (entity instanceof CabinetBlockEntity h) return h;
                    return null;
                },
                null
        );

        this.inventoryWrapper = new CabinetInvWrapper(be);
        if (be != null) {
            for (int i = 0; i < 4; i++) {
                inventoryWrapper.setItem(i, be.getInventory().getItem(i));
            }
            be.sendUpdates();
        }

        addSlot(new Slot(inventoryWrapper, 0, 68, 27));
        addSlot(new Slot(inventoryWrapper, 1, 92, 27));
        addSlot(new Slot(inventoryWrapper, 2, 68, 47));
        addSlot(new Slot(inventoryWrapper, 3, 92, 47));
        addSlot(new Slot(inventoryWrapper, 4, 92, 67));
        addSlot(new Slot(inventoryWrapper, 5, 68, 67));
        addSlot(new Slot(inventoryWrapper, 6, 68, 87));
        addSlot(new Slot(inventoryWrapper, 7, 92, 87));

        int x = 8;
        int y = 116;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 9; c++) {
                addSlot(new Slot(playerInv, c + r * 9 + 9, x + c * 18, y + r * 18 - 2));
            }
        }

        for (int c = 0; c < 9; c++) {
            addSlot(new Slot(playerInv, c, x + c * 18, y + 56));
        }


    }

    @Override
    public boolean stillValid(Player player) {
        return access.evaluate(
                (level, pos) -> level.getBlockEntity(pos) instanceof CabinetBlockEntity be &&
                        be.getInventory().stillValid(player),
                true
        );
    }


    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack stack = slot.getItem();
            result = stack.copy();

            boolean moved;
            if (index < ARMOR_END) {
                moved = moveItemStackTo(stack, INV_START, HOTBAR_END, true);
            } else {
                moved = moveItemStackTo(stack, ARMOR_START, ARMOR_END, false);
            }

            if (!moved) return ItemStack.EMPTY;

            slot.setChanged();

            if (stack.isEmpty()) slot.set(ItemStack.EMPTY);
            if (stack.getCount() == result.getCount()) return ItemStack.EMPTY;
            slot.onTake(player, stack);
            if (be != null) {
                be.sendUpdates();
            }

        }

        return result;
    }


}
