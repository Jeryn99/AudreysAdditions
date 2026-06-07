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
import whocraft.tardis_refined.common.tardis.manager.TardisPilotingManager;

public class ToyotaConsoleModel extends HierarchicalModel implements ConsoleUnit {

    public static final AnimationDefinition IDLE = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/toyota/idle.json"));
    public static final AnimationDefinition FLIGHT = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/toyota/flight.json"));
    public static final AnimationDefinition CRASH = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/toyota/crash.json"));
    public static final AnimationDefinition POWER_ON = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/toyota/power_on.json"));
    public static final AnimationDefinition POWER_OFF = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/toyota/power_off.json"));

    private final ModelPart root;
    private final ModelPart Throttle;
    private final ModelPart Handbrake;
    private final ModelPart HandbrakeLights;
    private final ModelPart Slider1;
    private final ModelPart Slider2;
    private final ModelPart Slider3;
    private final ModelPart Slider4;
    private final ModelPart Panel1Lever1;
    private final ModelPart Panel1Lever2;
    private final ModelPart Panel1Lever3;
    private final ModelPart Panel1Lever4;

    public ToyotaConsoleModel(ModelPart root) {
        this.root = root;
        this.Throttle = Frame.findPart(this, "Throttle");
        this.Handbrake = Frame.findPart(this, "Handbrake");
        this.HandbrakeLights = Frame.findPart(this, "HandbrakeLights");
        this.Slider1 = Frame.findPart(this, "Slider1");
        this.Slider2 = Frame.findPart(this, "Slider2");
        this.Slider3 = Frame.findPart(this, "Slider3");
        this.Slider4 = Frame.findPart(this, "Slider4");
        this.Panel1Lever1 = Frame.findPart(this, "Panel1Lever1");
        this.Panel1Lever2 = Frame.findPart(this, "Panel1Lever2");
        this.Panel1Lever3 = Frame.findPart(this, "Panel1Lever3");
        this.Panel1Lever4 = Frame.findPart(this, "Panel1Lever4");
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

        double fuelDouble = reactions.getFuel();
        float fuelAmount = (float) fuelDouble ;

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
        }

        float progress = Mth.clamp(reactions.getJourneyProgress(), 0.0F, 100.0F);
        float intermediary = (float)reactions.getFuel()/1000;
        float fyool = Mth.clamp(intermediary*2 +6.5f,6.5f,8.5f);

        if(reactions.getThrottleStage() == 0){
            this.Throttle.xRot = (float) Math.toRadians(-60);
        }
        if(reactions.getThrottleStage() == 1){
            this.Throttle.xRot = (float) Math.toRadians(-35);
        }
        if(reactions.getThrottleStage() == 2){
            this.Throttle.xRot = (float) Math.toRadians(-15);
        }
        if(reactions.getThrottleStage() == 3){
            this.Throttle.xRot = (float) Math.toRadians(15);
        }
        if(reactions.getThrottleStage() == 4){
            this.Throttle.xRot = (float) Math.toRadians(35);
        }
        if(reactions.getThrottleStage() == 5){
            this.Throttle.xRot = (float) Math.toRadians(60);
        }

        this.Handbrake.yRot = (float) Math.toRadians(reactions.isHandbrakeEngaged() ? -45 : 135);
        this.HandbrakeLights.xScale = (float) (reactions.isHandbrakeEngaged() ? 1 : 0 );
        this.HandbrakeLights.yScale = (float) (reactions.isHandbrakeEngaged() ? 1 : 0 );
        this.HandbrakeLights.zScale = (float) (reactions.isHandbrakeEngaged() ? 1 : 0 );

        this.Slider1.z = (float)(fyool);
        this.Slider2.z = (float)(fyool);
        this.Slider3.z = (float)(fyool);
        this.Slider4.z = (float)(fyool);

        this.Panel1Lever1.xRot = (float) Math.toRadians(progress*-1 / 2);
        this.Panel1Lever2.xRot = (float) Math.toRadians(progress*-1 / 2+2);
        this.Panel1Lever3.xRot = (float) Math.toRadians(progress*-1 / 2);
        this.Panel1Lever4.xRot = (float) Math.toRadians(progress*-1 / 2+4);

        // Final render call
        root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }


    @Override
    public ResourceLocation getDefaultTexture() {
        return new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/toyota/toyota.png");
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {

    }
}
