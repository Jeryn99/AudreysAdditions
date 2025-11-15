package dev.jeryn.audreys_additions.forge.data;

import dev.jeryn.audreys_additions.AudreysAdditions;
import net.minecraft.ChatFormatting;
import net.minecraft.data.DataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.TardisRefined;
import whocraft.tardis_refined.common.data.DesktopProvider;
import whocraft.tardis_refined.common.tardis.themes.DesktopTheme;
import whocraft.tardis_refined.common.util.MiscHelper;

public class AudDesktopProvider extends DesktopProvider {

    public AudDesktopProvider(DataGenerator generator) {
        super(generator);
    }

    public AudDesktopProvider(DataGenerator generator, boolean addDefaults) {
        super(generator, addDefaults);
    }

    @Override
    protected void addDesktops() {

        addDesktop(new DesktopTheme(
                new ResourceLocation(AudreysAdditions.MODID, "newbery"),
                new ResourceLocation(AudreysAdditions.MODID, "desktop/newbery"),
                TardisRefined.GSON.toJson(Component.literal(MiscHelper.getCleanName(ChatFormatting.YELLOW + "(1976) " + ChatFormatting.BLUE + "Secondary"))
        )));
//           TardisRefined.GSON.toJson(Component.literal(MiscHelper.getCleanName(ChatFormatting.BLUE + "Thorn" + ChatFormatting.YELLOW + "ton"))
        addDesktop(new DesktopTheme(
                new ResourceLocation(AudreysAdditions.MODID, "thornton"),
                new ResourceLocation(AudreysAdditions.MODID, "desktop/thornton"),
                TardisRefined.GSON.toJson(Component.literal(MiscHelper.getCleanName(ChatFormatting.YELLOW + "(1983) " + ChatFormatting.BLUE + "Thornton"))
        )));

        addDesktop(new DesktopTheme(
                new ResourceLocation(AudreysAdditions.MODID, "tremas"),
                new ResourceLocation(AudreysAdditions.MODID, "desktop/tremas"),
                TardisRefined.GSON.toJson(Component.literal(MiscHelper.getCleanName(ChatFormatting.YELLOW + "(1984) " + ChatFormatting.BLUE + "Tremas"))
        )));

        addDesktop(new DesktopTheme(
        new ResourceLocation(AudreysAdditions.MODID, "fugitive"),
                new ResourceLocation(AudreysAdditions.MODID, "desktop/fugitive"),
                TardisRefined.GSON.toJson(Component.literal(MiscHelper.getCleanName(ChatFormatting.YELLOW + "(2020) " + ChatFormatting.BLUE + "Fugitive"))
        )));

        addDesktop(new DesktopTheme(
                new ResourceLocation(AudreysAdditions.MODID, "brachacki"),
                new ResourceLocation(AudreysAdditions.MODID, "desktop/brachacki"),
                TardisRefined.GSON.toJson(Component.literal(MiscHelper.getCleanName(ChatFormatting.YELLOW + "(1963) " + ChatFormatting.BLUE + "Brachacki"))
        )));

        addDesktop(new DesktopTheme(
                new ResourceLocation(AudreysAdditions.MODID, "rani"),
                new ResourceLocation(AudreysAdditions.MODID, "desktop/rani"),
                TardisRefined.GSON.toJson(Component.literal(MiscHelper.getCleanName(ChatFormatting.YELLOW + "(1985) " + ChatFormatting.BLUE + "Rani"))
        )));

        addDesktop(new DesktopTheme(
                new ResourceLocation(AudreysAdditions.MODID, "liminton"),
                new ResourceLocation(AudreysAdditions.MODID, "desktop/liminton"),
                TardisRefined.GSON.toJson(Component.literal(MiscHelper.getCleanName(ChatFormatting.YELLOW + "(1973) " + ChatFormatting.BLUE + "Liminton"))
        )));

    }
}
