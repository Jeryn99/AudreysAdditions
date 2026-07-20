package dev.jeryn.audreys_additions.common.blocks;

import dev.jeryn.audreys_additions.common.blockentity.cabinet.CabinetBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.hatstand.HatstandBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.hatstand.HatstandMenu;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import static dev.jeryn.audreys_additions.common.blocks.MonitorBlock.rotateShape;

public class HatStandBlock extends HorizontalDirectionalBlock implements EntityBlock {

    public static final BooleanProperty TOP =
            BooleanProperty.create("top");

    public HatStandBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
                        .setValue(TOP, true)
        );

    }
    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return super.getStateForPlacement(blockPlaceContext).setValue(BlockStateProperties.HORIZONTAL_FACING, blockPlaceContext.getHorizontalDirection());
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state,
                            LivingEntity entity, ItemStack stack) {

        super.setPlacedBy(level, pos, state, entity, stack);

        if (level.isClientSide) {
            return;
        }

        BlockPos top = pos.above();

        if (!level.isInWorldBounds(top)) {
            return;
        }

        BlockState topState = level.getBlockState(top);

        if (topState.canBeReplaced()) {
            level.setBlock(
                    top,
                    AudBlocks.HATSTAND_TOP.get()
                            .defaultBlockState()
                            .setValue(FACING, state.getValue(FACING)),
                    Block.UPDATE_ALL
            );
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.INVISIBLE;
    }

    public static VoxelShape ACACIA_BOTTOM =
        Shapes.or(
                Shapes.box(0.25, 0, 0.25, 0.75, 0.1875, 0.75),
                Shapes.box(0.34375, 0.1875, 0.34375, 0.65625, 0.8125, 0.65625),
                Shapes.box(0.3125, 0.8125, 0.3125, 0.6875, 1, 0.6875)
        );

    public static VoxelShape BAMBOO_BOTTOM =
            Shapes.or(
                    Shapes.box(0.0625, 0, 0.0625, 0.9375, 0.125, 0.9375),
                    Shapes.box(0.21875, 0.125, 0.21875, 0.78125, 0.375, 0.78125),
                    Shapes.box(0.40625, 0.375, 0.40625, 0.59375, 1, 0.59375)
            );

    public static VoxelShape BIRCH_BOTTOM =
            Shapes.or(
                    Shapes.box(0.40625, 0.0625, 0.40625, 0.59375, 1, 0.59375),
                    Shapes.box(0, 0, 0, 1, 0.0625, 1)
            );

    public static VoxelShape CRIMSON_BOTTOM_NORTH =
            Shapes.or(
                    Shapes.box(0.40625, 0, 0, 0.59375, 1, 0.0625),
                    Shapes.box(0.125, 0, 0.0625, 0.875, 0.1875, 0.4375),
                    Shapes.box(0.21875, 0.6875, 0.0625, 0.78125, 0.875, 0.4375)
            );

    public static VoxelShape CHERRY_BOTTOM =
            Shapes.or(
                    Shapes.box(0, 0, 0, 1, 1, 1)
            );

    public static VoxelShape DARK_OAK_BOTTOM =
            Shapes.or(
                    Shapes.box(0, 0, 0, 1, 0.4375, 1),
                    Shapes.box(0.28125, 0.4375, 0.28125, 0.71875, 0.8125, 0.71875),
                    Shapes.box(0.0625, 0.8125, 0.0625, 0.9375, 1, 0.9375)
            );

    public static VoxelShape JUNGLE_BOTTOM =
            Shapes.or(
                    Shapes.box(0.1875, 0, 0.1875, 0.8125, 0.125, 0.8125),
                    Shapes.box(0.375, 0.125, 0.375, 0.625, 1, 0.625)
            );

    public static VoxelShape MANGROVE_BOTTOM_NORTH =
            Shapes.or(
                    Shapes.box(0, 0, 0, 1, 0.8125, 0.625),
                    Shapes.box(0.1875, 0.8125, 0, 0.8125, 1, 0.125)
            );

    public static VoxelShape OAK_BOTTOM =
            Shapes.or(
                    Shapes.box(0.28125, 0, 0.28125, 0.71875, 0.625, 0.71875),
                    Shapes.box(0.46875, 0.625, 0.46875, 0.53125, 1, 0.53125)
            );

    public static VoxelShape SPRUCE_BOTTOM =
            Shapes.or(
                    Shapes.box(0.1875, 0, 0.1875, 0.8125, 1, 0.8125)
            );

    public static VoxelShape WARPED_BOTTOM =
            Shapes.or(
                    Shapes.box(0.25, 0, 0.25, 0.75, 0.25, 0.75),
                    Shapes.box(0.4375, 0.25, 0.4375, 0.5625, 1, 0.5625)
            );

    protected static final VoxelShape CRIMSON_BOTTOM_EAST = rotateShape(Direction.NORTH, Direction.EAST, CRIMSON_BOTTOM_NORTH);
    protected static final VoxelShape CRIMSON_BOTTOM_SOUTH = rotateShape(Direction.NORTH, Direction.SOUTH, CRIMSON_BOTTOM_NORTH);
    protected static final VoxelShape CRIMSON_BOTTOM_WEST = rotateShape(Direction.NORTH, Direction.WEST, CRIMSON_BOTTOM_NORTH);

    protected static final VoxelShape MANGROVE_BOTTOM_EAST = rotateShape(Direction.NORTH, Direction.EAST, MANGROVE_BOTTOM_NORTH);
    protected static final VoxelShape MANGROVE_BOTTOM_SOUTH = rotateShape(Direction.NORTH, Direction.SOUTH, MANGROVE_BOTTOM_NORTH);
    protected static final VoxelShape MANGROVE_BOTTOM_WEST = rotateShape(Direction.NORTH, Direction.WEST, MANGROVE_BOTTOM_NORTH);

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
        builder.add(TOP);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        ItemStack stack = new ItemStack(this);

        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (blockEntity instanceof HatstandBlockEntity cabinet) {
            CompoundTag tag = new CompoundTag();

            cabinet.saveAdditional(tag);

            stack.setTag(tag);
        }

        return stack;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos,
                         BlockState newState, boolean moving) {

        if (!state.is(newState.getBlock())) {

            BlockPos top = pos.above();

            if (level.getBlockState(top).is(AudBlocks.HATSTAND_TOP.get())) {
                level.destroyBlock(top, false);
            }

            BlockEntity blockEntity = level.getBlockEntity(pos);

            if (blockEntity instanceof HatstandBlockEntity hatstand) {
                Containers.dropContents(level, pos, hatstand.getInventory());
            }

            super.onRemove(state, level, pos, newState, moving);
        }
    }
    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
            if (blockState.getBlock() == AudBlocks.HATSTAND_ACACIA.get()) {
                blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
                return ACACIA_BOTTOM;
            }
        if (blockState.getBlock() == AudBlocks.HATSTAND_BAMBOO.get()) {
            blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
            return BAMBOO_BOTTOM;
        }

        if (blockState.getBlock() == AudBlocks.HATSTAND_BIRCH.get()) {
            blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
            return BIRCH_BOTTOM;
        }

        if (blockState.getBlock() == AudBlocks.HATSTAND_CHERRY.get()) {
            blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
            return CHERRY_BOTTOM;
        }

        if (blockState.getBlock() == AudBlocks.HATSTAND_CRIMSON.get()) {
            Direction facing = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
            return switch (facing) {
                case EAST -> CRIMSON_BOTTOM_EAST;
                case SOUTH -> CRIMSON_BOTTOM_SOUTH;
                case WEST -> CRIMSON_BOTTOM_WEST;
                default -> CRIMSON_BOTTOM_NORTH;
            };
        }

        if (blockState.getBlock() == AudBlocks.HATSTAND_DARK_OAK.get()) {
            blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
            return DARK_OAK_BOTTOM;
        }

        if (blockState.getBlock() == AudBlocks.HATSTAND_JUNGLE.get()) {
            blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
            return JUNGLE_BOTTOM;
        }

        if (blockState.getBlock() == AudBlocks.HATSTAND_MANGROVE.get()) {
            Direction facing = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
            return switch (facing) {
                case EAST -> MANGROVE_BOTTOM_EAST;
                case SOUTH -> MANGROVE_BOTTOM_SOUTH;
                case WEST -> MANGROVE_BOTTOM_WEST;
                default -> MANGROVE_BOTTOM_NORTH;
            };
        }

        if (blockState.getBlock() == AudBlocks.HATSTAND_OAK.get()) {
            blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
            return OAK_BOTTOM;
        }

        if (blockState.getBlock() == AudBlocks.HATSTAND_PALE.get()) {
            blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
            return OAK_BOTTOM;
        }

        if (blockState.getBlock() == AudBlocks.HATSTAND_SPRUCE.get()) {
            blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
            return SPRUCE_BOTTOM;
        }

        if (blockState.getBlock() == AudBlocks.HATSTAND_WARPED.get()) {
            blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
            return WARPED_BOTTOM;
        }
        return super.getShape(blockState, blockGetter, blockPos, collisionContext);
    }


    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new HatstandBlockEntity(blockPos, blockState);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }
        player.openMenu(blockState.getMenuProvider(level, blockPos));
        return InteractionResult.CONSUME;
    }

    @Override
    public MenuProvider getMenuProvider(BlockState blockState, Level level, BlockPos blockPos) {
        return new SimpleMenuProvider((i, inventory, player) -> new HatstandMenu(i, inventory, ContainerLevelAccess.create(level, blockPos)), Component.translatable("container.hatstand"));
    }
}
