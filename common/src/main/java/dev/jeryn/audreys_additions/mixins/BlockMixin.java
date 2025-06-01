package dev.jeryn.audreys_additions.mixins;

import dev.jeryn.audreys_additions.common.blocks.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(
            method = "isExceptionForConnection",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void audreysAdditions$isExceptionForConnection(
            BlockState state,
            CallbackInfoReturnable<Boolean> cir
    ) {
        Block block = state.getBlock();
        if (block instanceof AstralMapBlock
                || block instanceof CeilingCanopyBlock
                || block instanceof ChairBaseBlock
                || block instanceof FoodMachineBlock
                || block instanceof MonitorBlock) {
            cir.setReturnValue(true);
        }
    }



}
