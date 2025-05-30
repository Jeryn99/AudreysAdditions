package dev.jeryn.audreys_additions.forge.data;

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
import net.minecraft.world.level.block.Blocks;
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
                this.dropSelf(block);
            }
        }

        protected Iterable<Block> getKnownBlocks() {
            ArrayList<Block> blocks = new ArrayList<>();

            for (Map.Entry<ResourceKey<Block>, Block> resourceKeyBlockEntry : AudBlocks.BLOCKS.entrySet()) {
                ResourceLocation blockId = TRBlockRegistry.BLOCKS.getKey(resourceKeyBlockEntry.getValue());
                if (blockId.toString().contains(AudreysAdditions.MODID)) {

                    if(blockId.getNamespace().contains("bed")){
                        this.add(resourceKeyBlockEntry.getValue(), (block) -> this.createSinglePropConditionTable(block, BedBlock.PART, BedPart.HEAD));
                        continue;
                    }

                    if(resourceKeyBlockEntry instanceof LightBoxBlock lightBoxBlock){
                        this.add(resourceKeyBlockEntry.getValue(), (block) -> this.createSinglePropConditionTable(block, LightBoxBlock.PART, BedPart.HEAD));
                        continue;
                    }


                    blocks.add(resourceKeyBlockEntry.getValue());
                }
            }

            return blocks;
        }
    }
}
