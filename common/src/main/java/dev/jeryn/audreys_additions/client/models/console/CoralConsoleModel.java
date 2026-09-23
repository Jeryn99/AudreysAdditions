package dev.jeryn.audreys_additions.client.models.console;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.frame.tardis.Frame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import whocraft.tardis_refined.TRConfig;
import whocraft.tardis_refined.client.TardisClientData;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleUnit;
import whocraft.tardis_refined.common.block.console.GlobalConsoleBlock;
import whocraft.tardis_refined.common.blockentity.console.GlobalConsoleBlockEntity;

public class CoralConsoleModel extends HierarchicalModel implements ConsoleUnit {

    public static final AnimationDefinition IDLE = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/coral/idle.json"));
    public static final AnimationDefinition FLIGHT = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/coral/flight.json"));
    public static final AnimationDefinition CRASH = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/coral/crash.json"));
    public static final AnimationDefinition POWER_ON = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/coral/power_on.json"));
    public static final AnimationDefinition POWER_OFF = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/coral/power_off.json"));

    private final ModelPart root;
    private final ModelPart Throttle;
    private final ModelPart ScopeyArm;
    private final ModelPart Pumper2;
    private final ModelPart Lever1;
    private final ModelPart Lever2;
    private final ModelPart Lever3;
    private final ModelPart Lever4;
    private final ModelPart Handley;

    public CoralConsoleModel(ModelPart root) {
        this.root = root;
        this.Throttle = Frame.findPart(this, "Throttle");
        this.ScopeyArm = Frame.findPart(this, "ScopeyArm");
        this.Pumper2 = Frame.findPart(this, "Pumper2");
        this.Lever1 = Frame.findPart(this, "Lever1");
        this.Lever2 = Frame.findPart(this, "Lever2");
        this.Lever3 = Frame.findPart(this, "Lever3");
        this.Lever4 = Frame.findPart(this, "Lever4");
        this.Handley = Frame.findPart(this, "Handley");
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

            float progress = (float) (-45+0.9*Mth.clamp(reactions.getJourneyProgress(), 0.0F, 100.0F));
            float intermediary = (float)reactions.getFuel()/1000;
            float fyool = (float) Mth.clamp(intermediary*-5,-5,0);

            if(reactions.getThrottleStage() == 0){
                this.Throttle.zRot = (float) Math.toRadians(-30);
            }
            if(reactions.getThrottleStage() == 1){
                this.Throttle.zRot = (float) Math.toRadians(-10);
            }
            if(reactions.getThrottleStage() == 2){
                this.Throttle.zRot = (float) Math.toRadians(10);
            }
            if(reactions.getThrottleStage() == 3){
                this.Throttle.zRot = (float) Math.toRadians(30);
            }
            if(reactions.getThrottleStage() == 4){
                this.Throttle.zRot = (float) Math.toRadians(50);
            }
            if(reactions.getThrottleStage() == 5){
                this.Throttle.zRot = (float) Math.toRadians(70);
            }

            this.Lever1.zRot = (float) Math.toRadians(reactions.isHandbrakeEngaged() ? -90 : -45);
            this.Lever2.zRot = (float) Math.toRadians(reactions.isHandbrakeEngaged() ? -135 : -5);
            this.Lever3.zRot = (float) Math.toRadians(reactions.isHandbrakeEngaged() ? 90 : 45);
            this.Lever4.zRot = (float) Math.toRadians(reactions.isHandbrakeEngaged() ? 135 : 5);

            this.Handley.zRot = (float) Math.toRadians(reactions.isHandbrakeEngaged() ? -120 : -5);

            this.Pumper2.y = (fyool-5);

            this.ScopeyArm.yRot = (float) Math.toRadians(progress);
        }


        // Final render call
        root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }


    @Override
    public ResourceLocation getDefaultTexture() {
        return new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/coral/coral.png");
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {

    }
}
