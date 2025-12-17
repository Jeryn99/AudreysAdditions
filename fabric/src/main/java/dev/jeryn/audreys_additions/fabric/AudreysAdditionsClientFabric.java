package dev.jeryn.audreys_additions.fabric;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.ClientUtil;
import dev.jeryn.audreys_additions.client.renderers.*;
import dev.jeryn.audreys_additions.common.blockentity.DyeableBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.DyeableRoundelBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.hatstand.HatstandScreen;
import dev.jeryn.audreys_additions.common.item.DyedItemBlock;
import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import dev.jeryn.audreys_additions.common.registry.AudEntities;
import dev.jeryn.audreys_additions.common.registry.AudMenus;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntity;

public class AudreysAdditionsClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AUDModelRegistry.init();
        ClientUtil.init();
        EntityRendererRegistry.register(AudEntities.CHAIR.get(), NoopRenderer::new);
        BlockEntityRendererRegistry.register(AudBlockEntities.KNOSSOS_THRONE.get(), RenderKnossosChairBlockEntity::new);
        BlockEntityRendererRegistry.register(AudBlockEntities.FOOD_MACHINE.get(), RenderFoodMachineBlockEntity::new);
        BlockEntityRendererRegistry.register(AudBlockEntities.ASTRAL_MAP.get(), RenderAstralMapBlockEntity::new);
        BlockEntityRendererRegistry.register(AudBlockEntities.CEILING_CANOPY.get(), RenderCeilingCanopyBlockEntity::new);
        BlockEntityRendererRegistry.register(AudBlockEntities.FOLD_OUT_BED.get(), RenderFoldOutBedBlockEntity::new);
        BlockEntityRendererRegistry.register(AudBlockEntities.SPECIMEN_JAR.get(), RenderSpecimenJar::new);
        BlockEntityRendererRegistry.register(AudBlockEntities.HAT_STAND.get(), RenderHatStand::new);

        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, tintIndex) -> {
            if (blockAndTintGetter != null && blockPos != null) {
                BlockEntity blockEntity = blockAndTintGetter.getBlockEntity(blockPos);
                if (blockEntity instanceof DyeableBlockEntity chairBlockEntity) {
                    return chairBlockEntity.getColour();
                }
            }
            return blockState.getBlock() == AudBlocks.ARMCHAIR.get() ? DyeColor.RED.getTextColor() : DyeColor.WHITE.getTextColor();
        }, AudBlocks.ARMCHAIR.get(), AudBlocks.ROUNDEL_OVERLAY_FULL.get(), AudBlocks.ROUNDEL_OVERLAY_HALF.get());


        for (Item item : BuiltInRegistries.ITEM) {
            if(item instanceof DyedItemBlock dyedItemBlock){
                ColorProviderRegistry.ITEM.register((itemStack, i) -> dyedItemBlock.getColor(itemStack), dyedItemBlock);
            }
        }

        MenuScreens.register(AudMenus.HAT_STAND.get(), HatstandScreen::new);

    }
}


