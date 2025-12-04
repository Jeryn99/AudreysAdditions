package dev.jeryn.audreys_additions.common.blocks;

import com.google.common.collect.ImmutableMap;
import dev.jeryn.audreys_additions.common.blockentity.DyeableRoundelBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.KnossosChairBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RoundelOverlayBlock extends BaseEntityBlock {

    public static final BooleanProperty UP = PipeBlock.UP;
    public static final BooleanProperty DOWN = PipeBlock.DOWN;
    public static final BooleanProperty NORTH = PipeBlock.NORTH;
    public static final BooleanProperty EAST = PipeBlock.EAST;
    public static final BooleanProperty SOUTH = PipeBlock.SOUTH;
    public static final BooleanProperty WEST = PipeBlock.WEST;

    public static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION =
            PipeBlock.PROPERTY_BY_DIRECTION;

    private static final VoxelShape UP_AABB = Block.box(0.0, 15.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape DOWN_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
    private static final VoxelShape WEST_AABB = Block.box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
    private static final VoxelShape EAST_AABB = Block.box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape NORTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
    private static final VoxelShape SOUTH_AABB = Block.box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);

    private final Map<BlockState, VoxelShape> shapesCache;

    public RoundelOverlayBlock(BlockBehaviour.Properties properties) {
        super(properties.lightLevel(value -> 13));
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(UP, false)
                        .setValue(DOWN, false)
                        .setValue(NORTH, false)
                        .setValue(EAST, false)
                        .setValue(SOUTH, false)
                        .setValue(WEST, false)
        );

        this.shapesCache = ImmutableMap.copyOf(
                this.stateDefinition.getPossibleStates().stream()
                        .collect(Collectors.toMap(Function.identity(), RoundelOverlayBlock::calculateShape))
        );
    }

    private static VoxelShape calculateShape(BlockState state) {
        VoxelShape shape = Shapes.empty();

        if (state.getValue(UP)) shape = Shapes.or(shape, UP_AABB);
        if (state.getValue(DOWN)) shape = Shapes.or(shape, DOWN_AABB);
        if (state.getValue(NORTH)) shape = Shapes.or(shape, NORTH_AABB);
        if (state.getValue(SOUTH)) shape = Shapes.or(shape, SOUTH_AABB);
        if (state.getValue(EAST)) shape = Shapes.or(shape, EAST_AABB);
        if (state.getValue(WEST)) shape = Shapes.or(shape, WEST_AABB);

        return shape.isEmpty() ? Shapes.block() : shape;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        return shapesCache.get(state);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        return true;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return hasFaces(getUpdatedState(state, level, pos));
    }


    private boolean hasFaces(BlockState state) {
        return countFaces(state) > 0;
    }

    private int countFaces(BlockState state) {
        int count = 0;
        for (BooleanProperty prop : PROPERTY_BY_DIRECTION.values())
            if (state.getValue(prop)) count++;
        return count;
    }

    private boolean canSupportAtFace(BlockGetter level, BlockPos pos, Direction dir) {
        BlockPos other = pos.relative(dir);
        return MultifaceBlock.canAttachTo(level, dir, other, level.getBlockState(other));
    }

    private BlockState getUpdatedState(BlockState state, BlockGetter level, BlockPos pos) {
        for (Direction dir : PROPERTY_BY_DIRECTION.keySet()) {
            BooleanProperty prop = PROPERTY_BY_DIRECTION.get(dir);
            if (!state.getValue(prop)) continue;
            boolean ok = canSupportAtFace(level, pos, dir);
            state = state.setValue(prop, ok);
        }
        return state;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction dir, BlockState neighbor, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        BlockState updated = getUpdatedState(state, level, pos);
        return hasFaces(updated) ? updated : Blocks.AIR.defaultBlockState();
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext ctx) {
        BlockState existing = ctx.getLevel().getBlockState(ctx.getClickedPos());
        if (existing.is(this))
            return countFaces(existing) < PROPERTY_BY_DIRECTION.size();
        return super.canBeReplaced(state, ctx);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState existing = ctx.getLevel().getBlockState(ctx.getClickedPos());
        boolean overlay = existing.is(this);
        BlockState result = overlay ? existing : defaultBlockState();

        for (Direction dir : ctx.getNearestLookingDirections()) {
            BooleanProperty prop = PROPERTY_BY_DIRECTION.get(dir);
            if (prop == null) continue;

            if (overlay && existing.getValue(prop)) continue;
            if (!canSupportAtFace(ctx.getLevel(), ctx.getClickedPos(), dir)) continue;

            return result.setValue(prop, true);
        }
        return overlay ? result : null;
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP, DOWN, NORTH, EAST, SOUTH, WEST);
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DyeableRoundelBlockEntity(pos, state);
    }
}
