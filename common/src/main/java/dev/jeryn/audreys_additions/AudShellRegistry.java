package dev.jeryn.audreys_additions;

import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.common.tardis.themes.ShellTheme;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;
import whocraft.tardis_refined.registry.RegistrySupplierHolder;

import static whocraft.tardis_refined.patterns.ShellPatterns.interiorTextureLocation;

public class AudShellRegistry {

    public static final DeferredRegistry<ShellTheme> SHELL_THEMES = DeferredRegistry.create(AudreysAdditions.MODID, ShellTheme.SHELL_THEME_REGISTRY_KEY);

    private static RegistrySupplier<ShellTheme> registerShellTheme(String id) {
        return SHELL_THEMES.register(id, () -> new ShellTheme(new ResourceLocation(AudreysAdditions.MODID, id)));
    }



}
