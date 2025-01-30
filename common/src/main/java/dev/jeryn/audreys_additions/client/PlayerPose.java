package dev.jeryn.audreys_additions.client;

import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class PlayerPose {
    public static void setUpAnim(HumanoidModel<?> bipedModel, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if(livingEntity.isSleeping() && livingEntity.level().getBlockState(livingEntity.getSleepingPos().get()).getBlock() == AudBlocks.FOLD_OUT_BED.get()){
            bipedModel.head.resetPose();
            bipedModel.body.resetPose();

            bipedModel.head.xRot = (float) Math.toRadians(22.5F);
            bipedModel.head.yRot = (float) Math.toRadians(0);
            bipedModel.head.zRot = (float) Math.toRadians(0);

            bipedModel.hat.xRot = (float) Math.toRadians(22.5F);
            bipedModel.hat.yRot = (float) Math.toRadians(0);
            bipedModel.hat.zRot = (float) Math.toRadians(0);

            bipedModel.body.xRot = (float) Math.toRadians(27.5);
            bipedModel.body.yRot = (float) Math.toRadians(0);
            bipedModel.body.zRot = (float) Math.toRadians(0);

            bipedModel.body.x = (float) Math.toRadians(-4);
            bipedModel.body.y = (float) Math.toRadians(-12);
            bipedModel.body.z = (float) Math.toRadians(-5);

            bipedModel.leftArm.xRot = (float) Math.toRadians(20);
            bipedModel.leftArm.yRot = (float) Math.toRadians(0);
            bipedModel.leftArm.zRot = (float) Math.toRadians(-5);

            bipedModel.rightArm.xRot = (float) Math.toRadians(20);
            bipedModel.rightArm.yRot = (float) Math.toRadians(0);
            bipedModel.rightArm.zRot = (float) Math.toRadians(5);

            bipedModel.leftLeg.resetPose();

            bipedModel.leftLeg.xRot = (float) Math.toRadians(30);
            bipedModel.leftLeg.yRot = (float) Math.toRadians(0);
            bipedModel.leftLeg.zRot = (float) Math.toRadians(-5);

            bipedModel.rightLeg.xRot = (float) Math.toRadians(30);
            bipedModel.rightLeg.yRot = (float) Math.toRadians(0);
            bipedModel.rightLeg.zRot = (float) Math.toRadians(5);

            ci.cancel();
        } else {
            bipedModel.head.resetPose();
            bipedModel.hat.resetPose();
            bipedModel.body.resetPose();
            bipedModel.leftArm.resetPose();
            bipedModel.rightArm.resetPose();
            bipedModel.leftLeg.resetPose();
            bipedModel.rightLeg.resetPose();
        }
    }

    public static double getPlayerBedOffset() {
        return 0.2D;
    }
}
