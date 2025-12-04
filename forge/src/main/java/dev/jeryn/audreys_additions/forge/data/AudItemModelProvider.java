package dev.jeryn.audreys_additions.forge.data;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.blocks.SpecimenJarBlock;
import dev.jeryn.audreys_additions.common.item.SpecimenJarItemBlock;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import dev.jeryn.audreys_additions.common.registry.AudItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AudItemModelProvider extends ItemModelProvider {


    public AudItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AudreysAdditions.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        blockItem(AudBlocks.LIMINTON_MONITOR.getId());
        basicItem(AudBlocks.KNOSSOS_THRONE.getId());
        basicItem(AudBlocks.FOOD_MACHINE.getId());
        basicItem(AudItems.FOOD_CUBE.getId());
        blockItem(AudBlocks.LIGHTCOLUMN_LEFT.getId());
        blockItem(AudBlocks.BRACHACKI_MONITOR.getId());
        blockItem(AudBlocks.LIGHTCOLUMN_RIGHT.getId());
        blockItem(AudBlocks.ARMCHAIR.getId());
        basicItem(AudBlocks.ASTRAL_MAP.getId());
        basicItem(AudBlocks.CEILING_CANOPY.getId());
        specimenJar(AudBlocks.SPECIMEN_JAR_ALLAY.getId());
        specimenJar(AudBlocks.SPECIMEN_JAR_CREEPER.getId());
        specimenJar(AudBlocks.SPECIMEN_JAR_DRAGON.getId());
        specimenJar(AudBlocks.SPECIMEN_JAR_PIGLIN.getId());
        specimenJar(AudBlocks.SPECIMEN_JAR_SKELETON.getId());
        specimenJar(AudBlocks.SPECIMEN_JAR_VEX.getId());
        specimenJar(AudBlocks.SPECIMEN_JAR_WITHERSKELETON.getId());
        specimenJar(AudBlocks.SPECIMEN_JAR_ZOMBIE.getId());

        blockItem(AudBlocks.ZEITON_QUARTZ_BLOCK.getId());
        blockItem(AudBlocks.ZEITON_QUARTZ_STAIRS.getId());
        blockItem(AudBlocks.ZEITON_QUARTZ_SLAB.getId());
        blockItem(AudBlocks.SMOOTH_ZEITON_QUARTZ_SLAB.getId());
        blockItem(AudBlocks.SMOOTH_ZEITON_QUARTZ_BLOCK.getId());
        blockItem(AudBlocks.SMOOTH_ZEITON_QUARTZ_STAIRS.getId());
        blockItem(AudBlocks.ZEITON_QUARTZ_BRICKS.getId());
        blockItem(AudBlocks.ZEITON_QUARTZ_PILLAR.getId());
        blockItem(AudBlocks.CHISELED_ZEITON_QUARTZ_BLOCK.getId());
        blockItem(AudBlocks.TREATED_ZEITON_QUARTZ_BLOCK.getId());

        basicItem(AudBlocks.ROUNDEL_OVERLAY_HALF.getId());
        basicItem(AudBlocks.ROUNDEL_OVERLAY_FULL.getId());

    }

    public ItemModelBuilder blockItem(ResourceLocation item) {
        return this.getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(item.getNamespace(), "block/" + item.getPath())));
    }

    public ItemModelBuilder specimenJar(ResourceLocation item) {
        return this.getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(item.getNamespace(), "item/" + AudBlocks.SPECIMEN_JAR.getId().getPath())));
    }

}
