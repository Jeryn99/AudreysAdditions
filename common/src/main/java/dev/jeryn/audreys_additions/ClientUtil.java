package dev.jeryn.audreys_additions;

import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class ClientUtil {

    public static void init(){
        BlockRenderLayerMap.INSTANCE.putBlock(AudBlocks.KNOSSOS_THRONE.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AudBlocks.LIMINTON_MONITOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AudBlocks.BRACHACKI_MONITOR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AudBlocks.ARMCHAIR.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AudBlocks.ROUNDEL_OVERLAY_FULL.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AudBlocks.ROUNDEL_OVERLAY_HALF.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AudBlocks.ZEITON_QUARTZ_DOOR.get(), RenderType.translucent());

    }

}
