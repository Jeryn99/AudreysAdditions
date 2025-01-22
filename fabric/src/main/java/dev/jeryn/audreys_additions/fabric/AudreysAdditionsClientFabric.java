package dev.jeryn.audreys_additions.fabric;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.ClientUtil;
import dev.jeryn.audreys_additions.client.models.renderers.RenderKnossosChairBlockEntity;
import dev.jeryn.audreys_additions.client.models.renderers.RenderFoodMachineBlockEntity;
import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import dev.jeryn.audreys_additions.common.registry.AudEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class AudreysAdditionsClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AUDModelRegistry.init();
        ClientUtil.init();
        EntityRendererRegistry.register(AudEntities.CHAIR.get(), NoopRenderer::new);
        BlockEntityRendererRegistry.register(AudBlockEntities.KNOSSOS_THRONE.get(), RenderKnossosChairBlockEntity::new);
        BlockEntityRendererRegistry.register(AudBlockEntities.FOOD_MACHINE.get(), RenderFoodMachineBlockEntity::new);

        ColorProviderRegistry.BLOCK.register(new BlockColor() {
            @Override
            public int getColor(BlockState blockState, @Nullable BlockAndTintGetter blockAndTintGetter, @Nullable BlockPos blockPos, int i) {
                return Color.RED.getRGB();
            }
        }, AudBlocks.ARMCHAIR.get());


    }
}


