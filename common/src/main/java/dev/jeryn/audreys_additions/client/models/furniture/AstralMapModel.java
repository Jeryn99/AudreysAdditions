package dev.jeryn.audreys_additions.client.models.furniture;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import dev.jeryn.audreys_additions.client.renderers.Animatable;
import dev.jeryn.audreys_additions.common.blockentity.AstralMapBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.opengl.GL11;
import whocraft.tardis_refined.client.TardisClientData;
import whocraft.tardis_refined.client.model.GenericModel;
import whocraft.tardis_refined.client.overlays.VortexOverlay;
import whocraft.tardis_refined.client.renderer.vortex.RenderTargetHelper;
import whocraft.tardis_refined.client.renderer.vortex.RenderTargetStencil;
import whocraft.tardis_refined.common.VortexRegistry;

import static dev.jeryn.audreys_additions.client.renderers.RenderAstralMapBlockEntity.texture;
import static whocraft.tardis_refined.client.renderer.vortex.RenderTargetHelper.*;

public class AstralMapModel extends GenericModel implements Animatable<AstralMapBlockEntity> {

    private final ModelPart portal;

    public AstralMapModel(ModelPart root) {
        super(root);
        portal = root.getChild("portal");
    }


    @Override
    public void renderToBuffer(AstralMapBlockEntity blockentity, PoseStack stack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
       root().getAllParts().forEach(ModelPart::resetPose);

        TardisClientData tardisClientData = TardisClientData.getInstance(blockentity.getLevel().dimension());

        if (tardisClientData.isFlying()) {
            if (!getIsStencilEnabled(Minecraft.getInstance().getMainRenderTarget())) {
                setIsStencilEnabled(Minecraft.getInstance().getMainRenderTarget(), true);
            }

            stack.pushPose();
            RenderSystem.depthMask(true);
            MultiBufferSource.BufferSource imBuffer = stencilBufferStorage.getVertexConsumer();

            portal.visible = true;
            portal.render(stack, imBuffer.getBuffer(RenderType.entityTranslucent(new ResourceLocation("tardis_refined", "textures/black_portal.png"))), packedLight, packedOverlay, red, green, blue, alpha);


          /*  root().getAllParts().forEach(modelPart -> {
                if (modelPart != portal) {
                    modelPart.visible = true;
                }
            });*/

            root().visible = true;
            portal.visible = false;
            // Render Astral Map Frame
            root().render(stack, imBuffer.getBuffer(RenderType.entityTranslucent(texture)), packedLight, packedOverlay, red, green, blue, alpha);

            imBuffer.endBatch();
            GL11.glEnable(2960);
            GL11.glStencilMask(255);
            GL11.glClear(1024);
            GL11.glStencilFunc(519, 1, 255);
            GL11.glStencilOp(7680, 7680, 7681);
            RenderSystem.depthMask(true);
            stack.pushPose();

            // Unhide Portal for now
            root().visible = false;
            portal.visible = true;
            portal.render(stack, imBuffer.getBuffer(RenderType.entityTranslucent(new ResourceLocation("tardis_refined", "textures/black_portal.png"))), packedLight, packedOverlay, red, green, blue, alpha);

            imBuffer.endBatch();
            stack.popPose();
            RenderSystem.depthMask(false);
            GL11.glStencilMask(0);
            GL11.glStencilFunc(514, 1, 255);
            GlStateManager._depthFunc(519);
            GL11.glColorMask(true, true, true, false);
            stack.pushPose();
            stack.scale(0.6F, 0.6F, 0.6F);
            VortexOverlay.VORTEX.vortexType = VortexRegistry.VORTEX_DEFERRED_REGISTRY.get(tardisClientData.getVortex());
            VortexOverlay.VORTEX.time.speed = 0.3F + (float) tardisClientData.getThrottleStage() * 0.1F;
            VortexOverlay.VORTEX.renderVortex(stack, 1.0F, false);
            stack.popPose();
            GlStateManager._depthFunc(515);
            GL11.glColorMask(true, true, true, true);
            GL11.glDisable(2960);
            GL11.glStencilMask(255);
            RenderSystem.depthMask(true);
            stack.popPose();
        } else {
            root().visible = true;
            portal.visible = true;
            root().render(stack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        }


    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        root().getAllParts().forEach(ModelPart::resetPose);
        root().render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
