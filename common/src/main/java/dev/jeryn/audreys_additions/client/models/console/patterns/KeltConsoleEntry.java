package dev.jeryn.audreys_additions.client.models.console.patterns;

import dev.jeryn.audreys_additions.client.models.console.WarriorConsoleModel;
import dev.jeryn.audreys_additions.client.models.console.NewberyConsoleModel;
import net.minecraft.client.Minecraft;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleModelEntry;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleUnit;
import whocraft.tardis_refined.patterns.ConsolePattern;

import static dev.jeryn.audreys_additions.AUDModelRegistry.WARRIOR_CONSOLE;
import static dev.jeryn.audreys_additions.AUDModelRegistry.NEWBERY_CONSOLE;

public class KeltConsoleEntry extends ConsoleModelEntry {


    private final WarriorConsoleModel alt;

    public KeltConsoleEntry(ConsoleUnit consoleUnit) {
        super(consoleUnit);
        alt = new WarriorConsoleModel(Minecraft.getInstance().getEntityModels().bakeLayer(WARRIOR_CONSOLE));
    }

    @Override
    public ConsoleUnit getConsoleModel(ConsolePattern consolePattern) {
        if (consolePattern == null || consolePattern.id() == null || consolePattern.id().getPath() == null) {
            return super.getConsoleModel(consolePattern);
        }

        if (consolePattern.id().getPath().contains("warrior")) {
            return alt;
        }

        return super.getConsoleModel(consolePattern);
    }

}
