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
        addShell(AudShellRegistry.POLICEBOX_2018.get(), ChatFormatting.BLUE + "Police Box (2018)");
        addShell(AudShellRegistry.POLICEBOX_2010.get(), ChatFormatting.BLUE + "Police Box (2010)");
        addShell(AudShellRegistry.POLICEBOX_1976.get(), ChatFormatting.BLUE + "Police Box (1976)");
        addShell(AudShellRegistry.POLICEBOX_1996.get(), ChatFormatting.BLUE + "Police Box (1996)");

        add(AudBlocks.KNOSSOS_THRONE.get(), "Knossos Throne");
        add(AudBlocks.LIMINTON_MONITOR.get(), "Liminton Monitor");
        add(AudBlocks.FOOD_MACHINE.get(), "Food Machine");
        add(AudBlocks.LIGHTCOLUMN_LEFT.get(), "Light Column (Left)");
        add(AudBlocks.LIGHTCOLUMN_RIGHT.get(), "Light Column (Right)");

        add(AudItems.FOOD_CUBE.get(), "Food Cube");
    }

    public void addShell(ShellTheme theme, String name) {
        this.add(theme.getTranslationKey(), name);
    }
}
