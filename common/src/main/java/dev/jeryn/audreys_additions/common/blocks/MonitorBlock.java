package dev.jeryn.audreys_additions.common.blocks;

import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import whocraft.tardis_refined.common.capability.tardis.TardisLevelOperator;
import whocraft.tardis_refined.common.network.messages.screens.S2COpenMonitor;

public class MonitorBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED;

    public MonitorBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
    }

    protected static final VoxelShape AABB = Shapes.or(
            Block.box(5.0, 0.0, 5.0, 11.0, 7.0, 11.0),
            Block.box(6.0, 7.0, 6.0, 10.0, 9.0, 10.0)
    );

    protected static final VoxelShape BRACHACKI_MONITOR_NORTH = makeShape();
    protected static final VoxelShape BRACHACKI_MONITOR_EAST = rotateShape(Direction.NORTH, Direction.EAST, BRACHACKI_MONITOR_NORTH);
    protected static final VoxelShape BRACHACKI_MONITOR_SOUTH = rotateShape(Direction.NORTH, Direction.SOUTH, BRACHACKI_MONITOR_NORTH);
    protected static final VoxelShape BRACHACKI_MONITOR_WEST = rotateShape(Direction.NORTH, Direction.WEST, BRACHACKI_MONITOR_NORTH);

    public static VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0.125, 0.375, 1, 1, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0, 0.4375, 0.1875, 0.125, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0, 0.75, 0.8125, 0.125, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.8125, 0, 0.4375, 0.9375, 0.125, 0.875), BooleanOp.OR);

        return shape;
    }

    public static boolean isY(Direction dir) { return dir.getAxis() == Direction.Axis.Y; }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return super.getStateForPlacement(blockPlaceContext).setValue(FACING, blockPlaceContext.getHorizontalDirection());
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (blockState.getBlock() == AudBlocks.BRACHACKI_MONITOR.get()) {
            Direction facing = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
            return switch (facing) {
                case EAST -> BRACHACKI_MONITOR_WEST;
                case SOUTH -> BRACHACKI_MONITOR_NORTH;
                case WEST -> BRACHACKI_MONITOR_EAST;
                default -> BRACHACKI_MONITOR_SOUTH;
            };
        }

        return AABB;
    }


    public static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape)
    {
        if (isY(from) || isY(to)) { throw new IllegalArgumentException("Invalid Direction!"); }
        if (from == to) { return shape; }

        VoxelShape[] buffer = new VoxelShape[] { shape, Shapes.empty() };

        int times = (to.get2DDataValue() - from.get2DDataValue() + 4) % 4;
        for (int i = 0; i < times; i++)
        {
            buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = Shapes.or(
                    buffer[1],
                    Shapes.box(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)
            ));
            buffer[0] = buffer[1];
            buffer[1] = Shapes.empty();
        }

        return buffer[0];
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level instanceof ServerLevel serverLevel) {
            TardisLevelOperator.get(serverLevel).ifPresent(tardisLevelOperator -> {
                (new S2COpenMonitor(tardisLevelOperator.getInteriorManager().isWaitingToGenerate(), tardisLevelOperator.getPilotingManager().getCurrentLocation(), tardisLevelOperator.getPilotingManager().getTargetLocation(), tardisLevelOperator.getUpgradeHandler(), tardisLevelOperator.getAestheticHandler().getShellTheme())).send((ServerPlayer) player);
            });
        }
        return super.use(state, level, pos, player, hand, hit);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
    }
}
