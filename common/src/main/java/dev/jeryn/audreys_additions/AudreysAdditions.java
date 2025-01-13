package dev.jeryn.audreys_additions;

import dev.jeryn.audreys_additions.common.registry.AudEntities;
import dev.jeryn.audreys_additions.events.AudreysAdditionsAPIEvents;
import dev.jeryn.audreys_additions.common.registry.*;

public class AudreysAdditions {
	public static final String MODID = "audreys_additions";

	public static void init() {
		AudreysAdditionsAPIEvents.init();
		AudItems.ITEMS.registerToModBus();
		AudBlocks.BLOCKS.registerToModBus();
		AudBlockEntities.TILES.registerToModBus();
		AudEntities.ENTITY_TYPES.registerToModBus();
		AudShellRegistry.SHELL_THEMES.registerToModBus();
		AudConsoleRegistry.CONSOLE_REGISTRY.registerToModBus();
		AudSounds.SOUNDS.registerToModBus();
	}
}
