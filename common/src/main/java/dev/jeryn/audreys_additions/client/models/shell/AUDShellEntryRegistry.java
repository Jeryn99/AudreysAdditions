package dev.jeryn.audreys_additions.client.models.shell;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.client.models.shells.patterns.PoliceBox1963Entry;
import dev.jeryn.audreys_additions.client.models.shells.patterns.PoliceBox2018Entry;
import dev.jeryn.audreys_additions.common.registry.AudShellRegistry;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellEntry;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModelCollection;

public class AUDShellEntryRegistry {

    public static void init() {
        ShellModelCollection.registerShellEntry(AudShellRegistry.POLICEBOX_2018.get(), new PoliceBox2018Entry(AUDModelRegistry.policeBox18, AUDModelRegistry.policeBox18Door));
        ShellModelCollection.registerShellEntry(AudShellRegistry.POLICEBOX_2010.get(), AUDModelRegistry.policeBox10, AUDModelRegistry.policeBox10Door);
        ShellModelCollection.registerShellEntry(AudShellRegistry.POLICEBOX_1976.get(), AUDModelRegistry.policeBox76, AUDModelRegistry.policeBox76Door);
        ShellModelCollection.registerShellEntry(AudShellRegistry.POLICEBOX_1996.get(), AUDModelRegistry.policeBox96, AUDModelRegistry.policeBox96Door);
        ShellModelCollection.registerShellEntry(AudShellRegistry.POLICEBOX_1963.get(), new PoliceBox1963Entry(AUDModelRegistry.policeBox63, AUDModelRegistry.policeBox63Door));
        ShellModelCollection.registerShellEntry(AudShellRegistry.SIDRAT.get(), AUDModelRegistry.sidrat, AUDModelRegistry.sidratDoor);
    }
}