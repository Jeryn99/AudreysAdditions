package dev.jeryn.audreys_additions.client.models.furniture;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.client.renderers.Animatable;
import dev.jeryn.audreys_additions.common.blockentity.FoldOutBedBlockEntity;
import dev.jeryn.frame.tardis.Frame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.client.model.GenericModel;

public class FoldOutBedModel extends GenericModel implements Animatable<FoldOutBedBlockEntity> {

    public static final AnimationDefinition UP = Frame.loadAnimation(
            new ResourceLocation(AudreysAdditions.MODID, "frame/fold_out_bed/up.json")
    );

    public static final AnimationDefinition DOWN = Frame.loadAnimation(
            new ResourceLocation(AudreysAdditions.MODID, "frame/fold_out_bed/down.json")
    );

    public FoldOutBedModel(ModelPart root) {
        super(root);
    }

    @Override
    public void renderToBuffer(FoldOutBedBlockEntity blockentity, PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root().getAllParts().forEach(ModelPart::resetPose);
        if(blockentity.isFolding()){
            root().getAllParts().forEach(ModelPart::resetPose);
            animate(blockentity.FOLDING, UP, Minecraft.getInstance().player.tickCount);
        } else {
            root().getAllParts().forEach(ModelPart::resetPose);
            animate(blockentity.UNFOLDING, DOWN, Minecraft.getInstance().player.tickCount);
        }
        root().render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
