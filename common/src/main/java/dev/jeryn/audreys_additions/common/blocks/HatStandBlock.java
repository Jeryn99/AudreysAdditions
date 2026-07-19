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
import org.jetbrains.annotations.Nullable;

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

        BlockPos top = pos.above();

        if (level.getBlockState(top).canBeReplaced()) {
            level.setBlock(
                    top,
                    AudBlocks.HATSTAND_TOP.get().defaultBlockState(),
                    Block.UPDATE_ALL
            );
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.INVISIBLE;
    }

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
