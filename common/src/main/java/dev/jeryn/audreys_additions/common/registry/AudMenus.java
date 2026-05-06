package dev.jeryn.audreys_additions.common.registry;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.blockentity.cabinet.CabinetMenu;
import dev.jeryn.audreys_additions.common.blockentity.hatstand.HatstandMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;

import java.util.function.Supplier;

public class AudMenus {

    public static final DeferredRegistry<MenuType<?>> MENUS = DeferredRegistry.create(AudreysAdditions.MODID, Registries.MENU);

    private static <T extends MenuType<?>> RegistrySupplier<T> register(String id, Supplier<T> supplier) {
        return MENUS.register(id, supplier);
    }

    public static final RegistrySupplier<MenuType<HatstandMenu>> HAT_STAND = register("hat_stand", () -> new MenuType<>(HatstandMenu::new, FeatureFlags.DEFAULT_FLAGS));
    public static final RegistrySupplier<MenuType<CabinetMenu>> CABINET = register("cabinet", () -> new MenuType<>(CabinetMenu::new, FeatureFlags.DEFAULT_FLAGS));


}