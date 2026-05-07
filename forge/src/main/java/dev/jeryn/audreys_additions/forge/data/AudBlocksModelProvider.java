package dev.jeryn.audreys_additions.forge.data;

import com.google.gson.JsonObject;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.blocks.HatStandBlock;
import dev.jeryn.audreys_additions.common.blocks.MonitorBlock;
import dev.jeryn.audreys_additions.common.blocks.SpecimenJarBlock;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class AudBlocksModelProvider extends BlockStateProvider {

    public AudBlocksModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), AudreysAdditions.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        for (Block value : ForgeRegistries.BLOCKS.getValues()) {

            @Nullable ResourceLocation location = ForgeRegistries.BLOCKS.getKey(value);

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

                if (value instanceof HatStandBlock) {
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

                if(value instanceof SpecimenJarBlock specimenJarBlock){
                    ResourceLocation specimenJarBlockModel = new ResourceLocation("block/red_stained_glass");
                    simpleBlockParticleOnly(value, specimenJarBlockModel);
                    continue;
                }

                if (value == AudBlocks.ZEITON_QUARTZ_BLOCK.get()) {
                    continue;
                }

                if (value == AudBlocks.ZEITON_QUARTZ_PILLAR.get()) {
                    continue;
                }

                if (value == AudBlocks.CHISELED_ZEITON_QUARTZ_BLOCK.get()) {
                    continue;
                }

                if (value == AudBlocks.TREATED_CHISELED_ZEITON_QUARTZ_BLOCK.get()) {
                    continue;
                }

                if (location.getPath().contains("stairs")) {
                    continue;
                }

                if (location.getPath().contains("slab")) {
                    continue;
                }

                if (location.getPath().contains("door")) {
                    continue;
                }

                if (location.getPath().contains("overlay")) {
                    continue;
                }

                if (location.getPath().contains("cabinet")) {
                    continue;
                }

                if (location.getPath().contains("hatstand")) {
                    continue;
                }


                simpleBlock(value);
            }
        }

        stairsBlock(AudBlocks.SMOOTH_ZEITON_QUARTZ_STAIRS.get(), new ResourceLocation(AudreysAdditions.MODID, "block/smooth_zeiton_quartz"));
        stairsBlock(AudBlocks.ZEITON_QUARTZ_STAIRS.get(), new ResourceLocation(AudreysAdditions.MODID, "block/zeiton_quartz_block_side"));

        autoCubeTopBottom(AudBlocks.ZEITON_QUARTZ_BLOCK.get());


        //simpleCubeTopBottom(AudBlocks.ZEITON_QUARTZ_PILLAR.get(), new ResourceLocation(AudreysAdditions.MODID, "block/zeiton_quartz_pillar_top"), new ResourceLocation(AudreysAdditions.MODID, "block/zeiton_quartz_pillar_top"), new ResourceLocation(AudreysAdditions.MODID, "block/zeiton_quartz_pillar"));
       // simpleCubeTopBottom(AudBlocks.CHISELED_ZEITON_QUARTZ_BLOCK.get(), new ResourceLocation(AudreysAdditions.MODID, "block/chiseled_zeiton_quartz_block_top"), new ResourceLocation(AudreysAdditions.MODID, "block/chiseled_zeiton_quartz_block_top"), new ResourceLocation(AudreysAdditions.MODID, "block/chiseled_zeiton_quartz_block"));

        logBlock(AudBlocks.CHISELED_ZEITON_QUARTZ_BLOCK.get());
        logBlock(AudBlocks.TREATED_CHISELED_ZEITON_QUARTZ_BLOCK.get());
        logBlock(AudBlocks.ZEITON_QUARTZ_PILLAR.get());

        slabBlock(AudBlocks.ZEITON_QUARTZ_SLAB.get(), new ResourceLocation(AudreysAdditions.MODID, "zeiton_quartz_block"),  new ResourceLocation(AudreysAdditions.MODID, "block/zeiton_quartz_block_side"));
        slabBlock(AudBlocks.SMOOTH_ZEITON_QUARTZ_SLAB.get(), new ResourceLocation(AudreysAdditions.MODID, "smooth_zeiton_quartz"),  new ResourceLocation(AudreysAdditions.MODID, "block/zeiton_quartz_block_bottom"));

        doorBlockWithRenderType(AudBlocks.TREATED_ZEITON_QUARTZ_DOOR.get(), new ResourceLocation(AudreysAdditions.MODID, "block/treated_zeiton_quartz_door_bottom"),  new ResourceLocation(AudreysAdditions.MODID, "block/treated_zeiton_quartz_door_top"), "cutout");


        doorBlockWithRenderType(AudBlocks.ZEITON_QUARTZ_DOOR.get(), new ResourceLocation(AudreysAdditions.MODID, "block/zeiton_quartz_door_bottom"),  new ResourceLocation(AudreysAdditions.MODID, "block/zeiton_quartz_door_top"), "cutout");

        vineSupport(AudBlocks.ROUNDEL_OVERLAY_FULL.get());
        vineSupport(AudBlocks.ROUNDEL_OVERLAY_HALF.get());

    }

    private void vineSupport(Block block) {
        ResourceLocation key = ForgeRegistries.BLOCKS.getKey(block);
        assert key != null;

        String name = key.getPath();
        ResourceLocation texture = modLoc("block/" + name);

        // Derived model: a simple flat plane exactly like vanilla vines
        ModelFile model = models().withExistingParent(name, new ResourceLocation(AudreysAdditions.MODID, "block/overlay"))
                .texture("vine", texture)
                .texture("particle", texture)
                .renderType("cutout");

        MultiPartBlockStateBuilder multipart = getMultipartBuilder(block);

        // SOUTH — default facing direction
        multipart.part()
                .modelFile(model)
                .rotationX(0)
                .rotationY(0)
                .addModel()
                .condition(BlockStateProperties.NORTH, true);

// WEST
        multipart.part()
                .modelFile(model)
                .rotationX(0)
                .rotationY(90)
                .addModel()
                .condition(BlockStateProperties.EAST, true);

// NORTH
        multipart.part()
                .modelFile(model)
                .rotationX(0)
                .rotationY(180)
                .addModel()
                .condition(BlockStateProperties.SOUTH, true);

// EAST
        multipart.part()
                .modelFile(model)
                .rotationX(0)
                .rotationY(270)
                .addModel()
                .condition(BlockStateProperties.WEST, true);

// UP
        multipart.part()
                .modelFile(model)
                .rotationX(270)
                .rotationY(0)
                .addModel()
                .condition(BlockStateProperties.UP, true);

// DOWN
        multipart.part()
                .modelFile(model)
                .rotationX(90)
                .rotationY(0)
                .addModel()
                .condition(BlockStateProperties.DOWN, true);

    }



    private void autoCubeTopBottom(Block block) {
        ResourceLocation key = ForgeRegistries.BLOCKS.getKey(block);
        assert key != null;
        String base = key.getPath();

        ResourceLocation top = modLoc("block/" + base + "_top");
        ResourceLocation bottom = modLoc("block/" + base + "_bottom");
        ResourceLocation side = modLoc("block/" + base + "_side");

        ModelFile model = models().withExistingParent(base, "block/cube")
                .texture("particle", side)
                .texture("north", side)
                .texture("south", side)
                .texture("east", side)
                .texture("west", side)
                .texture("up", top)
                .texture("down", bottom);

        simpleBlock(block, model);
    }


    private void simpleCubeTopBottom(Block block, ResourceLocation top, ResourceLocation bottom, ResourceLocation side) {
        ResourceLocation key = ForgeRegistries.BLOCKS.getKey(block);

        ModelFile model = models().withExistingParent(key.getPath(), "block/cube")
                .texture("particle", side)
                .texture("north", side)
                .texture("south", side)
                .texture("east", side)
                .texture("west", side)
                .texture("up", top)
                .texture("down", bottom);

        simpleBlock(block, model);
    }


    private void simpleBlockParticleOnly(Block block, ResourceLocation particleTexture) {

        @Nullable ResourceLocation key = ForgeRegistries.BLOCKS.getKey(block);

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