package dev.jeryn.audreys_additions;


import dev.jeryn.audreys_additions.client.models.console.PertweeConsole;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.EntityModelSet;
import whocraft.tardis_refined.api.event.TardisClientEvents;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleModelCollection;
import whocraft.tardis_refined.common.util.Platform;

import static dev.jeryn.audreys_additions.AUDModelRegistry.PERTWEE_CONSOLE;

public class ExtraShellAPIEvents {

    public static void init(){
        if(Platform.isClient()) {
            setupEventas();
        }
    }

    @Environment(EnvType.CLIENT)
    private static void setupEventas() {

        TardisClientEvents.SHELLENTRY_MODELS_SETUP.register(AUDModelRegistry::setupModelInstances);
        TardisClientEvents.CONSOLE_MODELS_SETUP.register(new TardisClientEvents.SetupConsoleModels() {
            @Override
            public void setupConsoleModels(ConsoleModelCollection consoleModelCollection, EntityModelSet entityModelSet) {
                consoleModelCollection.registerModel(new PertweeConsole(entityModelSet.bakeLayer(PERTWEE_CONSOLE)));
            }
        });
    }

}



