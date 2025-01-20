package dev.jeryn.audreys_additions.forge.data;

import dev.jeryn.audreys_additions.AudTags;
import dev.jeryn.audreys_additions.AudreysAdditions;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class AudItemTagProvider extends ItemTagsProvider {

    public AudItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries,
                              CompletableFuture<TagLookup<Block>> blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(packOutput, registries, blockTagsProvider, AudreysAdditions.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {

        BuiltInRegistries.BLOCK.forEach(block -> {
            // Set of block classes to check
            Set<Class<?>> fuelBlockClasses = Set.of(
                    FlowerBlock.class,
                    DeadBushBlock.class,
                    VineBlock.class,
                    LeavesBlock.class,
                    WaterlilyBlock.class,
                    GrassBlock.class,
                    TallGrassBlock.class,
                    BushBlock.class
            );

            // Check if the block is an instance of any class in the set
            if (fuelBlockClasses.stream().anyMatch(clazz -> clazz.isInstance(block))) {
                tag(AudTags.FUEL_ITEMS).add(Item.byBlock(block));
            }

            // Check if the block's path contains "log"
            if (BuiltInRegistries.BLOCK.getKey(block).getPath().contains("log")) {
                tag(AudTags.FUEL_ITEMS).add(Item.byBlock(block));
            }
        });

    }
}