package dev.jeryn.audreys_additions.common.blocks;

import dev.jeryn.audreys_additions.common.blockentity.hatstand.HatstandBlockEntity;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import static dev.jeryn.audreys_additions.common.blocks.MonitorBlock.rotateShape;

public class HatStandTopBlock extends HorizontalDirectionalBlock {

    public HatStandTopBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return super.getStateForPlacement(blockPlaceContext).setValue(BlockStateProperties.HORIZONTAL_FACING, blockPlaceContext.getHorizontalDirection());
    }

    static VoxelShape CRIMSON_TOP_NORTH =
            Shapes.or(
                    Shapes.box(0.40625, 0, 0, 0.59375, 1, 0.0625),
                    Shapes.box(-0.03125, 0.75, 0, 0.40625, 1, 0.0625),
                    Shapes.box(0.59375, 0.75, 0, 1.03125, 1, 0.0625),
                    Shapes.box(-0.03125, 0.25, 0, 0.40625, 0.5, 0.0625),
                    Shapes.box(0.59375, 0.25, 0, 1.03125, 0.5, 0.0625)
            );

   static VoxelShape MANGROVE_TOP_NORTH =
            Shapes.or(
                    Shapes.box(0.1875, 0, 0, 0.8125, 1.375, 0.125),
                    Shapes.box(0, 0, 0.03125, 1, 1.6875, 0.09375)
            );

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }


    protected static final VoxelShape CRIMSON_TOP_EAST = rotateShape(Direction.NORTH, Direction.EAST, CRIMSON_TOP_NORTH);
    protected static final VoxelShape CRIMSON_TOP_SOUTH = rotateShape(Direction.NORTH, Direction.SOUTH, CRIMSON_TOP_NORTH);
    protected static final VoxelShape CRIMSON_TOP_WEST = rotateShape(Direction.NORTH, Direction.WEST, CRIMSON_TOP_NORTH);

    protected static final VoxelShape MANGROVE_TOP_EAST = rotateShape(Direction.NORTH, Direction.EAST, MANGROVE_TOP_NORTH);
    protected static final VoxelShape MANGROVE_TOP_SOUTH = rotateShape(Direction.NORTH, Direction.SOUTH, MANGROVE_TOP_NORTH);
    protected static final VoxelShape MANGROVE_TOP_WEST = rotateShape(Direction.NORTH, Direction.WEST, MANGROVE_TOP_NORTH);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {

        BlockPos bottom = pos.below();
        Block bottomBlock = level.getBlockState(bottom).getBlock();
        if (bottomBlock == AudBlocks.HATSTAND_ACACIA.get()) {
            return Shapes.or(
                    Shapes.box(0.3125, 0, 0.3125, 0.6875, 0.3125, 0.6875),
                    Shapes.box(0.25, 0.3125, 0.25, 0.75, 0.375, 0.75)
            );
        }
        if (bottomBlock == AudBlocks.HATSTAND_BAMBOO.get()) {
            return Shapes.or(
                    Shapes.box(0.40625, 0, 0.40625, 0.59375, 1.5, 0.59375),
                    Shapes.box(0.28125, 1.625, 0.28125, 0.71875, 1.75, 0.71875),
                    Shapes.box(0.34375, 1.5, 0.34375, 0.65625, 1.625, 0.65625)
            );
        }
        if (bottomBlock == AudBlocks.HATSTAND_BIRCH.get()) {
            return Shapes.or(
                    Shapes.box(0, 0.9375, 0, 1, 1, 1),
                    Shapes.box(0.40625, 0, 0.40625, 0.59375, 0.9375, 0.59375)
            );
        }
        if (bottomBlock == AudBlocks.HATSTAND_CRIMSON.get()) {
            Direction facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
            return switch (facing) {
                case EAST -> CRIMSON_TOP_EAST;
                case SOUTH -> CRIMSON_TOP_SOUTH;
                case WEST -> CRIMSON_TOP_WEST;
                default -> CRIMSON_TOP_NORTH;
            };

        }
        if (bottomBlock == AudBlocks.HATSTAND_CHERRY.get()) {
            return Shapes.or(
                    Shapes.box(0.4375, 0.8125, 0.4375, 0.5625, 1, 0.5625),
                    Shapes.box(0.15625, 0.375, 0.15625, 0.84375, 0.8125, 0.84375)
            );
        }
        if (bottomBlock == AudBlocks.HATSTAND_DARK_OAK.get()) {
            return Shapes.or(
                    Shapes.box(0, 0, 0, 1, 0.4375, 1),
                    Shapes.box(0.28125, 0.4375, 0.28125, 0.71875, 0.8125, 0.71875),
                    Shapes.box(0.0625, 0.8125, 0.0625, 0.9375, 1, 0.9375)
            );
        }

        if (bottomBlock == AudBlocks.HATSTAND_JUNGLE.get()) {
            return Shapes.or(
                    Shapes.box(0.1875, 0.4375, 0.1875, 0.8125, 0.5, 0.8125),
                    Shapes.box(0.375, 0, 0.375, 0.625, 0.4375, 0.625)
            );
        }
        if (bottomBlock == AudBlocks.HATSTAND_MANGROVE.get()) {
            Direction facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
            return switch (facing) {
                case EAST -> MANGROVE_TOP_EAST;
                case SOUTH -> MANGROVE_TOP_SOUTH;
                case WEST -> MANGROVE_TOP_WEST;
                default -> MANGROVE_TOP_NORTH;
            };

        }
        if (bottomBlock == AudBlocks.HATSTAND_OAK.get()) {
            return Shapes.or(
                    Shapes.box(0.46875, 0, 0.46875, 0.53125, 1, 0.53125),
                    Shapes.box(0.125, 0.5, 0.125, 0.875, 0.9375, 0.875)
            );

        }
        if (bottomBlock == AudBlocks.HATSTAND_PALE.get()) {
            return Shapes.or(
                    Shapes.box(0.46875, 0, 0.46875, 0.53125, 1, 0.53125),
                    Shapes.box(0.125, 0.5, 0.125, 0.875, 0.9375, 0.875)
            );
        }
        if (bottomBlock == AudBlocks.HATSTAND_SPRUCE.get()) {
            return Shapes.or(
                    Shapes.box(0.4375, 0, 0.4375, 0.5625, 1, 0.5625),
                    Shapes.box(0.0625, 0.21875, 0.0625, 0.9375, 0.34375, 0.9375),
                    Shapes.box(0.125, 0.71875, 0.125, 0.875, 0.84375, 0.875)
            );
        }
        if (bottomBlock == AudBlocks.HATSTAND_WARPED.get()) {
            return Shapes.or(
                    Shapes.box(0.4375, 0, 0.4375, 0.5625, 0.375, 0.5625),
                    Shapes.box(0.1875, 0.375, 0.1875, 0.8125, 1, 0.8125)
            );


        }
        return Block.box(0, 0, 0, 16, 16, 16);
    }



    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {

        BlockPos bottom = pos.below();
        BlockState bottomState = level.getBlockState(bottom);

        // BlockState#use(Level, Player, InteractionHand, BlockHitResult) derives its BlockPos
        // from hit.getBlockPos(), which is still the position the player actually clicked (the
        // top half). That fed the wrong position into HatStandBlock#use()'s getMenuProvider(),
        // so the menu looked up a block entity at the top half (which has none) instead of the
        // bottom half, crashing with an NPE in ContainerLevelAccess. Calling the Block directly
        // with the correct bottom position avoids that.
        if (bottomState.getBlock() instanceof HatStandBlock hatStandBlock) {
            return hatStandBlock.use(bottomState, level, bottom, player, hand, hit);
        }

        return InteractionResult.PASS;
    }


    @Override
    public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        BlockPos bottom = blockPos.below();

        if (level.getBlockState(bottom).getBlock() instanceof HatStandBlock) {
            level.destroyBlock(bottom, !player.isCreative());
        }

        super.playerWillDestroy(level, blockPos, blockState, player);
    }
}