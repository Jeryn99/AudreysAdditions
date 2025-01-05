package dev.jeryn.audreys_additions;

public class AudreysAdditions {
	public static final String MODID = "audreys_additions";

	public static void init() {
		ExtraShellAPIEvents.init();
		AudShellRegistry.SHELL_THEMES.registerToModBus();
		AudConsoleRegistry.CONSOLE_REGISTRY.registerToModBus();
		AUDSounds.SOUNDS.registerToModBus();
	}
}
