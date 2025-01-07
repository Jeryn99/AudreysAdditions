package dev.jeryn.audreys_additions.client.models.shell;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.registry.AudShellRegistry;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModelCollection;

public class AUDShellEntryRegistry {

    public static void init() {
        ShellModelCollection.registerShellEntry(AudShellRegistry.POLICEBOX_2018.get(), AUDModelRegistry.policeBox18, AUDModelRegistry.policeBox18Door);
        ShellModelCollection.registerShellEntry(AudShellRegistry.POLICEBOX_2010.get(), AUDModelRegistry.policeBox10, AUDModelRegistry.policeBox10Door);
    }
}