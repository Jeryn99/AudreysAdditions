package dev.jeryn.audreys_additions.common.registry;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.blockentity.*;
import dev.jeryn.audreys_additions.common.blockentity.cabinet.CabinetBlockEntity;
import dev.jeryn.audreys_additions.common.blockentity.hatstand.HatstandBlockEntity;
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
    public static final RegistrySupplier<BlockEntityType<AstralMapBlockEntity>> ASTRAL_MAP = TILES.register("astral_map", () -> registerTiles(AstralMapBlockEntity::new, AudBlocks.ASTRAL_MAP.get()));
    public static final RegistrySupplier<BlockEntityType<CeilingCanopyBlockEntity>> CEILING_CANOPY = TILES.register("ceiling_canopy", () -> registerTiles(CeilingCanopyBlockEntity::new, AudBlocks.CEILING_CANOPY.get()));
    public static final RegistrySupplier<BlockEntityType<FoldOutBedBlockEntity>> FOLD_OUT_BED = TILES.register("fold_out_bed", () -> registerTiles(FoldOutBedBlockEntity::new, AudBlocks.FOLD_OUT_BED.get()));

    public static final RegistrySupplier<BlockEntityType<SpecimenJarBlockEntity>> SPECIMEN_JAR =
            TILES.register("specimen_jar", () ->
                    registerTiles(SpecimenJarBlockEntity::new,
                            AudBlocks.SPECIMEN_JAR.get(),
                            AudBlocks.SPECIMEN_JAR_ALLAY.get(),
                            AudBlocks.SPECIMEN_JAR_CREEPER.get(),
                            AudBlocks.SPECIMEN_JAR_DRAGON.get(),
                            AudBlocks.SPECIMEN_JAR_PIGLIN.get(),
                            AudBlocks.SPECIMEN_JAR_SKELETON.get(),
                            AudBlocks.SPECIMEN_JAR_VEX.get(),
                            AudBlocks.SPECIMEN_JAR_WITHERSKELETON.get(),
                            AudBlocks.SPECIMEN_JAR_ZOMBIE.get()
                    ));

    public static final RegistrySupplier<BlockEntityType<DyeableRoundelBlockEntity>> DYEABLE_ROUNDEL = TILES.register("dyeable_roundel", () -> registerTiles(DyeableRoundelBlockEntity::new, AudBlocks.ROUNDEL_OVERLAY_FULL.get(), AudBlocks.ROUNDEL_OVERLAY_HALF.get()));
    public static final RegistrySupplier<BlockEntityType<HatstandBlockEntity>> HAT_STAND = TILES.register("hat_stand", () -> registerTiles(HatstandBlockEntity::new, AudBlocks.HATSTAND_OAK.get(), AudBlocks.HATSTAND_SPRUCE.get(), AudBlocks.HATSTAND_BIRCH.get(), AudBlocks.HATSTAND_JUNGLE.get(), AudBlocks.HATSTAND_ACACIA.get(), AudBlocks.HATSTAND_PALE.get(), AudBlocks.HATSTAND_WARPED.get(), AudBlocks.HATSTAND_BAMBOO.get(), AudBlocks.HATSTAND_MANGROVE.get(), AudBlocks.HATSTAND_DARK_OAK.get(), AudBlocks.HATSTAND_CRIMSON.get(), AudBlocks.HATSTAND_CHERRY.get()));
    public static final RegistrySupplier<BlockEntityType<CabinetBlockEntity>> CABINET = TILES.register("cabinet", () -> registerTiles(CabinetBlockEntity::new, AudBlocks.CABINET.get()));



    private static <T extends BlockEntity> BlockEntityType<T> registerTiles(BlockEntityType.BlockEntitySupplier<T> tile, Block... validBlock) {
        return BlockEntityType.Builder.of(tile, validBlock).build(null);
    }

}
