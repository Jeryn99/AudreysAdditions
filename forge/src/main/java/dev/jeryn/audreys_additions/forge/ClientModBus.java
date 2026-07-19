package dev.jeryn.audreys_additions.forge;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.client.renderers.*;
import dev.jeryn.audreys_additions.common.blockentity.DyeableBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.hatstand.HatstandScreen;
import dev.jeryn.audreys_additions.common.item.DyedItemBlock;
import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import dev.jeryn.audreys_additions.common.registry.AudEntities;
import dev.jeryn.audreys_additions.common.registry.AudMenus;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import whocraft.tardis_refined.client.TardisClientData;

import java.util.Map;

import static whocraft.tardis_refined.registry.TRDimensionTypes.TARDIS;

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
        BlockEntityRenderers.register(AudBlockEntities.SPECIMEN_JAR.get(), RenderSpecimenJar::new);
        BlockEntityRenderers.register(AudBlockEntities.HAT_STAND.get(), RenderHatStand::new);

        MenuScreens.register(AudMenus.HAT_STAND.get(), HatstandScreen::new);

    }

    @SubscribeEvent
    public static void registerColorHandlersEventBlock(RegisterColorHandlersEvent.Block event) {

        event.register((blockState, blockAndTintGetter, blockPos, tintIndex) -> {

                    if (blockAndTintGetter != null && blockPos != null) {
                        BlockEntity blockEntity = blockAndTintGetter.getBlockEntity(blockPos);

                        if (blockEntity instanceof DyeableBlockEntity dyeableBlockEntity) {

                            if (blockEntity.getLevel() != null &&
                                    blockEntity.getLevel().dimensionTypeId() == TARDIS) {

                                ResourceKey<Level> dimKey = blockEntity.getLevel().dimension();
                                TardisClientData data = TardisClientData.getInstance(dimKey);
                                double fuel = data.getFuel();

                                int color = dyeableBlockEntity.getColour();

                                if (fuel < 500) {
                                    int steps = (int) ((500 - fuel) / 10);
                                    steps = Math.min(steps, 50);

                                    float factor = 1.0f - (steps * 0.02f);
                                    factor = Math.max(0.2f, factor);

                                    int r = (int) (((color >> 16) & 0xFF) * factor);
                                    int g = (int) (((color >> 8) & 0xFF) * factor);
                                    int b = (int) ((color & 0xFF) * factor);

                                    color = (r << 16) | (g << 8) | b;
                                }

                                // Force rerender when fuel changes
                                blockEntity.getLevel().sendBlockUpdated(blockPos, blockState, blockState, 2);
                                blockEntity.getLevel().updateNeighborsAt(blockPos, blockState.getBlock());

                                return color;
                            }

                            return dyeableBlockEntity.getColour();
                        }
                    }

                    return blockState.getBlock() == AudBlocks.ARMCHAIR.get()
                            ? DyeColor.RED.getTextColor()
                            : DyeColor.WHITE.getTextColor();

                }, AudBlocks.ARMCHAIR.get(),
                AudBlocks.ROUNDEL_OVERLAY_FULL.get(),
                AudBlocks.ROUNDEL_OVERLAY_HALF.get());
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