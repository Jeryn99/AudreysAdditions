package dev.jeryn.audreys_additions.forge.data;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.registry.AudShellRegistry;
import dev.jeryn.audreys_additions.common.registry.AudSounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.common.data.ShellPatternProvider;
import whocraft.tardis_refined.patterns.PatternTexture;
import whocraft.tardis_refined.patterns.ShellPattern;
import whocraft.tardis_refined.patterns.ShellPatterns;
import whocraft.tardis_refined.patterns.sound.ConfiguredSound;
import whocraft.tardis_refined.patterns.sound.ShellSoundProfile;
import whocraft.tardis_refined.patterns.sound.TRShellSoundProfiles;

import java.util.Optional;

public class AUDPatterns extends ShellPatternProvider {


    @Override
    protected void addPatterns() {

        ShellSoundProfile sidratSounds = new ShellSoundProfile();
        sidratSounds.setDoorClose(new ConfiguredSound(AudSounds.SIDRAT.get()));
        sidratSounds.setDoorOpen(new ConfiguredSound(AudSounds.SIDRAT.get()));

        quickAdd(AudShellRegistry.POLICEBOX_1966.getId(), "default", true);
        quickAdd(AudShellRegistry.POLICEBOX_1966.getId(), "season_5", true);
        quickAdd(AudShellRegistry.POLICEBOX_1966.getId(), "season_6", true);
        quickAdd(AudShellRegistry.POLICEBOX_1966.getId(), "season_11", true);
        quickAdd(AudShellRegistry.POLICEBOX_1966.getId(), "ruth", true);

        quickAdd(AudShellRegistry.POLICEBOX_2018.getId(), "default", true);
        quickAdd(AudShellRegistry.POLICEBOX_2018.getId(), "blue", true);

        quickAdd(AudShellRegistry.POLICEBOX_2010.getId(), "default", true);
        quickAdd(AudShellRegistry.POLICEBOX_2010.getId(), "series_7", true);
        quickAdd(AudShellRegistry.POLICEBOX_2010.getId(), "series_10", true);
        quickAdd(AudShellRegistry.POLICEBOX_2010.getId(), "memorial", true);

        quickAdd(AudShellRegistry.POLICEBOX_1980.getId(), "default", true);
        quickAdd(AudShellRegistry.POLICEBOX_1980.getId(), "season_20", true);
        quickAdd(AudShellRegistry.POLICEBOX_1980.getId(), "season_22", true);
        quickAdd(AudShellRegistry.POLICEBOX_1980.getId(), "season_24", true);
        quickAdd(AudShellRegistry.POLICEBOX_1980.getId(), "happiness_patrol", true);

        quickAdd(AudShellRegistry.POLICEBOX_1976.getId(), "default", true);

        quickAdd(AudShellRegistry.RANI_WARDROBE.getId(), "default", true);
        quickAdd(AudShellRegistry.RANI_WARDROBE.getId(), "iron", true);
        quickAdd(AudShellRegistry.RANI_WARDROBE.getId(), "nether_brick", true);
        quickAdd(AudShellRegistry.RANI_WARDROBE.getId(), "purpur", true);
        quickAdd(AudShellRegistry.RANI_WARDROBE.getId(), "quartz", true);
        quickAdd(AudShellRegistry.RANI_WARDROBE.getId(), "sandstone", true);
        quickAdd(AudShellRegistry.RANI_WARDROBE.getId(), "stone", true);
        quickAdd(AudShellRegistry.RANI_WARDROBE.getId(), "wooden", true);

        quickAdd(AudShellRegistry.TELEPHONE_BOOTH.getId(), "default", true);
        quickAdd(AudShellRegistry.TELEPHONE_BOOTH.getId(), "bee", true);

        quickAdd(AudShellRegistry.GRANDFATHER_CLOCK.getId(), "grandfather_clock", false);
        quickAdd(AudShellRegistry.GRANDFATHER_CLOCK.getId(), "grandfather_clock_acacia", false);
        quickAdd(AudShellRegistry.GRANDFATHER_CLOCK.getId(), "grandfather_clock_bamboo", false);
        quickAdd(AudShellRegistry.GRANDFATHER_CLOCK.getId(), "grandfather_clock_birch", false);
        quickAdd(AudShellRegistry.GRANDFATHER_CLOCK.getId(), "grandfather_clock_cherry", false);
        quickAdd(AudShellRegistry.GRANDFATHER_CLOCK.getId(), "grandfather_clock_crimson", false);
        quickAdd(AudShellRegistry.GRANDFATHER_CLOCK.getId(), "grandfather_clock_jungle", false);
        quickAdd(AudShellRegistry.GRANDFATHER_CLOCK.getId(), "grandfather_clock_mangrove", false);
        quickAdd(AudShellRegistry.GRANDFATHER_CLOCK.getId(), "grandfather_clock_oak", false);
        quickAdd(AudShellRegistry.GRANDFATHER_CLOCK.getId(), "grandfather_clock_pale", false);
        quickAdd(AudShellRegistry.GRANDFATHER_CLOCK.getId(), "grandfather_clock_spruce", false);
        quickAdd(AudShellRegistry.GRANDFATHER_CLOCK.getId(), "grandfather_clock_warped", false);

        quickAdd(AudShellRegistry.LAKERTYAN_PYRAMID.getId(), "default", false);


        quickAdd(AudShellRegistry.TRAKENCLOCK.getId(), "default", false);
        quickAdd(AudShellRegistry.TRAKENCLOCK.getId(), "acacia", false);
        quickAdd(AudShellRegistry.TRAKENCLOCK.getId(), "bamboo", false);
        quickAdd(AudShellRegistry.TRAKENCLOCK.getId(), "birch", false);
        quickAdd(AudShellRegistry.TRAKENCLOCK.getId(), "cherry", false);
        quickAdd(AudShellRegistry.TRAKENCLOCK.getId(), "crimson", false);
        quickAdd(AudShellRegistry.TRAKENCLOCK.getId(), "dark_oak", false);
        quickAdd(AudShellRegistry.TRAKENCLOCK.getId(), "jungle", false);
        quickAdd(AudShellRegistry.TRAKENCLOCK.getId(), "mangrove", false);
        quickAdd(AudShellRegistry.TRAKENCLOCK.getId(), "oak", false);
        quickAdd(AudShellRegistry.TRAKENCLOCK.getId(), "pale", false);
        quickAdd(AudShellRegistry.TRAKENCLOCK.getId(), "warped", false);

        quickAdd(AudShellRegistry.IRON_MAIDEN.getId(), "iron_maiden", false);

        quickAdd(AudShellRegistry.TT_CAPSULE.getId(), "tt_capsule", false);
        quickAdd(AudShellRegistry.TT_CAPSULE.getId(), "type_40", false);

        quickAdd(AudShellRegistry.POLICEBOX_1996.getId(), "default", true);
        quickAdd(AudShellRegistry.POLICEBOX_1996.getId(), "shalka", true);
        quickAdd(AudShellRegistry.POLICEBOX_1963.getId(), "default", true);
        quickAdd(AudShellRegistry.POLICEBOX_1963.getId(), "massacre", true);

        quickAdd(AudShellRegistry.SIDRAT.getId(), "sidrat", false, sidratSounds);
        quickAdd(AudShellRegistry.SIDRAT.getId(), "gallifrey", false, sidratSounds);

        quickAdd(AudShellRegistry.COLUMN.getId(), "sandstone", false);
        quickAdd(AudShellRegistry.COLUMN.getId(), "red_sandstone", false);

        quickAdd(AudShellRegistry.POLICEBOX_2018.getId(), "barbie", true);
        quickAdd(AudShellRegistry.POLICEBOX_2018.getId(), "proms", true);

    }

    public void quickAdd(ResourceLocation themeId, String patternName, boolean hasEmissiveTexture) {
        addPattern(themeId, createPattern(themeId, patternName, hasEmissiveTexture));
    }

    public void quickAdd(ResourceLocation themeId, String patternName, boolean hasEmissiveTexture, ShellSoundProfile soundProfile) {
        addPattern(themeId, createPattern(themeId, patternName, hasEmissiveTexture, soundProfile));
    }


    public ShellPattern createPattern(ResourceLocation themeId, String patternName, boolean hasEmissiveTexture) {
        ResourceLocation exteriorTextureLocation = ShellPatterns.exteriorTextureLocation(themeId, AudreysAdditions.MODID, patternName);
        ResourceLocation interiorTextureLocation = ShellPatterns.interiorTextureLocation(themeId, AudreysAdditions.MODID, patternName);
        ShellSoundProfile soundProfile = TRShellSoundProfiles.defaultSoundProfilesByTheme().getOrDefault(themeId, TRShellSoundProfiles.DEFAULT_SOUND_PROFILE);
        ShellPattern pattern = new ShellPattern(new ResourceLocation(themeId.getNamespace(), patternName), new PatternTexture(exteriorTextureLocation, hasEmissiveTexture), new PatternTexture(interiorTextureLocation, hasEmissiveTexture), Optional.of(soundProfile));
        pattern.setThemeId(themeId);

        return ShellPatterns.addDefaultPattern(themeId, pattern);
    }

    public ShellPattern createPattern(ResourceLocation themeId, String patternName, boolean hasEmissiveTexture, ShellSoundProfile soundProfile) {
        ResourceLocation exteriorTextureLocation = ShellPatterns.exteriorTextureLocation(themeId, AudreysAdditions.MODID, patternName);
        ResourceLocation interiorTextureLocation = ShellPatterns.interiorTextureLocation(themeId, AudreysAdditions.MODID, patternName);
        ShellPattern pattern = new ShellPattern(new ResourceLocation(themeId.getNamespace(), patternName), new PatternTexture(exteriorTextureLocation, hasEmissiveTexture), new PatternTexture(interiorTextureLocation, hasEmissiveTexture), Optional.of(soundProfile));
        pattern.setThemeId(themeId);

        return ShellPatterns.addDefaultPattern(themeId, pattern);
    }

    public AUDPatterns(DataGenerator generator) {
        super(generator, AudreysAdditions.MODID, false);
    }

    @Override
    public String getName() {
        return AudreysAdditions.MODID + " Patterns";
    }


}
