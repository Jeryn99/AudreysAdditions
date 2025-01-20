package dev.jeryn.audreys_additions.forge.data;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.registry.AudSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class AUDSoundProvider extends SoundDefinitionsProvider {


    public AUDSoundProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, AudreysAdditions.MODID, helper);
    }

    @Override
    public void registerSounds() {
        add(AudSounds.FOOD_MACHINE.get(), basicSound("food_machine", AudSounds.FOOD_MACHINE.getId()));
    }

    public SoundDefinition basicSound(String langKey, ResourceLocation resourceLocation) {
        return SoundDefinition.definition().with(SoundDefinition.Sound.sound(resourceLocation, SoundDefinition.SoundType.SOUND)).subtitle(createSubtitle(langKey));
    }

    public static String createSubtitle(String langKey) {
        return "sound." + langKey + ".subtitle";
    }
}
