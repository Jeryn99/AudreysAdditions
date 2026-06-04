package dev.jeryn.audreys_additions.common.item;

import dev.jeryn.audreys_additions.ModMessages;
import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SpecimenJarItemBlock extends BlockItem {

    public SpecimenJarItemBlock(Block block, Properties properties) {
        super(block, properties.stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, list, tooltipFlag);

        list.add(Component.translatable(ModMessages.TOOLTIP_SPECIMEN_JAR_DESCRIPTION));
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (!player.level().isClientSide) {

            ItemStack replacement = ItemStack.EMPTY;

            if (livingEntity instanceof Allay) {
                replacement = new ItemStack(AudBlocks.SPECIMEN_JAR_ALLAY.get());
            } else if (livingEntity instanceof Vex) {
                replacement = new ItemStack(AudBlocks.SPECIMEN_JAR_VEX.get());
            }

            if (!replacement.isEmpty()) {
                livingEntity.discard();

                player.setItemInHand(interactionHand, replacement);

                return InteractionResult.SUCCESS;
            }
        }

        return super.interactLivingEntity(itemStack, player, livingEntity, interactionHand);
    }

}
