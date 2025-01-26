package dev.jeryn.audreys_additions.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.blockentity.FoodMachineBlockEntity;
import dev.jeryn.audreys_additions.client.models.renderers.Animatable;
import dev.jeryn.frame.tardis.Frame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.client.model.GenericModel;

public class FoodMachineModel extends GenericModel implements Animatable<FoodMachineBlockEntity> {

    public static final AnimationDefinition POWER = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/food_machine/power.json"));
    public static final AnimationDefinition FLASHING = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/food_machine/flashing.json"));


    public FoodMachineModel(ModelPart root) {
        super(root);
    }

    @Override
    public void renderToBuffer(FoodMachineBlockEntity blockentity, PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root().getAllParts().forEach(ModelPart::resetPose);

        if (!blockentity.isProducing() && blockentity.getFuelLevel() > 0) {
            root().getAllParts().forEach(ModelPart::resetPose);
            animate(blockentity.POWER, POWER, blockentity.getAdjustedFrameTime());
        } else {
            root().getAllParts().forEach(ModelPart::resetPose);
            animate(blockentity.FLASHING, FLASHING, blockentity.getLevel().getGameTime());
        }

        this.root().render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }


}
