package dev.jeryn.audreys_additions.forge;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.forge.data.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AudreysAdditions.MODID)
public class AudreysAdditionsForge {
    public AudreysAdditionsForge() {
        AudreysAdditions.init();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::onGatherData);
    }

    public void onGatherData(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        ExistingFileHelper existingFileHelper = e.getExistingFileHelper();
        /*Data Pack*/
        generator.addProvider(e.includeServer(), new AudConsolePatternProvider(generator));
        generator.addProvider(e.includeServer(), new AUDPatterns(generator));
        generator.addProvider(e.includeServer(), new AudRecipeProvider(generator.getPackOutput()));

        generator.addProvider(e.includeClient(), new AUDEnglish(generator));

        AudBlockTagsProvider blockTags = new AudBlockTagsProvider(generator.getPackOutput(), e.getLookupProvider(), e.getExistingFileHelper());
        generator.addProvider(e.includeServer(), blockTags);


        generator.addProvider(e.includeClient(), new AudItemTagProvider(generator.getPackOutput(), e.getLookupProvider(), blockTags.contentsGetter(), existingFileHelper));
        generator.addProvider(e.includeClient(), new AudDesktopProvider(generator, false));
        generator.addProvider(e.includeClient(), new AudHumSoundScapeProvider(generator));
        generator.addProvider(e.includeClient(), new AudBlocksModelProvider(generator, existingFileHelper));
        generator.addProvider(e.includeClient(), new AudItemModelProvider(generator.getPackOutput(), existingFileHelper));
        generator.addProvider(e.includeClient(), new AUDSoundProvider(generator.getPackOutput(), existingFileHelper));
    }

}