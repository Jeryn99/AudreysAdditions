package dev.jeryn.audreys_additions.forge.data;

import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import whocraft.tardis_refined.registry.TRBlockRegistry;
import whocraft.tardis_refined.registry.TRItemRegistry;

public class AudRecipeProvider extends RecipeProvider {

    public AudRecipeProvider(PackOutput arg) {
        super(arg);
    }


    @Override
    protected void buildRecipes(RecipeOutput arg) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.BRACHACKI_MONITOR.get()).pattern("QRQ").pattern("QGQ").pattern("QZQ").define('Q', Blocks.QUARTZ_BLOCK).define('G', Blocks.GRAY_STAINED_GLASS).define('R', Blocks.REDSTONE_WIRE).define('Z', TRItemRegistry.ZEITON_INGOT.get()).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(arg);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.LIMINTON_MONITOR.get()).pattern("QRQ").pattern("QGQ").pattern("QZQ").define('Q', Blocks.DARK_OAK_PLANKS).define('G', Blocks.GRAY_STAINED_GLASS).define('R', Blocks.REDSTONE_WIRE).define('Z', TRItemRegistry.ZEITON_INGOT.get()).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(arg);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.CEILING_CANOPY.get()).pattern("QQQ").pattern("CLC").pattern("QQQ").define('Q', Blocks.QUARTZ_BLOCK).define('C', Blocks.CHAIN).define('L', Blocks.REDSTONE_LAMP).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(arg);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.LIGHTCOLUMN_RIGHT.get()).pattern("   ").pattern("LGQ").pattern("   ").define('Q', Blocks.QUARTZ_BLOCK).define('G', Blocks.GLASS).define('L', Blocks.REDSTONE_LAMP).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(arg);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.LIGHTCOLUMN_LEFT.get()).pattern("   ").pattern("QGL").pattern("   ").define('Q', Blocks.QUARTZ_BLOCK).define('G', Blocks.GLASS).define('L', Blocks.REDSTONE_LAMP).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(arg);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.FOLD_OUT_BED.get()).pattern("   ").pattern(" RB").pattern("  I").define('B', ItemTags.BEDS).define('R', Blocks.REDSTONE_WIRE).define('I', Items.IRON_INGOT).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(arg);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.KNOSSOS_THRONE.get()).pattern(" P ").pattern(" P ").pattern(" F ").define('P', ItemTags.PLANKS).define('F', ItemTags.FENCES).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(arg);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.ARMCHAIR.get()).pattern(" P ").pattern(" W ").pattern(" F ").define('P', ItemTags.PLANKS).define('W', ItemTags.WOOL).define('F', ItemTags.FENCES).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(arg);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AudBlocks.ASTRAL_MAP.get()).pattern(" R ").pattern("IGI").pattern(" Z ").define('R', Blocks.REDSTONE_WIRE).define('I', Items.IRON_INGOT).define('G', Blocks.GRAY_STAINED_GLASS).define('Z', TRItemRegistry.ZEITON_INGOT.get()).unlockedBy("has_crafting_table", has(TRBlockRegistry.ASTRAL_MANIPULATOR_BLOCK.get())).save(arg);
    }
}
