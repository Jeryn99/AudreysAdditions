package dev.jeryn.audreys_additions.client.models.shells.patterns;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import whocraft.tardis_refined.client.model.blockentity.door.interior.ShellDoorModel;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellEntry;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.patterns.ShellPattern;

public class PoliceBox1976Entry extends ShellEntry {

    public PoliceBox1976Entry(ShellModel shellModel, ShellDoorModel shellDoorModel) {
        super(shellModel, shellDoorModel);
    }


    @Override
    public ShellModel getShellModel(ShellPattern shellPattern) {

        String variantPath = shellPattern.id().getPath();


        if (variantPath.contains("season_16")) {
            return AUDModelRegistry.policeBox78;
        }

        if (variantPath.contains("season_17")) {
            return AUDModelRegistry.policeBox79;
        }

        if (variantPath.contains("black_orchid")) {
            return AUDModelRegistry.policeBoxBlackOrchid;
        }

        return super.getShellModel(shellPattern);
    }

    @Override
    public ShellDoorModel getShellDoorModel(ShellPattern shellPattern) {
        String variantPath = shellPattern.id().getPath();

        if (variantPath.contains("black_orchid")){
            return AUDModelRegistry.policeBoxBlackOrchidDoor;
        }

        return super.getShellDoorModel(shellPattern);
    }

}
