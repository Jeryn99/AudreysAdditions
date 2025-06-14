package dev.jeryn.audreys_additions.client.models.shell;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.client.models.shells.patterns.*;
import dev.jeryn.audreys_additions.common.registry.AudShellRegistry;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellEntry;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModelCollection;

public class AUDShellEntryRegistry {

    public static void init() {
        ShellModelCollection.registerShellEntry(AudShellRegistry.POLICEBOX_2018.get(), new PoliceBox2018Entry(AUDModelRegistry.policeBox18, AUDModelRegistry.policeBox18Door));
        ShellModelCollection.registerShellEntry(AudShellRegistry.POLICEBOX_2010.get(), new PoliceBox2010Entry(AUDModelRegistry.policeBox10, AUDModelRegistry.policeBox10Door));
        ShellModelCollection.registerShellEntry(AudShellRegistry.POLICEBOX_1976.get(), AUDModelRegistry.policeBox76, AUDModelRegistry.policeBox76Door);
        ShellModelCollection.registerShellEntry(AudShellRegistry.POLICEBOX_1996.get(), new PoliceBox1996Entry(AUDModelRegistry.policeBox96, AUDModelRegistry.policeBox96Door));
        ShellModelCollection.registerShellEntry(AudShellRegistry.POLICEBOX_1980.get(), new PoliceBox1980Entry(AUDModelRegistry.policeBox80, AUDModelRegistry.policeBox80Door));
        ShellModelCollection.registerShellEntry(AudShellRegistry.POLICEBOX_1963.get(), new PoliceBox1963Entry(AUDModelRegistry.policeBox63, AUDModelRegistry.policeBox63Door));
        ShellModelCollection.registerShellEntry(AudShellRegistry.POLICEBOX_1966.get(), new PoliceBox1966Entry(AUDModelRegistry.policeBox66, AUDModelRegistry.policeBox66Door));
        ShellModelCollection.registerShellEntry(AudShellRegistry.SIDRAT.get(), AUDModelRegistry.sidrat, AUDModelRegistry.sidratDoor);
        ShellModelCollection.registerShellEntry(AudShellRegistry.COLUMN.get(), AUDModelRegistry.column, AUDModelRegistry.columnDoor);
        ShellModelCollection.registerShellEntry(AudShellRegistry.TRAKENCLOCK.get(), AUDModelRegistry.trakenClock, AUDModelRegistry.trakenClockDoor);
        ShellModelCollection.registerShellEntry(AudShellRegistry.GRANDFATHER_CLOCK.get(), AUDModelRegistry.grandfatherClock, AUDModelRegistry.grandfatherClockDoor);
        ShellModelCollection.registerShellEntry(AudShellRegistry.TELEPHONE_BOOTH.get(), AUDModelRegistry.telephoneBooth, AUDModelRegistry.telephoneBoothDoor);
        ShellModelCollection.registerShellEntry(AudShellRegistry.IRON_MAIDEN.get(), AUDModelRegistry.ironMaiden, AUDModelRegistry.ironMaidenDoor);
        ShellModelCollection.registerShellEntry(AudShellRegistry.TT_CAPSULE.get(), new TTCapsuleEntry(AUDModelRegistry.ttCapsule, AUDModelRegistry.ttCapsuleDoor));
        ShellModelCollection.registerShellEntry(AudShellRegistry.RANI_WARDROBE.get(), AUDModelRegistry.raniWardrobe, AUDModelRegistry.raniWardrobeDoor);
        ShellModelCollection.registerShellEntry(AudShellRegistry.LAKERTYAN_PYRAMID.get(), AUDModelRegistry.lakertyanPyramid, AUDModelRegistry.lakertyanPyramidDoor);

    }
}