package dev.jeryn.audreys_additions.forge.data;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.registry.AudConsoleRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.common.data.ConsolePatternProvider;
import whocraft.tardis_refined.patterns.ConsolePattern;
import whocraft.tardis_refined.patterns.PatternTexture;
import whocraft.tardis_refined.patterns.sound.ConsoleSoundProfile;
import whocraft.tardis_refined.patterns.sound.TRConsoleSoundProfiles;

import java.nio.file.Path;
import java.util.Optional;

public class AudConsolePatternProvider extends ConsolePatternProvider {

    public AudConsolePatternProvider(DataGenerator generator) {
        super(generator, false);
    }

    public static ConsolePattern createWithDefaultSound(String identifier, PatternTexture textureDefinition) {
        return new ConsolePattern(
                new ResourceLocation(AudreysAdditions.MODID, identifier),
                textureDefinition,
                Optional.of(TRConsoleSoundProfiles.DEFAULT_SOUND_PROFILE)
        );
    }

    public static ConsolePattern createWithCustomSound(String identifier, PatternTexture textureDefinition, ConsoleSoundProfile soundProfile) {
        return new ConsolePattern(
                new ResourceLocation(AudreysAdditions.MODID, identifier),
                textureDefinition,
                Optional.of(soundProfile)
        );
    }

    public static ConsolePattern createWithNameAndDefaultSound(String identifier, String name, PatternTexture textureDefinition) {
        return new ConsolePattern(
                new ResourceLocation(AudreysAdditions.MODID, identifier),
                name,
                textureDefinition,
                Optional.of(TRConsoleSoundProfiles.DEFAULT_SOUND_PROFILE)
        );
    }


    @Override
    protected void addPatterns() {
        addPatternToDatagen(AudConsoleRegistry.TOYOTA.getId(), createWithDefaultSound("toyota", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/toyota/toyota.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.TOYOTA.getId(), createWithDefaultSound("toyota_blue", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/toyota/toyota_blue.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.TOYOTA.getId(), createWithDefaultSound("toyota_missy", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/toyota/toyota_missy.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.KELT.getId(), createWithDefaultSound("kelt", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/kelt/kelt.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.KELT.getId(), createWithDefaultSound("kelt_rani", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/kelt/kelt_rani.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.KELT.getId(), createWithDefaultSound("kelt_master", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/kelt/kelt_master.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.KELT.getId(), createWithDefaultSound("kelt_warrior", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/kelt/kelt_warrior.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.KELT.getId(), createWithDefaultSound("yellowed", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/kelt/yellowed.png"), true)));

        addPatternToDatagen(AudConsoleRegistry.BRACHACKI.getId(), createWithDefaultSound("brachacki", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/brachacki/brachacki.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.BRACHACKI.getId(), createWithDefaultSound("brachacki_ruth", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/brachacki/brachacki_ruth.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.BRACHACKI.getId(), createWithDefaultSound("brachacki_quartz", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/brachacki/brachacki_quartz.png"), true)));

        addPatternToDatagen(AudConsoleRegistry.PERTWEE.getId(), createWithDefaultSound("pertwee", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/pertwee/pertwee.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.PERTWEE.getId(), createWithDefaultSound("master", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/pertwee/master.png"), true)));

        addPatternToDatagen(AudConsoleRegistry.ALTERED_SHARP.getId(), createWithDefaultSound("season_13", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/altered_sharp/season_13.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.ALTERED_SHARP.getId(), createWithDefaultSound("season_16", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/altered_sharp/season_16.png"), false)));

        addPatternToDatagen(AudConsoleRegistry.RANI.getId(), createWithDefaultSound("rani", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/rani/rani.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.RANI.getId(), createWithDefaultSound("rani_crimson", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/rani/rani_crimson.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.RANI.getId(), createWithDefaultSound("rani_end", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/rani/rani_end.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.RANI.getId(), createWithDefaultSound("rani_keltic", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/rani/rani_keltic.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.RANI.getId(), createWithDefaultSound("rani_nether", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/rani/rani_nether.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.RANI.getId(), createWithDefaultSound("rani_white", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/rani/rani_white.png"), false)));






        addPatternToDatagen(AudConsoleRegistry.NEWBERY.getId(), createWithDefaultSound("newbery", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/newbery/default.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.NEWBERY.getId(), createWithDefaultSound("newbery_acacia", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/newbery/newbery_acacia.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.NEWBERY.getId(), createWithDefaultSound("newbery_bamboo", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/newbery/newbery_bamboo.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.NEWBERY.getId(), createWithDefaultSound("newbery_birch", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/newbery/newbery_birch.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.NEWBERY.getId(), createWithDefaultSound("newbery_cherry", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/newbery/newbery_cherry.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.NEWBERY.getId(), createWithDefaultSound("newbery_crimson", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/newbery/newbery_crimson.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.NEWBERY.getId(), createWithDefaultSound("newbery_darkoak", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/newbery/newbery_darkoak.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.NEWBERY.getId(), createWithDefaultSound("newbery_jungle", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/newbery/newbery_jungle.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.NEWBERY.getId(), createWithDefaultSound("newbery_oak", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/newbery/newbery_oak.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.NEWBERY.getId(), createWithDefaultSound("newbery_pale", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/newbery/newbery_pale.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.NEWBERY.getId(), createWithDefaultSound("newbery_spruce", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/newbery/newbery_spruce.png"), false)));
        addPatternToDatagen(AudConsoleRegistry.NEWBERY.getId(), createWithDefaultSound("newbery_warped", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/newbery/newbery_warped.png"), false)));

        addPatternToDatagen(AudConsoleRegistry.HUMAN_NATURE.getId(), createWithDefaultSound("human_nature", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/human_nature/human_nature.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.HUMAN_NATURE.getId(), createWithDefaultSound("human_nature_no_cat", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/human_nature/human_nature.png"), true)));

        addPatternToDatagen(AudConsoleRegistry.SILENCE.getId(), createWithDefaultSound("silence", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/silence/silence.png"), true)));

        addPatternToDatagen(AudConsoleRegistry.MCGANN.getId(), createWithDefaultSound("default", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/mcgann/mcgann.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.MCGANN.getId(), createWithDefaultSound("acacia", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/mcgann/mcgann_acacia.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.MCGANN.getId(), createWithDefaultSound("bamboo", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/mcgann/mcgann_bamboo.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.MCGANN.getId(), createWithDefaultSound("birch", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/mcgann/mcgann_birch.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.MCGANN.getId(), createWithDefaultSound("cherry", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/mcgann/mcgann_cherry.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.MCGANN.getId(), createWithDefaultSound("crimson", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/mcgann/mcgann_crimson.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.MCGANN.getId(), createWithDefaultSound("dark_oak", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/mcgann/mcgann_dark_oak.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.MCGANN.getId(), createWithDefaultSound("jungle", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/mcgann/mcgann_jungle.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.MCGANN.getId(), createWithDefaultSound("oak", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/mcgann/mcgann_oak.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.MCGANN.getId(), createWithDefaultSound("pale", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/mcgann/mcgann_pale.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.MCGANN.getId(), createWithDefaultSound("spruce", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/mcgann/mcgann_spruce.png"), true)));
        addPatternToDatagen(AudConsoleRegistry.MCGANN.getId(), createWithDefaultSound("warped", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/mcgann/mcgann_warped.png"), true)));


    }

    @Override
    protected Path getPath(ResourceLocation themeId) {
        Path var10000 = this.generator.getPackOutput().getOutputFolder();
        return var10000.resolve("data/" + themeId.getNamespace() + "/tardis_refined/patterns/console/" + themeId.getPath() + ".json");
    }
}
