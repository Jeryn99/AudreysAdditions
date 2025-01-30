package dev.jeryn.audreys_additions.forge;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.item.DyedItemBlock;
import dev.jeryn.audreys_additions.common.registry.AudTabs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonMod {


    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent buildEvent) {
        String modNamespace = AudreysAdditions.MODID;

        if(buildEvent.getTab() == AudTabs.MAIN_TAB.get()) {
            BuiltInRegistries.ITEM.iterator().forEachRemaining(item -> {
                String namespace = BuiltInRegistries.ITEM.getKey(item).getNamespace();

                if (!namespace.equals(modNamespace)) {
                    return; // Skip items from other namespaces
                }
                buildEvent.accept(item);
            });
        }

    }


}