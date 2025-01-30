package dev.jeryn.audreys_additions.common.registry.fabric;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class AudTabsImpl {

    public static final CreativeModeTab ITEM_GROUP = FabricItemGroup.builder().icon(() -> new ItemStack(AudBlocks.FOOD_MACHINE.get())).displayItems((enabledFeatures, entries) -> {
        BuiltInRegistries.ITEM.iterator().forEachRemaining(item -> {
            if (BuiltInRegistries.ITEM.getKey(item).getNamespace().matches(AudreysAdditions.MODID)) {
                if(item == AudBlocks.ARMCHAIR.get().asItem()){
                    entries.accept(AudBlocks.ARMCHAIR.get().asItem().getDefaultInstance());
                    return;
                }
                entries.accept(item);
            }
        });
    }).title(Component.translatable(AudreysAdditions.NAME)).build();

    public static CreativeModeTab getCreativeTab() {
        return ITEM_GROUP;
    }

}
