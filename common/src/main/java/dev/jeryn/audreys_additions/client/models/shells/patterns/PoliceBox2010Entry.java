package dev.jeryn.audreys_additions.client.models.shells.patterns;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import whocraft.tardis_refined.client.model.blockentity.door.interior.ShellDoorModel;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellEntry;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.patterns.ShellPattern;

public class PoliceBox2010Entry extends ShellEntry {

    public PoliceBox2010Entry(ShellModel shellModel, ShellDoorModel shellDoorModel) {
        super(shellModel, shellDoorModel);
    }


    @Override
    public ShellModel getShellModel(ShellPattern shellPattern) {

        String variantPath = shellPattern.id().getPath();


        if (variantPath.contains("series_7")) {
            return AUDModelRegistry.policeBox11;
        }

        if (variantPath.contains("series_10")) {
            return AUDModelRegistry.policeBox17;
        }

        if (variantPath.contains("memorial")) {
            return AUDModelRegistry.policeBoxMemorial;
        }

        return super.getShellModel(shellPattern);
    }

    @Override
    public ShellDoorModel getShellDoorModel(ShellPattern shellPattern) {
        String variantPath = shellPattern.id().getPath();


        if (variantPath.contains("series_7")) {
            return AUDModelRegistry.policeBox11Door;
        }

        if (variantPath.contains("series_10") || variantPath.contains("memorial"))  {
            return AUDModelRegistry.policeBox17Door;
        }

        return super.getShellDoorModel(shellPattern);
    }

}
