package dev.jeryn.audreys_additions.neoforge.data;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.blocks.LightBoxBlock;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import whocraft.tardis_refined.registry.TRBlockRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProviderLootTable extends LootTableProvider {

    public ProviderLootTable(PackOutput arg) {
        super(arg, Set.of(), List.of(new LootTableProvider.SubProviderEntry(ModBlockLoot::new, LootContextParamSets.BLOCK)));
    }

    public static class ModBlockLoot extends BlockLootSubProvider {
        protected ModBlockLoot() {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        }

        protected void generate() {
            for (Block block : this.getKnownBlocks()) {

                if (block == AudBlocks.ARMCHAIR.get()) {
                    this.add(block, noDrop());
                    continue;
                }

                if (block == AudBlocks.FOLD_OUT_BED.get()) {
                    this.add(block, (block2) -> this.createSinglePropConditionTable(block2, BedBlock.PART, BedPart.HEAD));
                    continue;
                }

                if (block == AudBlocks.LIGHTCOLUMN_LEFT.get()) {
                    this.add(block, (block2) -> this.createSinglePropConditionTable(block2, LightBoxBlock.PART, BedPart.HEAD));
                    continue;
                }

                if (block == AudBlocks.LIGHTCOLUMN_RIGHT.get()) {
                    this.add(block, (block2) -> this.createSinglePropConditionTable(block2, LightBoxBlock.PART, BedPart.HEAD));
                    continue;
                }

                this.dropSelf(block);
            }


        }

        protected Iterable<Block> getKnownBlocks() {
            ArrayList<Block> blocks = new ArrayList<>();

            for (Map.Entry<ResourceKey<Block>, Block> resourceKeyBlockEntry : AudBlocks.BLOCKS.entrySet()) {
                ResourceLocation blockId = TRBlockRegistry.BLOCKS.getKey(resourceKeyBlockEntry.getValue());
                if (blockId.toString().contains(AudreysAdditions.MODID)) {
                    blocks.add(resourceKeyBlockEntry.getValue());
                }
            }

            return blocks;
        }
    }
}
