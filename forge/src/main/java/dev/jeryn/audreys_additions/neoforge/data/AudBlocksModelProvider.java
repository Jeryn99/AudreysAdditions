package dev.jeryn.audreys_additions.neoforge.data;

import com.google.gson.JsonObject;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.blocks.MonitorBlock;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class AudBlocksModelProvider extends BlockStateProvider {

    public AudBlocksModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), AudreysAdditions.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (Map.Entry<ResourceKey<Block>, Block> block : BuiltInRegistries.BLOCK.entrySet()) {
            Block value = block.getValue();
            @Nullable ResourceLocation location = BuiltInRegistries.BLOCK.getKey(value);
            if (location.getNamespace().matches(AudreysAdditions.MODID)) {

                if(value == AudBlocks.LIGHTCOLUMN_RIGHT.get()){
                    ResourceLocation leftColumn = new ResourceLocation(AudreysAdditions.MODID, "block/lightcolumn_right");
                    threeDeeRotating(value, leftColumn);
                    continue;
                }

                if(value == AudBlocks.LIGHTCOLUMN_LEFT.get()){
                    ResourceLocation leftColumn = new ResourceLocation(AudreysAdditions.MODID, "block/lightcolumn_left");
                    threeDeeRotating(value, leftColumn);
                    continue;
                }

                if(value == AudBlocks.ARMCHAIR.get()){
                    ResourceLocation armChairModel = new ResourceLocation(AudreysAdditions.MODID, "block/armchair");
                    threeDeeRotating(value, armChairModel);
                    continue;
                }

                if(value == AudBlocks.KNOSSOS_THRONE.get()){
                    simpleBlockParticleOnly(value, new ResourceLocation("block/spruce_planks"));
                    continue;
                }

                if(value == AudBlocks.FOLD_OUT_BED.get()){
                    simpleBlockParticleOnly(value, new ResourceLocation("block/black_wool"));
                    continue;
                }

                if(value == AudBlocks.CEILING_CANOPY.get()){
                    simpleBlockParticleOnly(value, new ResourceLocation("block/quartz_pillar"));
                    continue;
                }

                if(value == AudBlocks.ASTRAL_MAP.get()){
                    simpleBlockParticleOnly(value, new ResourceLocation("block/clay"));
                    continue;
                }

                if(value == AudBlocks.FOOD_MACHINE.get()){
                    simpleBlockParticleOnly(value, new ResourceLocation("block/clay"));
                    continue;
                }

                if (value instanceof MonitorBlock monitorBlock) {
                    ResourceLocation vicMon = new ResourceLocation(AudreysAdditions.MODID, "block/" + location.getPath());
                    threeDeeRotating(monitorBlock, vicMon);
                    continue;
                }


                simpleBlock(value);
            }
        }
    }


    private void simpleBlockParticleOnly(Block block, ResourceLocation particleTexture) {

        @Nullable ResourceLocation key = BuiltInRegistries.BLOCK.getKey(block);

        models().getBuilder(key.toString())
                .texture("particle", particleTexture);

        getVariantBuilder(block)
                .partialState().modelForState()
                .modelFile(models().getExistingFile(modLoc("block/" + key.getPath())))
                .addModel();
    }

    public JsonObject customLocation(Block block, ResourceLocation resourceLocation) {
        return getVariantBuilder(block).partialState().modelForState().modelFile(models().getExistingFile(resourceLocation)).addModel().toJson();
    }

    // Paul McGann is...
    public JsonObject threeDeeRotating(Block block, ResourceLocation location) {
        return getVariantBuilder(block).forAllStates(
                state -> ConfiguredModel.builder().modelFile(new ModelFile.UncheckedModelFile(location)).rotationY((int) state.getValue(HorizontalDirectionalBlock.FACING).toYRot()).build()).toJson();
    }




}