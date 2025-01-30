package dev.jeryn.audreys_additions.common.blockentity;

import dev.jeryn.audreys_additions.AudTags;
import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import dev.jeryn.audreys_additions.common.registry.AudItems;
import dev.jeryn.audreys_additions.common.registry.AudSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.world.level.block.Block.popResource;

public class FoodMachineBlockEntity extends BlockEntity implements BlockEntityTicker<FoodMachineBlockEntity> {

    public final AnimationState POWER = new AnimationState();
    public final AnimationState FLASHING = new AnimationState();

    private int fuelLevel = 0;
    private static final int MAX_FUEL = 100;
    private int productionTimer = 0;
    private boolean isProducing = false;

    public FoodMachineBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(AudBlockEntities.FOOD_MACHINE.get(), blockPos, blockState);
    }

    public boolean isProducing() {
        return isProducing;
    }

    public void setProducing(boolean producing) {
        isProducing = producing;
        sendUpdates();
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag);
        return tag;
    }

    public void sendUpdates() {
        if (level != null && getBlockState() != null && getBlockState().getBlock() != null) {
            level.updateNeighbourForOutputSignal(worldPosition, getBlockState().getBlock());
            level.sendBlockUpdated(worldPosition, level.getBlockState(worldPosition), level.getBlockState(worldPosition), 3);
        }
        setChanged();
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("FuelLevel", fuelLevel);
        tag.putInt("ProductionTimer", productionTimer);
        tag.putBoolean("IsProducing", isProducing);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        fuelLevel = tag.getInt("FuelLevel");
        productionTimer = tag.getInt("ProductionTimer");
        isProducing = tag.getBoolean("IsProducing");
    }

    @Override
    public void tick(Level level, BlockPos blockPos, BlockState blockState, FoodMachineBlockEntity blockEntity) {
        if (!level.isClientSide) {
            if (fuelLevel > 0 && isProducing) {
                startProducing(level, blockPos);
            }
            return;
        }

        if (isProducing) {
            if(!FLASHING.isStarted()) {
                FLASHING.start((int) level.getGameTime());
            }
        } else {
            FLASHING.stop();
        }
    }


    public void startProducing(Level level, BlockPos blockPos) {
        if (fuelLevel > 0 && isProducing) {
            productionTimer++;
            sendUpdates();
            if (productionTimer == 1) {
                level.playSound(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), AudSounds.FOOD_MACHINE.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
            }
            if (productionTimer >= 180) {
                ItemStack output = new ItemStack(AudItems.FOOD_CUBE.get());
                popResource(level, blockPos, output);
                productionTimer = 0;
                isProducing = false;
                fuelLevel = fuelLevel - 5;
                sendUpdates();
            }
        }
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public boolean addFuel(ItemStack fuelItem) {
        if (fuelItem.is(AudTags.FUEL_ITEMS)) {
            int fuelValue = 5;
            int spaceLeft = MAX_FUEL - fuelLevel;

            if (spaceLeft > 0) {
                int fuelToAdd = Math.min(fuelValue, spaceLeft);
                fuelLevel += fuelToAdd;
                sendUpdates();

                if (level instanceof ServerLevel serverLevel) {
                    BlockPos blockPos = getBlockPos();
                    serverLevel.sendParticles(ParticleTypes.SMOKE, blockPos.getX() + 0.5, blockPos.getY() + 1, blockPos.getZ() + 0.5, 5, 0.2, 0.2, 0.2, 0.02);
                }

                float pitch = 0.5F + ((float) fuelLevel / MAX_FUEL) * 1.5F;
                pitch = Math.min(pitch, 2.0F);

                level.playSound(null, worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(),
                        SoundEvents.NOTE_BLOCK_BIT.value(), SoundSource.BLOCKS, 1.0F, pitch);

                fuelItem.shrink(1);
                return true;
            }
        }
        return false;
    }


    public int getFuelLevel() {
        return fuelLevel;
    }
}
