package dev.jeryn.audreys_additions.forge.data;

import dev.jeryn.audreys_additions.AudTags;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.data.recipes.packs.VanillaRecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.datafix.fixes.FurnaceRecipeFix;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import whocraft.tardis_refined.registry.TRBlockRegistry;
import whocraft.tardis_refined.registry.TRItemRegistry;


import java.util.List;
import java.util.function.Consumer;

public class AudRecipeProvider extends RecipeProvider {

    public AudRecipeProvider(PackOutput arg) {
        super(arg);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.BRACHACKI_MONITOR.get()).pattern("QRQ").pattern("QGQ").pattern("QZQ").define('Q', Blocks.QUARTZ_BLOCK).define('G', Blocks.GRAY_STAINED_GLASS).define('R', Blocks.REDSTONE_WIRE).define('Z', TRItemRegistry.ZEITON_INGOT.get()).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.LIMINTON_MONITOR.get()).pattern("QRQ").pattern("QGQ").pattern("QZQ").define('Q', Blocks.DARK_OAK_PLANKS).define('G', Blocks.GRAY_STAINED_GLASS).define('R', Blocks.REDSTONE_WIRE).define('Z', TRItemRegistry.ZEITON_INGOT.get()).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.CEILING_CANOPY.get()).pattern("QQQ").pattern("CLC").pattern("QQQ").define('Q', Blocks.QUARTZ_BLOCK).define('C', Blocks.CHAIN).define('L', Blocks.REDSTONE_LAMP).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.LIGHTCOLUMN_RIGHT.get())
                .pattern("L  ")
                .pattern(" G ")
                .pattern("  Q")
                .define('Q', (AudTags.ZEITON_BLOCKS))
                .define('G', Blocks.GLASS)
                .define('L', Blocks.REDSTONE_LAMP)
                .unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.LIGHTCOLUMN_LEFT.get()).pattern("  Q").pattern(" G ").pattern("L  ").define('Q', (AudTags.ZEITON_BLOCKS)).define('G', Blocks.GLASS).define('L', Blocks.REDSTONE_LAMP).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.TREATED_LIGHTCOLUMN_RIGHT.get()).pattern("L  ").pattern(" G ").pattern("  Q").define('Q', Blocks.QUARTZ_BLOCK).define('G', Blocks.GLASS).define('L', Blocks.REDSTONE_LAMP).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.TREATED_LIGHTCOLUMN_LEFT.get()).pattern("  Q").pattern(" G ").pattern("L  ").define('Q', Blocks.QUARTZ_BLOCK).define('G', Blocks.GLASS).define('L', Blocks.REDSTONE_LAMP).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.FOLD_OUT_BED.get()).pattern("   ").pattern(" RB").pattern("  I").define('B', ItemTags.BEDS).define('R', Blocks.REDSTONE_WIRE).define('I', Items.IRON_INGOT).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.KNOSSOS_THRONE.get()).pattern(" P ").pattern(" P ").pattern(" F ").define('P', ItemTags.PLANKS).define('F', ItemTags.FENCES).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.ARMCHAIR.get()).pattern(" P ").pattern(" W ").pattern(" F ").define('P', ItemTags.PLANKS).define('W', ItemTags.WOOL).define('F', ItemTags.FENCES).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.ASTRAL_MAP.get()).pattern(" R ").pattern("IGI").pattern(" Z ").define('R', Blocks.REDSTONE_WIRE).define('I', Items.IRON_INGOT).define('G', Blocks.GRAY_STAINED_GLASS).define('Z', TRItemRegistry.ZEITON_INGOT.get()).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.SPECIMEN_JAR.get(), 4)
                .pattern(" G ")
                .pattern("GSG")
                .pattern(" G ")
                .define('G', Blocks.RED_STAINED_GLASS)
                .define('S', Blocks.STONE)
                .unlockedBy("has_glass", has(Blocks.RED_STAINED_GLASS))
                .save(consumer);

        VanillaRecipeProvider.cut(consumer, RecipeCategory.BUILDING_BLOCKS, AudBlocks.HATSTAND_ACACIA.get(), Blocks.ACACIA_PLANKS);


        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.CHISELED_ZEITON_QUARTZ_BLOCK.get())
                .pattern(" S ")
                .pattern(" S ")
                .define('S', AudBlocks.ZEITON_QUARTZ_SLAB.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.ZEITON_QUARTZ_PILLAR.get())
                .pattern(" S ")
                .pattern(" S ")
                .define('S', AudBlocks.ZEITON_QUARTZ_BLOCK.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.ZEITON_QUARTZ_SLAB.get(), 6)
                .pattern("BBB")
                .define('B', AudTags.NON_STAIR_ZEITON_BLOCKS)
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.SMOOTH_ZEITON_QUARTZ_SLAB.get(), 6)
                .pattern("BBB")
                .define('B', AudBlocks.SMOOTH_ZEITON_QUARTZ_BLOCK.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.ZEITON_QUARTZ_BRICKS.get(), 4)
                .pattern("BB ")
                .pattern("BB ")
                .define('B', AudBlocks.ZEITON_QUARTZ_BLOCK.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.ZEITON_QUARTZ_STAIRS.get(), 4)
                .pattern("B  ")
                .pattern("BB ")
                .pattern("BBB")
                .define('B', AudBlocks.ZEITON_QUARTZ_BLOCK.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.SMOOTH_ZEITON_QUARTZ_STAIRS.get(), 4)
                .pattern("B  ")
                .pattern("BB ")
                .pattern("BBB")
                .define('B', AudBlocks.SMOOTH_ZEITON_QUARTZ_BLOCK.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.ZEITON_QUARTZ_DOOR.get(), 3)
                .pattern("BB ")
                .pattern("BB ")
                .pattern("BB ")
                .define('B', AudBlocks.ZEITON_QUARTZ_BLOCK.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.TREATED_ZEITON_QUARTZ_DOOR.get(), 3)
                .pattern("BB ")
                .pattern("BB ")
                .pattern("BB ")
                .define('B', Items.QUARTZ)
                .unlockedBy("has_quartz", has(Items.QUARTZ))
                .save(consumer);

        // Smelting example
         SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(AudBlocks.ZEITON_QUARTZ_BLOCK.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        AudBlocks.SMOOTH_ZEITON_QUARTZ_BLOCK.get(),
                        0.1f,
                        200)
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer);

        // Stonecutting example
        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(AudTags.ZEITON_BLOCKS),
                        RecipeCategory.BUILDING_BLOCKS,
                        AudBlocks.ZEITON_QUARTZ_SLAB.get(),
                        2)
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "zeiton_quartz_slab_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(AudTags.ZEITON_BLOCKS),
                        RecipeCategory.BUILDING_BLOCKS,
                        AudBlocks.ZEITON_QUARTZ_STAIRS.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "zeiton_quartz_stairs_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(AudTags.ZEITON_BLOCKS),
                        RecipeCategory.BUILDING_BLOCKS,
                        AudBlocks.ZEITON_QUARTZ_BRICKS.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "zeiton_quartz_bricks_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(AudTags.ZEITON_BLOCKS),
                        RecipeCategory.BUILDING_BLOCKS,
                        AudBlocks.ZEITON_QUARTZ_PILLAR.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "zeiton_quartz_pillar_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(AudTags.ZEITON_BLOCKS),
                        RecipeCategory.BUILDING_BLOCKS,
                        AudBlocks.SMOOTH_ZEITON_QUARTZ_BLOCK.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "smooth_zeiton_quartz_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(AudTags.ZEITON_BLOCKS),
                        RecipeCategory.BUILDING_BLOCKS,
                        AudBlocks.SMOOTH_ZEITON_QUARTZ_SLAB.get(),
                        2)
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "smooth_zeiton_quartz_slab_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(AudTags.ZEITON_BLOCKS),
                        RecipeCategory.BUILDING_BLOCKS,
                        AudBlocks.SMOOTH_ZEITON_QUARTZ_STAIRS.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "smooth_zeiton_quartz_stairs_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(AudTags.ZEITON_BLOCKS),
                        RecipeCategory.BUILDING_BLOCKS,
                        AudBlocks.TREATED_ZEITON_QUARTZ_BRICKS.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "treated_zeiton_quartz_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(AudTags.ZEITON_BLOCKS),
                        RecipeCategory.BUILDING_BLOCKS,
                        AudBlocks.CHISELED_ZEITON_QUARTZ_BLOCK.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "chiseled_zeiton_quartz_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(
                        Ingredient.of(AudTags.ZEITON_BLOCKS),
                        RecipeCategory.BUILDING_BLOCKS,
                        AudBlocks.TREATED_CHISELED_ZEITON_QUARTZ_BLOCK.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "treated_chiseled_zeiton_quartz_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.ROUNDEL_OVERLAY_FULL.get(), 16)
                .pattern(" G ")
                .pattern("DZG")
                .pattern(" D ")
                .define('G', Blocks.GLASS)
                .define('D', Items.GLOWSTONE_DUST)
                .define('Z', TRItemRegistry.ZEITON_NUGGET.get())
                .unlockedBy("has_zeiton", has(TRItemRegistry.ZEITON_INGOT.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, AudBlocks.ROUNDEL_OVERLAY_HALF.get())
                .requires(AudBlocks.ROUNDEL_OVERLAY_FULL.get())
                .unlockedBy("has_zeiton", has(TRItemRegistry.ZEITON_INGOT.get()))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "half_roundel_from_full"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, AudBlocks.ROUNDEL_OVERLAY_FULL.get())
                .requires(AudBlocks.ROUNDEL_OVERLAY_HALF.get())
                .unlockedBy("has_zeiton", has(TRItemRegistry.ZEITON_INGOT.get()))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "full_roundel_from_half"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, AudBlocks.TREATED_ZEITON_QUARTZ_BRICKS.get())
                .requires(AudBlocks.ZEITON_QUARTZ_BRICKS.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "treated_bricks_from_bricks"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, AudBlocks.ZEITON_QUARTZ_BRICKS.get())
                .requires(AudBlocks.TREATED_ZEITON_QUARTZ_BRICKS.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "bricks_from_treated_bricks"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, AudBlocks.TREATED_CHISELED_ZEITON_QUARTZ_BLOCK.get())
                .requires(AudBlocks.CHISELED_ZEITON_QUARTZ_BLOCK.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "treated_chiseled_from_chiseled"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, AudBlocks.CHISELED_ZEITON_QUARTZ_BLOCK.get())
                .requires(AudBlocks.TREATED_CHISELED_ZEITON_QUARTZ_BLOCK.get())
                .unlockedBy("has_zeiton_quartz", has(AudBlocks.ZEITON_QUARTZ_BLOCK.get()))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "chiseled_from_treated_chiseled"));


        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.HATSTAND_BIRCH.get())
                .pattern("SSS")
                .pattern(" B ")
                .pattern("STS")
                .define('S', Items.STICK)
                .define('B', Blocks.BIRCH_PLANKS)
                .define('T', Blocks.SMOOTH_STONE_SLAB)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.HATSTAND_BAMBOO.get())
                .pattern("SSS")
                .pattern(" B ")
                .pattern("STS")
                .define('S', Items.STICK)
                .define('B', Blocks.BAMBOO_BLOCK)
                .define('T', Blocks.SMOOTH_STONE_SLAB)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.HATSTAND_ACACIA.get())
                .pattern("SSS")
                .pattern(" B ")
                .pattern("STS")
                .define('S', Items.STICK)
                .define('B', Blocks.ACACIA_PLANKS)
                .define('T', Blocks.SMOOTH_STONE_SLAB)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "hatstand_acacia_crafting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.HATSTAND_CHERRY.get())
                .pattern("SSS")
                .pattern(" B ")
                .pattern("STS")
                .define('S', Items.STICK)
                .define('B', Blocks.CHERRY_PLANKS)
                .define('T', Blocks.SMOOTH_STONE_SLAB)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.HATSTAND_CRIMSON.get())
                .pattern("SSS")
                .pattern(" B ")
                .pattern("STS")
                .define('S', Items.STICK)
                .define('B', Blocks.CRIMSON_PLANKS)
                .define('T', Blocks.SMOOTH_STONE_SLAB)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.HATSTAND_DARK_OAK.get())
                .pattern("SSS")
                .pattern(" B ")
                .pattern("STS")
                .define('S', Items.STICK)
                .define('B', Blocks.DARK_OAK_PLANKS)
                .define('T', Blocks.SMOOTH_STONE_SLAB)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.HATSTAND_JUNGLE.get())
                .pattern("SSS")
                .pattern(" B ")
                .pattern("STS")
                .define('S', Items.STICK)
                .define('B', Blocks.JUNGLE_PLANKS)
                .define('T', Blocks.SMOOTH_STONE_SLAB)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.HATSTAND_MANGROVE.get())
                .pattern("SSS")
                .pattern(" B ")
                .pattern("STS")
                .define('S', Items.STICK)
                .define('B', Blocks.MANGROVE_PLANKS)
                .define('T', Blocks.SMOOTH_STONE_SLAB)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.HATSTAND_OAK.get())
                .pattern("SSS")
                .pattern(" B ")
                .pattern("STS")
                .define('S', Items.STICK)
                .define('B', Blocks.OAK_PLANKS)
                .define('T', Blocks.SMOOTH_STONE_SLAB)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.HATSTAND_PALE.get())
                .pattern("SSS")
                .pattern(" B ")
                .pattern("STS")
                .define('S', Items.STICK)
                .define('B', Blocks.DIORITE)
                .define('T', Blocks.SMOOTH_STONE_SLAB)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "hatstand_pale_a"));


        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.HATSTAND_PALE.get())
                .pattern("SSS")
                .pattern("DB ")
                .pattern("STS")
                .define('S', Items.STICK)
                .define('D', Items.WHITE_DYE)
                .define('B', Blocks.OAK_PLANKS)
                .define('T', Blocks.SMOOTH_STONE_SLAB)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "hatstand_pale_b"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.HATSTAND_PALE.get())
                .pattern("SSS")
                .pattern(" B ")
                .pattern("STS")
                .define('S', Items.STICK)
                .define('B', Blocks.CALCITE)
                .define('T', Blocks.SMOOTH_STONE_SLAB)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "hatstand_pale_c"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, AudBlocks.HATSTAND_PALE.get())
                .requires(AudBlocks.HATSTAND_OAK.get())
                .requires(Items.WHITE_DYE)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer, new ResourceLocation(AudreysAdditions.MODID, "hatstand_pale_d"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.HATSTAND_WARPED.get())
                .pattern("SSS")
                .pattern(" B ")
                .pattern("STS")
                .define('S', Items.STICK)
                .define('B', Blocks.WARPED_PLANKS)
                .define('T', Blocks.SMOOTH_STONE_SLAB)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.HATSTAND_SPRUCE.get())
                .pattern("SSS")
                .pattern(" B ")
                .pattern("STS")
                .define('S', Items.STICK)
                .define('B', Blocks.SPRUCE_PLANKS)
                .define('T', Blocks.SMOOTH_STONE_SLAB)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.CABINET.get())
                .pattern("PPP")
                .pattern("P P")
                .pattern("SSS")
                .define('P', ItemTags.PLANKS)
                .define('S', Blocks.SMOOTH_STONE_SLAB)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(consumer);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, AudBlocks.SPECIMEN_JAR_CREEPER.get())
                .requires(AudBlocks.SPECIMEN_JAR.get())
                .requires(Items.CREEPER_HEAD)
                .unlockedBy("has_creeper_head", has(Items.CREEPER_HEAD))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, AudBlocks.SPECIMEN_JAR_DRAGON.get())
                .requires(AudBlocks.SPECIMEN_JAR.get())
                .requires(Items.DRAGON_HEAD)
                .unlockedBy("has_dragon_head", has(Items.DRAGON_HEAD))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, AudBlocks.SPECIMEN_JAR_PIGLIN.get())
                .requires(AudBlocks.SPECIMEN_JAR.get())
                .requires(Items.PIGLIN_HEAD)
                .unlockedBy("has_piglin_head", has(Items.PIGLIN_HEAD))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, AudBlocks.SPECIMEN_JAR_SKELETON.get())
                .requires(AudBlocks.SPECIMEN_JAR.get())
                .requires(Items.SKELETON_SKULL)
                .unlockedBy("has_skeleton_skull", has(Items.SKELETON_SKULL))
                .save(consumer);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, AudBlocks.SPECIMEN_JAR_WITHERSKELETON.get())
                .requires(AudBlocks.SPECIMEN_JAR.get())
                .requires(Items.WITHER_SKELETON_SKULL)
                .unlockedBy("has_wither_skeleton_skull", has(Items.WITHER_SKELETON_SKULL))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, AudBlocks.SPECIMEN_JAR_ZOMBIE.get())
                .requires(AudBlocks.SPECIMEN_JAR.get())
                .requires(Items.ZOMBIE_HEAD)
                .unlockedBy("has_zombie_head", has(Items.ZOMBIE_HEAD))
                .save(consumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.FOOD_MACHINE.get())
                .pattern("ZDZ")
                .pattern("ZGZ")
                .pattern("ZCZ")
                .define('Z', TRItemRegistry.ZEITON_INGOT.get())
                .define('D', Blocks.DISPENSER)
                .define('G', Blocks.GRASS)
                .define('C', Blocks.COMPOSTER)
                .unlockedBy("has_zeiton", has(TRItemRegistry.ZEITON_INGOT.get()))
                .save(consumer);

    }
}
