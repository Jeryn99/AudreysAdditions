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

    @Inject(method = {"isExceptionForConnection(Lnet/minecraft/world/level/block/state/BlockState;)Z"}, at = {@At(value = "HEAD")}, cancellable = true)
    private static void audreysAdditions$isExceptionForConnection(BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        Block block = blockState.getBlock();
        if(block instanceof AstralMapBlock || block instanceof CeilingCanopyBlock || block instanceof ChairBaseBlock || block instanceof FoodMachineBlock  || block instanceof MonitorBlock){
            cir.setReturnValue(true);
        }
    }


}
