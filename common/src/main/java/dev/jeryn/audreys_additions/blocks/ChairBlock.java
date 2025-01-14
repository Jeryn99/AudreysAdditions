package dev.jeryn.audreys_additions.blocks;

import dev.jeryn.audreys_additions.blockentity.ChairBlockEntity;
import dev.jeryn.audreys_additions.common.registry.AudEntities;
import dev.jeryn.audreys_additions.entity.ChairEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import whocraft.tardis_refined.common.util.MiscHelper;
import whocraft.tardis_refined.common.util.PlayerUtil;
import whocraft.tardis_refined.registry.TRItemRegistry;
import whocraft.tardis_refined.registry.TRSoundRegistry;

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
    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        if (level.getBlockEntity(blockPos) instanceof ChairBlockEntity chairBlockEntity) {
            if (chairBlockEntity.getChairEntity() != null) {
                ChairEntity chairEntity = chairBlockEntity.getChairEntity();
                chairEntity.ejectPassengers();
                chairEntity.remove(Entity.RemovalReason.KILLED);
            }
        }

        super.onRemove(blockState, level, blockPos, blockState2, bl);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(ROTATION);
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

        // Handle Pattern Manipulator usage
        if (player.getMainHandItem().getItem() == TRItemRegistry.PATTERN_MANIPULATOR.get()) {
            if (player.getCooldowns().isOnCooldown(TRItemRegistry.PATTERN_MANIPULATOR.get()))
                return InteractionResult.CONSUME;
            blockChair.cycleVariant();
            PlayerUtil.sendMessage(player, Component.translatable(MiscHelper.getCleanName(blockChair.getCurrentVariant())), true);
            level.playSound(player, pos, TRSoundRegistry.PATTERN_MANIPULATOR.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
            player.getCooldowns().addCooldown(TRItemRegistry.PATTERN_MANIPULATOR.get(), 20);
            return InteractionResult.SUCCESS;
        }

        // Handle ChairEntity interaction
        ChairEntity chairEntity = blockChair.getChairEntity();

        if (chairEntity == null || !chairEntity.isAlive()) {
            chairEntity = new ChairEntity(AudEntities.CHAIR.get(), level);
            chairEntity.moveTo(pos, state.getValue(ROTATION), player.xRotO);
            blockChair.setChairEntity(chairEntity);
            level.addFreshEntity(chairEntity);
        }

        // Let the player ride the chair if not already riding
        if (!chairEntity.hasPassenger(player)) {
            player.startRiding(chairEntity);
        }

        return InteractionResult.SUCCESS;
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ChairBlockEntity(pos, state);
    }
}
