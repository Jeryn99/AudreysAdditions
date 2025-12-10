package dev.jeryn.audreys_additions.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.item.ItemStack;
import whocraft.tardis_refined.client.model.GenericModel;

public class GenericHatStandModel extends GenericModel {

    private final Positioner positioner;

    public GenericHatStandModel(ModelPart root, Positioner positioner) {
        super(root);
        this.positioner = positioner;
    }

    public Positioner getPositioner() {
        return positioner;
    }

    public interface Positioner {
        void positionSlot(int slotIndex, ItemStack stack, PoseStack poseStack);
    }
}
