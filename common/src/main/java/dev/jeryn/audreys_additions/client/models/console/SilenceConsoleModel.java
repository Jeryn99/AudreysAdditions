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

public class SilenceConsoleModel extends HierarchicalModel implements ConsoleUnit {

    public static final AnimationDefinition IDLE = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/silence/idle.json"));
    public static final AnimationDefinition FLIGHT = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/silence/flight.json"));
    public static final AnimationDefinition CRASH = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/silence/crash.json"));
    public static final AnimationDefinition POWER_ON = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/silence/power_on.json"));
    public static final AnimationDefinition POWER_OFF = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/silence/power_off.json"));

    private final ModelPart root;
    private final ModelPart Lightning;
    private final ModelPart L1S1;
    private final ModelPart L1S2;
    private final ModelPart L1S3;
    private final ModelPart L2S1;
    private final ModelPart L2S2;
    private final ModelPart L2S3;
    private final ModelPart L3S1;
    private final ModelPart L3S2;
    private final ModelPart L3S3;
    private final ModelPart FuelThingy;

    public SilenceConsoleModel(ModelPart root) {
        this.root = root;
        this.Lightning = Frame.findPart(this, "Lightning");
        this.L1S1 = Frame.findPart(this, "L1S1");
        this.L1S2 = Frame.findPart(this, "L1S2");
        this.L1S3 = Frame.findPart(this, "L1S3");
        this.L2S1 = Frame.findPart(this, "L2S1");
        this.L2S2 = Frame.findPart(this, "L2S2");
        this.L2S3 = Frame.findPart(this, "L2S3");
        this.L3S1 = Frame.findPart(this, "L3S1");
        this.L3S2 = Frame.findPart(this, "L3S2");
        this.L3S3 = Frame.findPart(this, "L3S3");
        this.FuelThingy = Frame.findPart(this, "FuelThingy");
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

        if(reactions.getThrottleStage() == 0){
            this.Lightning.xScale = 0;
            this.Lightning.yScale = 0;
            this.Lightning.zScale = 0;
        }
        if(reactions.getThrottleStage() == 1){
            this.Lightning.xScale = 0.75f;
            this.Lightning.yScale = 0.75f;
            this.Lightning.zScale = 0.75f;

            this.L1S1.xScale = 1;
            this.L1S1.yScale = 1;
            this.L1S1.zScale = 1;

            this.L1S2.xScale = 0;
            this.L1S2.yScale = 0;
            this.L1S2.zScale = 0;

            this.L1S3.xScale = 0;
            this.L1S3.yScale = 0;
            this.L1S3.zScale = 0;

            this.L2S1.xScale = 1;
            this.L2S1.yScale = 1;
            this.L2S1.zScale = 1;

            this.L2S2.xScale = 0;
            this.L2S2.yScale = 0;
            this.L2S2.zScale = 0;

            this.L2S3.xScale = 0;
            this.L2S3.yScale = 0;
            this.L2S3.zScale = 0;

            this.L3S1.xScale = 1;
            this.L3S1.yScale = 1;
            this.L3S1.zScale = 1;

            this.L3S2.xScale = 0;
            this.L3S2.yScale = 0;
            this.L3S2.zScale = 0;

            this.L3S3.xScale = 0;
            this.L3S3.yScale = 0;
            this.L3S3.zScale = 0;
        }
        if(reactions.getThrottleStage() == 2){
            this.Lightning.xScale = 1;
            this.Lightning.yScale = 1;
            this.Lightning.zScale = 1;

            this.L1S1.xScale = 1;
            this.L1S1.yScale = 1;
            this.L1S1.zScale = 1;

            this.L1S2.xScale = 0;
            this.L1S2.yScale = 0;
            this.L1S2.zScale = 0;

            this.L1S3.xScale = 0;
            this.L1S3.yScale = 0;
            this.L1S3.zScale = 0;

            this.L2S1.xScale = 1;
            this.L2S1.yScale = 1;
            this.L2S1.zScale = 1;

            this.L2S2.xScale = 0;
            this.L2S2.yScale = 0;
            this.L2S2.zScale = 0;

            this.L2S3.xScale = 0;
            this.L2S3.yScale = 0;
            this.L2S3.zScale = 0;

            this.L3S1.xScale = 1;
            this.L3S1.yScale = 1;
            this.L3S1.zScale = 1;

            this.L3S2.xScale = 0;
            this.L3S2.yScale = 0;
            this.L3S2.zScale = 0;

            this.L3S3.xScale = 0;
            this.L3S3.yScale = 0;
            this.L3S3.zScale = 0;
        }
        if(reactions.getThrottleStage() == 3){
            this.Lightning.xScale = 0.75f;
            this.Lightning.yScale = 0.75f;
            this.Lightning.zScale = 0.75f;

            this.L1S1.xScale = 0;
            this.L1S1.yScale = 0;
            this.L1S1.zScale = 0;

            this.L1S2.xScale = 1;
            this.L1S2.yScale = 1;
            this.L1S2.zScale = 1;

            this.L1S3.xScale = 0;
            this.L1S3.yScale = 0;
            this.L1S3.zScale = 0;

            this.L2S1.xScale = 0;
            this.L2S1.yScale = 0;
            this.L2S1.zScale = 0;

            this.L2S2.xScale = 1;
            this.L2S2.yScale = 1;
            this.L2S2.zScale = 1;

            this.L2S3.xScale = 0;
            this.L2S3.yScale = 0;
            this.L2S3.zScale = 0;

            this.L3S1.xScale = 0;
            this.L3S1.yScale = 0;
            this.L3S1.zScale = 0;

            this.L3S2.xScale = 1;
            this.L3S2.yScale = 1;
            this.L3S2.zScale = 1;

            this.L3S3.xScale = 0;
            this.L3S3.yScale = 0;
            this.L3S3.zScale = 0;
        }
        if(reactions.getThrottleStage() == 4){
            this.Lightning.xScale = 1;
            this.Lightning.yScale = 1;
            this.Lightning.zScale = 1;

            this.L1S1.xScale = 0;
            this.L1S1.yScale = 0;
            this.L1S1.zScale = 0;

            this.L1S2.xScale = 1;
            this.L1S2.yScale = 1;
            this.L1S2.zScale = 1;

            this.L1S3.xScale = 0;
            this.L1S3.yScale = 0;
            this.L1S3.zScale = 0;

            this.L2S1.xScale = 0;
            this.L2S1.yScale = 0;
            this.L2S1.zScale = 0;

            this.L2S2.xScale = 1;
            this.L2S2.yScale = 1;
            this.L2S2.zScale = 1;

            this.L2S3.xScale = 0;
            this.L2S3.yScale = 0;
            this.L2S3.zScale = 0;

            this.L3S1.xScale = 0;
            this.L3S1.yScale = 0;
            this.L3S1.zScale = 0;

            this.L3S2.xScale = 1;
            this.L3S2.yScale = 1;
            this.L3S2.zScale = 1;

            this.L3S3.xScale = 0;
            this.L3S3.yScale = 0;
            this.L3S3.zScale = 0;
        }
        if(reactions.getThrottleStage() == 5){
            this.Lightning.xScale = 1;
            this.Lightning.yScale = 1;
            this.Lightning.zScale = 1;

            this.L1S1.xScale = 0;
            this.L1S1.yScale = 0;
            this.L1S1.zScale = 0;

            this.L1S2.xScale = 0;
            this.L1S2.yScale = 0;
            this.L1S2.zScale = 0;

            this.L1S3.xScale = 1;
            this.L1S3.yScale = 1;
            this.L1S3.zScale = 1;

            this.L2S1.xScale = 0;
            this.L2S1.yScale = 0;
            this.L2S1.zScale = 0;

            this.L2S2.xScale = 0;
            this.L2S2.yScale = 0;
            this.L2S2.zScale = 0;

            this.L2S3.xScale = 1;
            this.L2S3.yScale = 1;
            this.L2S3.zScale = 1;

            this.L3S1.xScale = 0;
            this.L3S1.yScale = 0;
            this.L3S1.zScale = 0;

            this.L3S2.xScale = 0;
            this.L3S2.yScale = 0;
            this.L3S2.zScale = 0;

            this.L3S3.xScale = 1;
            this.L3S3.yScale = 1;
            this.L3S3.zScale = 1;
        }
        this.FuelThingy.xScale = (intermediary);
        this.FuelThingy.yScale = (intermediary);

        // Final render call
        root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }


    @Override
    public ResourceLocation getDefaultTexture() {
        return new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/silence/silence.png");
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {

    }
}
