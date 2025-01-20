package dev.jeryn.audreys_additions.common.registry;

import dev.jeryn.audreys_additions.AudreysAdditions;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class AudItems {

    public static final DeferredRegistry<Item> ITEMS = DeferredRegistry.create(AudreysAdditions.MODID, Registries.ITEM);
    public static Item.Properties GENERIC_PROPERTIES = new Item.Properties().stacksTo(1);

    public static List<RegistrySupplier<Item>> TAB_ITEMS = new ArrayList();

    public static final RegistrySupplier<Item> FOOD_CUBE = register("food_cube", () -> new Item((new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).build()))), true);


    private static <T extends Item> RegistrySupplier<T> register(String id, Supplier<T> itemSupplier, boolean addToTab) {
        RegistrySupplier<T> item = ITEMS.register(id, itemSupplier);
        if (addToTab) {
            TAB_ITEMS.add((RegistrySupplier<Item>) item);
        }
        return item;
    }
}
