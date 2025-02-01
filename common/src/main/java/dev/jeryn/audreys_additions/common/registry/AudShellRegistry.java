package dev.jeryn.audreys_additions.common.registry;

import dev.jeryn.audreys_additions.AudreysAdditions;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.common.tardis.themes.ShellTheme;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;

public class AudShellRegistry {

    public static final DeferredRegistry<ShellTheme> SHELL_THEMES = DeferredRegistry.create(AudreysAdditions.MODID, ShellTheme.SHELL_THEME_REGISTRY_KEY);

    public static final RegistrySupplier<ShellTheme> POLICEBOX_2018 = registerShellTheme("policebox_2018");
    public static final RegistrySupplier<ShellTheme> POLICEBOX_2010 = registerShellTheme("policebox_2010");
    public static final RegistrySupplier<ShellTheme> POLICEBOX_1976 = registerShellTheme("policebox_1976");
    public static final RegistrySupplier<ShellTheme> POLICEBOX_1996 = registerShellTheme("policebox_1996");
    public static final RegistrySupplier<ShellTheme> POLICEBOX_1963 = registerShellTheme("policebox_1963");
    public static final RegistrySupplier<ShellTheme> POLICEBOX_1966 = registerShellTheme("policebox_1966");
    public static final RegistrySupplier<ShellTheme> SIDRAT = registerShellTheme("sidrat");


    private static RegistrySupplier<ShellTheme> registerShellTheme(String id) {
        return SHELL_THEMES.register(id, () -> new ShellTheme(new ResourceLocation(AudreysAdditions.MODID, id)));
    }



}
