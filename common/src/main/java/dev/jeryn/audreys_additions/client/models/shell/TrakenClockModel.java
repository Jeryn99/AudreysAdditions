package dev.jeryn.audreys_additions.client.models.shell;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.jeryn.frame.tardis.Frame;
import net.minecraft.client.model.geom.ModelPart;
import whocraft.tardis_refined.client.TardisClientData;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

import java.util.Calendar;

public class TrakenClockModel extends PoliceBoxModel {

    private final ModelPart big_hand, small_hand, right_door;

    public TrakenClockModel(ModelPart root) {
        super(root, (entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha) -> {

        });

        this.big_hand = Frame.findPart(this, "big_hand");
        this.small_hand = Frame.findPart(this, "small_hand");
        this.right_door = Frame.findPart(this, "right_door");
    }

    @Override
    public void setDoorPosition(boolean open) {
        this.right_door.yRot = open ? (float) Math.toRadians(-110) : 0.0F;
    }


    @Override
    public void handleSpecialAnimation(GlobalShellBlockEntity entity, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float baseAlpha) {
        poseStack.pushPose();

        if (entity.getTardisId() == null) {
            poseStack.popPose();
            return;
        }

        TardisClientData tardisClientData = TardisClientData.getInstance(entity.getTardisId());
        boolean isInFlight = tardisClientData.isFlying();

        float bigHandAngle;
        float smallHandAngle;

        if (isInFlight) {
            long time = System.currentTimeMillis();
            float seconds = (time % 1000L) / 1000.0f;

            bigHandAngle = seconds * 2.0f * (float) Math.PI * 1f;
            smallHandAngle = -seconds * 2.0f * (float) Math.PI * 0.5f;
        } else {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR) % 12;
            int minute = calendar.get(Calendar.MINUTE);
            double hourHandDegree = ((double) hour + (double) minute / 60.0) / 12.0 * 360.0;
            double minuteHandDegree = (double) minute / 60.0 * 360.0;

            smallHandAngle = (float) Math.toRadians(hourHandDegree);
            bigHandAngle = (float) Math.toRadians(minuteHandDegree);
        }

        this.small_hand.xRot = 0f;
        this.small_hand.yRot = 0f;
        this.small_hand.zRot = smallHandAngle;

        this.big_hand.xRot = 0f;
        this.big_hand.yRot = 0f;
        this.big_hand.zRot = bigHandAngle;

        setDoorPosition(entity.isOpen());

        poseStack.popPose();

    }
}
