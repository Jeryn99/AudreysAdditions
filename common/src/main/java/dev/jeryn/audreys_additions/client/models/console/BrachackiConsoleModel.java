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

public class BrachackiConsoleModel extends HierarchicalModel implements ConsoleUnit {

    public static final AnimationDefinition IDLE = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/brachacki/idle.json"));
    public static final AnimationDefinition FLIGHT = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/brachacki/flight.json"));
    public static final AnimationDefinition CRASH = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/brachacki/crash.json"));
    public static final AnimationDefinition POWER_ON = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/brachacki/power_on.json"));
    public static final AnimationDefinition POWER_OFF = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/brachacki/power_off.json"));

    private final ModelPart root;
    private final ModelPart MainLever1;
    private final ModelPart MainLever2;
    private final ModelPart RadNeedle;
    private final ModelPart Needle1;
    private final ModelPart Needle2;

    public BrachackiConsoleModel(ModelPart root) {
        this.root = root;
        this.MainLever1 = Frame.findPart(this, "MainLever1");
        this.MainLever2 = Frame.findPart(this, "MainLever2");
        this.RadNeedle = Frame.findPart(this, "RadNeedle");
        this.Needle1 = Frame.findPart(this, "Needle1");
        this.Needle2 = Frame.findPart(this, "Needle2");
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

            float progress = Mth.clamp(reactions.getJourneyProgress(), 0.0F, 100.0F);
            float intermediary = (float)reactions.getFuel()/1000;
            float fyool = Mth.clamp(intermediary*160 -80,-80,80);

            if(reactions.getThrottleStage() == 0){
              this.MainLever1.xRot = (float) Math.toRadians(30);
            }
            if(reactions.getThrottleStage() == 1){
                this.MainLever1.xRot = (float) Math.toRadians(20);
            }
            if(reactions.getThrottleStage() == 2){
                this.MainLever1.xRot = (float) Math.toRadians(10);
            }
            if(reactions.getThrottleStage() == 3){
                this.MainLever1.xRot = (float) Math.toRadians(-10);
            }
            if(reactions.getThrottleStage() == 4){
                this.MainLever1.xRot = (float) Math.toRadians(-20);
            }
            if(reactions.getThrottleStage() == 5){
                this.MainLever1.xRot = (float) Math.toRadians(-30);
            }

            this.MainLever2.xRot = (float) Math.toRadians(reactions.isHandbrakeEngaged() ? -30 : 30);
            this.RadNeedle.zRot = (float) Math.toRadians(fyool);

            this.Needle1.yRot = (float) Math.toRadians(-80.0F + (progress * 160.0F / 100.0F));
            this.Needle2.yRot = (float) Math.toRadians(-80.0F + (progress * 160.0F / 100.0F));
        }
        // Final render call
        root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }


    @Override
    public ResourceLocation getDefaultTexture() {
        return new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/brachacki/brachacki.png");
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {

    }
}
