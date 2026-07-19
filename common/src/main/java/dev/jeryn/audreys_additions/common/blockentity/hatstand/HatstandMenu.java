package dev.jeryn.audreys_additions.common.blockentity.hatstand;

import com.mojang.datafixers.util.Pair;
import dev.jeryn.audreys_additions.common.registry.AudMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.InventoryMenu;
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
    private static final ResourceLocation BLOCK_ATLAS = InventoryMenu.BLOCK_ATLAS;
    private static final ResourceLocation EMPTY_HELMET =
            InventoryMenu.EMPTY_ARMOR_SLOT_HELMET;
    private static final ResourceLocation EMPTY_CHEST =
            InventoryMenu.EMPTY_ARMOR_SLOT_CHESTPLATE;
    private static final ResourceLocation EMPTY_LEGS =
            InventoryMenu.EMPTY_ARMOR_SLOT_LEGGINGS;
    private static final ResourceLocation EMPTY_BOOTS =
            InventoryMenu.EMPTY_ARMOR_SLOT_BOOTS;

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

        addSlot(new ArmorSlot(inventoryWrapper, 0, 8, 37, EquipmentSlot.HEAD));
        addSlot(new ArmorSlot(inventoryWrapper, 1, 56, 37, EquipmentSlot.CHEST));
        addSlot(new ArmorSlot(inventoryWrapper, 2, 104, 37, EquipmentSlot.LEGS));
        addSlot(new ArmorSlot(inventoryWrapper, 3, 152, 37, EquipmentSlot.FEET));

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
        private final EquipmentSlot equipmentSlot;

        public ArmorSlot(Container container, int index, int x, int y, EquipmentSlot slot) {
            super(container, index, x, y);
            this.equipmentSlot = slot;
        }
        @Override
        public boolean mayPlace(ItemStack stack) {
            return stack.getItem() instanceof ArmorItem armorItem
                    && armorItem.getEquipmentSlot() == equipmentSlot;
        }
        @Override
        public int getMaxStackSize() {
            return 1;
        }

        @Override
        public com.mojang.datafixers.util.Pair<ResourceLocation, ResourceLocation> getNoItemIcon() {
            return switch (equipmentSlot) {
                case HEAD -> Pair.of(InventoryMenu.BLOCK_ATLAS, InventoryMenu.EMPTY_ARMOR_SLOT_HELMET);
                case CHEST -> Pair.of(InventoryMenu.BLOCK_ATLAS, InventoryMenu.EMPTY_ARMOR_SLOT_CHESTPLATE);
                case LEGS -> Pair.of(InventoryMenu.BLOCK_ATLAS, InventoryMenu.EMPTY_ARMOR_SLOT_LEGGINGS);
                case FEET -> Pair.of(InventoryMenu.BLOCK_ATLAS, InventoryMenu.EMPTY_ARMOR_SLOT_BOOTS);
                default -> null;
            };
        }
    }

}
