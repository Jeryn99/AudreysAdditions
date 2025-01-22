package dev.jeryn.audreys_additions.blocks;

import net.minecraft.util.Mth;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import org.jetbrains.annotations.NotNull;

public class LightBoxBlock extends HorizontalDirectionalBlock {


    public LightBoxBlock(Properties properties) {
        super(properties.noOcclusion());
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState p_60550_) {
        return super.getRenderShape(p_60550_);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext arg) {
        return this.defaultBlockState().setValue(FACING, arg.getHorizontalDirection());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(HorizontalDirectionalBlock.FACING);
    }

}
