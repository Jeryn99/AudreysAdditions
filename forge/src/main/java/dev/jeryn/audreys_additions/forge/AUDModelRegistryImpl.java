package dev.jeryn.audreys_additions.forge;

import dev.jeryn.audreys_additions.AUDModelRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraftforge.client.event.EntityRenderersEvent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class AUDModelRegistryImpl {

    public static final Map<ModelLayerLocation, Supplier<LayerDefinition>> DEFINITIONS = new ConcurrentHashMap<>();

    public static ModelLayerLocation register(ModelLayerLocation location, Supplier<LayerDefinition> definition) {
        DEFINITIONS.put(location, definition);
        return location;
    }

    public static void register(EntityRenderersEvent.RegisterLayerDefinitions event) {
        AUDModelRegistry.init();
        DEFINITIONS.forEach(event::registerLayerDefinition);
    }
}