package dev.jeryn.audreys_additions.forge;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.client.renderers.*;
import dev.jeryn.audreys_additions.common.blockentity.ChairBlockEntity;
import dev.jeryn.audreys_additions.common.item.DyedItemBlock;
import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import dev.jeryn.audreys_additions.common.registry.AudEntities;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

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
        BlockEntityRenderers.register(AudBlockEntities.FOLD_OUT_BED.get(), RenderFoldOutBedBlockEntity::new);
    }

    @SubscribeEvent
    public static void registerColorHandlersEventBlock(RegisterColorHandlersEvent.Block event) {
        event.register((blockState, blockAndTintGetter, blockPos, tintIndex) -> {
            if (blockAndTintGetter != null && blockPos != null) {
                BlockEntity blockEntity = blockAndTintGetter.getBlockEntity(blockPos);
                if (blockEntity instanceof ChairBlockEntity chairBlockEntity) {
                    return chairBlockEntity.getColour();
                }
            }
            return DyeColor.RED.getTextColor();
        }, AudBlocks.ARMCHAIR.get());
    }

    @SubscribeEvent
    public static void registerColorHandlersEventItem(RegisterColorHandlersEvent.Item event) {

        for (Map.Entry<ResourceKey<Item>, Item> entry : ForgeRegistries.ITEMS.getEntries()) {
            if(entry.getValue() instanceof DyedItemBlock dyedItemBlock){
                event.register((arg, i) -> dyedItemBlock.getColor(arg), dyedItemBlock);
            }
        }
    }


}