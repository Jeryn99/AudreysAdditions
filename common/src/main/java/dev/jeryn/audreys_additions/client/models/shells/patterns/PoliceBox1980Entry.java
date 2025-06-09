package dev.jeryn.audreys_additions.client.models.shells.patterns;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import whocraft.tardis_refined.client.model.blockentity.door.interior.ShellDoorModel;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellEntry;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.patterns.ShellPattern;

public class PoliceBox1980Entry extends ShellEntry {

    public PoliceBox1980Entry(ShellModel shellModel, ShellDoorModel shellDoorModel) {
        super(shellModel, shellDoorModel);
    }


    @Override
    public ShellModel getShellModel(ShellPattern shellPattern) {

        String variantPath = shellPattern.id().getPath();


        if (variantPath.contains("season_20")) {
            return AUDModelRegistry.policeBox83;
        }

        if (variantPath.contains("season_22")) {
            return AUDModelRegistry.policeBox83;
        }

        if (variantPath.contains("season_24")) {
            return AUDModelRegistry.policeBox87;
        }

        if (variantPath.contains("happiness_patrol")) {
            return AUDModelRegistry.policeBoxHappinessPatrol;
        }

        return super.getShellModel(shellPattern);
    }

    @Override
    public ShellDoorModel getShellDoorModel(ShellPattern shellPattern) {
        String variantPath = shellPattern.id().getPath();

        if (variantPath.contains("season_20") || variantPath.contains("season_22") || variantPath.contains("season_24") || variantPath.contains("happiness_patrol")){
            return AUDModelRegistry.policeBox83Door;
        }

        return super.getShellDoorModel(shellPattern);
    }

}
