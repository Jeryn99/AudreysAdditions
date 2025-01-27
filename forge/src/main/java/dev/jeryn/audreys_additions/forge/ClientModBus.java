package dev.jeryn.audreys_additions.forge;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.client.renderers.RenderAstralMapBlockEntity;
import dev.jeryn.audreys_additions.client.renderers.RenderCeilingCanopyBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.ChairBlockEntity;
import dev.jeryn.audreys_additions.client.renderers.RenderKnossosChairBlockEntity;
import dev.jeryn.audreys_additions.client.renderers.RenderFoodMachineBlockEntity;
import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import dev.jeryn.audreys_additions.common.registry.AudEntities;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AudreysAdditions.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModBus {

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        AUDModelRegistry.init();
        AUDModelRegistryImpl.register(event);
        EntityRenderers.register(AudEntities.CHAIR.get(), NoopRenderer::new);
        BlockEntityRenderers.register(AudBlockEntities.KNOSSOS_THRONE.get(), RenderKnossosChairBlockEntity::new);
        BlockEntityRenderers.register(AudBlockEntities.FOOD_MACHINE.get(), RenderFoodMachineBlockEntity::new);
        BlockEntityRenderers.register(AudBlockEntities.ASTRAL_MAP.get(), RenderAstralMapBlockEntity::new);
        BlockEntityRenderers.register(AudBlockEntities.CEILING_CANOPY.get(), RenderCeilingCanopyBlockEntity::new);
    }

    @SubscribeEvent
    public static void registerColorHandlersEventBlock(RegisterColorHandlersEvent.Block event) {
        event.register((blockState, blockAndTintGetter, blockPos, tintIndex) -> {
            if (blockAndTintGetter != null && blockPos != null) {
                BlockEntity blockEntity = blockAndTintGetter.getBlockEntity(blockPos);
                if (blockEntity instanceof ChairBlockEntity chairBlockEntity) {
                    DyeColor dyeColor = chairBlockEntity.getColour();
                    return dyeColor.getTextColor();
                }
            }
            return DyeColor.WHITE.getTextColor();
        }, AudBlocks.ARMCHAIR.get());
    }


}