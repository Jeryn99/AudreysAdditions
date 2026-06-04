package dev.jeryn.audreys_additions.client.models.console.patterns;

import dev.jeryn.audreys_additions.client.models.console.Season16ConsoleModel;
import dev.jeryn.audreys_additions.client.models.console.Season20ConsoleModel;
import dev.jeryn.audreys_additions.client.models.console.MemoryConsoleModel;
import net.minecraft.client.Minecraft;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleModelEntry;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleUnit;
import whocraft.tardis_refined.patterns.ConsolePattern;

import static dev.jeryn.audreys_additions.AUDModelRegistry.SEASON_16_CONSOLE;
import static dev.jeryn.audreys_additions.AUDModelRegistry.SEASON_20_CONSOLE;
import static dev.jeryn.audreys_additions.AUDModelRegistry.MEMORY_CONSOLE;


public class AlteredSharpConsoleEntry extends ConsoleModelEntry {


    private final Season16ConsoleModel alt;
    private final Season20ConsoleModel alter;
    private final MemoryConsoleModel weebly;

    public AlteredSharpConsoleEntry(ConsoleUnit consoleUnit) {
        super(consoleUnit);
        alt = new Season16ConsoleModel(Minecraft.getInstance().getEntityModels().bakeLayer(SEASON_16_CONSOLE));
        alter = new Season20ConsoleModel(Minecraft.getInstance().getEntityModels().bakeLayer(SEASON_20_CONSOLE));
        weebly = new MemoryConsoleModel(Minecraft.getInstance().getEntityModels().bakeLayer(MEMORY_CONSOLE));
    }

    @Override
    public ConsoleUnit getConsoleModel(ConsolePattern consolePattern) {
        if (consolePattern == null || consolePattern.id() == null || consolePattern.id().getPath() == null) {
            return super.getConsoleModel(consolePattern);
        }

        if (consolePattern.id().getPath().contains("season_16")) {
            return alt;
        }

       if (consolePattern.id().getPath().contains("season_20")) {
            return alter;
        }

        if (consolePattern.id().getPath().contains("memory")) {
            return weebly;
        }

        return super.getConsoleModel(consolePattern);
    }

}
