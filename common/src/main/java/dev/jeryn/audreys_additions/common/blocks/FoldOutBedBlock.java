package dev.jeryn.audreys_additions.common.blocks;

import dev.jeryn.audreys_additions.common.blockentity.FoldOutBedBlockEntity;
import dev.jeryn.audreys_additions.common.registry.AudSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.phys.BlockHitResult;

public class FoldOutBedBlock extends BedBlock implements EntityBlock {
    public FoldOutBedBlock(Properties properties) {
        super(DyeColor.BLACK, properties);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!(level.getBlockEntity(blockPos) instanceof FoldOutBedBlockEntity foldOutBedBlockEntity)) {
            return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
        }

        if (foldOutBedBlockEntity.isFolding() && !player.isCrouching()) {
            return InteractionResult.SUCCESS;
        }

        if (player.isCrouching()) {
            boolean isFolding = !foldOutBedBlockEntity.isFolding();
            foldOutBedBlockEntity.setFolding(isFolding);
            level.playSound(null, player.getX(), player.getY(), player.getZ(), AudSounds.SIDRAT.get(), SoundSource.BLOCKS, 0.3F, 0.3F);

            if (isFolding) {
                foldOutBedBlockEntity.FOLDING.start(player.tickCount);
            } else {
                foldOutBedBlockEntity.UNFOLDING.start(player.tickCount);
            }
            return InteractionResult.SUCCESS;
        }

        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }


    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        if (blockState.getValue(PART) == BedPart.FOOT) {
            return new FoldOutBedBlockEntity(blockPos, blockState);
        }
        return null;
    }
}
