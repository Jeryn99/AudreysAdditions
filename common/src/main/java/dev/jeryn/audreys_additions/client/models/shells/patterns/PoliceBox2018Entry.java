package dev.jeryn.audreys_additions.client.models.shells.patterns;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import whocraft.tardis_refined.client.model.blockentity.door.interior.ShellDoorModel;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellEntry;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.patterns.ShellPattern;

public class PoliceBox2018Entry extends ShellEntry {

    public PoliceBox2018Entry(ShellModel shellModel, ShellDoorModel shellDoorModel) {
        super(shellModel, shellDoorModel);
    }

    @Override
    public ShellModel getShellModel(ShellPattern shellPattern) {
        if (isSpecialShellPattern(shellPattern)) {
            return AUDModelRegistry.policeBox18_special;
        }
        return super.getShellModel(shellPattern);
    }

    @Override
    public ShellDoorModel getShellDoorModel(ShellPattern shellPattern) {
        if (isSpecialShellPattern(shellPattern)) {
            return AUDModelRegistry.policeBox18Door_special;
        }
        return super.getShellDoorModel(shellPattern);
    }

    private boolean isSpecialShellPattern(ShellPattern shellPattern) {
        String path = shellPattern.id().getPath();
        return path.contains("proms") || path.contains("barbie");
    }

}
