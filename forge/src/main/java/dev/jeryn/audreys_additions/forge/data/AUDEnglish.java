package dev.jeryn.audreys_additions.forge.data;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import dev.jeryn.audreys_additions.common.registry.AudItems;
import dev.jeryn.audreys_additions.common.registry.AudShellRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import whocraft.tardis_refined.common.tardis.themes.ShellTheme;

public class AUDEnglish extends LanguageProvider {

    public AUDEnglish(DataGenerator gen) {
        super(gen.getPackOutput(), AudreysAdditions.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addShell(AudShellRegistry.POLICEBOX_2018.get(), ChatFormatting.BLUE + "Police Box " + ChatFormatting.YELLOW + "(2018)");
        addShell(AudShellRegistry.POLICEBOX_2010.get(), ChatFormatting.BLUE + "Police Box " + ChatFormatting.YELLOW + "(2010)");
        addShell(AudShellRegistry.POLICEBOX_2005.get(), ChatFormatting.BLUE + "Police Box " + ChatFormatting.YELLOW + "(2005)");
        addShell(AudShellRegistry.POLICEBOX_1976.get(), ChatFormatting.BLUE + "Police Box " + ChatFormatting.YELLOW + "(1976)");
        addShell(AudShellRegistry.POLICEBOX_1996.get(), ChatFormatting.BLUE + "Police Box " + ChatFormatting.YELLOW + "(1996)");
        addShell(AudShellRegistry.POLICEBOX_1980.get(), ChatFormatting.BLUE + "Police Box " + ChatFormatting.YELLOW + "(1980)");
        addShell(AudShellRegistry.POLICEBOX_1963.get(), ChatFormatting.BLUE + "Police Box " + ChatFormatting.YELLOW + "(1963)");
        addShell(AudShellRegistry.POLICEBOX_1966.get(), ChatFormatting.BLUE + "Police Box " + ChatFormatting.YELLOW + "(1966)");
        addShell(AudShellRegistry.SIDRAT.get(), ChatFormatting.BLUE + "SIDRAT");
        addShell(AudShellRegistry.IRON_MAIDEN.get(), ChatFormatting.BLUE + "Iron Maiden");
        addShell(AudShellRegistry.TT_CAPSULE.get(), ChatFormatting.BLUE + "TT Capsule");
        addShell(AudShellRegistry.COLUMN.get(), ChatFormatting.BLUE + "Sandstone Column");
        addShell(AudShellRegistry.TRAKENCLOCK.get(), ChatFormatting.BLUE + "Traken Clock");
        addShell(AudShellRegistry.GRANDFATHER_CLOCK.get(), ChatFormatting.BLUE + "Grandfather Clock");
        addShell(AudShellRegistry.TELEPHONE_BOOTH.get(), ChatFormatting.BLUE + "Telephone Booth");
        addShell(AudShellRegistry.RANI_WARDROBE.get(), ChatFormatting.BLUE + "Rani's Wardrobe");
        addShell(AudShellRegistry.LAKERTYAN_PYRAMID.get(), ChatFormatting.BLUE + "Lakertyan Pyramid");
        addShell(AudShellRegistry.CABINET.get(), ChatFormatting.BLUE + "TARDIS Cabinet");

        add(AudBlocks.KNOSSOS_THRONE.get(), "Knossos Throne");
        add(AudBlocks.LIMINTON_MONITOR.get(), "Liminton Monitor");
        add(AudBlocks.BRACHACKI_MONITOR.get(), "Brachacki Monitor");
        add(AudBlocks.FOOD_MACHINE.get(), "Food Machine");
        add(AudBlocks.LIGHTCOLUMN_LEFT.get(), "Light Column (Left)");
        add(AudBlocks.LIGHTCOLUMN_RIGHT.get(), "Light Column (Right)");
        add(AudBlocks.ASTRAL_MAP.get(), "Astral Map");
        add(AudBlocks.ARMCHAIR.get(), "Armchair");
        add(AudBlocks.CEILING_CANOPY.get(), "Ceiling Canopy");
        add(AudBlocks.FOLD_OUT_BED.get(), "Foldout Bed");

        add(AudBlocks.SPECIMEN_JAR.get(), "Specimen Jar");
        add(AudBlocks.SPECIMEN_JAR_ALLAY.get(), "Specimen Jar (" + ChatFormatting.AQUA + "Allay" + ChatFormatting.RESET + ")");
        add(AudBlocks.SPECIMEN_JAR_CREEPER.get(), "Specimen Jar (" + ChatFormatting.GREEN + "Creeper" + ChatFormatting.RESET + ")");
        add(AudBlocks.SPECIMEN_JAR_DRAGON.get(), "Specimen Jar (" + ChatFormatting.DARK_PURPLE + "Dragon" + ChatFormatting.RESET + ")");
        add(AudBlocks.SPECIMEN_JAR_PIGLIN.get(), "Specimen Jar (" + ChatFormatting.GOLD + "Piglin" + ChatFormatting.RESET + ")");
        add(AudBlocks.SPECIMEN_JAR_SKELETON.get(), "Specimen Jar (" + ChatFormatting.GRAY + "Skeleton" + ChatFormatting.RESET + ")");
        add(AudBlocks.SPECIMEN_JAR_VEX.get(), "Specimen Jar (" + ChatFormatting.BLUE + "Vex" + ChatFormatting.RESET + ")");
        add(AudBlocks.SPECIMEN_JAR_WITHERSKELETON.get(), "Specimen Jar (" + ChatFormatting.DARK_GRAY + "Wither Skeleton" + ChatFormatting.RESET + ")");
        add(AudBlocks.SPECIMEN_JAR_ZOMBIE.get(), "Specimen Jar (" + ChatFormatting.DARK_GREEN + "Zombie" + ChatFormatting.RESET + ")");
        add(AudBlocks.ZEITON_QUARTZ_BLOCK.get(), "Zeiton Quartz Block");
        add(AudBlocks.ZEITON_QUARTZ_SLAB.get(), "Zeiton Quartz Slab");
        add(AudBlocks.ZEITON_QUARTZ_STAIRS.get(), "Zeiton Quartz Stairs");
        add(AudBlocks.SMOOTH_ZEITON_QUARTZ_BLOCK.get(), "Smooth Zeiton Quartz");
        add(AudBlocks.SMOOTH_ZEITON_QUARTZ_SLAB.get(), "Smooth Zeiton Quartz Slab");
        add(AudBlocks.SMOOTH_ZEITON_QUARTZ_STAIRS.get(), "Smooth Zeiton Quartz Stairs");
        add(AudBlocks.ZEITON_QUARTZ_PILLAR.get(), "Zeiton Quartz Pillar");
        add(AudBlocks.CHISELED_ZEITON_QUARTZ_BLOCK.get(), "Chiseled Zeiton Quartz Block");
        add(AudBlocks.TREATED_ZEITON_QUARTZ_BLOCK.get(), "Treated Zeiton Quartz Block");
        add(AudBlocks.ZEITON_QUARTZ_BRICKS.get(), "Zeiton Quartz Bricks");


        add(AudItems.FOOD_CUBE.get(), "Food Cube");





    }

    public void addShell(ShellTheme theme, String name) {
        this.add(theme.getTranslationKey(), name);
    }
}
