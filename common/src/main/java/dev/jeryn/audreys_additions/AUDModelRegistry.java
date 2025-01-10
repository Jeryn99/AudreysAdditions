package dev.jeryn.audreys_additions;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.jeryn.audreys_additions.client.models.shell.AUDShellEntryRegistry;
import dev.jeryn.audreys_additions.client.models.shell.PoliceBoxModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.client.model.blockentity.door.interior.DualInteriorDoorModel;
import whocraft.tardis_refined.common.util.PlatformWarning;

import java.util.function.Supplier;

public class AUDModelRegistry {


    // Models
    public static PoliceBoxModel policeBox18, policeBox10;
    public static DualInteriorDoorModel policeBox18Door, policeBox10Door;

    // Model Layers
    public static ModelLayerLocation POLICEBOX_2018 = shell("policebox_2018");
    public static ModelLayerLocation POLICEBOX_2018_DOOR = interiorDoor("policebox_2018_door");

    public static ModelLayerLocation POLICEBOX_2010 = shell("policebox_2010");
    public static ModelLayerLocation POLICEBOX_2010_DOOR = interiorDoor("policebox_2010_door");


    public static ModelLayerLocation PERTWEE_CONSOLE = console("pertwee");
    public static ModelLayerLocation NEWBERY_CONSOLE = console("newbery");


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

    }

    public static void setupModelInstances(EntityModelSet entityModels) {

        // Police Box - 2018
        policeBox18 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_2018), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
            poseStack.scale(0.7F, 0.7F, 0.7F);
            poseStack.translate(0F, 0.7F, 0F);
        });
        policeBox18Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_2018_DOOR), -275.0F, false, true);

        // Police Box - 2010
        policeBox10 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_2010), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
            poseStack.scale(0.75F, 0.75F, 0.75F);
            poseStack.translate(0F, 0.5F, 0F);
        });
        policeBox10Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_2010_DOOR), -275.0F, false, true);

        // Model Registration
        AUDShellEntryRegistry.init();
    }

    @ExpectPlatform
    public static ModelLayerLocation register(ModelLayerLocation location, Supplier<LayerDefinition> definitionSupplier) {
        throw new RuntimeException(PlatformWarning.addWarning(AUDModelRegistry.class));
    }

}
