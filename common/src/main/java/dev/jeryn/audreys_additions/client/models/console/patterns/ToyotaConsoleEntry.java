package dev.jeryn.audreys_additions.client.models.console.patterns;

import dev.jeryn.audreys_additions.client.models.console.ToyotaBlueConsoleModel;
import dev.jeryn.audreys_additions.client.models.console.ToyotaMissyConsoleModel;
import net.minecraft.client.Minecraft;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleModelEntry;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleUnit;
import whocraft.tardis_refined.patterns.ConsolePattern;

import static dev.jeryn.audreys_additions.AUDModelRegistry.TOYOTA_MISSY_CONSOLE;
import static dev.jeryn.audreys_additions.AUDModelRegistry.TOYOTA_BLUE_CONSOLE;


public class ToyotaConsoleEntry extends ConsoleModelEntry {


    private final ToyotaBlueConsoleModel alt;
    private final ToyotaMissyConsoleModel alter;

    public ToyotaConsoleEntry(ConsoleUnit consoleUnit) {
        super(consoleUnit);
        alt = new ToyotaBlueConsoleModel(Minecraft.getInstance().getEntityModels().bakeLayer(TOYOTA_BLUE_CONSOLE));
        alter = new ToyotaMissyConsoleModel(Minecraft.getInstance().getEntityModels().bakeLayer(TOYOTA_MISSY_CONSOLE));
    }

    @Override
    public ConsoleUnit getConsoleModel(ConsolePattern consolePattern) {
        if (consolePattern == null || consolePattern.id() == null || consolePattern.id().getPath() == null) {
            return super.getConsoleModel(consolePattern);
        }

        if (consolePattern.id().getPath().contains("toyota_blue")) {
            return alt;
        }

        if (consolePattern.id().getPath().contains("toyota_missy")) {
            return alter;
        }

        return super.getConsoleModel(consolePattern);
    }

}
