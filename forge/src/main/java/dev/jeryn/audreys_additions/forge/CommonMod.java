package dev.jeryn.audreys_additions.forge;

import dev.jeryn.audreys_additions.AudreysAdditions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonMod {


    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent buildEvent) {
        String modNamespace = AudreysAdditions.MODID;

        BuiltInRegistries.ITEM.iterator().forEachRemaining(item -> {
            String namespace = BuiltInRegistries.ITEM.getKey(item).getNamespace();

            if (!namespace.equals(modNamespace)) {
                return; // Skip items from other namespaces
            }
            buildEvent.accept(item);
        });
    }


}