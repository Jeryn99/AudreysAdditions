package dev.jeryn.audreys_additions.neoforge.mixin;

import dev.jeryn.audreys_additions.common.blockentity.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.client.extensions.IBlockEntityRendererExtension;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({KnossosChairBlockEntity.class, AstralMapBlockEntity.class, CeilingCanopyBlockEntity.class, FoldOutBedBlockEntity.class, FoodMachineBlockEntity.class})
public class BlockEntityRendererMixin extends BlockEntity implements IBlockEntityRendererExtension {
    public BlockEntityRendererMixin(BlockEntityType<?> arg, BlockPos arg2, BlockState arg3) {
        super(arg, arg2, arg3);
    }

    @Override
    public AABB getRenderBoundingBox(BlockEntity blockEntity) {
        return INFINITE_EXTENT_AABB;
    }
}
