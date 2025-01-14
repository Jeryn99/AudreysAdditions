package dev.jeryn.audreys_additions.client.models.console.patterns;

import dev.jeryn.audreys_additions.client.models.console.MasterConsoleModel;
import dev.jeryn.audreys_additions.client.models.console.NewberyConsoleModel;
import net.minecraft.client.Minecraft;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleModelEntry;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleUnit;
import whocraft.tardis_refined.patterns.ConsolePattern;

import static dev.jeryn.audreys_additions.AUDModelRegistry.MASTER_CONSOLE;
import static dev.jeryn.audreys_additions.AUDModelRegistry.NEWBERY_CONSOLE;

public class PertweeConsoleEntry extends ConsoleModelEntry {


    private final MasterConsoleModel alt;

    public PertweeConsoleEntry(ConsoleUnit consoleUnit) {
        super(consoleUnit);
        alt = new MasterConsoleModel(Minecraft.getInstance().getEntityModels().bakeLayer(MASTER_CONSOLE));
    }

    @Override
    public ConsoleUnit getConsoleModel(ConsolePattern consolePattern) {
        if(consolePattern.id().getPath().contains("master")){
            return alt;
        }

        return super.getConsoleModel(consolePattern);
    }
}
