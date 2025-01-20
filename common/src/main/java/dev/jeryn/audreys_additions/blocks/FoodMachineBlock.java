package dev.jeryn.audreys_additions.blocks;

import dev.jeryn.audreys_additions.AudTags;
import dev.jeryn.audreys_additions.blockentity.FoodMachineBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FoodMachineBlock extends Block  implements EntityBlock {

    public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;

    public FoodMachineBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState p_60550_) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(ROTATION);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {

        if(level.getBlockEntity(blockPos) instanceof FoodMachineBlockEntity foodMachine){

            // Start Producing
            if(player.getMainHandItem().isEmpty() && !foodMachine.isProducing()){
                foodMachine.setProducing(true);
                return InteractionResult.SUCCESS;
            }

            // Add Fuel
            if(player.getMainHandItem().is(AudTags.FUEL_ITEMS)){
                foodMachine.addFuel(player.getMainHandItem());
                return InteractionResult.SUCCESS;
            }

        }

        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
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
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new FoodMachineBlockEntity(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return (level1, blockPos, blockState, t) -> {
            if (t instanceof FoodMachineBlockEntity foodMachineBlock) {
                foodMachineBlock.tick(level, blockPos, blockState, foodMachineBlock);
            }
        };
    }
}
