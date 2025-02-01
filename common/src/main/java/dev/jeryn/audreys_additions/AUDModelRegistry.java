package dev.jeryn.audreys_additions;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.jeryn.audreys_additions.client.models.shell.AUDShellEntryRegistry;
import dev.jeryn.audreys_additions.client.models.shell.PoliceBoxModel;
import dev.jeryn.audreys_additions.client.models.shell.SidratModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.client.model.blockentity.door.interior.DualInteriorDoorModel;
import whocraft.tardis_refined.client.model.blockentity.door.interior.DualTexInteriorDoorModel;
import whocraft.tardis_refined.client.model.blockentity.door.interior.SingleTexInteriorDoorModel;
import whocraft.tardis_refined.common.util.PlatformWarning;

import java.util.function.Supplier;

public class AUDModelRegistry {


    // Models
    public static PoliceBoxModel policeBox03, policeBox66, policeBoxRuth, policeBox73, policeBox18, policeBox18_special, policeBox10, policeBox76, policeBox96, policeBox63, policeBox63Massacre;
    public static DualInteriorDoorModel policeBox03Door, policeBox66Door, policeBox63Door, policeBox18Door, policeBox18Door_special, policeBox10Door, policeBox76Door, policeBox96Door;
    public static DualTexInteriorDoorModel sidratDoor;
    public static SidratModel sidrat;

    // Model Layers
    public static ModelLayerLocation POLICEBOX_2018 = shell("policebox_2018");
    public static ModelLayerLocation POLICEBOX_2018_SPECIAL = shell("policebox_2018_special");
    public static ModelLayerLocation POLICEBOX_2018_DOOR = interiorDoor("policebox_2018_door");
    public static ModelLayerLocation POLICEBOX_2018_DOOR_SPECIAL = interiorDoor("policebox_2018_door_special");

    public static ModelLayerLocation POLICEBOX_2010 = shell("policebox_2010");
    public static ModelLayerLocation POLICEBOX_2010_DOOR = interiorDoor("policebox_2010_door");

    public static ModelLayerLocation POLICEBOX_1976 = shell("policebox_1976");
    public static ModelLayerLocation POLICEBOX_1976_DOOR = interiorDoor("policebox_1976_door");

    public static ModelLayerLocation POLICEBOX_1996 = shell("policebox_1996");
    public static ModelLayerLocation POLICEBOX_1996_DOOR = interiorDoor("policebox_1996_door");

    public static ModelLayerLocation POLICEBOX_2003 = shell("policebox_2003");
    public static ModelLayerLocation POLICEBOX_2003_DOOR = interiorDoor("policebox_2003_door");

    public static ModelLayerLocation POLICEBOX_1966 = shell("policebox_1966");
    public static ModelLayerLocation POLICEBOX_RUTH = shell("policebox_ruth");
    public static ModelLayerLocation POLICEBOX_1973= shell("policebox_1973");
    public static ModelLayerLocation POLICEBOX_1966_DOOR = interiorDoor("policebox_1966_door");


    public static ModelLayerLocation POLICEBOX_1963 = shell("policebox_1963");
    public static ModelLayerLocation POLICEBOX_1963_MASSACRE = shell("policebox_1963_massacre");
    public static ModelLayerLocation POLICEBOX_1963_DOOR = interiorDoor("policebox_1963_door");

    public static ModelLayerLocation SIDRAT = shell("sidrat");
    public static ModelLayerLocation SIDRAT_DOOR = interiorDoor("sidrat_door");

    public static ModelLayerLocation PERTWEE_CONSOLE = console("pertwee");
    public static ModelLayerLocation NEWBERY_CONSOLE = console("newbery");
    public static ModelLayerLocation MASTER_CONSOLE = console("master");
    public static ModelLayerLocation BRACHACKI_CONSOLE = console("brachacki");
    public static ModelLayerLocation TOYOTA_CONSOLE = console("toyota");
    public static ModelLayerLocation KELT_CONSOLE = console("kelt");

    public static ModelLayerLocation KNOSSOS_THRONE = furniture("knossos_throne");
    public static ModelLayerLocation FOOD_MACHINE = furniture("food_machine");
    public static ModelLayerLocation ASTRAL_MAP = furniture("astral_map");
    public static ModelLayerLocation CEILING_CANOPY = furniture("ceiling_canopy");
    public static ModelLayerLocation CEILING_CANOPY_HANGING = furniture("ceiling_canopy_hanging");
    public static ModelLayerLocation FOLD_OUT_BED = furniture("fold_out_bed");


    private static ModelLayerLocation interiorDoor(String name) {
        return createLocation(name, "door");
    }

    private static ModelLayerLocation console(String name) {
        return createLocation(name, "console");
    }

    private static ModelLayerLocation shell(String name) {
        return createLocation(name, "shell");
    }

    private static ModelLayerLocation furniture(String name) {
        return createLocation(name, "furniture");
    }


    private static ModelLayerLocation createLocation(String name, String layer) {
        return new ModelLayerLocation(new ResourceLocation(AudreysAdditions.MODID, name), layer);
    }        


    public static void init() {

    }

    public static void setupModelInstances(EntityModelSet entityModels) {

        // Police Box - 1976
        policeBox76 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_1976), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {

        });
        policeBox76Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_1976_DOOR), -275.0F, false, true);

        // Police Box - 1996
        policeBox96 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_1996), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {

        });
        policeBox96Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_1996_DOOR), -275.0F, false, true);

        // Police Box - 2003
        policeBox03 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_2003), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {

        });
        policeBox03Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_2003_DOOR), -275.0F, false, true);

        // Police Box - 1963
        policeBox63 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_1963), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {

        });

        policeBox63Massacre = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_1963_MASSACRE), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {

        });

        policeBox63Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_1963_DOOR), -275.0F, false, true);


        // Police Box - 2018
        policeBox18 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_2018), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
            poseStack.scale(0.7F, 0.7F, 0.7F);
            poseStack.translate(0F, 0.7F, 0F);
        });

        policeBox18_special = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_2018_SPECIAL), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
            poseStack.scale(0.7F, 0.7F, 0.7F);
            poseStack.translate(0F, 0.7F, 0F);
        });

        policeBox18Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_2018_DOOR), -275.0F, false, true);

        policeBox18Door_special = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_2018_DOOR_SPECIAL), -275.0F, false, true);



        policeBox66 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_1966), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
        });

        policeBoxRuth = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_RUTH), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
        });

        policeBox73 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_1973), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
        });



        policeBox66Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_1966_DOOR), -275.0F, false, true);



        // Police Box - 2010
        policeBox10 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_2010), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
            poseStack.scale(0.75F, 0.75F, 0.75F);
            poseStack.translate(0F, 0.5F, 0F);
        });
        policeBox10Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_2010_DOOR), -275.0F, false, true);

        sidrat = new SidratModel(entityModels.bakeLayer(SIDRAT));
        sidratDoor = new DualTexInteriorDoorModel(entityModels.bakeLayer(SIDRAT_DOOR));


        // Model Registration
        AUDShellEntryRegistry.init();
    }

    @ExpectPlatform
    public static ModelLayerLocation register(ModelLayerLocation location, Supplier<LayerDefinition> definitionSupplier) {
        throw new RuntimeException(PlatformWarning.addWarning(AUDModelRegistry.class));
    }

}
