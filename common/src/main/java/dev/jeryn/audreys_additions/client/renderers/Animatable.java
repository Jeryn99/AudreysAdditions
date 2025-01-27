package dev.jeryn.audreys_additions.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.world.level.block.entity.BlockEntity;

public interface Animatable<T extends BlockEntity> {

    public default void renderToBuffer(T blockentity, PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {}

}
