package dev.jeryn.audreys_additions.client.models.shells.patterns;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import whocraft.tardis_refined.client.model.blockentity.door.interior.ShellDoorModel;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellEntry;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.patterns.ShellPattern;

public class TTCapsuleEntry extends ShellEntry {

    public TTCapsuleEntry(ShellModel shellModel, ShellDoorModel shellDoorModel) {
        super(shellModel, shellDoorModel);
    }


    @Override
    public ShellModel getShellModel(ShellPattern shellPattern) {

        String variantPath = shellPattern.id().getPath();


        if (variantPath.contains("type_40")) {
            return AUDModelRegistry.type40;
        }

        return super.getShellModel(shellPattern);
    }

    @Override
    public ShellDoorModel getShellDoorModel(ShellPattern shellPattern) {
        String variantPath = shellPattern.id().getPath();

        if (variantPath.contains("type_40")) {
            return AUDModelRegistry.type40Door;
        }

        return super.getShellDoorModel(shellPattern);
    }

}
