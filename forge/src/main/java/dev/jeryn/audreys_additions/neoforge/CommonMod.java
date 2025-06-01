package dev.jeryn.audreys_additions.neoforge;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.registry.AudTabs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;


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