package dev.jeryn.audreys_additions.common.blocks;

import dev.jeryn.audreys_additions.common.blockentity.KnossosChairBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.cabinet.CabinetBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.cabinet.CabinetMenu;
import dev.jeryn.audreys_additions.common.blockentity.hatstand.HatstandBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.hatstand.HatstandMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import whocraft.tardis_refined.common.util.MiscHelper;
import whocraft.tardis_refined.common.util.PlayerUtil;
import whocraft.tardis_refined.registry.TRItemRegistry;
import whocraft.tardis_refined.registry.TRSoundRegistry;

public class CabinetBlock extends HorizontalDirectionalBlock implements EntityBlock {

    public CabinetBlock(Properties properties) {
        super(properties);
    }


    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return super.getStateForPlacement(blockPlaceContext).setValue(BlockStateProperties.HORIZONTAL_FACING, blockPlaceContext.getHorizontalDirection());
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.INVISIBLE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);

            if (blockEntity instanceof CabinetBlockEntity cabinet) {
                Containers.dropContents(level, pos, cabinet.getInventory());
                level.updateNeighbourForOutputSignal(pos, this);
            }

            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CabinetBlockEntity(blockPos, blockState);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        // Only handle main hand interactions
        if (hand != InteractionHand.MAIN_HAND) {
            return super.use(state, level, pos, player, hand, hit);
        }

        // Check if the block at the position is a ChairBlockEntity
        if (!(level.getBlockEntity(pos) instanceof CabinetBlockEntity cabinetBlock)) {
            return super.use(state, level, pos, player, hand, hit);
        }

        // Handle Pattern Manipulator usage
        if (player.getMainHandItem().getItem() == TRItemRegistry.PATTERN_MANIPULATOR.get()) {
            if (player.getCooldowns().isOnCooldown(TRItemRegistry.PATTERN_MANIPULATOR.get()))
                return InteractionResult.CONSUME;
            cabinetBlock.cycleVariant();
            PlayerUtil.sendMessage(player, Component.translatable(MiscHelper.getCleanName(cabinetBlock.getCurrentVariant())), true);
            level.playSound(player, pos, TRSoundRegistry.PATTERN_MANIPULATOR.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
            player.getCooldowns().addCooldown(TRItemRegistry.PATTERN_MANIPULATOR.get(), 20);
            return InteractionResult.SUCCESS;
        } else {
                if (level.isClientSide) {
                    return InteractionResult.SUCCESS;
                }

                if (player.isShiftKeyDown()) {
                    cabinetBlock.setOpen(false);
                    level.playSound(player, pos, SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    return InteractionResult.SUCCESS;
                }

                if (!cabinetBlock.isOpen()) {
                    cabinetBlock.setOpen(true);
                    level.playSound(player, pos, SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                    return InteractionResult.SUCCESS;
                }

                player.openMenu(state.getMenuProvider(level, pos));
                return InteractionResult.CONSUME;
        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        ItemStack stack = new ItemStack(this);

        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (blockEntity instanceof CabinetBlockEntity cabinet) {
            CompoundTag tag = new CompoundTag();

            cabinet.saveAdditional(tag);

            stack.setTag(tag);
        }

        return stack;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
        super.setPlacedBy(level, pos, state, entity, stack);

        if (stack.hasTag() && level.getBlockEntity(pos) instanceof CabinetBlockEntity cabinet) {
            cabinet.load(stack.getTag());
            cabinet.setChanged();
        }
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return super.getShape(blockState, blockGetter, blockPos, collisionContext);
    }

    @Override
    public MenuProvider getMenuProvider(BlockState blockState, Level level, BlockPos blockPos) {
        return new SimpleMenuProvider((i, inventory, player) -> new CabinetMenu(i, inventory, ContainerLevelAccess.create(level, blockPos)), Component.translatable("container.cabinet"));
    }
}
