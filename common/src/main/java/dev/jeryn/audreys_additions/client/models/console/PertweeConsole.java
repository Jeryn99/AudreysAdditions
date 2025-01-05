package dev.jeryn.audreys_additions.client.models.console;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.jeryn.audreys_additions.AudConsoleRegistry;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.frame.tardis.Frame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import whocraft.tardis_refined.TRConfig;
import whocraft.tardis_refined.client.TardisClientData;
import whocraft.tardis_refined.client.model.blockentity.console.ConsoleUnit;
import whocraft.tardis_refined.common.block.console.GlobalConsoleBlock;
import whocraft.tardis_refined.common.blockentity.console.GlobalConsoleBlockEntity;
import whocraft.tardis_refined.common.tardis.manager.TardisPilotingManager;

public class PertweeConsole extends HierarchicalModel implements ConsoleUnit {

    public static final AnimationDefinition IDLE = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/pertwee/idle.json"));
    public static final AnimationDefinition FLIGHT = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/pertwee/flight.json"));
    public static final AnimationDefinition CRASH = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/pertwee/crash.json"));
    public static final AnimationDefinition POWER_ON = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/pertwee/power_on.json"));
    public static final AnimationDefinition POWER_OFF = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/console/pertwee/power_off.json"));

    private final ModelPart root, throttle_1, throttle_2, throttle_3, incrementSwitch;

    public PertweeConsole(ModelPart root) {
        this.root = root;
        this.throttle_1 = Frame.findPart(this, "ThrottleSwitch1");
        this.throttle_2 = Frame.findPart(this, "ThrottleSwitch2");
        this.throttle_3 = Frame.findPart(this, "ThrottleSwitch3");
        this.incrementSwitch = Frame.findPart(this, "MainLever1");

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root().getAllParts().forEach(ModelPart::resetPose);
        root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }


    @Override
    public void renderConsole(GlobalConsoleBlockEntity globalConsoleBlock, Level level, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root().getAllParts().forEach(ModelPart::resetPose);
        TardisClientData reactions = TardisClientData.getInstance(level.dimension());
        if (globalConsoleBlock == null) return;
        if (globalConsoleBlock.getBlockState() == null) return;

        Boolean powered = globalConsoleBlock.getBlockState() == null ? true : globalConsoleBlock.getBlockState().getValue(GlobalConsoleBlock.POWERED);


        if (!reactions.isInRecovery()) {
            if (!globalConsoleBlock.powerOn.isStarted()) {
                globalConsoleBlock.powerOff.stop();
                globalConsoleBlock.powerOn.start(Minecraft.getInstance().player.tickCount);
            }
            root().getAllParts().forEach(ModelPart::resetPose);
            this.animate(globalConsoleBlock.powerOn, POWER_ON, Minecraft.getInstance().player.tickCount);

            if (reactions.isCrashing()) {
                // Handle crashing animation
                root().getAllParts().forEach(ModelPart::resetPose);
                this.animate(reactions.CRASHING_ANIMATION, CRASH, Minecraft.getInstance().player.tickCount);
            } else if (reactions.isFlying()) {
                root().getAllParts().forEach(ModelPart::resetPose);
                this.animate(reactions.ROTOR_ANIMATION, FLIGHT, Minecraft.getInstance().player.tickCount);
            } else {
                root().getAllParts().forEach(ModelPart::resetPose);
                if (TRConfig.CLIENT.PLAY_CONSOLE_IDLE_ANIMATIONS.get() && globalConsoleBlock != null) {
                    this.animate(globalConsoleBlock.liveliness, IDLE, Minecraft.getInstance().player.tickCount);
                }
            }

        } else {
            if (globalConsoleBlock != null) {
                if (!globalConsoleBlock.powerOff.isStarted()) {
                    globalConsoleBlock.powerOn.stop();
                    globalConsoleBlock.powerOff.start(Minecraft.getInstance().player.tickCount);
                }
                root().getAllParts().forEach(ModelPart::resetPose);
                this.animate(globalConsoleBlock.powerOff, POWER_OFF, Minecraft.getInstance().player.tickCount);
            }
        }
/*
        float rot = 120.0f + (140.0f * ((float) reactions.getThrottleStage() / TardisPilotingManager.MAX_THROTTLE_STAGE));
        this.throttle_1.xRot = (float) Math.toRadians(rot);
        System.out.println(rot);*/

        root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }


    @Override
    public ResourceLocation getDefaultTexture() {
        return new ResourceLocation(AudreysAdditions.MODID, "textures/blockentity/console/pertwee/pertwee.png");
    }

    @Override
    public ResourceLocation getConsoleTheme() {
        return AudConsoleRegistry.PERTWEE.getId();
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {

    }
}
