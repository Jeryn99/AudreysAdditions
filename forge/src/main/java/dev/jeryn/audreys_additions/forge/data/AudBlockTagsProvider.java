package dev.jeryn.audreys_additions.forge.data;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class AudBlockTagsProvider extends BlockTagsProvider {

    public AudBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,  @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AudreysAdditions.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(
                        AudBlocks.KNOSSOS_THRONE.get(),
                        AudBlocks.ARMCHAIR.get(),
                        AudBlocks.HATSTAND_ACACIA.get(),
                        AudBlocks.HATSTAND_BAMBOO.get(),
                        AudBlocks.HATSTAND_BIRCH.get(),
                        AudBlocks.HATSTAND_CHERRY.get(),
                        AudBlocks.HATSTAND_CRIMSON.get(),
                        AudBlocks.HATSTAND_DARK_OAK.get(),
                        AudBlocks.HATSTAND_JUNGLE.get(),
                        AudBlocks.HATSTAND_MANGROVE.get(),
                        AudBlocks.HATSTAND_OAK.get(),
                        AudBlocks.HATSTAND_PALE.get(),
                        AudBlocks.HATSTAND_SPRUCE.get(),
                        AudBlocks.HATSTAND_WARPED.get()
                );

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        AudBlocks.LIMINTON_MONITOR.get(),
                        AudBlocks.FOOD_MACHINE.get(),
                        AudBlocks.LIGHTCOLUMN_LEFT.get(),
                        AudBlocks.LIGHTCOLUMN_RIGHT.get(),
                        AudBlocks.TREATED_LIGHTCOLUMN_LEFT.get(),
                        AudBlocks.TREATED_LIGHTCOLUMN_RIGHT.get(),
                        AudBlocks.ASTRAL_MAP.get(),
                        AudBlocks.CEILING_CANOPY.get(),
                        AudBlocks.BRACHACKI_MONITOR.get(),
                        AudBlocks.FOLD_OUT_BED.get(),
                        AudBlocks.ZEITON_QUARTZ_BLOCK.get(),
                        AudBlocks.ZEITON_QUARTZ_STAIRS.get(),
                        AudBlocks.ZEITON_QUARTZ_SLAB.get(),
                        AudBlocks.ZEITON_QUARTZ_DOOR.get(),
                        AudBlocks.ZEITON_QUARTZ_PILLAR.get(),
                        AudBlocks.ZEITON_QUARTZ_BRICKS.get(),
                        AudBlocks.CHISELED_ZEITON_QUARTZ_BLOCK.get(),
                        AudBlocks.SMOOTH_ZEITON_QUARTZ_BLOCK.get(),
                        AudBlocks.SMOOTH_ZEITON_QUARTZ_STAIRS.get(),
                        AudBlocks.SMOOTH_ZEITON_QUARTZ_SLAB.get(),
                        AudBlocks.TREATED_ZEITON_QUARTZ_BRICKS.get(),
                        AudBlocks.TREATED_CHISELED_ZEITON_QUARTZ_BLOCK.get()
                );



    }
}
