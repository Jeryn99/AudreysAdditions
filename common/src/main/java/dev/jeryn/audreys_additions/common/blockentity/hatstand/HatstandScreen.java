package dev.jeryn.audreys_additions.common.blockentity.hatstand;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.ArrayList;
import java.util.List;

public class HatstandScreen extends AbstractContainerScreen<HatstandMenu> {

    private static final ResourceLocation TEX =
            new ResourceLocation("audreys_additions:textures/gui/hatstand.png");

    /* ================= DEV SLOT HELPER ================= */

    private final List<int[]> helperSlots = new ArrayList<>();
    private boolean helperMode = false; // set false for release
    private int[] selectedSlot = null;

    /* =================================================== */

    public HatstandScreen(HatstandMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.imageWidth = 176;
        this.imageHeight = 180;
    }

    @Override
    protected void renderBg(GuiGraphics g, float partialTicks, int mouseX, int mouseY) {
        g.blit(TEX, leftPos, topPos, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
    }

    @Override
    protected void renderLabels(GuiGraphics g, int i, int j) {

    }

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float partialTicks) {
        super.render(g, mouseX, mouseY, partialTicks);

        // Existing menu slots (grey)
        for (var slot : menu.slots) {
            int x = leftPos + slot.x;
            int y = topPos + slot.y;
            g.fill(x, y, x + 16, y + 16, 0xFF808080);
        }

        // Helper slots
        if (helperMode) {
            for (int[] slot : helperSlots) {
                int x = leftPos + slot[0];
                int y = topPos + slot[1];

                int color = (slot == selectedSlot)
                        ? 0xA000FF00 // green = selected
                        : 0x80FF0000; // red = unselected

                g.fill(x, y, x + 16, y + 16, color);
            }
        }

        renderTooltip(g, mouseX, mouseY);
    }

    /* ================= MOUSE ================= */

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (!helperMode) return super.mouseClicked(mouseX, mouseY, button);

        int guiX = (int) mouseX - leftPos;
        int guiY = (int) mouseY - topPos;

        // Select slot
        for (int[] slot : helperSlots) {
            if (guiX >= slot[0] && guiX <= slot[0] + 16 &&
                    guiY >= slot[1] && guiY <= slot[1] + 16) {

                if (button == 1) { // right click delete
                    helperSlots.remove(slot);
                    if (slot == selectedSlot) selectedSlot = null;
                } else {
                    selectedSlot = slot;
                }
                return true;
            }
        }

        // Create new slot
        if (button == 0) {
            int[] slot = new int[]{guiX, guiY};
            helperSlots.add(slot);
            selectedSlot = slot;
            logSlot(slot);
            return true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    /* ================= KEYBOARD ================= */

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (!helperMode || selectedSlot == null)
            return super.keyPressed(keyCode, scanCode, modifiers);

        int step = 1;
        if (hasShiftDown()) step = 5;
        if (hasControlDown()) step = 10;

        switch (keyCode) {
            case 263 -> selectedSlot[0] -= step; // left
            case 262 -> selectedSlot[0] += step; // right
            case 265 -> selectedSlot[1] -= step; // up
            case 264 -> selectedSlot[1] += step; // down

            case 257 -> { // Enter
                if (hasControlDown()) dumpAllSlots();
                else logSlot(selectedSlot);
            }

            default -> {
                return super.keyPressed(keyCode, scanCode, modifiers);
            }
        }

        return true;
    }

    /* ================= LOGGING ================= */

    private void logSlot(int[] slot) {
        System.out.println(
                "addSlot(new Slot(inventoryWrapper, i, " +
                        slot[0] + ", " + slot[1] + "));"
        );
    }

    private void dumpAllSlots() {
        System.out.println("---- SLOT EXPORT ----");
        for (int i = 0; i < helperSlots.size(); i++) {
            int[] s = helperSlots.get(i);
            System.out.println(
                    "addSlot(new Slot(inventoryWrapper, " + i +
                            ", " + s[0] + ", " + s[1] + "));"
            );
        }
        System.out.println("---------------------");
    }
}
