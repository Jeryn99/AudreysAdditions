package dev.jeryn.audreys_additions.client.models.shell;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.jeryn.frame.tardis.Frame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import whocraft.tardis_refined.client.TardisClientData;
import whocraft.tardis_refined.client.model.blockentity.door.interior.SingleInteriorDoorModel;
import whocraft.tardis_refined.common.blockentity.door.GlobalDoorBlockEntity;

import java.util.Calendar;

import static dev.jeryn.audreys_additions.client.models.shell.TrakenClockModel.FREE_SPIN;

public class TrakenClockInteriorDoorModel extends SingleInteriorDoorModel {

    private final ModelPart portal, small_hand, big_hand;

    public TrakenClockInteriorDoorModel(ModelPart root, float openAmount) {
        super(root, openAmount);
        this.portal = Frame.findPart(this, "portal");
        this.small_hand = Frame.findPart(this, "small_hand");
        this.big_hand = Frame.findPart(this, "big_hand");
    }


    @Override
    public void renderFrame(GlobalDoorBlockEntity doorBlockEntity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.setDoorPosition(open);
        this.root().getAllParts().forEach((modelPart) -> {
            modelPart.visible = true;
        });
        this.portal.visible = false;

        TardisClientData tardisClientData = TardisClientData.getInstance(doorBlockEntity.getLevel().dimension());
        boolean isInFlight = tardisClientData.isFlying();

        float bigHandAngle = 0;
        float smallHandAngle = 0;

        if (isInFlight) {
            this.root().getAllParts().forEach(ModelPart::resetPose);
            setDoorPosition(open);
            animate(tardisClientData.ROTOR_ANIMATION, FREE_SPIN, Minecraft.getInstance().player.tickCount, 1F);
        } else {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR) % 12;
            int minute = calendar.get(Calendar.MINUTE);
            double hourHandDegree = ((double) hour + (double) minute / 60.0) / 12.0 * 360.0;
            double minuteHandDegree = (double) minute / 60.0 * 360.0;

            smallHandAngle = (float) Math.toRadians(hourHandDegree);
            bigHandAngle = (float) Math.toRadians(minuteHandDegree);

            this.small_hand.xRot = 0f;
            this.small_hand.yRot = 0f;
            this.small_hand.zRot = smallHandAngle;

            this.big_hand.xRot = 0f;
            this.big_hand.yRot = 0f;
            this.big_hand.zRot = bigHandAngle;
        }



        this.root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
