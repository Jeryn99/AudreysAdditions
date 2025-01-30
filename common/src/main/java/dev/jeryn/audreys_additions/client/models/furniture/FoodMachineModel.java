package dev.jeryn.audreys_additions.client.models.furniture;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.blockentity.FoodMachineBlockEntity;
import dev.jeryn.audreys_additions.client.renderers.Animatable;
import dev.jeryn.frame.tardis.Frame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.client.model.GenericModel;

import java.util.ArrayList;
import java.util.List;

public class FoodMachineModel extends GenericModel implements Animatable<FoodMachineBlockEntity> {

    public static final AnimationDefinition FLASHING = Frame.loadAnimation(
            new ResourceLocation(AudreysAdditions.MODID, "frame/food_machine/flashing.json")
    );

    private final List<ModelPart> lights = new ArrayList<>();

    public FoodMachineModel(ModelPart root) {
        super(root);
        for (int i = 1; i <= 18; i++) {
            lights.add(Frame.findPart(this, "Light" + i));
        }
    }

    @Override
    public void renderToBuffer(FoodMachineBlockEntity blockentity, PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root().getAllParts().forEach(ModelPart::resetPose);

        updateLights(blockentity);

        if (blockentity.isProducing()) {
            root().getAllParts().forEach(ModelPart::resetPose);
            animate(blockentity.FLASHING, FLASHING, blockentity.getLevel().getGameTime());
        }

        root().render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void updateLights(FoodMachineBlockEntity blockentity) {
        int fuelLevel = blockentity.getFuelLevel();
        double step = 100.0 / lights.size();

        for (int i = 0; i < lights.size(); i++) {
            double threshold = (i + 1) * step;
            setLightRotation(lights.get(i), fuelLevel >= threshold ? (int) Math.toRadians(180) : 0);
        }
    }

    private void setLightRotation(ModelPart light, int rotation) {
        if (light != null) {
            light.xRot = rotation;
        }
    }
}
