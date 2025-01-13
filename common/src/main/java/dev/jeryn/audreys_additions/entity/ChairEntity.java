package dev.jeryn.audreys_additions.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class ChairEntity extends Entity {

    private static int MAX_PASSENGERS = 1;


    public ChairEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return getPassengers().size() < MAX_PASSENGERS;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {

    }


    /**
     * Positions the given passenger on the vehicle.
     *
     * @param passenger the passenger to position on the vehicle
     */
    @Override
    protected void positionRider(Entity passenger, MoveFunction moveFunction) {
        double mountOffset = this.getY() + 0.10;
        BlockPos blockPos = blockPosition();
        passenger.setPos(blockPos.getX() + 0.5, mountOffset, blockPos.getZ() + 0.5);
    }


    @Override
    public void tick() {
        if (getPassengers().isEmpty()) {
            kill();
        }

        super.tick();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }
}
