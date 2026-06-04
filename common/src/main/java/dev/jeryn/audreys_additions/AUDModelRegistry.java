package dev.jeryn.audreys_additions;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.jeryn.audreys_additions.client.models.shell.*;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.client.model.blockentity.door.interior.DualInteriorDoorModel;
import whocraft.tardis_refined.client.model.blockentity.door.interior.DualTexInteriorDoorModel;
import whocraft.tardis_refined.client.model.blockentity.door.interior.SingleInteriorDoorModel;
import whocraft.tardis_refined.common.util.PlatformWarning;

import java.util.function.Supplier;

public class AUDModelRegistry {


    // Models
    public static PoliceBoxModel policeBox03, policeBox66, policeBoxRuth, policeBox73, policeBoxS13, policeBox18, policeBox18_special, policeBox10, policeBox11, policeBox17, policeBoxMemorial, policeBox76, policeBox96, policeBox63, policeBox63Massacre, trakenClock, policeBox83, policeBox87, policeBoxHappinessPatrol, policeBox05, policeBoxTimeWar, policeBox78, policeBox79, policeBoxPilot;
    public static DualInteriorDoorModel policeBox03Door, policeBox66Door, policeBox63Door, policeBox18Door, policeBox18Door_special, policeBox10Door, policeBox11Door, policeBox17Door, policeBox76Door, policeBox96Door, policeBox80Door, policeBox83Door, policeBox05Door;
    public static SingleInteriorDoorModel trakenClockDoor;
    public static DualTexInteriorDoorModel sidratDoor, columnDoor, ironMaidenDoor, ttCapsuleDoor, type40Door, telephoneBoothDoor, raniWardrobeDoor, lakertyanPyramidDoor, cabinetDoor, policeBoxBlackOrchidDoor, policeBoxAAISATDoor;
    public static SidratModel sidrat, column, ironMaiden, ttCapsule, type40, telephoneBooth, policeBox80, raniWardrobe, lakertyanPyramid, cabinet, policeBoxBlackOrchid, policeBoxAAISAT;
    public static TrakenClockModel grandfatherClock;
    public static TrakenClockInteriorDoorModel grandfatherClockDoor;

    // Model Layers
    public static ModelLayerLocation POLICEBOX_2018 = shell("policebox_2018");
    public static ModelLayerLocation POLICEBOX_2018_SPECIAL = shell("policebox_2018_special");
    public static ModelLayerLocation POLICEBOX_2018_DOOR = interiorDoor("policebox_2018_door");
    public static ModelLayerLocation POLICEBOX_2018_DOOR_SPECIAL = interiorDoor("policebox_2018_door_special");

    public static ModelLayerLocation POLICEBOX_2010 = shell("policebox_2010");
    public static ModelLayerLocation POLICEBOX_2010_DOOR = interiorDoor("policebox_2010_door");
    public static ModelLayerLocation POLICEBOX_2011 = shell("policebox_2011");
    public static ModelLayerLocation POLICEBOX_2011_DOOR = interiorDoor("policebox_2011_door");
    public static ModelLayerLocation POLICEBOX_2017 = shell("policebox_2017");
    public static ModelLayerLocation POLICEBOX_2017_DOOR = interiorDoor("policebox_2017_door");
    public static ModelLayerLocation POLICEBOX_MEMORIAL = shell("policebox_memorial");

    public static ModelLayerLocation POLICEBOX_2005 = shell("policebox_2005");
    public static ModelLayerLocation POLICEBOX_2005_DOOR = interiorDoor("policebox_2005_door");
    public static ModelLayerLocation POLICEBOX_TIME_WAR = shell("policebox_timewar");

    public static ModelLayerLocation POLICEBOX_1980 = shell("policebox_1980");
    public static ModelLayerLocation POLICEBOX_1980_DOOR = interiorDoor("policebox_1980_door");
    public static ModelLayerLocation POLICEBOX_1983 = shell("policebox_1983");
    public static ModelLayerLocation POLICEBOX_1983_DOOR = interiorDoor("policebox_1983_door");
    public static ModelLayerLocation POLICEBOX_1987 = shell("policebox_1987");
    public static ModelLayerLocation POLICEBOX_HAPPINESS_PATROL = shell("policebox_happiness_patrol");

    public static ModelLayerLocation POLICEBOX_1976 = shell("policebox_1976");
    public static ModelLayerLocation POLICEBOX_1976_DOOR = interiorDoor("policebox_1976_door");
    public static ModelLayerLocation POLICEBOX_1978 = shell("policebox_1978");
    public static ModelLayerLocation POLICEBOX_1979 = shell("policebox_1979");
    public static ModelLayerLocation POLICEBOX_BLACKORCHID = shell("policebox_blackorchid");
    public static ModelLayerLocation POLICEBOX_BLACKORCHID_DOOR = interiorDoor("policebox_blackorchid_door");

    public static ModelLayerLocation POLICEBOX_1996 = shell("policebox_1996");
    public static ModelLayerLocation POLICEBOX_1996_DOOR = interiorDoor("policebox_1996_door");

    public static ModelLayerLocation POLICEBOX_2003 = shell("policebox_2003");
    public static ModelLayerLocation POLICEBOX_2003_DOOR = interiorDoor("policebox_2003_door");

    public static ModelLayerLocation POLICEBOX_1966 = shell("policebox_1966");
    public static ModelLayerLocation POLICEBOX_RUTH = shell("policebox_ruth");
    public static ModelLayerLocation POLICEBOX_1973= shell("policebox_1973");
    public static ModelLayerLocation POLICEBOX_S13= shell("policebox_s13");
    public static ModelLayerLocation POLICEBOX_1966_DOOR = interiorDoor("policebox_1966_door");

    public static ModelLayerLocation CABINET = shell("cabinet");
    public static ModelLayerLocation CABINET_DOOR = interiorDoor("cabinet_door");

    public static ModelLayerLocation POLICEBOX_1963 = shell("policebox_1963");
    public static ModelLayerLocation POLICEBOX_1963_MASSACRE = shell("policebox_1963_massacre");
    public static ModelLayerLocation POLICEBOX_PILOT = shell("policebox_pilot");
    public static ModelLayerLocation POLICEBOX_1963_DOOR = interiorDoor("policebox_1963_door");

    public static ModelLayerLocation POLICEBOX_AAISAT = shell("policebox_aaisat");
    public static ModelLayerLocation POLICEBOX_AAISAT_DOOR = interiorDoor("policebox_aaisat_door");

    public static ModelLayerLocation SIDRAT = shell("sidrat");
    public static ModelLayerLocation SIDRAT_DOOR = interiorDoor("sidrat_door");

    public static ModelLayerLocation COLUMN = shell("column");
    public static ModelLayerLocation COLUMN_DOOR = interiorDoor("column_door");

    public static ModelLayerLocation TRAKENCLOCK = shell("trakenclock");
    public static ModelLayerLocation TRAKENCLOCK_DOOR = interiorDoor("trakenclock_door");

    public static ModelLayerLocation GRANDFATHER_CLOCK = shell("grandfather_clock");
    public static ModelLayerLocation GRANDFATHER_CLOCK_DOOR = interiorDoor("grandfather_clock_door");

    public static ModelLayerLocation TELEPHONE_BOOTH = shell("telephone_booth");
    public static ModelLayerLocation TELEPHONE_BOOTH_DOOR = interiorDoor("telephone_booth_door");

    public static ModelLayerLocation RANI_WARDROBE = shell("rani_wardrobe");
    public static ModelLayerLocation RANI_WARDROBE_DOOR = interiorDoor("rani_wardrobe_door");

    public static ModelLayerLocation IRON_MAIDEN = shell("iron_maiden");
    public static ModelLayerLocation IRON_MAIDEN_DOOR = interiorDoor("iron_maiden_door");

    public static ModelLayerLocation TT_CAPSULE = shell("tt_capsule");
    public static ModelLayerLocation TT_CAPSULE_DOOR = interiorDoor("tt_capsule_door");

    public static ModelLayerLocation TYPE_40 = shell("type_40");
    public static ModelLayerLocation TYPE_40_DOOR = interiorDoor("type_40_door");

    public static ModelLayerLocation LAKERTYAN_PYRAMID = shell("pyramid");
    public static ModelLayerLocation LAKERTYAN_PYRAMID_DOOR = interiorDoor("pyramid_door");

    public static ModelLayerLocation PERTWEE_CONSOLE = console("pertwee");
    public static ModelLayerLocation NEWBERY_CONSOLE = console("newbery");
    public static ModelLayerLocation MASTER_CONSOLE = console("master");
    public static ModelLayerLocation BRACHACKI_CONSOLE = console("brachacki");
    public static ModelLayerLocation TOYOTA_CONSOLE = console("toyota");
    public static ModelLayerLocation TOYOTA_BLUE_CONSOLE = console("toyota_blue");
    public static ModelLayerLocation TOYOTA_MISSY_CONSOLE = console("toyota_missy");
    public static ModelLayerLocation KELT_CONSOLE = console("kelt");
    public static ModelLayerLocation WARRIOR_CONSOLE = console("kelt_warrior");
    public static ModelLayerLocation MCGANN_CONSOLE = console("mcgann");
    public static ModelLayerLocation HUMAN_NATURE_CONSOLE = console("human_nature");
    public static ModelLayerLocation SILENCE_CONSOLE = console("silence");
    public static ModelLayerLocation RANI_CONSOLE = console("rani");
    public static ModelLayerLocation ALTERED_SHARP_CONSOLE = console("altered_sharp");
    public static ModelLayerLocation SEASON_16_CONSOLE = console("season_16");
    public static ModelLayerLocation SEASON_20_CONSOLE = console("season_20");
    public static ModelLayerLocation MEMORY_CONSOLE = console("memory");
    public static ModelLayerLocation CHRONOTIS_CONSOLE = console("chronotis");


    public static ModelLayerLocation KNOSSOS_THRONE = furniture("knossos_throne");
    public static ModelLayerLocation FOOD_MACHINE = furniture("food_machine");
    public static ModelLayerLocation ASTRAL_MAP = furniture("astral_map");
    public static ModelLayerLocation CEILING_CANOPY = furniture("ceiling_canopy");
    public static ModelLayerLocation CEILING_CANOPY_HANGING = furniture("ceiling_canopy_hanging");
    public static ModelLayerLocation FOLD_OUT_BED = furniture("fold_out_bed");
    public static ModelLayerLocation CAT = overlords("cat");
    public static ModelLayerLocation HATSTAND_OAK = furniture("hatstand_oak");
    public static ModelLayerLocation HATSTAND_SPRUCE = furniture("hatstand_spruce");
    public static ModelLayerLocation HATSTAND_BIRCH = furniture("hatstand_birch");
    public static ModelLayerLocation HATSTAND_JUNGLE = furniture("hatstand_jungle");
    public static ModelLayerLocation HATSTAND_ACACIA = furniture("hatstand_acacia");
    public static ModelLayerLocation HATSTAND_DARK_OAK = furniture("hatstand_dark_oak");
    public static ModelLayerLocation HATSTAND_MANGROVE = furniture("hatstand_mangrove");
    public static ModelLayerLocation HATSTAND_CHERRY = furniture("hatstand_cherry");
    public static ModelLayerLocation HATSTAND_PALE = furniture("hatstand_pale");
    public static ModelLayerLocation HATSTAND_BAMBOO = furniture("hatstand_bamboo");
    public static ModelLayerLocation HATSTAND_CRIMSON = furniture("hatstand_crimson");
    public static ModelLayerLocation HATSTAND_WARPED = furniture("hatstand_warped");
    public static ModelLayerLocation CABINET_INV = furniture("tardis_cabinet");


    public static ModelLayerLocation SPECIMEN_JAR = furniture("specimen_jar/specimen_jar");
    public static ModelLayerLocation SPECIMEN_JAR_ALLAY = furniture("specimen_jar/specimen_jar_allay");
    public static ModelLayerLocation SPECIMEN_JAR_CREEPER = furniture("specimen_jar/specimen_jar_creeper");
    public static ModelLayerLocation SPECIMEN_JAR_DRAGON = furniture("specimen_jar/specimen_jar_dragon");
    public static ModelLayerLocation SPECIMEN_JAR_PIGLIN = furniture("specimen_jar/specimen_jar_piglin");
    public static ModelLayerLocation SPECIMEN_JAR_SKELETON = furniture("specimen_jar/specimen_jar_skeleton");
    public static ModelLayerLocation SPECIMEN_JAR_VEX = furniture("specimen_jar/specimen_jar_vex");
    public static ModelLayerLocation SPECIMEN_JAR_WITHERSKELETON = furniture("specimen_jar/specimen_jar_wither_skeleton");
    public static ModelLayerLocation SPECIMEN_JAR_ZOMBIE = furniture("specimen_jar/specimen_jar_zombie");

    public static AnimatedCatModel cat;


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

    private static ModelLayerLocation overlords(String name) {
        return createLocation(name, "overlords");
    }


    private static ModelLayerLocation createLocation(String name, String layer) {
        return new ModelLayerLocation(new ResourceLocation(AudreysAdditions.MODID, name), layer);
    }        


    public static void init() {

    }

    public static void setupModelInstances(EntityModelSet entityModels) {
        cat = new AnimatedCatModel(entityModels.bakeLayer(CAT));

        // Police Box - 1976
        policeBox76 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_1976), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {

        });
        policeBox76Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_1976_DOOR), -275.0F, false, true);

        policeBox78 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_1978), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {

        });

        policeBox79 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_1979), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {

        });


        policeBoxBlackOrchid = new SidratModel(entityModels.bakeLayer(POLICEBOX_BLACKORCHID));
        policeBoxBlackOrchidDoor = new DualTexInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_BLACKORCHID_DOOR));





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

        policeBoxPilot = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_PILOT), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {

        });

        policeBox63Massacre = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_1963_MASSACRE), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {

        });

        policeBox63Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_1963_DOOR), -275.0F, false, true);

        policeBoxAAISAT = new SidratModel(entityModels.bakeLayer(POLICEBOX_AAISAT));
        policeBoxAAISATDoor = new DualTexInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_AAISAT_DOOR));

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


        // Police Box - 1966
        policeBox66 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_1966), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
        });

        policeBoxRuth = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_RUTH), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
        });

        policeBox73 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_1973), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
        });

        policeBoxS13 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_S13), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
        });

        policeBox66Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_1966_DOOR), -275.0F, false, true);



        // Police Box - 2010
        policeBox10 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_2010), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
        });
        policeBox10Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_2010_DOOR), -275.0F, false, true);

        policeBox11 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_2011), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
        });
        policeBox11Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_2011_DOOR), -275.0F, false, true);


        policeBox17 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_2017), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
        });
        policeBox17Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_2017_DOOR), -275.0F, false, true);

        policeBoxMemorial = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_MEMORIAL), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
        });

        // Police Box - 2005
        policeBox05 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_2005), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
        });
        policeBox05Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_2005_DOOR), -275.0F, false, true);
        policeBoxTimeWar = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_TIME_WAR), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
        });


        // TARDIS Cabinet
        cabinet = new SidratModel(entityModels.bakeLayer(CABINET));
        cabinetDoor = new DualTexInteriorDoorModel(entityModels.bakeLayer(CABINET_DOOR));

        // Police Box - 1980
        policeBox80 = new SidratModel(entityModels.bakeLayer(POLICEBOX_1980));
        policeBox80Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_1980_DOOR), -275.0F, true, false);

        policeBox83 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_1983), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
        });
        policeBox83Door = new DualInteriorDoorModel(entityModels.bakeLayer(POLICEBOX_1983_DOOR), -275.0F, false, true);

        policeBox87 = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_1987), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
        });

        policeBoxHappinessPatrol = new PoliceBoxModel(entityModels.bakeLayer(POLICEBOX_HAPPINESS_PATROL), (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {
        });

        // Sidrat
        sidrat = new SidratModel(entityModels.bakeLayer(SIDRAT));
        sidratDoor = new DualTexInteriorDoorModel(entityModels.bakeLayer(SIDRAT_DOOR));

        // Lakertyan Pyramid
        lakertyanPyramid = new SidratModel(entityModels.bakeLayer(LAKERTYAN_PYRAMID));
        lakertyanPyramidDoor = new DualTexInteriorDoorModel(entityModels.bakeLayer(LAKERTYAN_PYRAMID_DOOR));

        // Column
        column = new SidratModel(entityModels.bakeLayer(COLUMN));
        columnDoor = new DualTexInteriorDoorModel(entityModels.bakeLayer(COLUMN_DOOR));

        // TT Capsule
        ttCapsule = new SidratModel(entityModels.bakeLayer(TT_CAPSULE));
        ttCapsuleDoor = new DualTexInteriorDoorModel(entityModels.bakeLayer(TT_CAPSULE_DOOR));

        type40 = new SidratModel(entityModels.bakeLayer(TYPE_40));
        type40Door = new DualTexInteriorDoorModel(entityModels.bakeLayer(TYPE_40_DOOR));

        // Traken Clock
        trakenClock = new TrakenClockModel(entityModels.bakeLayer(TRAKENCLOCK));
        trakenClockDoor = new TrakenClockInteriorDoorModel(entityModels.bakeLayer(TRAKENCLOCK_DOOR), (float)Math.toRadians(110));

        // Grandfather Clock
        grandfatherClock = new TrakenClockModel(entityModels.bakeLayer(GRANDFATHER_CLOCK));
        grandfatherClockDoor = new TrakenClockInteriorDoorModel(entityModels.bakeLayer(GRANDFATHER_CLOCK_DOOR), (float)Math.toRadians(120));

        // Telephone Booth
        telephoneBooth = new SidratModel(entityModels.bakeLayer(TELEPHONE_BOOTH));
        telephoneBoothDoor = new DualTexInteriorDoorModel(entityModels.bakeLayer(TELEPHONE_BOOTH_DOOR));

        // Rani Wardrobe
        raniWardrobe = new SidratModel(entityModels.bakeLayer(RANI_WARDROBE));
        raniWardrobeDoor = new DualTexInteriorDoorModel(entityModels.bakeLayer(RANI_WARDROBE_DOOR));

        // Iron Maiden
        ironMaiden = new SidratModel(entityModels.bakeLayer(IRON_MAIDEN));
        ironMaidenDoor = new DualTexInteriorDoorModel(entityModels.bakeLayer(IRON_MAIDEN_DOOR));

        // Model Registration
        AUDShellEntryRegistry.init();
    }

    @ExpectPlatform
    public static ModelLayerLocation register(ModelLayerLocation location, Supplier<LayerDefinition> definitionSupplier) {
        throw new RuntimeException(PlatformWarning.addWarning(AUDModelRegistry.class));
    }

}
