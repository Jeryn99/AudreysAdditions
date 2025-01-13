package dev.jeryn.audreys_additions.blocks;

import dev.jeryn.audreys_additions.blockentity.ChairBlockEntity;
import dev.jeryn.audreys_additions.entity.ChairEntity;
import dev.jeryn.audreys_additions.common.registry.AudEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ChairBlock extends Block implements EntityBlock {

    public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;

    public ChairBlock(Properties properties) {
        super(properties.noOcclusion());
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState p_60550_) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(ROTATION, Mth.floor((double)(context.getRotation() * 16.0F / 360.0F) + 0.5) & 15);
    }
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(ROTATION, rotation.rotate(state.getValue(ROTATION), 16));
    }
    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.setValue(ROTATION, mirror.mirror(state.getValue(ROTATION), 16));
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(ROTATION);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {

        if(hand == InteractionHand.MAIN_HAND){
            if(level.getBlockEntity(pos) instanceof ChairBlockEntity blockChair){
                ChairEntity chairEntity = null;
                if (blockChair.getChairEntity() == null || !blockChair.chairEntity.isAlive()) {
                    chairEntity = new ChairEntity(AudEntities.CHAIR.get(), level);
                    chairEntity.moveTo(pos, state.getValue(ROTATION), player.xRotO);
                    blockChair.setChairEntity(chairEntity);
                    level.addFreshEntity(chairEntity);
                } else {
                    chairEntity = blockChair.getChairEntity();
                }

                if (!chairEntity.hasPassenger(player)) {
                    player.startRiding(chairEntity);
                }

            }
        }
        return super.use(state, level, pos, player, hand, hit);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ChairBlockEntity(pos, state);
    }
}
