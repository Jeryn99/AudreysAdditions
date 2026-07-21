package dev.jeryn.audreys_additions.forge.data;

import dev.jeryn.audreys_additions.AudTags;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import whocraft.tardis_refined.common.items.ZeitonIngotItem;

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
                if (block.asItem() != Items.AIR) {
                    tag(AudTags.FUEL_ITEMS).add(block.asItem());
                }
            }


            // Check if the block's path contains "log"
            if (BuiltInRegistries.BLOCK.getKey(block).getPath().contains("log")) {
                if (block.asItem() != Items.AIR) {
                    tag(AudTags.FUEL_ITEMS).add(block.asItem());
                }
            }


        });
        tag(AudTags.ZEITON_BLOCKS).add(AudBlocks.ZEITON_QUARTZ_BLOCK.get().asItem())
                .add(AudBlocks.ZEITON_QUARTZ_STAIRS.get().asItem())
                .add(AudBlocks.ZEITON_QUARTZ_SLAB.get().asItem())
                .add(AudBlocks.SMOOTH_ZEITON_QUARTZ_BLOCK.get().asItem())
                .add(AudBlocks.SMOOTH_ZEITON_QUARTZ_STAIRS.get().asItem())
                .add(AudBlocks.SMOOTH_ZEITON_QUARTZ_SLAB.get().asItem())
                .add(AudBlocks.ZEITON_QUARTZ_BRICKS.get().asItem())
                .add(AudBlocks.ZEITON_QUARTZ_PILLAR.get().asItem())
                .add(AudBlocks.CHISELED_ZEITON_QUARTZ_BLOCK.get().asItem())
                .add(AudBlocks.ZEITON_QUARTZ_DOOR.get().asItem())
                .add(AudBlocks.TREATED_ZEITON_QUARTZ_BRICKS.get().asItem())
                .add(AudBlocks.TREATED_ZEITON_QUARTZ_DOOR.get().asItem())
                .add(AudBlocks.TREATED_CHISELED_ZEITON_QUARTZ_BLOCK.get().asItem());

        tag(AudTags.NON_STAIR_ZEITON_BLOCKS).add(AudBlocks.ZEITON_QUARTZ_BLOCK.get().asItem())
                .add(AudBlocks.SMOOTH_ZEITON_QUARTZ_BLOCK.get().asItem())
                .add(AudBlocks.ZEITON_QUARTZ_BRICKS.get().asItem())
                .add(AudBlocks.ZEITON_QUARTZ_PILLAR.get().asItem())
                .add(AudBlocks.CHISELED_ZEITON_QUARTZ_BLOCK.get().asItem())
                .add(AudBlocks.ZEITON_QUARTZ_DOOR.get().asItem())
                .add(AudBlocks.TREATED_ZEITON_QUARTZ_BRICKS.get().asItem())
                .add(AudBlocks.TREATED_ZEITON_QUARTZ_DOOR.get().asItem())
                .add(AudBlocks.TREATED_CHISELED_ZEITON_QUARTZ_BLOCK.get().asItem());
    }
}