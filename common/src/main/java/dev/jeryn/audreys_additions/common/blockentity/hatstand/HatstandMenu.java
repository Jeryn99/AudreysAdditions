package dev.jeryn.audreys_additions.common.blockentity.hatstand;

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

class HatstandInventoryWrapper extends SimpleContainer {
    private final HatstandBlockEntity blockEntity;

    public HatstandInventoryWrapper(HatstandBlockEntity be) {
        super(4);
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

public class HatstandMenu extends AbstractContainerMenu {

    public static final int ARMOR_START = 0;
    public static final int ARMOR_END = 4;

    public static final int INV_START = 4;

    public static final int HOTBAR_END = 40;

    private final ContainerLevelAccess access;
    private final HatstandInventoryWrapper inventoryWrapper;
    private final HatstandBlockEntity be;

    // ------- CLIENT CONSTRUCTOR -------
    public HatstandMenu(int id, Inventory inv, FriendlyByteBuf buf) {
        this(id, inv, ContainerLevelAccess.create(inv.player.level(), buf.readBlockPos()));
    }

    public HatstandMenu(int id, Inventory inventory) {
        this(id, inventory, ContainerLevelAccess.NULL);
    }

    public HatstandMenu(int id, Inventory playerInv, ContainerLevelAccess access) {
        super(AudMenus.HAT_STAND.get(), id);
        this.access = access;

        be = access.evaluate(
                (level, pos) -> {
                    var entity = level.getBlockEntity(pos);
                    if (entity instanceof HatstandBlockEntity h) return h;
                    return null;
                },
                null
        );

        this.inventoryWrapper = new HatstandInventoryWrapper(be);
        if (be != null) {
            for (int i = 0; i < 4; i++) {
                inventoryWrapper.setItem(i, be.getInventory().getItem(i));
            }
            be.sendUpdates();
        }

        addSlot(new ArmorSlot(inventoryWrapper, 0, 8, 37));
        addSlot(new ArmorSlot(inventoryWrapper, 1, 56, 37));
        addSlot(new ArmorSlot(inventoryWrapper, 2, 104, 37));
        addSlot(new ArmorSlot(inventoryWrapper, 3, 152, 37));

        int x = 8;
        int y = 100;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 9; c++) {
                addSlot(new Slot(playerInv, c + r * 9 + 9, x + c * 18, y + r * 18 -2));
            }
        }

        for (int c = 0; c < 9; c++) {
            addSlot(new Slot(playerInv, c, x + c * 18, y + 56));
        }


    }

    @Override
    public boolean stillValid(Player player) {
        return access.evaluate(
                (level, pos) -> level.getBlockEntity(pos) instanceof HatstandBlockEntity be &&
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


    public class ArmorSlot extends Slot {

        public ArmorSlot(HatstandInventoryWrapper inventory, int index, int x, int y) {
            super(inventory, index, x, y);
        }

        @Override
        public boolean mayPlace(ItemStack stack) {
            return stack.getItem() instanceof ArmorItem;
        }
    }

}
