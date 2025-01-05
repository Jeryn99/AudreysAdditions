package dev.jeryn.audreys_additions;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.jeryn.audreys_additions.client.models.console.PertweeConsole;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleModelCollection;
import whocraft.tardis_refined.common.util.PlatformWarning;

import java.util.function.Supplier;

public class AUDModelRegistry {


    public static ModelLayerLocation PERTWEE_CONSOLE = console("pertwee");


    private static ModelLayerLocation interiorDoor(String name) {
        return createLocation(name, "door");
    }

    private static ModelLayerLocation console(String name) {
        return createLocation(name, "console");
    }

    private static ModelLayerLocation shell(String name) {
        return createLocation(name, "shell");
    }


    private static ModelLayerLocation createLocation(String name, String layer) {
        return new ModelLayerLocation(new ResourceLocation(AudreysAdditions.MODID, name), layer);
    }        


    public static void init() {
        ExtraShellAPIEvents.init();
    }

    public static void setupModelInstances(EntityModelSet entityModels) {
        System.out.println("YES I AM HERE, YES YOU WILL OBEY ME");
        ConsoleModelCollection.getInstance().registerModel(new PertweeConsole(entityModels.bakeLayer(PERTWEE_CONSOLE)));
    }

    @ExpectPlatform
    public static ModelLayerLocation register(ModelLayerLocation location, Supplier<LayerDefinition> definitionSupplier) {
        throw new RuntimeException(PlatformWarning.addWarning(AUDModelRegistry.class));
    }

}
