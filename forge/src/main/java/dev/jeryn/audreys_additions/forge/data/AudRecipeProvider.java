package dev.jeryn.audreys_additions.forge.data;

import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import whocraft.tardis_refined.registry.TRBlockRegistry;
import whocraft.tardis_refined.registry.TRItemRegistry;

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
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.LIGHTCOLUMN_RIGHT.get()).pattern("   ").pattern("LGQ").pattern("   ").define('Q', Blocks.QUARTZ_BLOCK).define('G', Blocks.GLASS).define('L', Blocks.REDSTONE_LAMP).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.LIGHTCOLUMN_LEFT.get()).pattern("   ").pattern("QGL").pattern("   ").define('Q', Blocks.QUARTZ_BLOCK).define('G', Blocks.GLASS).define('L', Blocks.REDSTONE_LAMP).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.FOLD_OUT_BED.get()).pattern("   ").pattern(" RB").pattern("  I").define('B', ItemTags.BEDS).define('R', Blocks.REDSTONE_WIRE).define('I', Items.IRON_INGOT).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.KNOSSOS_THRONE.get()).pattern(" P ").pattern(" P ").pattern(" F ").define('P', ItemTags.PLANKS).define('F', ItemTags.FENCES).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.ARMCHAIR.get()).pattern(" P ").pattern(" W ").pattern(" F ").define('P', ItemTags.PLANKS).define('W', ItemTags.WOOL).define('F', ItemTags.FENCES).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.ASTRAL_MAP.get()).pattern(" R ").pattern("IGI").pattern(" Z ").define('R', Blocks.REDSTONE_WIRE).define('I', Items.IRON_INGOT).define('G', Blocks.GRAY_STAINED_GLASS).define('Z', TRItemRegistry.ZEITON_INGOT.get()).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.SPECIMEN_JAR.get())
                .pattern(" G ")
                .pattern("GSG")
                .pattern(" G ")
                .define('G', Blocks.RED_STAINED_GLASS)
                .define('S', Blocks.STONE)
                .unlockedBy("has_glass", has(Blocks.RED_STAINED_GLASS))
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
