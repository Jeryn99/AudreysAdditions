
package dev.jeryn.audreys_additions;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;

public class AUDSounds {

    public static final DeferredRegistry<SoundEvent> SOUNDS = DeferredRegistry.create(AudreysAdditions.MODID, Registries.SOUND_EVENT);

    private static RegistrySupplier<SoundEvent> setUpSound(String soundName) {
        SoundEvent sound = SoundEvent.createVariableRangeEvent(new ResourceLocation(AudreysAdditions.MODID, soundName));
        return SOUNDS.register(soundName, () -> {
            return sound;
        });
    }

}
