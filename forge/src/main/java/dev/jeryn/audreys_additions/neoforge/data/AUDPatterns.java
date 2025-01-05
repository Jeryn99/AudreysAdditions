package dev.jeryn.audreys_additions.neoforge.data;

import dev.jeryn.audreys_additions.AudreysAdditions;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.common.data.ShellPatternProvider;
import whocraft.tardis_refined.patterns.PatternTexture;
import whocraft.tardis_refined.patterns.ShellPattern;
import whocraft.tardis_refined.patterns.ShellPatterns;
import whocraft.tardis_refined.patterns.sound.ShellSoundProfile;
import whocraft.tardis_refined.patterns.sound.TRShellSoundProfiles;

import java.util.Optional;

public class AUDPatterns extends ShellPatternProvider {


    @Override
    protected void addPatterns() {

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
        ;
        ShellPattern pattern = new ShellPattern(new ResourceLocation(themeId.getNamespace(), patternName), new PatternTexture(exteriorTextureLocation, hasEmissiveTexture), new PatternTexture(interiorTextureLocation, hasEmissiveTexture), Optional.of(soundProfile));
        pattern.setThemeId(themeId);

        return ShellPatterns.addDefaultPattern(themeId, pattern);
    }

    public AUDPatterns(DataGenerator generator) {
        super(generator, AudreysAdditions.MODID, false);
    }

    @Override
    public String getName() {
        return "ExtraShells Patterns";
    }


}
