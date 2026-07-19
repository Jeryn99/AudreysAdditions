package dev.jeryn.audreys_additions.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HatStandTopBlock extends Block {

    public HatStandTopBlock(Properties properties) {
        super(properties);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Block.box(0, 0, 0, 16, 16, 16);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {

        BlockPos bottom = pos.below();

        if (level.getBlockState(bottom).getBlock() instanceof HatStandBlock) {
            return level.getBlockState(bottom)
                    .use(level, player, hand, hit);
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