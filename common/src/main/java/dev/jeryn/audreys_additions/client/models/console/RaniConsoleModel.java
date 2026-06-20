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

public class RaniConsoleModel extends HierarchicalModel implements ConsoleUnit {

    public static final AnimationDefinition IDLE = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/rani/idle.json"));
    public static final AnimationDefinition FLIGHT = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/rani/flight.json"));
    public static final AnimationDefinition CRASH = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/rani/crash.json"));
    public static final AnimationDefinition POWER_ON = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/rani/power_on.json"));
    public static final AnimationDefinition POWER_OFF = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/rani/power_off.json"));

    private final ModelPart root;
    private final ModelPart ThrottlePop;
    private final ModelPart HandPop;

    public RaniConsoleModel(ModelPart root) {
        this.root = root;
        this.ThrottlePop = Frame.findPart(this, "ThrottlePop");
        this.HandPop = Frame.findPart(this, "HandPop");
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

        if(reactions.getThrottleStage() == 0){
            this.ThrottlePop.xRot = (float) Math.toRadians(0);
        }
        if(reactions.getThrottleStage() == 1){
            this.ThrottlePop.xRot = (float) Math.toRadians(10);
        }
        if(reactions.getThrottleStage() == 2){
            this.ThrottlePop.xRot = (float) Math.toRadians(20);
        }
        if(reactions.getThrottleStage() == 3){
            this.ThrottlePop.xRot = (float) Math.toRadians(30);
        }
        if(reactions.getThrottleStage() == 4){
            this.ThrottlePop.xRot = (float) Math.toRadians(40);
        }
        if(reactions.getThrottleStage() == 5){
            this.ThrottlePop.xRot = (float) Math.toRadians(50);
        }

        this.HandPop.xRot = (float) Math.toRadians(reactions.isHandbrakeEngaged() ? 0 : 50);

        // Final render call
        root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }


    @Override
    public ResourceLocation getDefaultTexture() {
        return new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/rani/rani.png");
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {

    }
}
