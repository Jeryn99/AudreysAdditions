package dev.jeryn.audreys_additions.common.registry.forge;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class AudTabsImpl {

    public static CreativeModeTab getCreativeTab() {
        return CreativeModeTab.builder().title(Component.translatable(AudreysAdditions.NAME)).icon(() -> new ItemStack(AudBlocks.FOOD_MACHINE.get())).build();
    }

}
