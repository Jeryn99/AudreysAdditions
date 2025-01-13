package dev.jeryn.audreys_additions.common.registry;

import dev.jeryn.audreys_additions.AudreysAdditions;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import whocraft.tardis_refined.registry.DeferredRegistry;

public class AudItems {

    public static final DeferredRegistry<Item> ITEMS = DeferredRegistry.create(AudreysAdditions.MODID, Registries.ITEM);
    public static Item.Properties GENERIC_PROPERTIES = new Item.Properties().stacksTo(1);

}
