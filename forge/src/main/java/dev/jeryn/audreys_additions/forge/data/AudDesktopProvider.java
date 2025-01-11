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
                TardisRefined.GSON.toJson(Component.literal(MiscHelper.getCleanName("Secondary")).setStyle(Style.EMPTY.withColor(ChatFormatting.GOLD)))
        ));    }
}
