package dev.jeryn.audreys_additions.fabric;

import dev.jeryn.audreys_additions.AudreysAdditions;
import net.fabricmc.api.ModInitializer;

public class AudreysAdditionsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AudreysAdditions.init();
    }
}