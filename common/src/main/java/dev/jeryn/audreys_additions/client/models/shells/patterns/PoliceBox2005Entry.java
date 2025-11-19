package dev.jeryn.audreys_additions.client.models.shells.patterns;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import whocraft.tardis_refined.client.model.blockentity.door.interior.ShellDoorModel;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellEntry;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.patterns.ShellPattern;

public class PoliceBox2005Entry extends ShellEntry {

    public PoliceBox2005Entry(ShellModel shellModel, ShellDoorModel shellDoorModel) {
        super(shellModel, shellDoorModel);
    }

    @Override
    public ShellModel getShellModel(ShellPattern shellPattern) {

        String variantPath = shellPattern.id().getPath();

        if (variantPath.contains("time_war")) {
            return AUDModelRegistry.policeBoxTimeWar;
        }
        // base
        return super.getShellModel(shellPattern);
    }

    @Override
    public ShellDoorModel getShellDoorModel(ShellPattern shellPattern) {
        return super.getShellDoorModel(shellPattern);
    }

}
