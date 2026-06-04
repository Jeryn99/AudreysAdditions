package dev.jeryn.audreys_additions.forge.data;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import dev.jeryn.audreys_additions.common.registry.AudItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

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
        basicItem(AudBlocks.SPECIMEN_JAR.getId());
        basicItem(AudBlocks.SPECIMEN_JAR_ALLAY.getId());
        basicItem(AudBlocks.SPECIMEN_JAR_CREEPER.getId());
        basicItem(AudBlocks.SPECIMEN_JAR_DRAGON.getId());
        basicItem(AudBlocks.SPECIMEN_JAR_PIGLIN.getId());
        basicItem(AudBlocks.SPECIMEN_JAR_SKELETON.getId());
        basicItem(AudBlocks.SPECIMEN_JAR_VEX.getId());
        basicItem(AudBlocks.SPECIMEN_JAR_WITHERSKELETON.getId());
        basicItem(AudBlocks.SPECIMEN_JAR_ZOMBIE.getId());

        basicItem(AudBlocks.HATSTAND_ACACIA.getId());
        basicItem(AudBlocks.HATSTAND_BAMBOO.getId());
        basicItem(AudBlocks.HATSTAND_BIRCH.getId());
        basicItem(AudBlocks.HATSTAND_CHERRY.getId());
        basicItem(AudBlocks.HATSTAND_CRIMSON.getId());
        basicItem(AudBlocks.HATSTAND_DARK_OAK.getId());
        basicItem(AudBlocks.HATSTAND_JUNGLE.getId());
        basicItem(AudBlocks.HATSTAND_MANGROVE.getId());
        basicItem(AudBlocks.HATSTAND_OAK.getId());
        basicItem(AudBlocks.HATSTAND_PALE.getId());
        basicItem(AudBlocks.HATSTAND_SPRUCE.getId());
        basicItem(AudBlocks.HATSTAND_WARPED.getId());
        basicItem(AudBlocks.TREATED_ZEITON_QUARTZ_DOOR.getId());
        basicItem(AudBlocks.ZEITON_QUARTZ_DOOR.getId());

        basicItem(AudBlocks.CABINET.getId());

        blockItem(AudBlocks.ZEITON_QUARTZ_BLOCK.getId());
        blockItem(AudBlocks.ZEITON_QUARTZ_STAIRS.getId());
        blockItem(AudBlocks.ZEITON_QUARTZ_SLAB.getId());
        blockItem(AudBlocks.SMOOTH_ZEITON_QUARTZ_SLAB.getId());
        blockItem(AudBlocks.SMOOTH_ZEITON_QUARTZ_BLOCK.getId());
        blockItem(AudBlocks.SMOOTH_ZEITON_QUARTZ_STAIRS.getId());
        blockItem(AudBlocks.ZEITON_QUARTZ_BRICKS.getId());
        blockItem(AudBlocks.ZEITON_QUARTZ_PILLAR.getId());
        blockItem(AudBlocks.CHISELED_ZEITON_QUARTZ_BLOCK.getId());
        blockItem(AudBlocks.TREATED_CHISELED_ZEITON_QUARTZ_BLOCK.getId());
        blockItem(AudBlocks.TREATED_ZEITON_QUARTZ_BRICKS.getId());

    }

    public ItemModelBuilder blockItem(ResourceLocation item) {
        return this.getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(item.getNamespace(), "block/" + item.getPath())));
    }

}
