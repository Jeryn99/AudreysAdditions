package dev.jeryn.audreys_additions.neoforge;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.neoforge.data.*;
import net.minecraft.data.DataGenerator;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

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
        generator.addProvider(e.includeServer(), new AudRecipeProvider(generator.getPackOutput(), e.getLookupProvider()));

        generator.addProvider(e.includeClient(), new AUDEnglish(generator));

        AudBlockTagsProvider blockTags = new AudBlockTagsProvider(generator.getPackOutput(), e.getLookupProvider(), e.getExistingFileHelper());
        generator.addProvider(e.includeServer(), blockTags);
        generator.addProvider(e.includeServer(), new ProviderLootTable(generator.getPackOutput()));


        generator.addProvider(e.includeClient(), new AudItemTagProvider(generator.getPackOutput(), e.getLookupProvider(), blockTags.contentsGetter(), existingFileHelper));
        generator.addProvider(e.includeClient(), new AudDesktopProvider(generator, false));
        generator.addProvider(e.includeClient(), new AudHumSoundScapeProvider(generator));
        generator.addProvider(e.includeClient(), new AudBlocksModelProvider(generator, existingFileHelper));
        generator.addProvider(e.includeClient(), new AudItemModelProvider(generator.getPackOutput(), existingFileHelper));
        generator.addProvider(e.includeClient(), new AUDSoundProvider(generator.getPackOutput(), existingFileHelper));
    }

}