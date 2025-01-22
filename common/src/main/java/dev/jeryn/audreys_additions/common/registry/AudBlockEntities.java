package dev.jeryn.audreys_additions.common.registry;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.blockentity.ChairBlockEntity;
import dev.jeryn.audreys_additions.blockentity.KnossosChairBlockEntity;
import dev.jeryn.audreys_additions.blockentity.FoodMachineBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;

public class AudBlockEntities {

    public static final DeferredRegistry<BlockEntityType<?>> TILES = DeferredRegistry.create(AudreysAdditions.MODID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<KnossosChairBlockEntity>> KNOSSOS_THRONE = TILES.register("knossos_throne", () -> registerTiles(KnossosChairBlockEntity::new, AudBlocks.KNOSSOS_THRONE.get()));
    public static final RegistrySupplier<BlockEntityType<FoodMachineBlockEntity>> FOOD_MACHINE = TILES.register("food_machine", () -> registerTiles(FoodMachineBlockEntity::new, AudBlocks.FOOD_MACHINE.get()));
    public static final RegistrySupplier<BlockEntityType<ChairBlockEntity>> ARMCHAIR = TILES.register("armchair", () -> registerTiles(ChairBlockEntity::new, AudBlocks.ARMCHAIR.get()));


    private static <T extends BlockEntity> BlockEntityType<T> registerTiles(BlockEntityType.BlockEntitySupplier<T> tile, Block... validBlock) {
        return BlockEntityType.Builder.of(tile, validBlock).build(null);
    }

}
