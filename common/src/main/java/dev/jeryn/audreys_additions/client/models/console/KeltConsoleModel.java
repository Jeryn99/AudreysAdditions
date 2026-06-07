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

public class KeltConsoleModel extends HierarchicalModel implements ConsoleUnit {

    public static final AnimationDefinition IDLE = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/kelt/idle.json"));
    public static final AnimationDefinition FLIGHT = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/kelt/flight.json"));
    public static final AnimationDefinition CRASH = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/kelt/crash.json"));
    public static final AnimationDefinition POWER_ON = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/kelt/power_on.json"));
    public static final AnimationDefinition POWER_OFF = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/kelt/power_off.json"));

    private final ModelPart root;
    private final ModelPart Slider1;
    private final ModelPart Slider4;
    private final ModelPart Slider5;

    private final ModelPart Flasher1;
    private final ModelPart Flasher2;
    private final ModelPart Flasher3;
    private final ModelPart Flasher4;
    private final ModelPart Flasher5;
    private final ModelPart Flasher6;
    private final ModelPart Flasher7;
    private final ModelPart Flasher8;
    private final ModelPart Flasher9;


    public KeltConsoleModel(ModelPart root) {
        this.root = root;
        this.Slider1 = Frame.findPart(this, "Slider1");
        this.Slider4 = Frame.findPart(this, "Slider4");
        this.Slider5 = Frame.findPart(this, "Slider5");

        this.Flasher1 = Frame.findPart(this, "Flasher1");
        this.Flasher2 = Frame.findPart(this, "Flasher2");
        this.Flasher3 = Frame.findPart(this, "Flasher3");
        this.Flasher4 = Frame.findPart(this, "Flasher4");
        this.Flasher5 = Frame.findPart(this, "Flasher5");
        this.Flasher6 = Frame.findPart(this, "Flasher6");
        this.Flasher7 = Frame.findPart(this, "Flasher7");
        this.Flasher8 = Frame.findPart(this, "Flasher8");
        this.Flasher9 = Frame.findPart(this, "Flasher9");

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

        this.Flasher1.zScale = 0;
        this.Flasher2.zScale = 0;
        this.Flasher3.zScale = 0;
        this.Flasher4.zScale = 0;
        this.Flasher5.zScale = 0;
        this.Flasher6.zScale = 0;
        this.Flasher7.zScale = 0;
        this.Flasher8.zScale = 0;
        this.Flasher9.zScale = 0;

        float progress = Mth.clamp(reactions.getJourneyProgress(), 0.0F, 100.0F);
        float flee = (reactions.getJourneyProgress()*0.01f);

        float intermediary = (float)reactions.getFuel()/1000;

        if(reactions.getThrottleStage() == 0){
            this.Slider1.z = (float)0;
        }
        if(reactions.getThrottleStage() == 1){
            this.Slider1.z = (float)0.5;
        }
        if(reactions.getThrottleStage() == 2){
            this.Slider1.z = (float)1;
        }
        if(reactions.getThrottleStage() == 3){
            this.Slider1.z = (float)1.5;
        }
        if(reactions.getThrottleStage() == 4){
            this.Slider1.z = (float)2;
        }
        if(reactions.getThrottleStage() == 5){
            this.Slider1.z = (float)2.5;
        }

        this.Slider5.z = (reactions.isHandbrakeEngaged()) ? 2.5f : 0.5f;

        if (reactions.getFuel()/100 < 0.2f) {
            this.Flasher1.zScale = 0;
            this.Flasher2.zScale = 0;
            this.Flasher3.zScale = 0;
            this.Flasher4.zScale = 0;
            this.Flasher5.zScale = 0;
            this.Flasher6.zScale = 0;
            this.Flasher7.zScale = 0;
            this.Flasher8.zScale = 0;
            this.Flasher9.zScale = 0;
        }
        if (reactions.getFuel()/100 >= 1.1f) {
            this.Flasher1.zScale = 1;
            this.Flasher2.zScale = 0;
            this.Flasher3.zScale = 0;
            this.Flasher4.zScale = 0;
            this.Flasher5.zScale = 0;
            this.Flasher6.zScale = 0;
            this.Flasher7.zScale = 0;
            this.Flasher8.zScale = 0;
            this.Flasher9.zScale = 0;
        }
        if (reactions.getFuel()/100 >= 2.21f) {
            this.Flasher1.zScale = 1;
            this.Flasher2.zScale = 1;
            this.Flasher3.zScale = 0;
            this.Flasher4.zScale = 0;
            this.Flasher5.zScale = 0;
            this.Flasher6.zScale = 0;
            this.Flasher7.zScale = 0;
            this.Flasher8.zScale = 0;
            this.Flasher9.zScale = 0;
        }
        if (reactions.getFuel()/100 >= 3.3f) {
            this.Flasher1.zScale = 1;
            this.Flasher2.zScale = 1;
            this.Flasher3.zScale = 1;
            this.Flasher4.zScale = 0;
            this.Flasher5.zScale = 0;
            this.Flasher6.zScale = 0;
            this.Flasher7.zScale = 0;
            this.Flasher8.zScale = 0;
            this.Flasher9.zScale = 0;
        }
        if (reactions.getFuel()/100 >= 4.4f) {
            this.Flasher1.zScale = 1;
            this.Flasher2.zScale = 1;
            this.Flasher3.zScale = 1;
            this.Flasher4.zScale = 1;
            this.Flasher5.zScale = 0;
            this.Flasher6.zScale = 0;
            this.Flasher7.zScale = 0;
            this.Flasher8.zScale = 0;
            this.Flasher9.zScale = 0;
        }
        if (reactions.getFuel()/100 >= 5.5f) {
            this.Flasher1.zScale = 1;
            this.Flasher2.zScale = 1;
            this.Flasher3.zScale = 1;
            this.Flasher4.zScale = 1;
            this.Flasher5.zScale = 1;
            this.Flasher6.zScale = 0;
            this.Flasher7.zScale = 0;
            this.Flasher8.zScale = 0;
            this.Flasher9.zScale = 0;
        }
        if (reactions.getFuel()/100 >= 6.6f) {
            this.Flasher1.zScale = 1;
            this.Flasher2.zScale = 1;
            this.Flasher3.zScale = 1;
            this.Flasher4.zScale = 1;
            this.Flasher5.zScale = 1;
            this.Flasher6.zScale = 1;
            this.Flasher7.zScale = 0;
            this.Flasher8.zScale = 0;
            this.Flasher9.zScale = 0;
        }
        if (reactions.getFuel()/100 >= 7.7f) {
            this.Flasher1.zScale = 1;
            this.Flasher2.zScale = 1;
            this.Flasher3.zScale = 1;
            this.Flasher4.zScale = 1;
            this.Flasher5.zScale = 1;
            this.Flasher6.zScale = 1;
            this.Flasher7.zScale = 1;
            this.Flasher8.zScale = 0;
            this.Flasher9.zScale = 0;
        }
        if (reactions.getFuel()/100 >= 8.8f) {
            this.Flasher1.zScale = 1;
            this.Flasher2.zScale = 1;
            this.Flasher3.zScale = 1;
            this.Flasher4.zScale = 1;
            this.Flasher5.zScale = 1;
            this.Flasher6.zScale = 1;
            this.Flasher7.zScale = 1;
            this.Flasher8.zScale = 1;
            this.Flasher9.zScale = 0;
        }
        if (reactions.getFuel()/100 >= 9.9f) {
            this.Flasher1.zScale = 1;
            this.Flasher2.zScale = 1;
            this.Flasher3.zScale = 1;
            this.Flasher4.zScale = 1;
            this.Flasher5.zScale = 1;
            this.Flasher6.zScale = 1;
            this.Flasher7.zScale = 1;
            this.Flasher8.zScale = 1;
            this.Flasher9.zScale = 1;
        }



        this.Slider4.z = (float) (flee*2.5);

        // Final render call
        root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }


    @Override
    public ResourceLocation getDefaultTexture() {
        return new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/kelt/kelt.png");
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {

    }
}
