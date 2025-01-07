package dev.jeryn.audreys_additions;

import dev.jeryn.audreys_additions.events.ExtraShellAPIEvents;
import dev.jeryn.audreys_additions.registry.AUDSounds;
import dev.jeryn.audreys_additions.registry.AudConsoleRegistry;
import dev.jeryn.audreys_additions.registry.AudShellRegistry;

public class AudreysAdditions {
	public static final String MODID = "audreys_additions";

	public static void init() {
		ExtraShellAPIEvents.init();
		AudShellRegistry.SHELL_THEMES.registerToModBus();
		AudConsoleRegistry.CONSOLE_REGISTRY.registerToModBus();
		AUDSounds.SOUNDS.registerToModBus();
	}
}
