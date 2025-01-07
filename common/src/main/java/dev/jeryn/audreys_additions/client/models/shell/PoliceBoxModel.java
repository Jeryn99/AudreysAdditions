package dev.jeryn.audreys_additions.client.models.shell;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.jeryn.frame.tardis.Frame;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import whocraft.tardis_refined.client.model.blockentity.shell.ShellModel;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

public class PoliceBoxModel extends ShellModel {
    private final ModelPart root;
    private final ModelPart left_door;
    private final ModelPart right_door;
    private final ModelPart frame;
    private final ModelPart portal;
    private final PreRender preRender;

    public interface PreRender {
        void preRender(GlobalShellBlockEntity entity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha);
    }

    public PoliceBoxModel(ModelPart root, PreRender preRender) {
        super(root);
        this.root = root;
        this.frame = Frame.findPart(this, "frame");
        this.right_door = Frame.findPart(this,"right_door");
        this.left_door = Frame.findPart(this,"left_door");
        this.portal = Frame.findPart(this,"portal");
        this.preRender = preRender;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.frame.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.left_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.right_door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(Entity entity, float f, float g, float h, float i, float j) {
    }

    @Override
    public void setDoorPosition(boolean open) {
        this.right_door.yRot = open ? -275.0F : 0.0F;
    }

    @Override
    public void renderShell(GlobalShellBlockEntity entity, boolean open, boolean isBaseModel, PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        preRender.preRender(entity, open, isBaseModel, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.handleAllAnimations(entity, this.root(), isBaseModel, open, poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
    }
}
