package dev.jeryn.audreys_additions.client.models.console.patterns;

import dev.jeryn.audreys_additions.client.models.console.CoralMasterConsoleModel;
import dev.jeryn.audreys_additions.client.models.console.Season16ConsoleModel;
import dev.jeryn.audreys_additions.client.models.console.Season20ConsoleModel;
import dev.jeryn.audreys_additions.client.models.console.MemoryConsoleModel;
import net.minecraft.client.Minecraft;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleModelEntry;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleUnit;
import whocraft.tardis_refined.patterns.ConsolePattern;

import static dev.jeryn.audreys_additions.AUDModelRegistry.*;


public class CoralConsoleEntry extends ConsoleModelEntry {


    private final CoralMasterConsoleModel alt;

    public CoralConsoleEntry(ConsoleUnit consoleUnit) {
        super(consoleUnit);
        alt = new CoralMasterConsoleModel(Minecraft.getInstance().getEntityModels().bakeLayer(CORAL_MASTER_CONSOLE));
    }

    @Override
    public ConsoleUnit getConsoleModel(ConsolePattern consolePattern) {
        if (consolePattern == null || consolePattern.id() == null || consolePattern.id().getPath() == null) {
            return super.getConsoleModel(consolePattern);
        }

        if (consolePattern.id().getPath().contains("master")) {
            return alt;
        }
        return super.getConsoleModel(consolePattern);
    }

}
