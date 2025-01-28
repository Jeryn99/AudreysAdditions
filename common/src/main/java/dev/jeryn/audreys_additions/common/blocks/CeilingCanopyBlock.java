package dev.jeryn.audreys_additions.common.blocks;

import dev.jeryn.audreys_additions.common.blockentity.CeilingCanopyBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import whocraft.tardis_refined.registry.TRItemRegistry;
import whocraft.tardis_refined.registry.TRSoundRegistry;

import java.util.function.ToIntFunction;

public class CeilingCanopyBlock extends HorizontalDirectionalBlock implements EntityBlock {

    public static final BooleanProperty HANGING = BlockStateProperties.HANGING;

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(HorizontalDirectionalBlock.FACING);
        builder.add(HANGING);
    }

    public CeilingCanopyBlock(Properties properties) {
        super(properties.lightLevel(value -> 15));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        // Only handle main hand interactions
        if (hand != InteractionHand.MAIN_HAND) {
            return super.use(state, level, pos, player, hand, hit);
        }

        if (!(level.getBlockEntity(pos) instanceof CeilingCanopyBlockEntity blockChair)) {
            return super.use(state, level, pos, player, hand, hit);
        }

        // Handle Pattern Manipulator usage
        if (player.getMainHandItem().getItem() == TRItemRegistry.PATTERN_MANIPULATOR.get()) {
            if (player.getCooldowns().isOnCooldown(TRItemRegistry.PATTERN_MANIPULATOR.get()))
                return InteractionResult.CONSUME;

            level.setBlock(pos, state.cycle(HANGING), Block.UPDATE_ALL);

            level.playSound(player, pos, TRSoundRegistry.PATTERN_MANIPULATOR.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
            player.getCooldowns().addCooldown(TRItemRegistry.PATTERN_MANIPULATOR.get(), 20);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext arg) {
        return this.defaultBlockState().setValue(HANGING, false).setValue(FACING, arg.getHorizontalDirection().getClockWise());
    }


    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState p_60550_) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CeilingCanopyBlockEntity(pos, state);
    }

}
