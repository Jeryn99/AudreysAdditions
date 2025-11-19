package dev.jeryn.audreys_additions.client.models.console.patterns;

import dev.jeryn.audreys_additions.client.models.console.Season16ConsoleModel;
import net.minecraft.client.Minecraft;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleModelEntry;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleUnit;
import whocraft.tardis_refined.patterns.ConsolePattern;

import static dev.jeryn.audreys_additions.AUDModelRegistry.SEASON_16_CONSOLE;

public class AlteredSharpConsoleEntry extends ConsoleModelEntry {


    private final Season16ConsoleModel alt;

    public AlteredSharpConsoleEntry(ConsoleUnit consoleUnit) {
        super(consoleUnit);
        alt = new Season16ConsoleModel(Minecraft.getInstance().getEntityModels().bakeLayer(SEASON_16_CONSOLE));
    }

    @Override
    public ConsoleUnit getConsoleModel(ConsolePattern consolePattern) {
        if (consolePattern == null || consolePattern.id() == null || consolePattern.id().getPath() == null) {
            return super.getConsoleModel(consolePattern);
        }

        if (consolePattern.id().getPath().contains("season_16")) {
            return alt;
        }

        return super.getConsoleModel(consolePattern);
    }

}
