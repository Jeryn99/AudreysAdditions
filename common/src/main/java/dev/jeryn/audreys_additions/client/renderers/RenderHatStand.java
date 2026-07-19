package dev.jeryn.audreys_additions.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.client.models.GenericHatStandModel;
import dev.jeryn.audreys_additions.common.blockentity.hatstand.HatstandBlockEntity;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.Map;
import java.util.Objects;

public class RenderHatStand implements BlockEntityRenderer<HatstandBlockEntity>, BlockEntityRendererProvider<HatstandBlockEntity> {

    private static final Map<Block, ResourceLocation> HATSTAND_TEXTURES = Map.ofEntries(
            Map.entry(AudBlocks.HATSTAND_OAK.get(),
                    new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_oak.png")),
            Map.entry(AudBlocks.HATSTAND_SPRUCE.get(),
                    new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_spruce.png")),
            Map.entry(AudBlocks.HATSTAND_BIRCH.get(),
                    new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_birch.png")),
            Map.entry(AudBlocks.HATSTAND_JUNGLE.get(),
                    new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_jungle.png")),
            Map.entry(AudBlocks.HATSTAND_ACACIA.get(),
                    new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_acacia.png")),
            Map.entry(AudBlocks.HATSTAND_DARK_OAK.get(),
                    new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_dark_oak.png")),
            Map.entry(AudBlocks.HATSTAND_MANGROVE.get(),
                    new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_mangrove.png")),
            Map.entry(AudBlocks.HATSTAND_CHERRY.get(),
                    new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_cherry.png")),
            Map.entry(AudBlocks.HATSTAND_PALE.get(),
                    new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_pale.png")),
            Map.entry(AudBlocks.HATSTAND_BAMBOO.get(),
                    new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_bamboo.png")),
            Map.entry(AudBlocks.HATSTAND_CRIMSON.get(),
                    new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_crimson.png")),
            Map.entry(AudBlocks.HATSTAND_WARPED.get(),
                    new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/hat_stand/hatstand_warped.png"))
    );

    private final GenericHatStandModel hatStandOak;
    private final GenericHatStandModel hatStandSpruce;
    private final GenericHatStandModel hatStandBirch;
    private final GenericHatStandModel hatStandJungle;
    private final GenericHatStandModel hatStandAcacia;
    private final GenericHatStandModel hatStandDarkOak;
    private final GenericHatStandModel hatStandMangrove;
    private final GenericHatStandModel hatStandCherry;
    private final GenericHatStandModel hatStandPale;
    private final GenericHatStandModel hatStandBamboo;
    private final GenericHatStandModel hatStandCrimson;
    private final GenericHatStandModel hatStandWarped;
    private GenericHatStandModel hatStandMain;

    public RenderHatStand(Context context) {
        hatStandOak = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_OAK), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {
                // rotations on Y axis need inverting. positions on X and Y axes need inverting
                humanoidModel.head.yRot = (float) Math.toRadians(-45);
                humanoidModel.head.zRot = (float) Math.toRadians(15);
                humanoidModel.head.x =  -5;
                humanoidModel.head.z =  -5;
                humanoidModel.head.xScale = (float)0.75; humanoidModel.head.yScale = (float)0.75; humanoidModel.head.zScale = (float)0.75;

                humanoidModel.body.yRot = (float) Math.toRadians(-47.5);
                humanoidModel.body.x =  3;
                humanoidModel.body.y =  -1;
                humanoidModel.body.z =  -3;
                humanoidModel.body.xScale = (float)0.75; humanoidModel.body.yScale = (float)0.75; humanoidModel.body.zScale = (float)0.75;

                humanoidModel.leftArm.yRot = (float) Math.toRadians(-72.5);
                humanoidModel.leftArm.zRot = (float) Math.toRadians(-5);
                // this position number. why the fuck does the torso position work off of what i had but the arms need to be special??
                // note: do not set positions to 0 if you're not using them
                humanoidModel.leftArm.x =  6;
                humanoidModel.leftArm.xScale = (float)0.75; humanoidModel.leftArm.yScale = (float)0.75; humanoidModel.leftArm.zScale = (float)0.75;

                humanoidModel.rightArm.xRot = (float) Math.toRadians(-5);
                humanoidModel.rightArm.yRot = (float) Math.toRadians(0);
                humanoidModel.rightArm.zRot = (float) Math.toRadians(0);
                // WHAT IS GOING ON. these positions are not off in the same way every time. i am going insane
                humanoidModel.rightArm.x =  0;
                humanoidModel.rightArm.z =  -5;
                humanoidModel.rightArm.xScale = (float)0.75; humanoidModel.rightArm.yScale = (float)0.75; humanoidModel.rightArm.zScale = (float)0.75;

                humanoidModel.leftLeg.xRot = (float) Math.toRadians(0);
                humanoidModel.leftLeg.yRot = (float) Math.toRadians(47.5);
                humanoidModel.leftLeg.zRot = (float) Math.toRadians(0);
                humanoidModel.leftLeg.x =  (float)-3.1;
                // okay. okay. so whenever i access these positions it is adjusting them to be moving relative to 0 0 0 of the model. not relative to its prior position
                // dumb. Dumb. nothing i cant adjust for but it means that i shouldve just maintained how i was doing things prior
                humanoidModel.leftLeg.y =  (float)14.5;
                humanoidModel.leftLeg.z =  -3;
                humanoidModel.leftLeg.xScale = (float)0.75; humanoidModel.leftLeg.yScale = (float)0.75; humanoidModel.leftLeg.zScale = (float)0.75;
                // no i was wrong. there's no easy way for me to preview the scale-down transformation in blockbench while still accessing worldspace coords
                // this shit is so stupid

                humanoidModel.rightLeg.xRot = (float) Math.toRadians(0);
                humanoidModel.rightLeg.yRot = (float) Math.toRadians(-20);
                humanoidModel.rightLeg.zRot = (float) Math.toRadians(0);
                humanoidModel.rightLeg.x =  (float)-7.9;
                humanoidModel.rightLeg.y =  (float)14.5;
                humanoidModel.rightLeg.z =  -5;
                humanoidModel.rightLeg.xScale = (float)0.75; humanoidModel.rightLeg.yScale = (float)0.75; humanoidModel.rightLeg.zScale = (float)0.75;
            }
        });
        hatStandSpruce = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_SPRUCE), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {
                humanoidModel.head.xRot = (float) Math.toRadians(-42.5);
                humanoidModel.head.yRot = (float) Math.toRadians(-170);
                humanoidModel.head.x = (float) 1.5;
                humanoidModel.head.y = (float) 0.5;
                humanoidModel.head.z =  -5;
                humanoidModel.head.xScale = (float)0.75; humanoidModel.head.yScale = (float)0.75; humanoidModel.head.zScale = (float)0.75;

                humanoidModel.leftArm.yRot = (float) Math.toRadians(100);
                humanoidModel.leftArm.x =  0;
                humanoidModel.leftArm.y = (float) 2.5;
                humanoidModel.leftArm.z = (float) 7.5;
                humanoidModel.leftArm.xScale = (float)0.75; humanoidModel.leftArm.yScale = (float)0.75; humanoidModel.leftArm.zScale = (float)0.75;

                humanoidModel.rightArm.xRot = (float) Math.toRadians(-5);
                humanoidModel.rightArm.x = (float) 6.5;
                humanoidModel.rightArm.y = 4;
                humanoidModel.rightArm.z =  -4;
                humanoidModel.rightArm.xScale = (float)0.75; humanoidModel.rightArm.yScale = (float)0.75; humanoidModel.rightArm.zScale = (float)0.75;

                humanoidModel.body.xRot = (float) Math.toRadians(-22.5);
                humanoidModel.body.yRot = (float) Math.toRadians(-47.5);
                humanoidModel.body.zRot = (float) Math.toRadians(22.5);
                humanoidModel.body.x =  10;
                humanoidModel.body.y =  2;
                humanoidModel.body.xScale = (float)0.75; humanoidModel.body.yScale = (float)0.75; humanoidModel.body.zScale = (float)0.75;

                humanoidModel.leftLeg.yRot = (float) Math.toRadians(47.5);
                humanoidModel.leftLeg.x = 1;
                humanoidModel.leftLeg.y =  (float)14.5;
                humanoidModel.leftLeg.z =  6;
                humanoidModel.leftLeg.xScale = (float)0.75; humanoidModel.leftLeg.yScale = (float)0.75; humanoidModel.leftLeg.zScale = (float)0.75;

                humanoidModel.rightLeg.yRot = (float) Math.toRadians(5);
                humanoidModel.rightLeg.x =  -4;
                humanoidModel.rightLeg.y =  (float)14.5;
                humanoidModel.rightLeg.z =  -4;
                humanoidModel.rightLeg.xScale = (float)0.75; humanoidModel.rightLeg.yScale = (float)0.75; humanoidModel.rightLeg.zScale = (float)0.75;

            }
        });
        hatStandBirch = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_BIRCH), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {
                humanoidModel.head.xRot = (float) Math.toRadians(-42.5);
                humanoidModel.head.yRot = (float) Math.toRadians(-170);
                humanoidModel.head.x = (float) 1.5;
                humanoidModel.head.y = (float) -2.5;
                humanoidModel.head.z =  -5;
                humanoidModel.head.xScale = (float)0.75; humanoidModel.head.yScale = (float)0.75; humanoidModel.head.zScale = (float)0.75;

                humanoidModel.leftArm.yRot = (float) Math.toRadians(100);
                humanoidModel.leftArm.x =  0;
                humanoidModel.leftArm.y = (float) -2.5;
                humanoidModel.leftArm.z = (float) 7.5;
                humanoidModel.leftArm.xScale = (float)0.75; humanoidModel.leftArm.yScale = (float)0.75; humanoidModel.leftArm.zScale = (float)0.75;

                humanoidModel.rightArm.xRot = (float) Math.toRadians(-5);
                humanoidModel.rightArm.x = (float) 0.5;
                humanoidModel.rightArm.y = 4;
                humanoidModel.rightArm.z = (float) -4.5;
                humanoidModel.rightArm.xScale = (float)0.75; humanoidModel.rightArm.yScale = (float)0.75; humanoidModel.rightArm.zScale = (float)0.75;

                humanoidModel.body.xRot = (float) Math.toRadians(-22.5);
                humanoidModel.body.yRot = (float) Math.toRadians(-47.5);
                humanoidModel.body.zRot = (float) Math.toRadians(22.5);
                humanoidModel.body.x =  4;
                humanoidModel.body.y =  5;
                humanoidModel.body.z = (float) -1.5;
                humanoidModel.body.xScale = (float)0.75; humanoidModel.body.yScale = (float)0.75; humanoidModel.body.zScale = (float)0.75;

                humanoidModel.leftLeg.yRot = (float) Math.toRadians(47.5);
                humanoidModel.leftLeg.x = 1;
                humanoidModel.leftLeg.y =  (float)14.5;
                humanoidModel.leftLeg.z =  6;
                humanoidModel.leftLeg.xScale = (float)0.75; humanoidModel.leftLeg.yScale = (float)0.75; humanoidModel.leftLeg.zScale = (float)0.75;

                humanoidModel.rightLeg.yRot = (float) Math.toRadians(5);
                humanoidModel.rightLeg.x =  -4;
                humanoidModel.rightLeg.y =  (float)14.5;
                humanoidModel.rightLeg.z =  -4;
                humanoidModel.rightLeg.xScale = (float)0.75; humanoidModel.rightLeg.yScale = (float)0.75; humanoidModel.rightLeg.zScale = (float)0.75;
            }
        });
        hatStandJungle = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_JUNGLE), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {
                humanoidModel.head.yRot = (float) Math.toRadians(62.5);
                humanoidModel.head.x = (float) 0.5;
                humanoidModel.head.y = (float) -2;
                humanoidModel.head.z =  -1;
                humanoidModel.head.xScale = (float)0.75; humanoidModel.head.yScale = (float)0.75; humanoidModel.head.zScale = (float)0.75;

                humanoidModel.leftArm.xRot = (float) Math.toRadians(2.5);
                humanoidModel.leftArm.zRot = (float) Math.toRadians(-2.5);
                humanoidModel.leftArm.x =  4;
                humanoidModel.leftArm.y = -1;
                humanoidModel.leftArm.z = 3;
                humanoidModel.leftArm.xScale = (float)0.75; humanoidModel.leftArm.yScale = (float)0.75; humanoidModel.leftArm.zScale = (float)0.75;

                humanoidModel.rightArm.zRot = (float) Math.toRadians(22.5);
                humanoidModel.rightArm.x = -5;
                humanoidModel.rightArm.y = -1;
                humanoidModel.rightArm.z = 3;
                humanoidModel.rightArm.xScale = (float)0.75; humanoidModel.rightArm.yScale = (float)0.75; humanoidModel.rightArm.zScale = (float)0.75;

                humanoidModel.body.xRot = (float) Math.toRadians(-90);
                humanoidModel.body.yRot = (float) Math.toRadians(17.5);
                humanoidModel.body.y =  -2;
                humanoidModel.body.z = (float) 4;
                humanoidModel.body.xScale = (float)0.75; humanoidModel.body.yScale = (float)0.75; humanoidModel.body.zScale = (float)0.75;

                humanoidModel.leftLeg.zRot = (float) Math.toRadians(-27.5);
                humanoidModel.leftLeg.x = 4;
                humanoidModel.leftLeg.y =  (float)14.5;
                humanoidModel.leftLeg.xScale = (float)0.75; humanoidModel.leftLeg.yScale = (float)0.75; humanoidModel.leftLeg.zScale = (float)0.75;

                humanoidModel.rightLeg.yRot = (float) Math.toRadians(5);
                humanoidModel.rightLeg.x =  -8;
                humanoidModel.rightLeg.y =  (float)14.5;
                humanoidModel.rightLeg.z =  -3;
                humanoidModel.rightLeg.xScale = (float)0.75; humanoidModel.rightLeg.yScale = (float)0.75; humanoidModel.rightLeg.zScale = (float)0.75;
            }
        });
        hatStandAcacia = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_ACACIA), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {
                humanoidModel.head.xRot = (float) Math.toRadians(90);
                humanoidModel.head.yRot = (float) Math.toRadians(62.5);
                humanoidModel.head.x = (float) 3.5;
                humanoidModel.head.y = (float) -1.5;
                humanoidModel.head.z =  1;
                humanoidModel.head.xScale = (float)0.75; humanoidModel.head.yScale = (float)0.75; humanoidModel.head.zScale = (float)0.75;

                humanoidModel.body.xRot = (float) Math.toRadians(-30);
                humanoidModel.body.y =  15;
                humanoidModel.body.z = -4;
                humanoidModel.body.xScale = (float)0.75; humanoidModel.body.yScale = (float)0.75; humanoidModel.body.zScale = (float)0.75;

                humanoidModel.leftArm.zRot = (float) Math.toRadians(-17.5);
                humanoidModel.leftArm.x =  5;
                humanoidModel.leftArm.y = 17;
                humanoidModel.leftArm.z = -4;
                humanoidModel.leftArm.xScale = (float)0.75; humanoidModel.leftArm.yScale = (float)0.75; humanoidModel.leftArm.zScale = (float)0.75;

                humanoidModel.rightArm.x = -4;
                humanoidModel.rightArm.y = 17;
                humanoidModel.rightArm.z = -4;
                humanoidModel.rightArm.xScale = (float)0.75; humanoidModel.rightArm.yScale = (float)0.75; humanoidModel.rightArm.zScale = (float)0.75;

                humanoidModel.leftLeg.zRot = (float) Math.toRadians(-27.5);
                humanoidModel.leftLeg.x = 4;
                humanoidModel.leftLeg.y =  (float)14.5;
                humanoidModel.leftLeg.z =  2;
                humanoidModel.leftLeg.xScale = (float)0.75; humanoidModel.leftLeg.yScale = (float)0.75; humanoidModel.leftLeg.zScale = (float)0.75;

                humanoidModel.rightLeg.yRot = (float) Math.toRadians(5);
                humanoidModel.rightLeg.x =  -8;
                humanoidModel.rightLeg.y =  (float)14.5;
                humanoidModel.rightLeg.z =  1;
                humanoidModel.rightLeg.xScale = (float)0.75; humanoidModel.rightLeg.yScale = (float)0.75; humanoidModel.rightLeg.zScale = (float)0.75;
            }
        });
        hatStandDarkOak = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_DARK_OAK), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {
                humanoidModel.head.xRot = (float) Math.toRadians(90);
                humanoidModel.head.yRot = (float) Math.toRadians(-62.5);
                humanoidModel.head.x = (float) -3.5;
                humanoidModel.head.y = (float) -11.5;
                humanoidModel.head.z =  1;
                humanoidModel.head.xScale = (float)0.75; humanoidModel.head.yScale = (float)0.75; humanoidModel.head.zScale = (float)0.75;

                humanoidModel.body.xRot = (float) Math.toRadians(7.5);
                humanoidModel.body.y =  1;
                humanoidModel.body.z = -5;
                humanoidModel.body.xScale = (float)0.75; humanoidModel.body.yScale = (float)0.75; humanoidModel.body.zScale = (float)0.75;

                humanoidModel.leftArm.xRot = (float) Math.toRadians(-5);
                humanoidModel.leftArm.x =  4;
                humanoidModel.leftArm.y = 1;
                humanoidModel.leftArm.z = -4;
                humanoidModel.leftArm.xScale = (float)0.75; humanoidModel.leftArm.yScale = (float)0.75; humanoidModel.leftArm.zScale = (float)0.75;

                humanoidModel.rightArm.xRot = (float) Math.toRadians(-5);
                humanoidModel.rightArm.x = -4;
                humanoidModel.rightArm.y = 1;
                humanoidModel.rightArm.z = -4;
                humanoidModel.rightArm.xScale = (float)0.75; humanoidModel.rightArm.yScale = (float)0.75; humanoidModel.rightArm.zScale = (float)0.75;

                humanoidModel.leftLeg.yRot = (float) Math.toRadians(60);
                humanoidModel.leftLeg.x = (float)2.5;
                humanoidModel.leftLeg.y =  (float)7.5;
                humanoidModel.leftLeg.z =  (float)1.5;
                humanoidModel.leftLeg.xScale = (float)0.75; humanoidModel.leftLeg.yScale = (float)0.75; humanoidModel.leftLeg.zScale = (float)0.75;

                humanoidModel.rightLeg.yRot = (float) Math.toRadians(-60);
                humanoidModel.rightLeg.x =  (float)-2.5;
                humanoidModel.rightLeg.y =  (float)7.5;
                humanoidModel.rightLeg.z =  (float)1.5;
                humanoidModel.rightLeg.xScale = (float)0.75; humanoidModel.rightLeg.yScale = (float)0.75; humanoidModel.rightLeg.zScale = (float)0.75;


            }
        });
        hatStandMangrove = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_MANGROVE), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {
                humanoidModel.head.xRot = (float) Math.toRadians(-42.5);
                humanoidModel.head.yRot = (float) Math.toRadians(-170);
                humanoidModel.head.x = (float) -4.5;
                humanoidModel.head.y = (float) -5.5;
                humanoidModel.head.z =  3;
                humanoidModel.head.xScale = (float)0.75; humanoidModel.head.yScale = (float)0.75; humanoidModel.head.zScale = (float)0.75;

                humanoidModel.body.y =  (float)-3.5;
                humanoidModel.body.z = 2;
                humanoidModel.body.xScale = (float)0.75; humanoidModel.body.yScale = (float)0.75; humanoidModel.body.zScale = (float)0.75;

                humanoidModel.leftArm.zRot = (float) Math.toRadians(-22.5);
                humanoidModel.leftArm.x = 4;
                humanoidModel.leftArm.y =  (float)-3.5;
                humanoidModel.leftArm.z = 3;
                humanoidModel.leftArm.xScale = (float)0.75; humanoidModel.leftArm.yScale = (float)0.75; humanoidModel.leftArm.zScale = (float)0.75;

                humanoidModel.rightArm.zRot = (float) Math.toRadians(22.5);
                humanoidModel.rightArm.x = -4;
                humanoidModel.rightArm.y =  (float)-3.5;
                humanoidModel.rightArm.z = 3;
                humanoidModel.rightArm.xScale = (float)0.75; humanoidModel.rightArm.yScale = (float)0.75; humanoidModel.rightArm.zScale = (float)0.75;

                humanoidModel.leftLeg.yRot = (float) Math.toRadians(5);
                humanoidModel.leftLeg.x = 3;
                humanoidModel.leftLeg.y = (float)12.5;
                humanoidModel.leftLeg.z = 3;
                humanoidModel.leftLeg.xScale = (float)0.75; humanoidModel.leftLeg.yScale = (float)0.75; humanoidModel.leftLeg.zScale = (float)0.75;

                humanoidModel.rightLeg.yRot = (float) Math.toRadians(5);
                humanoidModel.rightLeg.x = -3;
                humanoidModel.rightLeg.y = (float)12.5;
                humanoidModel.rightLeg.z = 3;
                humanoidModel.rightLeg.xScale = (float)0.75; humanoidModel.leftLeg.yScale = (float)0.75; humanoidModel.leftLeg.zScale = (float)0.75;
            }
        });
        hatStandCherry = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_CHERRY), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {
                humanoidModel.head.yRot = (float) Math.toRadians(-45);
                humanoidModel.head.zRot = (float) Math.toRadians(15);
                humanoidModel.head.x =  -3;
                humanoidModel.head.z =  -5;
                humanoidModel.head.xScale = (float)0.75; humanoidModel.head.yScale = (float)0.75; humanoidModel.head.zScale = (float)0.75;

                humanoidModel.leftArm.xRot = (float) Math.toRadians(2.5);
                humanoidModel.leftArm.zRot = (float) Math.toRadians(-2.5);
                humanoidModel.leftArm.x =  4;
                humanoidModel.leftArm.y = 22;
                humanoidModel.leftArm.z = 3;
                humanoidModel.leftArm.xScale = (float)0.75; humanoidModel.leftArm.yScale = (float)0.75; humanoidModel.leftArm.zScale = (float)0.75;

                humanoidModel.rightArm.zRot = (float) Math.toRadians(2.5);
                humanoidModel.rightArm.x = -5;
                humanoidModel.rightArm.y = 22;
                humanoidModel.rightArm.z = 3;
                humanoidModel.rightArm.xScale = (float)0.75; humanoidModel.rightArm.yScale = (float)0.75; humanoidModel.rightArm.zScale = (float)0.75;

                humanoidModel.body.xRot = (float) Math.toRadians(-90);
                humanoidModel.body.yRot = (float) Math.toRadians(17.5);
                humanoidModel.body.y =  22;
                humanoidModel.body.z = (float) 4;
                humanoidModel.body.xScale = (float)0.75; humanoidModel.body.yScale = (float)0.75; humanoidModel.body.zScale = (float)0.75;

                humanoidModel.leftLeg.yRot = (float) Math.toRadians(47.5);
                humanoidModel.leftLeg.x = 1;
                humanoidModel.leftLeg.y =  (float)10.5;
                humanoidModel.leftLeg.z =  2;
                humanoidModel.leftLeg.xScale = (float)0.75; humanoidModel.leftLeg.yScale = (float)0.75; humanoidModel.leftLeg.zScale = (float)0.75;

                humanoidModel.rightLeg.yRot = (float) Math.toRadians(5);
                humanoidModel.rightLeg.x =  5;
                humanoidModel.rightLeg.y =  (float)14.5;
                humanoidModel.rightLeg.z =  -4;
                humanoidModel.rightLeg.xScale = (float)0.75; humanoidModel.rightLeg.yScale = (float)0.75; humanoidModel.rightLeg.zScale = (float)0.75;
            }
        });
        hatStandPale = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_PALE), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {
                humanoidModel.head.yRot = (float) Math.toRadians(-45);
                humanoidModel.head.zRot = (float) Math.toRadians(15);
                humanoidModel.head.x =  -5;
                humanoidModel.head.z =  -5;
                humanoidModel.head.xScale = (float)0.75; humanoidModel.head.yScale = (float)0.75; humanoidModel.head.zScale = (float)0.75;

                humanoidModel.body.yRot = (float) Math.toRadians(-47.5);
                humanoidModel.body.x =  3;
                humanoidModel.body.y =  -1;
                humanoidModel.body.z =  -3;
                humanoidModel.body.xScale = (float)0.75; humanoidModel.body.yScale = (float)0.75; humanoidModel.body.zScale = (float)0.75;

                humanoidModel.leftArm.yRot = (float) Math.toRadians(-72.5);
                humanoidModel.leftArm.zRot = (float) Math.toRadians(-5);
                humanoidModel.leftArm.x =  6;
                humanoidModel.leftArm.xScale = (float)0.75; humanoidModel.leftArm.yScale = (float)0.75; humanoidModel.leftArm.zScale = (float)0.75;

                humanoidModel.rightArm.xRot = (float) Math.toRadians(-5);
                humanoidModel.rightArm.yRot = (float) Math.toRadians(0);
                humanoidModel.rightArm.zRot = (float) Math.toRadians(0);
                humanoidModel.rightArm.x =  0;
                humanoidModel.rightArm.z =  -5;
                humanoidModel.rightArm.xScale = (float)0.75; humanoidModel.rightArm.yScale = (float)0.75; humanoidModel.rightArm.zScale = (float)0.75;

                humanoidModel.leftLeg.xRot = (float) Math.toRadians(0);
                humanoidModel.leftLeg.yRot = (float) Math.toRadians(47.5);
                humanoidModel.leftLeg.zRot = (float) Math.toRadians(0);
                humanoidModel.leftLeg.x =  (float)-3.1;
                humanoidModel.leftLeg.y =  (float)14.5;
                humanoidModel.leftLeg.z =  -3;
                humanoidModel.leftLeg.xScale = (float)0.75; humanoidModel.leftLeg.yScale = (float)0.75; humanoidModel.leftLeg.zScale = (float)0.75;

                humanoidModel.rightLeg.xRot = (float) Math.toRadians(0);
                humanoidModel.rightLeg.yRot = (float) Math.toRadians(-20);
                humanoidModel.rightLeg.zRot = (float) Math.toRadians(0);
                humanoidModel.rightLeg.x =  (float)-7.9;
                humanoidModel.rightLeg.y =  (float)14.5;
                humanoidModel.rightLeg.z =  -5;
                humanoidModel.rightLeg.xScale = (float)0.75; humanoidModel.rightLeg.yScale = (float)0.75; humanoidModel.rightLeg.zScale = (float)0.75;
            }
        });
        hatStandBamboo = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_BAMBOO), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {
                humanoidModel.head.yRot = (float) Math.toRadians(-45);
                humanoidModel.head.zRot = (float) Math.toRadians(-45);
                humanoidModel.head.x =  1;
                humanoidModel.head.y =  -17;
                humanoidModel.head.z =  1;
                humanoidModel.head.xScale = (float)0.75; humanoidModel.head.yScale = (float)0.75; humanoidModel.head.zScale = (float)0.75;

                humanoidModel.body.xRot = (float) Math.toRadians(-30);
                humanoidModel.body.y =  13;
                humanoidModel.body.z = -4;
                humanoidModel.body.xScale = (float)0.75; humanoidModel.body.yScale = (float)0.75; humanoidModel.body.zScale = (float)0.75;

                humanoidModel.leftArm.zRot = (float) Math.toRadians(-17.5);
                humanoidModel.leftArm.x =  5;
                humanoidModel.leftArm.y = 15;
                humanoidModel.leftArm.z = -4;
                humanoidModel.leftArm.xScale = (float)0.75; humanoidModel.leftArm.yScale = (float)0.75; humanoidModel.leftArm.zScale = (float)0.75;

                humanoidModel.rightArm.x = -4;
                humanoidModel.rightArm.y = 15;
                humanoidModel.rightArm.z = -4;
                humanoidModel.rightArm.xScale = (float)0.75; humanoidModel.rightArm.yScale = (float)0.75; humanoidModel.rightArm.zScale = (float)0.75;

                humanoidModel.leftLeg.zRot = (float) Math.toRadians(-27.5);
                humanoidModel.leftLeg.x = 4;
                humanoidModel.leftLeg.y =  (float)12.5;
                humanoidModel.leftLeg.z =  2;
                humanoidModel.leftLeg.xScale = (float)0.75; humanoidModel.leftLeg.yScale = (float)0.75; humanoidModel.leftLeg.zScale = (float)0.75;

                humanoidModel.rightLeg.yRot = (float) Math.toRadians(5);
                humanoidModel.rightLeg.x =  -10;
                humanoidModel.rightLeg.y =  (float)14.5;
                humanoidModel.rightLeg.z =  1;
                humanoidModel.rightLeg.xScale = (float)0.75; humanoidModel.rightLeg.yScale = (float)0.75; humanoidModel.rightLeg.zScale = (float)0.75;

            }
        });
        hatStandCrimson = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_CRIMSON), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {
                humanoidModel.head.xRot = (float) Math.toRadians(-42.5);
                humanoidModel.head.yRot = (float) Math.toRadians(-170);
                humanoidModel.head.x = (float) -5.5;
                humanoidModel.head.y = (float) -1;
                humanoidModel.head.z =  4;
                humanoidModel.head.xScale = (float)0.75; humanoidModel.head.yScale = (float)0.75; humanoidModel.head.zScale = (float)0.75;

                humanoidModel.body.xRot = (float) Math.toRadians(-45);
                humanoidModel.body.y =  4;
                humanoidModel.body.z = 4;
                humanoidModel.body.xScale = (float)0.75; humanoidModel.body.yScale = (float)0.75; humanoidModel.body.zScale = (float)0.75;

                humanoidModel.leftArm.zRot = (float) Math.toRadians(-17.5);
                humanoidModel.leftArm.x =  6;
                humanoidModel.leftArm.y = 4;
                humanoidModel.leftArm.z = 4;
                humanoidModel.leftArm.xScale = (float)0.75; humanoidModel.leftArm.yScale = (float)0.75; humanoidModel.leftArm.zScale = (float)0.75;

                humanoidModel.rightArm.zRot = (float) Math.toRadians(17.5);
                humanoidModel.rightArm.x = -6;
                humanoidModel.rightArm.y = 4;
                humanoidModel.rightArm.z = 4;
                humanoidModel.rightArm.xScale = (float)0.75; humanoidModel.rightArm.yScale = (float)0.75; humanoidModel.rightArm.zScale = (float)0.75;

                humanoidModel.leftLeg.xRot = (float) Math.toRadians(-10);
                humanoidModel.leftLeg.zRot = (float) Math.toRadians(-90);
                humanoidModel.leftLeg.x = -5;
                humanoidModel.leftLeg.y =  (float)19.5;
                humanoidModel.leftLeg.z = (float) 5.5;
                humanoidModel.leftLeg.xScale = (float)0.75; humanoidModel.leftLeg.yScale = (float)0.75; humanoidModel.leftLeg.zScale = (float)0.75;

                humanoidModel.rightLeg.xRot = (float) Math.toRadians(10);
                humanoidModel.rightLeg.zRot = (float) Math.toRadians(-90);
                humanoidModel.rightLeg.x = -5;
                humanoidModel.rightLeg.y =  (float)15.5;
                humanoidModel.rightLeg.z = (float) 3.5;
                humanoidModel.rightLeg.xScale = (float)0.75; humanoidModel.leftLeg.yScale = (float)0.75; humanoidModel.leftLeg.zScale = (float)0.75;
            }
        });
        hatStandWarped = new GenericHatStandModel(context.bakeLayer(AUDModelRegistry.HATSTAND_WARPED), new GenericHatStandModel.Positioner() {
            @Override
            public void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack) {

            }

            @Override
            public void animateArmor(int slotIndex, ItemStack stack, PoseStack poseStack, HumanoidModel<LivingEntity> humanoidModel) {
                humanoidModel.head.xRot = (float) Math.toRadians(-42.5);
                humanoidModel.head.yRot = (float) Math.toRadians(-170);
                humanoidModel.head.x = (float) 5;
                humanoidModel.head.y = (float) 3;
                humanoidModel.head.z = -3;
                humanoidModel.head.xScale = (float)0.75; humanoidModel.head.yScale = (float)0.75; humanoidModel.head.zScale = (float)0.75;

                humanoidModel.body.xRot = (float) Math.toRadians(-5);
                humanoidModel.body.yRot = (float) Math.toRadians(90);
                humanoidModel.body.y = (float) -5;
                humanoidModel.body.x =  -5;
                humanoidModel.body.xScale = (float)0.75; humanoidModel.body.yScale = (float)0.75; humanoidModel.body.zScale = (float)0.75;


                humanoidModel.leftArm.yRot = (float) Math.toRadians(67.5); //six sevennn
                humanoidModel.leftArm.x =  -4;
                humanoidModel.leftArm.y = -6;
                humanoidModel.leftArm.z = -4;
                humanoidModel.leftArm.xScale = (float)0.75; humanoidModel.leftArm.yScale = (float)0.75; humanoidModel.leftArm.zScale = (float)0.75;

                humanoidModel.rightArm.yRot = (float) Math.toRadians(-67.5);
                humanoidModel.rightArm.x =  -3;
                humanoidModel.rightArm.y = -6;
                humanoidModel.rightArm.z = 6;
                humanoidModel.rightArm.xScale = (float)0.75; humanoidModel.rightArm.yScale = (float)0.75; humanoidModel.rightArm.zScale = (float)0.75;

                humanoidModel.leftLeg.yRot = (float) Math.toRadians(47.5);
                humanoidModel.leftLeg.x = 1;
                humanoidModel.leftLeg.y =  (float)10.5;
                humanoidModel.leftLeg.z =  3;
                humanoidModel.leftLeg.xScale = (float)0.75; humanoidModel.leftLeg.yScale = (float)0.75; humanoidModel.leftLeg.zScale = (float)0.75;

                humanoidModel.rightLeg.yRot = (float) Math.toRadians(5);
                humanoidModel.rightLeg.x =  6;
                humanoidModel.rightLeg.y =  (float)14.5;
                humanoidModel.rightLeg.z =  -5;
                humanoidModel.rightLeg.xScale = (float)0.75; humanoidModel.rightLeg.yScale = (float)0.75; humanoidModel.rightLeg.zScale = (float)0.75;
            }
        });
    }

    private GenericHatStandModel getModelForBlock(BlockState state) {
        if (state.is(AudBlocks.HATSTAND_OAK.get())) return hatStandOak;
        if (state.is(AudBlocks.HATSTAND_SPRUCE.get())) return hatStandSpruce;
        if (state.is(AudBlocks.HATSTAND_BIRCH.get())) return hatStandBirch;
        if (state.is(AudBlocks.HATSTAND_JUNGLE.get())) return hatStandJungle;
        if (state.is(AudBlocks.HATSTAND_ACACIA.get())) return hatStandAcacia;
        if (state.is(AudBlocks.HATSTAND_DARK_OAK.get())) return hatStandDarkOak;
        if (state.is(AudBlocks.HATSTAND_MANGROVE.get())) return hatStandMangrove;
        if (state.is(AudBlocks.HATSTAND_CHERRY.get())) return hatStandCherry;
        if (state.is(AudBlocks.HATSTAND_PALE.get())) return hatStandPale;
        if (state.is(AudBlocks.HATSTAND_BAMBOO.get())) return hatStandBamboo;
        if (state.is(AudBlocks.HATSTAND_CRIMSON.get())) return hatStandCrimson;
        if (state.is(AudBlocks.HATSTAND_WARPED.get())) return hatStandWarped;

        return hatStandMain;
    }

    private ResourceLocation getTextureForBlock(BlockState state) {
        return HATSTAND_TEXTURES.get(state.getBlock());
    }


    @Override
    public void render(HatstandBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 1.5, 0.5D); // move to center of block

        BlockState state = blockEntity.getBlockState();

        BlockState blockState = blockEntity.getBlockState();
        poseStack.mulPose(Axis.ZP.rotationDegrees(180));
        poseStack.mulPose(Axis.YP.rotationDegrees(blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot()));
        hatStandMain = getModelForBlock(state);
        // Render hatstand model
        hatStandMain.renderToBuffer(poseStack, bufferSource.getBuffer(RenderType.entityTranslucent(Objects.requireNonNull(getTextureForBlock(state)))), packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);

        // Render items on the stand
        renderItems(blockEntity, poseStack, bufferSource, packedLight, packedOverlay);

        poseStack.popPose();
    }

    private void renderItems(HatstandBlockEntity blockEntity, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        var itemRenderer = Minecraft.getInstance().getItemRenderer();
        var entityModels = Minecraft.getInstance().getEntityModels();

        HumanoidModel<LivingEntity> innerModel =
                new HumanoidModel<>(entityModels.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR));

        HumanoidModel<LivingEntity> outerModel =
                new HumanoidModel<>(entityModels.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR));

        for (int i = 0; i < 4; i++) {
            ItemStack stack = blockEntity.getInventory().getItem(i);

            if (stack.isEmpty()) continue;

            poseStack.pushPose();

            hatStandMain.getPositioner().positionSlot(i, stack, poseStack);

            if (stack.getItem() instanceof ArmorItem armorItem) {

                EquipmentSlot slot = armorItem.getEquipmentSlot();
                HumanoidModel<LivingEntity> armorModel =
                        slot == EquipmentSlot.LEGS ? innerModel : outerModel;

                new HumanoidModel<>(entityModels.bakeLayer(ModelLayers.PLAYER))
                        .copyPropertiesTo(armorModel);

                armorModel.young = false;
                armorModel.setAllVisible(false);

                switch (slot) {
                    case HEAD -> {
                        armorModel.head.visible = true;
                        armorModel.hat.visible = true;
                    }
                    case CHEST -> {
                        armorModel.body.visible = true;
                        armorModel.leftArm.visible = true;
                        armorModel.rightArm.visible = true;
                    }
                    case LEGS -> {
                        armorModel.body.visible = true;
                        armorModel.leftLeg.visible = true;
                        armorModel.rightLeg.visible = true;
                    }
                    case FEET -> {
                        armorModel.leftLeg.visible = true;
                        armorModel.rightLeg.visible = true;
                    }
                }

                hatStandMain.getPositioner()
                        .animateArmor(i, stack, poseStack, armorModel);

                String layer = slot == EquipmentSlot.LEGS ? "2" : "1";

                ResourceLocation texture = new ResourceLocation(
                        "minecraft",
                        "textures/models/armor/"
                                + armorItem.getMaterial().getName()
                                + "_layer_" + layer + ".png"
                );

                if (armorItem.getMaterial() == ArmorMaterials.LEATHER && armorItem instanceof DyeableLeatherItem dyeableLeatherItem) {

                    int color = dyeableLeatherItem.getColor(stack);

                    float r = ((color >> 16) & 255) / 255.0F;
                    float g = ((color >> 8) & 255) / 255.0F;
                    float b = (color & 255) / 255.0F;

                    // dyed leather base
                    armorModel.renderToBuffer(
                            poseStack,
                            bufferSource.getBuffer(
                                    RenderType.armorCutoutNoCull(texture)
                            ),
                            packedLight,
                            packedOverlay,
                            r,
                            g,
                            b,
                            1.0F
                    );

                    // leather overlay (buttons/stitching)
                    ResourceLocation overlay = new ResourceLocation(
                            "minecraft",
                            "textures/models/armor/"
                                    + armorItem.getMaterial().getName()
                                    + "_layer_" + layer + "_overlay.png"
                    );

                    armorModel.renderToBuffer(
                            poseStack,
                            bufferSource.getBuffer(
                                    RenderType.armorCutoutNoCull(overlay)
                            ),
                            packedLight,
                            packedOverlay,
                            1.0F,
                            1.0F,
                            1.0F,
                            1.0F
                    );

                } else {

                    armorModel.renderToBuffer(
                            poseStack,
                            bufferSource.getBuffer(
                                    RenderType.armorCutoutNoCull(texture)
                            ),
                            packedLight,
                            packedOverlay,
                            1.0F,
                            1.0F,
                            1.0F,
                            1.0F
                    );
                }

            } else {

                poseStack.mulPose(Axis.XP.rotationDegrees(180));

                itemRenderer.renderStatic(
                        stack,
                        i == 0 ? ItemDisplayContext.HEAD : ItemDisplayContext.GROUND,
                        packedLight,
                        packedOverlay,
                        poseStack,
                        bufferSource,
                        blockEntity.getLevel(),
                        i
                );
            }

            poseStack.popPose();
        }
    }




    @Override
    public BlockEntityRenderer<HatstandBlockEntity> create(Context context) {
        return new RenderHatStand(context);
    }
}
