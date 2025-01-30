package dev.jeryn.audreys_additions.common.blocks;

import dev.jeryn.audreys_additions.common.blockentity.ChairBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.KnossosChairBlockEntity;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import dev.jeryn.audreys_additions.common.registry.AudEntities;
import dev.jeryn.audreys_additions.entity.ChairEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static dev.jeryn.audreys_additions.common.blocks.MonitorBlock.rotateShape;

public class ChairBaseBlock extends HorizontalDirectionalBlock implements EntityBlock {

    public ChairBaseBlock(Properties properties) {
        super(properties.noOcclusion());
    }

    protected static final VoxelShape ARMCHAIR_NORTH = makeShape();
    protected static final VoxelShape ARMCHAIR_EAST = rotateShape(Direction.NORTH, Direction.EAST, ARMCHAIR_NORTH);
    protected static final VoxelShape ARMCHAIR_SOUTH = rotateShape(Direction.NORTH, Direction.SOUTH, ARMCHAIR_NORTH);
    protected static final VoxelShape ARMCHAIR_WEST = rotateShape(Direction.NORTH, Direction.WEST, ARMCHAIR_NORTH);

    
    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (blockState.getBlock() == AudBlocks.ARMCHAIR.get()) {
            Direction facing = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
            return switch (facing) {
                case EAST -> ARMCHAIR_WEST;
                case SOUTH -> ARMCHAIR_NORTH;
                case WEST -> ARMCHAIR_EAST;
                default -> ARMCHAIR_SOUTH;
            };
        }
        return super.getShape(blockState, blockGetter, blockPos, collisionContext);
    }

    public static VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.1875, 0, 0.875, 0.25, 0.875, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.875, 0.875, 0.8125, 0.9375, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.875, 0, 0.8125, 0.9375, 0.125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.21875, 0.125, 0.0625, 0.78125, 0.5, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0, 0.875, 0.8125, 0.875, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0.875, 0, 0.8125, 1.5, 0.125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0.875, 0.875, 0.8125, 1.5, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 1, 0.125, 0.8125, 1.4375, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0.875, 0.875, 0.8125, 1.5, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 1, 0.125, 0.8125, 1.4375, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0.875, 0, 0.8125, 1.5, 0.125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0.8125, 0.125, 0.8125, 1, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0, 0, 0.8125, 0.875, 0.125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0, 0, 0.25, 0.875, 0.125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.21875, 0.5, 0.03125, 0.78125, 0.625, 0.96875), BooleanOp.OR);
        return shape;
    }


    @Override
    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        if (level.getBlockEntity(blockPos) instanceof KnossosChairBlockEntity knossosChairBlockEntity) {
            if (knossosChairBlockEntity.getChairEntity() != null) {
                ChairEntity chairEntity = knossosChairBlockEntity.getChairEntity();
                chairEntity.ejectPassengers();
                chairEntity.remove(Entity.RemovalReason.KILLED);
            }
        }

        super.onRemove(blockState, level, blockPos, blockState2, bl);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        // Only handle main hand interactions
        if (hand != InteractionHand.MAIN_HAND) {
            return super.use(state, level, pos, player, hand, hit);
        }

        // Check if the block at the position is a ChairBlockEntity
        if (!(level.getBlockEntity(pos) instanceof ChairBlockEntity blockChair)) {
            return super.use(state, level, pos, player, hand, hit);
        }

        // Handle dye interaction
        ItemStack heldItem = player.getItemInHand(hand);
        if (heldItem.getItem() instanceof DyeItem dyeItem) {
            DyeColor dyeColour = dyeItem.getDyeColor();
            if (blockChair.getColour() != dyeColour) {
                blockChair.setColour(dyeColour);
                if (!player.isCreative()) {
                    heldItem.shrink(1);
                }
                level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.PASS;
        }

        // Handle ChairEntity interaction
        ChairEntity chairEntity = blockChair.getChairEntity();
        if (chairEntity == null || !chairEntity.isAlive()) {
            chairEntity = new ChairEntity(AudEntities.CHAIR.get(), level);
            chairEntity.moveTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, player.getYRot(), 0);
            blockChair.setChairEntity(chairEntity);
            level.addFreshEntity(chairEntity);
        }

        if (!chairEntity.hasPassenger(player)) {
            player.startRiding(chairEntity);
        }

        return InteractionResult.SUCCESS;
    }


    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext arg) {
        return this.defaultBlockState().setValue(FACING, arg.getHorizontalDirection().getClockWise());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(HorizontalDirectionalBlock.FACING);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ChairBlockEntity(pos, state);
    }
}
