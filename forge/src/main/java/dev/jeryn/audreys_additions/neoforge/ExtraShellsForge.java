package dev.jeryn.audreys_additions.neoforge;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.neoforge.data.AUDEnglish;
import dev.jeryn.audreys_additions.neoforge.data.AUDPatterns;
import dev.jeryn.audreys_additions.neoforge.data.AUDSoundProvider;
import dev.jeryn.audreys_additions.neoforge.data.AudConsolePatternProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AudreysAdditions.MODID)
public class ExtraShellsForge {
    public ExtraShellsForge() {
        AudreysAdditions.init();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::onGatherData);
    }

    public void onGatherData(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        /*Data Pack*/
        generator.addProvider(e.includeServer(), new AudConsolePatternProvider(generator));
        generator.addProvider(e.includeServer(), new AUDPatterns(generator));
        generator.addProvider(e.includeClient(), new AUDEnglish(generator));
        generator.addProvider(e.includeClient(), new AUDSoundProvider(generator.getPackOutput(), e.getExistingFileHelper()));
    }

}