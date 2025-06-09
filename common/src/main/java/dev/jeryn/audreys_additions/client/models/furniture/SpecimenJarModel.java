package dev.jeryn.audreys_additions.client.models.furniture;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.jeryn.audreys_additions.client.renderers.Animatable;
import dev.jeryn.audreys_additions.common.blockentity.SpecimenJarBlockEntity;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.geom.ModelPart;
import whocraft.tardis_refined.client.model.GenericModel;

public class SpecimenJarModel extends GenericModel implements Animatable<SpecimenJarBlockEntity> {

    private AnimationDefinition currentAnimation;

    public SpecimenJarModel(ModelPart root) {
        super(root);
    }

    /**
     * Sets the current animation for this model.
     */
    public SpecimenJarModel setAnimation(AnimationDefinition animation) {
        this.currentAnimation = animation;
        return this;
    }

    /**
     * Gets the currently assigned animation.
     */
    public AnimationDefinition getAnimation() {
        return currentAnimation;
    }


    @Override
    public void renderToBuffer(SpecimenJarBlockEntity blockentity, PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root().getAllParts().forEach(ModelPart::resetPose);

        if(currentAnimation != null) {
            animate(blockentity.animation, currentAnimation, blockentity.getLevel().getGameTime());
        }

        root().render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
