package dev.jeryn.audreys_additions.forge.data;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.registry.AudShellRegistry;
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
    }

    public void addShell(ShellTheme theme, String name) {
        this.add(theme.getTranslationKey(), name);
    }
}
