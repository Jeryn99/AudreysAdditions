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

    public KeltConsoleModel(ModelPart root) {
        this.root = root;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root().getAllParts().forEach(ModelPart::resetPose);
        root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void renderConsole(GlobalConsoleBlockEntity globalConsoleBlock, Level level, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root().getAllParts().forEach(ModelPart::resetPose);

        if (globalConsoleBlock == null || globalConsoleBlock.getBlockState() == null) return;

        Boolean powered = globalConsoleBlock.getBlockState() == null ? true : globalConsoleBlock.getBlockState().getValue(GlobalConsoleBlock.POWERED);


        // Store tick count for later use
        int tickCount = Minecraft.getInstance().player.tickCount;

        TardisClientData reactions = TardisClientData.getInstance(level.dimension());

        // Booting logic
        if (powered) {
            if (globalConsoleBlock.getTicksBooting() > 0) {
                globalConsoleBlock.powerOff.stop();
                globalConsoleBlock.powerOn.startIfStopped(tickCount);

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
                globalConsoleBlock.powerOff.start(tickCount);
            }
            root().getAllParts().forEach(ModelPart::resetPose);
            this.animate(globalConsoleBlock.powerOff, POWER_OFF, tickCount);
        }

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
