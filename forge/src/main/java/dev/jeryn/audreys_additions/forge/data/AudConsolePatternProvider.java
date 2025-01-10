package dev.jeryn.audreys_additions.forge.data;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.registry.AudConsoleRegistry;
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
        addPatternToDatagen(AudConsoleRegistry.PERTWEE.getId(), createWithDefaultSound("pertwee", new PatternTexture(new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/pertwee/pertwee.png"), true)));

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
    }

    @Override
    protected Path getPath(ResourceLocation themeId) {
        Path var10000 = this.generator.getPackOutput().getOutputFolder();
        return var10000.resolve("data/" + themeId.getNamespace() + "/tardis_refined/patterns/console/" + themeId.getPath() + ".json");
    }
}
