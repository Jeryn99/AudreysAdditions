package dev.jeryn.audreys_additions.common.item;

import dev.jeryn.audreys_additions.common.registry.AudBlocks;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class SpecimenJarItemBlock extends BlockItem {

    public SpecimenJarItemBlock(Block block, Properties properties) {
        super(block, properties);
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
                livingEntity.discard(); // Remove the entity

                itemStack.shrink(1); // Use one empty jar

                if (!player.getInventory().add(replacement)) {
                    player.drop(replacement, false);
                }

                return InteractionResult.SUCCESS;
            }
        }

        return super.interactLivingEntity(itemStack, player, livingEntity, interactionHand);
    }
}
