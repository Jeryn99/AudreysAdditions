package dev.jeryn.audreys_additions.common.item;

import dev.jeryn.audreys_additions.common.blockentity.ChairBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class DyedItemBlock extends BlockItem implements DyeableLeatherItem {

    public DyedItemBlock(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack defaultInstance = super.getDefaultInstance();
        setColor(defaultInstance, DyeColor.RED.getTextColor());
        return defaultInstance;
    }


    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos pos = useOnContext.getClickedPos();
        BlockState state = level.getBlockState(pos);

        if (state.is(Blocks.WATER_CAULDRON) || state.is(Blocks.CAULDRON) && state.getValue(LayeredCauldronBlock.LEVEL) > 0) {
            clearColor(useOnContext.getItemInHand());
            return InteractionResult.SUCCESS;
        }

        return super.useOn(useOnContext);
    }


    @Override
    protected boolean placeBlock(BlockPlaceContext blockPlaceContext, BlockState blockState) {
        boolean superPlace = super.placeBlock(blockPlaceContext, blockState);

        if(blockPlaceContext.getLevel().getBlockEntity(blockPlaceContext.getClickedPos()) instanceof ChairBlockEntity chairBlockEntity){
            chairBlockEntity.setColour((getColor(blockPlaceContext.getItemInHand())));
        }

        return superPlace;
    }

    /**
     * Adds tooltip info showing the dye color.
     */
    @Override
    public void appendHoverText(ItemStack stack,  Level world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
