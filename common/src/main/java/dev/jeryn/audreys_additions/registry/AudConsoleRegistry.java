package dev.jeryn.audreys_additions.registry;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.console.theme.PertweeConsoleTheme;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.common.tardis.themes.ConsoleTheme;
import whocraft.tardis_refined.common.tardis.themes.console.ConsoleThemeDetails;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;

public class AudConsoleRegistry {

    public static final DeferredRegistry<ConsoleTheme> CONSOLE_REGISTRY = DeferredRegistry.create(AudreysAdditions.MODID, ConsoleTheme.CONSOLE_THEME_REGISTRY_KEY);

    public static final RegistrySupplier<ConsoleTheme> PERTWEE = registerConsoleTheme("pertwee", new PertweeConsoleTheme());


    private static RegistrySupplier<ConsoleTheme> registerConsoleTheme(String id, ConsoleThemeDetails themeDetails) {
        return CONSOLE_REGISTRY.register(id, () -> {
            return new ConsoleTheme(new ResourceLocation(AudreysAdditions.MODID, id), themeDetails);
        });
    }



}
