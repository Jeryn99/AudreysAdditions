package dev.jeryn.audreys_additions.blocks;

import dev.jeryn.audreys_additions.blockentity.ChairBlockEntity;
import dev.jeryn.audreys_additions.blockentity.KnossosChairBlockEntity;
import dev.jeryn.audreys_additions.common.registry.AudEntities;
import dev.jeryn.audreys_additions.entity.ChairEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ChairBaseBlock extends HorizontalDirectionalBlock implements EntityBlock {

    public ChairBaseBlock(Properties properties) {
        super(properties.noOcclusion());
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
