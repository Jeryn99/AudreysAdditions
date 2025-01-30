package dev.jeryn.audreys_additions.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LightBoxBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<BedPart> PART = BlockStateProperties.BED_PART;

    public LightBoxBlock(Properties properties) {
        super(properties.noOcclusion());
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, BedPart.FOOT));
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        if (!level.isClientSide && player.isCreative()) {
            BedPart bedPart = blockState.getValue(PART);
            BlockPos otherPartPos = blockPos.relative(getNeighbourDirection(bedPart, blockState.getValue(FACING)));
            BlockState otherPartState = level.getBlockState(otherPartPos);

            if (otherPartState.is(this) && otherPartState.getValue(PART) != bedPart) {
                level.setBlock(otherPartPos, Blocks.AIR.defaultBlockState(), 35);
                level.levelEvent(player, 2001, otherPartPos, Block.getId(otherPartState));
            }
        }

        super.playerWillDestroy(level, blockPos, blockState, player);
    }


    private static Direction getNeighbourDirection(BedPart bedPart, Direction direction) {
        return bedPart == BedPart.FOOT ? direction : direction.getOpposite();
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Direction direction = blockPlaceContext.getHorizontalDirection();
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        BlockPos blockPos2 = blockPos.relative(direction);
        Level level = blockPlaceContext.getLevel();
        return level.getBlockState(blockPos2).canBeReplaced(blockPlaceContext) && level.getWorldBorder().isWithinBounds(blockPos2) ? this.defaultBlockState().setValue(FACING, direction) : null;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, @Nullable LivingEntity livingEntity, ItemStack itemStack) {
        super.setPlacedBy(level, blockPos, blockState, livingEntity, itemStack);
        if (!level.isClientSide) {
            BlockPos blockPos2 = blockPos.relative(blockState.getValue(FACING));
            level.setBlock(blockPos2, blockState.setValue(PART, BedPart.HEAD), 3);
            level.blockUpdated(blockPos, Blocks.AIR);
            blockState.updateNeighbourShapes(level, blockPos, 3);
        }

    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        if (state.getValue(PART) == BedPart.HEAD){
            return RenderShape.INVISIBLE;
        }
        return RenderShape.MODEL;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, PART);
    }


}
