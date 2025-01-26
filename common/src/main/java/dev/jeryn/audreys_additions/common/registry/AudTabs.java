package dev.jeryn.audreys_additions.common.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.jeryn.audreys_additions.AudreysAdditions;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import whocraft.tardis_refined.common.util.PlatformWarning;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;
import whocraft.tardis_refined.registry.TRItemRegistry;

public class AudTabs {

    public static final DeferredRegistry<CreativeModeTab> TABS = DeferredRegistry.create(AudreysAdditions.MODID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> MAIN_TAB = TABS.register("main", AudTabs::getCreativeTab);


    @ExpectPlatform
    public static CreativeModeTab getCreativeTab() {
        throw new RuntimeException(PlatformWarning.addWarning(AudItems.class));
    }

}
