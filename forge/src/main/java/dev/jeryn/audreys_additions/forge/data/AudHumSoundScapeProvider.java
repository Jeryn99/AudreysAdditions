package dev.jeryn.audreys_additions.forge.data;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.registry.AudSounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.common.data.HumProvider;
import whocraft.tardis_refined.common.soundscape.hum.HumEntry;

import java.util.List;

public class AudHumSoundScapeProvider extends HumProvider {

    public AudHumSoundScapeProvider(DataGenerator generator) {
        super(generator, false);
    }

    @Override
    protected void addHums() {
        addHum(new HumEntry(new ResourceLocation(AudreysAdditions.MODID, "brachacki"), AudSounds.BRACHACKI_HUM.getId(), List.of(AudSounds.BRACHACKI_AMBIENCE.getId())));
        super.addHums();

    }
}
