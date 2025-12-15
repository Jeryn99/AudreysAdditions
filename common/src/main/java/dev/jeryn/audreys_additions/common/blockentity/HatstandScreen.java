package dev.jeryn.audreys_additions.common.blockentity;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class HatstandScreen extends AbstractContainerScreen<HatstandMenu> {
    private static final ResourceLocation TEX = new ResourceLocation("audreys_additions:textures/gui/hatstand.png");

    public HatstandScreen(HatstandMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.imageWidth = 176;
        this.imageHeight = 180;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        guiGraphics.blit(TEX, leftPos, topPos, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int i, int j) {
        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, ChatFormatting.BLACK.getColor(), false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, ChatFormatting.BLACK.getColor(), false);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        super.render(guiGraphics, mouseX, mouseY, partialTicks);

        for (int i = 0; i < menu.slots.size(); i++) {

            int slotX = leftPos + menu.slots.get(i).x;
            int slotY = topPos + menu.slots.get(i).y;
            int greyColor = 0xFF808080;
            guiGraphics.fill(slotX, slotY, slotX + 16, slotY + 16, greyColor);
        }

        renderTooltip(guiGraphics, mouseX, mouseY);
    }


}
