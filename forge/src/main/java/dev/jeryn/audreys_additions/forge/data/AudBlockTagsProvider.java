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
                        AudBlocks.ARMCHAIR.get()
                );

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        AudBlocks.LIMINTON_MONITOR.get(),
                        AudBlocks.FOOD_MACHINE.get(),
                        AudBlocks.LIGHTCOLUMN_LEFT.get(),
                        AudBlocks.LIGHTCOLUMN_RIGHT.get(),
                        AudBlocks.ASTRAL_MAP.get(),
                        AudBlocks.CEILING_CANOPY.get(),
                        AudBlocks.BRACHACKI_MONITOR.get(),
                        AudBlocks.FOLD_OUT_BED.get()
                );



    }
}
