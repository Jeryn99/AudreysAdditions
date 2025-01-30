package dev.jeryn.audreys_additions.common.registry;

import dev.jeryn.audreys_additions.AudreysAdditions;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;

public class AudSounds {

    public static final DeferredRegistry<SoundEvent> SOUNDS = DeferredRegistry.create(AudreysAdditions.MODID, Registries.SOUND_EVENT);
    public static final RegistrySupplier<SoundEvent> FOOD_MACHINE = setUpSound("food_machine");
    public static final RegistrySupplier<SoundEvent> SIDRAT = setUpSound("sidrat");
    public static final RegistrySupplier<SoundEvent> BRACHACKI_HUM = setUpSound("brachacki_hum");
    public static final RegistrySupplier<SoundEvent> BRACHACKI_AMBIENCE = setUpSound("brachacki_ambience");


    private static RegistrySupplier<SoundEvent> setUpSound(String soundName) {
        SoundEvent sound = SoundEvent.createVariableRangeEvent(new ResourceLocation(AudreysAdditions.MODID, soundName));
        return SOUNDS.register(soundName, () -> {
            return sound;
        });
    }

}
