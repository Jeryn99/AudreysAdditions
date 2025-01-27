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

    public static final AnimationDefinition FLASHING = Frame.loadAnimation(new ResourceLocation(AudreysAdditions.MODID, "frame/food_machine/flashing.json"));

    private final ModelPart light1, light2, light3, light4, light5, light6, light7, light8, light9, light10, light11, light12, light13, light14, light15, light16, light17, light18;

    public FoodMachineModel(ModelPart root) {
        super(root);
        light1 = Frame.findPart(this, "Light1");
        light2 = Frame.findPart(this, "Light2");
        light3 = Frame.findPart(this, "Light3");
        light4 = Frame.findPart(this, "Light4");
        light5 = Frame.findPart(this, "Light5");
        light6 = Frame.findPart(this, "Light6");
        light7 = Frame.findPart(this, "Light7");
        light8 = Frame.findPart(this, "Light8");
        light9 = Frame.findPart(this, "Light9");
        light10 = Frame.findPart(this, "Light10");
        light11 = Frame.findPart(this, "Light11");
        light12 = Frame.findPart(this, "Light12");
        light13 = Frame.findPart(this, "Light13");
        light14 = Frame.findPart(this, "Light14");
        light15 = Frame.findPart(this, "Light15");
        light16 = Frame.findPart(this, "Light16");
        light17 = Frame.findPart(this, "Light17");
        light18 = Frame.findPart(this, "Light18");
    }


    @Override
    public void renderToBuffer(FoodMachineBlockEntity blockentity, PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root().getAllParts().forEach(ModelPart::resetPose);

        updateLights(blockentity);

        if (blockentity.isProducing()) {
            root().getAllParts().forEach(ModelPart::resetPose);
            animate(blockentity.FLASHING, FLASHING, Minecraft.getInstance().player.tickCount);
        }

        this.root().render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void updateLights(FoodMachineBlockEntity blockentity) {
        int fuelLevel = blockentity.getFuelLevel();

        for (int i = 0; i < 18; i++) {
            double threshold = (i + 1) * (100.0 / 18);
            if (fuelLevel >= threshold) {
                setLightRotation(i, (int) Math.toRadians(180));
            } else {
                setLightRotation(i, 0);
            }
        }
    }

    private void setLightRotation(int lightIndex, int rotation) {
        switch (lightIndex) {
            case 0:
                light1.xRot = rotation;
                break;
            case 1:
                light2.xRot = rotation;
                break;
            case 2:
                light3.xRot = rotation;
                break;
            case 3:
                light4.xRot = rotation;
                break;
            case 4:
                light5.xRot = rotation;
                break;
            case 5:
                light6.xRot = rotation;
                break;
            case 6:
                light7.xRot = rotation;
                break;
            case 7:
                light8.xRot = rotation;
                break;
            case 8:
                light9.xRot = rotation;
                break;
            case 9:
                light10.xRot = rotation;
                break;
            case 10:
                light11.xRot = rotation;
                break;
            case 11:
                light12.xRot = rotation;
                break;
            case 12:
                light13.xRot = rotation;
                break;
            case 13:
                light14.xRot = rotation;
                break;
            case 14:
                light15.xRot = rotation;
                break;
            case 15:
                light16.xRot = rotation;
                break;
            case 16:
                light17.xRot = rotation;
                break;
            case 17:
                light18.xRot = rotation;
                break;
        }
    }


}
