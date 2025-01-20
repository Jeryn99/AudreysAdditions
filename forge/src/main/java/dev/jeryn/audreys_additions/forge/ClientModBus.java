package dev.jeryn.audreys_additions.forge;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.ClientUtil;
import dev.jeryn.audreys_additions.client.models.renderers.RenderChairBlockEntity;
import dev.jeryn.audreys_additions.client.models.renderers.RenderFoodMachineBlockEntity;
import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import dev.jeryn.audreys_additions.common.registry.AudEntities;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AudreysAdditions.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModBus {

    @SubscribeEvent
    public static void event(EntityRenderersEvent.RegisterLayerDefinitions event) {
        AUDModelRegistry.init();
        AUDModelRegistryImpl.register(event);
        EntityRenderers.register(AudEntities.CHAIR.get(), NoopRenderer::new);
        BlockEntityRenderers.register(AudBlockEntities.KNOSSOS_THRONE.get(), RenderChairBlockEntity::new);
        BlockEntityRenderers.register(AudBlockEntities.FOOD_MACHINE.get(), RenderFoodMachineBlockEntity::new);

    }


}