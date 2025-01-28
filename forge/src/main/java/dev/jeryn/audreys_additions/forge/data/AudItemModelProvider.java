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
        basicItem(AudItems.FOOD_CUBE.getId());
        blockItem(AudBlocks.LIGHTCOLUMN_LEFT.getId());
        blockItem(AudBlocks.BRACHACKI_MONITOR.getId());
        blockItem(AudBlocks.LIGHTCOLUMN_RIGHT.getId());
        blockItem(AudBlocks.ARMCHAIR.getId());
        basicItem(AudBlocks.ASTRAL_MAP.getId());
        basicItem(AudBlocks.CEILING_CANOPY.getId());
    }

    public ItemModelBuilder blockItem(ResourceLocation item) {
        return this.getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(item.getNamespace(), "block/" + item.getPath())));
    }

}
