package dev.jeryn.audreys_additions;

import dev.jeryn.audreys_additions.common.registry.*;
import dev.jeryn.audreys_additions.events.AudreysAdditionsAPIEvents;

public class AudreysAdditions {
	public static final String MODID = "audreys_additions";
	public static final String NAME = "Audrey's Additions";

	public static void init() {
		AudreysAdditionsAPIEvents.init();
		AudTabs.TABS.registerToModBus();
		AudMenus.MENUS.registerToModBus();
		AudItems.ITEMS.registerToModBus();
		AudBlocks.BLOCKS.registerToModBus();
		AudBlockEntities.TILES.registerToModBus();
		AudEntities.ENTITY_TYPES.registerToModBus();
		AudShellRegistry.SHELL_THEMES.registerToModBus();
		AudConsoleRegistry.CONSOLE_REGISTRY.registerToModBus();
		AudSounds.SOUNDS.registerToModBus();
	}
}
