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

    public static final AnimationDefinition IDLE = Frame.loadAnimation(Minecraft.getInstance().getResourceManager(), new ResourceLocation(AudreysAdditions.MODID, "frame/console/pertwee/idle.json"));
    public static final AnimationDefinition FLIGHT = Frame.loadAnimation(Minecraft.getInstance().getResourceManager(), new ResourceLocation(AudreysAdditions.MODID, "frame/console/pertwee/flight.json"));
    public static final AnimationDefinition CRASH = Frame.loadAnimation(Minecraft.getInstance().getResourceManager(), new ResourceLocation(AudreysAdditions.MODID, "frame/console/pertwee/crash.json"));
    public static final AnimationDefinition POWER_ON = Frame.loadAnimation(Minecraft.getInstance().getResourceManager(), new ResourceLocation(AudreysAdditions.MODID, "frame/console/pertwee/power_on.json"));
    public static final AnimationDefinition POWER_OFF = Frame.loadAnimation(Minecraft.getInstance().getResourceManager(), new ResourceLocation(AudreysAdditions.MODID, "frame/console/pertwee/power_off.json"));

    private final ModelPart root;

    public PertweeConsole(ModelPart root) {
        this.root = root;
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
            this.animate(globalConsoleBlock.powerOn, POWER_ON, Minecraft.getInstance().player.tickCount);

            if (reactions.isCrashing()) {
                // Handle crashing animation
                this.animate(reactions.CRASHING_ANIMATION, CRASH, Minecraft.getInstance().player.tickCount);
            } else if (reactions.isFlying()) {
                this.animate(reactions.ROTOR_ANIMATION, FLIGHT, Minecraft.getInstance().player.tickCount);
            } else {
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
                this.animate(globalConsoleBlock.powerOff, POWER_OFF, Minecraft.getInstance().player.tickCount);
            }
        }

        float rot = -125 - (30 * ((float) reactions.getThrottleStage() / TardisPilotingManager.MAX_THROTTLE_STAGE));
        //   this.throttleLever.xRot = rot;

        //    this.handbrake.xRot = reactions.isHandbrakeEngaged() ? -155f : -125f;*/
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
