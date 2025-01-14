package dev.jeryn.audreys_additions.events;


import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.client.models.console.NewberyConsoleModel;
import dev.jeryn.audreys_additions.client.models.console.PertweeConsoleModel;
import dev.jeryn.audreys_additions.client.models.console.patterns.PertweeConsoleEntry;
import dev.jeryn.audreys_additions.common.registry.AudConsoleRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import whocraft.tardis_refined.api.event.TardisClientEvents;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleModelEntry;
import whocraft.tardis_refined.common.util.Platform;

import static dev.jeryn.audreys_additions.AUDModelRegistry.NEWBERY_CONSOLE;
import static dev.jeryn.audreys_additions.AUDModelRegistry.PERTWEE_CONSOLE;

public class AudreysAdditionsAPIEvents {

    public static void init(){
        if(Platform.isClient()) {
            setupEvents();
        }
    }

    @Environment(EnvType.CLIENT)
    private static void setupEvents() {

        TardisClientEvents.SHELLENTRY_MODELS_SETUP.register(AUDModelRegistry::setupModelInstances);

        TardisClientEvents.CONSOLE_MODELS_SETUP.register((consoleModelCollection, entityModelSet) -> consoleModelCollection.registerModel(AudConsoleRegistry.PERTWEE.getId(), new PertweeConsoleEntry(new PertweeConsoleModel(entityModelSet.bakeLayer(PERTWEE_CONSOLE)))));
        TardisClientEvents.CONSOLE_MODELS_SETUP.register((consoleModelCollection, entityModelSet) -> consoleModelCollection.registerModel(AudConsoleRegistry.NEWBERY.getId(), new ConsoleModelEntry(new NewberyConsoleModel(entityModelSet.bakeLayer(NEWBERY_CONSOLE)))));
    }

}



