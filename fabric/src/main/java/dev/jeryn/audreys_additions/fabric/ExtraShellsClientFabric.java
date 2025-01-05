package dev.jeryn.audreys_additions.fabric;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import net.fabricmc.api.ClientModInitializer;

public class ExtraShellsClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AUDModelRegistry.init();
    }
}
