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

public class CabinetTopBlock extends HorizontalDirectionalBlock {

    public CabinetTopBlock(Properties properties) {
        super(properties.noParticlesOnBreak());
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return super.getStateForPlacement(blockPlaceContext).setValue(BlockStateProperties.HORIZONTAL_FACING, blockPlaceContext.getHorizontalDirection());
    }


    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return super.getShape(blockState, blockGetter, blockPos, collisionContext);
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
        if (bottomState.getBlock() instanceof CabinetBlock cabinetBlock) {
            return cabinetBlock.use(bottomState, level, bottom, player, hand, hit);
        }

        return InteractionResult.PASS;
    }


    @Override
    public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        BlockPos bottom = blockPos.below();

        if (level.getBlockState(bottom).getBlock() instanceof CabinetBlock) {
            level.destroyBlock(bottom, !player.isCreative());
        }

        super.playerWillDestroy(level, blockPos, blockState, player);
    }

    @Override
    protected void spawnDestroyParticles(Level level, Player player, BlockPos blockPos, BlockState blockState) {
    // NO!!!!!    super.spawnDestroyParticles(level, player, blockPos, blockState);
    }
}