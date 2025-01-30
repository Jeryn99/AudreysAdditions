package dev.jeryn.audreys_additions.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LightBoxBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public LightBoxBlock(Properties properties) {
        super(properties.noOcclusion());
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext arg) {
        Direction direction = arg.getHorizontalDirection();
        BlockPos blockPos = arg.getClickedPos();
        BlockPos blockPos2 = blockPos.relative(direction);
        Level level = arg.getLevel();
        if (level.getBlockState(blockPos2).canBeReplaced(arg) && level.getWorldBorder().isWithinBounds(blockPos2)) {
            return this.defaultBlockState().setValue(FACING,  arg.getHorizontalDirection());
        }
        return null;
    }


    @Override
    public void onPlace(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);

        // Determine the position for the secondary block (barrier)
        BlockPos barrierPos = pos.relative(state.getValue(FACING));

        // Check if both positions are valid for placement
        if (level.isEmptyBlock(barrierPos) && canPlaceBlock(level, barrierPos)) {
            level.setBlock(barrierPos, Blocks.BARRIER.defaultBlockState(), Block.UPDATE_ALL);
        } else {
            // Remove the main block if the barrier cannot be placed
            level.removeBlock(pos, false);
        }
    }

    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean isMoving) {
        super.onRemove(state, level, pos, newState, isMoving);
        BlockPos barrierPos = pos.relative(state.getValue(FACING));
        if (level.getBlockState(barrierPos).is(Blocks.BARRIER)) {
            level.removeBlock(barrierPos, false);
        }
    }

    @Override
    public void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Block block, @NotNull BlockPos neighborPos, boolean isMoving) {
        super.neighborChanged(state, level, pos, block, neighborPos, isMoving);
        BlockPos barrierPos = pos.relative(state.getValue(FACING));
        if (level.getBlockState(pos).is(Blocks.BARRIER)) {
            if (!level.getBlockState(barrierPos).isAir()) {
                if (level.getBlockState(barrierPos).isAir()) {
                    level.destroyBlock(pos, true);
                }
            }
        }
    }


    private boolean canPlaceBlock(Level level, BlockPos pos) {
        // Check if the position is valid for block placement
        return level.getBlockState(pos).canBeReplaced() &&
                level.getBlockState(pos).canBeReplaced() &&
                level.getBlockState(pos).getCollisionShape(level, pos, CollisionContext.empty()).isEmpty();
    }
}
