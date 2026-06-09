package dev.jeryn.audreys_additions.client.models.console;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import dev.jeryn.audreys_additions.AUDModelRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.CatVariantHolder;
import dev.jeryn.frame.tardis.Frame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraft.world.level.Level;
import whocraft.tardis_refined.TRConfig;
import whocraft.tardis_refined.client.TardisClientData;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleUnit;
import whocraft.tardis_refined.common.block.console.GlobalConsoleBlock;
import whocraft.tardis_refined.common.blockentity.console.GlobalConsoleBlockEntity;

public class HumanNatureConsoleModel extends HierarchicalModel implements ConsoleUnit {

    public static final AnimationDefinition IDLE = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/human_nature/idle.json"));
    public static final AnimationDefinition FLIGHT = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/human_nature/flight.json"));
    public static final AnimationDefinition CRASH = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/human_nature/crash.json"));
    public static final AnimationDefinition POWER_ON = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/human_nature/power_on.json"));
    public static final AnimationDefinition POWER_OFF = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/human_nature/power_off.json"));

    private final ModelPart root;
    private final ModelPart BrakeAngler;
    private final ModelPart RoofSlider;
    private final ModelPart RoofLight1;
    private final ModelPart RoofLight2;
    private final ModelPart RoofLight3;
    private final ModelPart RoofLight4;
    private final ModelPart LightAngler;
    private final ModelPart GlowLeft;
    private final ModelPart GlowRight;


    public HumanNatureConsoleModel(ModelPart root) {
        this.root = root;
        this.BrakeAngler = Frame.findPart(this, "BrakeAngler");
        this.RoofSlider = Frame.findPart(this, "RoofSlider");
        this.RoofLight1 = Frame.findPart(this, "RoofLight1");
        this.RoofLight2 = Frame.findPart(this, "RoofLight2");
        this.RoofLight3 = Frame.findPart(this, "RoofLight3");
        this.RoofLight4 = Frame.findPart(this, "RoofLight4");
        this.LightAngler = Frame.findPart(this, "LightAngler");
        this.GlowLeft = Frame.findPart(this, "GlowLeft");
        this.GlowRight = Frame.findPart(this, "GlowRight");
    }

    public static void renderConsoleCat(GlobalConsoleBlockEntity blockEntity, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        if (blockEntity == null ||
                AUDModelRegistry.cat == null ||
                !blockEntity.theme().getPath().contains("human_nature") ||
                blockEntity.pattern().id().getPath().contains("no_cat")) {
            return;
        }

        ResourceLocation catLocation = ((CatVariantHolder) blockEntity).getCatVariant();
        if (catLocation == null || !BuiltInRegistries.CAT_VARIANT.containsKey(catLocation)) {
            catLocation = CatVariant.ALL_BLACK.location();
        }

        CatVariant catVariant = BuiltInRegistries.CAT_VARIANT.get(catLocation);
        if (catVariant == null) return;

        poseStack.pushPose();

        Minecraft mc = Minecraft.getInstance();
        MultiBufferSource.BufferSource isolatedBuffer = mc.renderBuffers().bufferSource();

        RenderType renderType = RenderType.entityCutoutNoCull(catVariant.texture());

        AUDModelRegistry.cat.renderCat(
                blockEntity,
                blockEntity.getLevel(),
                poseStack,
                isolatedBuffer.getBuffer(renderType),
                packedLight,
                packedOverlay,
                1f, 1f, 1f, 1f
        );

        poseStack.popPose();
        isolatedBuffer.endBatch(renderType);
    }



    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root().getAllParts().forEach(ModelPart::resetPose);
        root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void renderConsole(GlobalConsoleBlockEntity globalConsoleBlock, Level level, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root().getAllParts().forEach(ModelPart::resetPose);

        boolean powered = globalConsoleBlock == null || globalConsoleBlock.getBlockState().getValue(GlobalConsoleBlock.POWERED);

        // Store tick count for later use
        int playerTicks = Minecraft.getInstance().player.tickCount;
        float tickCount = playerTicks + Minecraft.getInstance().getFrameTime();

        TardisClientData reactions = TardisClientData.getInstance(level.dimension());
        if (globalConsoleBlock != null) {

            double fuelDouble = reactions.getFuel();
            float fuelAmount = (float) fuelDouble ;

            // Booting logic
            if (powered) {
                if (globalConsoleBlock.getTicksBooting() > 0) {
                    globalConsoleBlock.powerOff.stop();
                    globalConsoleBlock.powerOn.startIfStopped((int) tickCount);

                    root().getAllParts().forEach(ModelPart::resetPose);
                    this.animate(globalConsoleBlock.powerOn, POWER_ON, tickCount);
                } else {
                    globalConsoleBlock.powerOff.stop();
                }

                if (reactions.isFlying()) {
                    root().getAllParts().forEach(ModelPart::resetPose);
                    this.animate(reactions.ROTOR_ANIMATION, FLIGHT, tickCount);
                } else if (reactions.isCrashing()) {
                    root().getAllParts().forEach(ModelPart::resetPose);
                    this.animate(reactions.CRASHING_ANIMATION, CRASH, tickCount);
                } else {
                    if (TRConfig.CLIENT.PLAY_CONSOLE_IDLE_ANIMATIONS.get() && globalConsoleBlock.getTicksBooting() == 0) {
                        root().getAllParts().forEach(ModelPart::resetPose);
                        this.animate(globalConsoleBlock.liveliness, IDLE, tickCount);
                    }
                }

            } else {
                // Power off animation if not booting
                if (!globalConsoleBlock.powerOff.isStarted()) {
                    globalConsoleBlock.powerOn.stop();
                    globalConsoleBlock.powerOff.start((int) tickCount);
                }
                root().getAllParts().forEach(ModelPart::resetPose);
                this.animate(globalConsoleBlock.powerOff, POWER_OFF, tickCount);
            }
        }

        float intermediary = (float)reactions.getFuel()/1000;

        float rotty = intermediary*-25;

        if(reactions.getThrottleStage() == 0){
            this.RoofSlider.zRot = (float) Math.toRadians(-40);
            this.RoofLight1.xScale = 0;
            this.RoofLight1.zScale = 0;
            this.RoofLight2.xScale = 0;
            this.RoofLight2.zScale = 0;
            this.RoofLight3.xScale = 0;
            this.RoofLight3.zScale = 0;
            this.RoofLight4.xScale = 0;
            this.RoofLight4.zScale = 0;
        }
        if(reactions.getThrottleStage() == 1){
            this.RoofSlider.zRot = (float) Math.toRadians(-25);
            this.RoofLight1.xScale = 1;
            this.RoofLight1.zScale = 1;
            this.RoofLight2.xScale = 0;
            this.RoofLight2.zScale = 0;
            this.RoofLight3.xScale = 0;
            this.RoofLight3.zScale = 0;
            this.RoofLight4.xScale = 0;
            this.RoofLight4.zScale = 0;
        }
        if(reactions.getThrottleStage() == 2){
            this.RoofSlider.zRot = (float) Math.toRadians(-10);
            this.RoofLight1.xScale = 1;
            this.RoofLight1.zScale = 1;
            this.RoofLight2.xScale = 1;
            this.RoofLight2.zScale = 1;
            this.RoofLight3.xScale = 0;
            this.RoofLight3.zScale = 0;
            this.RoofLight4.xScale = 0;
            this.RoofLight4.zScale = 0;
        }
        if(reactions.getThrottleStage() == 3){
            this.RoofSlider.zRot = (float) Math.toRadians(10);
            this.RoofLight1.xScale = 1;
            this.RoofLight1.zScale = 1;
            this.RoofLight2.xScale = 1;
            this.RoofLight2.zScale = 1;
            this.RoofLight3.xScale = 1;
            this.RoofLight3.zScale = 1;
            this.RoofLight4.xScale = 0;
            this.RoofLight4.zScale = 0;
        }
        if(reactions.getThrottleStage() == 4){
            this.RoofSlider.zRot = (float) Math.toRadians(25);
            this.RoofLight1.xScale = 1;
            this.RoofLight1.zScale = 1;
            this.RoofLight2.xScale = 1;
            this.RoofLight2.zScale = 1;
            this.RoofLight3.xScale = 1;
            this.RoofLight3.zScale = 1;
            this.RoofLight4.xScale = 1;
            this.RoofLight4.zScale = 1;
        }
        if(reactions.getThrottleStage() == 5){
            this.RoofSlider.zRot = (float) Math.toRadians(40);
            this.RoofLight1.xScale = 1;
            this.RoofLight1.zScale = 1;
            this.RoofLight2.xScale = 1;
            this.RoofLight2.zScale = 1;
            this.RoofLight3.xScale = 1;
            this.RoofLight3.zScale = 1;
            this.RoofLight4.xScale = 1;
            this.RoofLight4.zScale = 1;
        }

        this.BrakeAngler.xRot = (float) Math.toRadians(reactions.isHandbrakeEngaged() ? 30 : -30);

        this.LightAngler.xRot = (float) Math.toRadians(rotty-1);
        this.GlowLeft.xScale = intermediary;
        this.GlowLeft.yScale = intermediary;
        this.GlowRight.xScale = intermediary;
        this.GlowRight.yScale = intermediary;

        // Final render call
        root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        renderConsoleCat(globalConsoleBlock, poseStack, Minecraft.getInstance().renderBuffers().bufferSource(), 0xF000F0, packedOverlay);

    }


    @Override
    public ResourceLocation getDefaultTexture() {
        return new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/human_nature/human_nature.png");
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {

    }
}
