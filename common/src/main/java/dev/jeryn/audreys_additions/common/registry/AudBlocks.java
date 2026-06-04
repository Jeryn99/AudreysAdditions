package dev.jeryn.audreys_additions.common.registry;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.blocks.*;
import dev.jeryn.audreys_additions.common.item.DyedItemBlock;
import dev.jeryn.audreys_additions.common.item.SpecimenJarItemBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.PushReaction;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;

import java.util.function.Supplier;

public class AudBlocks {

    public static final DeferredRegistry<Block> BLOCKS = DeferredRegistry.create(AudreysAdditions.MODID, Registries.BLOCK);

    public static final RegistrySupplier<Block> KNOSSOS_THRONE = register("knossos_throne", () -> new KnossosChairBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistrySupplier<Block> LIMINTON_MONITOR = register("liminton_monitor", () -> new MonitorBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistrySupplier<Block> FOOD_MACHINE = register("food_machine", () -> new FoodMachineBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final RegistrySupplier<Block> LIGHTCOLUMN_LEFT = register("lightcolumn_left", () -> new LightBoxBlock(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).noOcclusion()));
    public static final RegistrySupplier<Block> LIGHTCOLUMN_RIGHT = register("lightcolumn_right", () -> new LightBoxBlock(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).noOcclusion()));
    public static final RegistrySupplier<Block> TREATED_LIGHTCOLUMN_LEFT = register("treated_lightcolumn_left", () -> new LightBoxBlock(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).noOcclusion()));
    public static final RegistrySupplier<Block> TREATED_LIGHTCOLUMN_RIGHT = register("treated_lightcolumn_right", () -> new LightBoxBlock(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).noOcclusion()));
    public static final RegistrySupplier<Block> ARMCHAIR = registerDyed("armchair", () -> new ChairBaseBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));
    public static final RegistrySupplier<Block> ASTRAL_MAP = register("astral_map", () -> new AstralMapBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD).noOcclusion()));
    public static final RegistrySupplier<Block> CEILING_CANOPY  = register("ceiling_canopy", () -> new CeilingCanopyBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).noOcclusion()));
    public static final RegistrySupplier<Block> BRACHACKI_MONITOR = register("brachacki_monitor", () -> new MonitorBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistrySupplier<Block> FOLD_OUT_BED = register("fold_out_bed", AudBlocks::createBed);

    public static final RegistrySupplier<Block> SPECIMEN_JAR = registerSpecimenJar("specimen_jar",
            () -> new SpecimenJarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

    public static final RegistrySupplier<Block> SPECIMEN_JAR_ALLAY = registerSpecimenJar("specimen_jar_allay",
            () -> new SpecimenJarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

    public static final RegistrySupplier<Block> SPECIMEN_JAR_CREEPER = registerSpecimenJar("specimen_jar_creeper",
            () -> new SpecimenJarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

    public static final RegistrySupplier<Block> SPECIMEN_JAR_DRAGON = registerSpecimenJar("specimen_jar_dragon",
            () -> new SpecimenJarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

    public static final RegistrySupplier<Block> SPECIMEN_JAR_PIGLIN = registerSpecimenJar("specimen_jar_piglin",
            () -> new SpecimenJarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

    public static final RegistrySupplier<Block> SPECIMEN_JAR_SKELETON = registerSpecimenJar("specimen_jar_skeleton",
            () -> new SpecimenJarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

    public static final RegistrySupplier<Block> SPECIMEN_JAR_VEX = registerSpecimenJar("specimen_jar_vex",
            () -> new SpecimenJarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

    public static final RegistrySupplier<Block> SPECIMEN_JAR_WITHERSKELETON = registerSpecimenJar("specimen_jar_witherskeleton",
            () -> new SpecimenJarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

    public static final RegistrySupplier<Block> SPECIMEN_JAR_ZOMBIE = registerSpecimenJar("specimen_jar_zombie",
            () -> new SpecimenJarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

    //quartzzz
    public static final RegistrySupplier<Block> ZEITON_QUARTZ_BLOCK = register("zeiton_quartz_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK)));

    public static final RegistrySupplier<StairBlock> ZEITON_QUARTZ_STAIRS = register("zeiton_quartz_stairs",
            () -> new StairBlock(ZEITON_QUARTZ_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.QUARTZ_STAIRS)));

    public static final RegistrySupplier<SlabBlock> ZEITON_QUARTZ_SLAB = register("zeiton_quartz_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_SLAB)));

    public static final RegistrySupplier<Block> SMOOTH_ZEITON_QUARTZ_BLOCK = register("smooth_zeiton_quartz",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SMOOTH_QUARTZ)));

    public static final RegistrySupplier<StairBlock> SMOOTH_ZEITON_QUARTZ_STAIRS = register("smooth_zeiton_quartz_stairs",
            () -> new StairBlock(SMOOTH_ZEITON_QUARTZ_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SMOOTH_QUARTZ_STAIRS)));

    public static final RegistrySupplier<SlabBlock> SMOOTH_ZEITON_QUARTZ_SLAB = register("smooth_zeiton_quartz_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_SLAB)));

    public static final RegistrySupplier<Block> ZEITON_QUARTZ_BRICKS = register("zeiton_quartz_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BRICKS)));

    public static final RegistrySupplier<RotatedPillarBlock> ZEITON_QUARTZ_PILLAR = register("zeiton_quartz_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_PILLAR)));

    public static final RegistrySupplier<RotatedPillarBlock> CHISELED_ZEITON_QUARTZ_BLOCK = register("chiseled_zeiton_quartz_block",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_QUARTZ_BLOCK)));

    public static final RegistrySupplier<RotatedPillarBlock> TREATED_CHISELED_ZEITON_QUARTZ_BLOCK = register("treated_chiseled_zeiton_quartz_block",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_QUARTZ_BLOCK)));

    public static final RegistrySupplier<Block> TREATED_ZEITON_QUARTZ_BRICKS = register("treated_zeiton_quartz_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BRICKS)));


    public static final RegistrySupplier<RoundelOverlayBlock> ROUNDEL_OVERLAY_FULL = registerDyed("roundel_overlay_full",
            () -> new RoundelOverlayBlock(BlockBehaviour.Properties.copy(Blocks.VINE)));

    public static final RegistrySupplier<RoundelOverlayBlock> ROUNDEL_OVERLAY_HALF = registerDyed("roundel_overlay_half",
            () -> new RoundelOverlayBlock(BlockBehaviour.Properties.copy(Blocks.VINE)));

    public static final RegistrySupplier<DoorBlock> TREATED_ZEITON_QUARTZ_DOOR = register("treated_zeiton_quartz_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR), BlockSetType.ACACIA));

    public static final RegistrySupplier<DoorBlock> ZEITON_QUARTZ_DOOR = register("zeiton_quartz_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR), BlockSetType.ACACIA));

    public static final RegistrySupplier<Block> HATSTAND_OAK = register("hatstand_oak", () -> new HatStandBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR)));
    public static final RegistrySupplier<Block> HATSTAND_SPRUCE = register("hatstand_spruce", () -> new HatStandBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR)));
    public static final RegistrySupplier<Block> HATSTAND_BIRCH = register("hatstand_birch", () -> new HatStandBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR)));
    public static final RegistrySupplier<Block> HATSTAND_JUNGLE = register("hatstand_jungle", () -> new HatStandBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR)));
    public static final RegistrySupplier<Block> HATSTAND_ACACIA = register("hatstand_acacia", () -> new HatStandBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR)));
    public static final RegistrySupplier<Block> HATSTAND_DARK_OAK = register("hatstand_dark_oak", () -> new HatStandBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR)));
    public static final RegistrySupplier<Block> HATSTAND_MANGROVE = register("hatstand_mangrove", () -> new HatStandBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR)));
    public static final RegistrySupplier<Block> HATSTAND_CHERRY = register("hatstand_cherry", () -> new HatStandBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR)));
    public static final RegistrySupplier<Block> HATSTAND_PALE = register("hatstand_pale", () -> new HatStandBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR)));
    public static final RegistrySupplier<Block> HATSTAND_BAMBOO = register("hatstand_bamboo", () -> new HatStandBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR)));
    public static final RegistrySupplier<Block> HATSTAND_CRIMSON = register("hatstand_crimson", () -> new HatStandBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR)));
    public static final RegistrySupplier<Block> HATSTAND_WARPED = register("hatstand_warped", () -> new HatStandBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR)));

    public static final RegistrySupplier<Block> CABINET = register("cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR)));
    /**
     * Registers a Block and BlockItem to the ItemGroup of your choice
     */
    private static <T extends Block> RegistrySupplier<T> register(String id, Supplier<T> blockSupplier, CreativeModeTab itemGroup) {
        RegistrySupplier<T> RegistrySupplier = BLOCKS.register(id, blockSupplier);
        AudItems.ITEMS.register(id, () -> new BlockItem(RegistrySupplier.get(), new Item.Properties()));
        return RegistrySupplier;
    }





    /**
     * Registers a Block without a BlockItem
     * <br> Use when you need a special BlockItem. The BlockItem should be registered in RItems with the same registry name as the block
     */
    private static <T extends Block> RegistrySupplier<T> registerBlockOnly(String id, Supplier<T> blockSupplier) {
        return BLOCKS.register(id, blockSupplier);
    }

    /**
     * Registers a Block and BlockItem into the Main ItemGroup
     */
    private static <T extends Block> RegistrySupplier<T> register(String id, Supplier<T> blockSupplier) {
        RegistrySupplier<T> RegistrySupplier = BLOCKS.register(id, blockSupplier);
        AudItems.ITEMS.register(id, () -> new BlockItem(RegistrySupplier.get(), new Item.Properties()));
        return RegistrySupplier;
    }

    private static <T extends Block> RegistrySupplier<T> registerDyed(String id, Supplier<T> blockSupplier) {
        RegistrySupplier<T> RegistrySupplier = BLOCKS.register(id, blockSupplier);
        AudItems.ITEMS.register(id, () -> new DyedItemBlock(RegistrySupplier.get(), new Item.Properties()));
        return RegistrySupplier;
    }

    private static <T extends Block> RegistrySupplier<T> registerSpecimenJar(String id, Supplier<T> blockSupplier) {
        RegistrySupplier<T> RegistrySupplier = BLOCKS.register(id, blockSupplier);
        AudItems.ITEMS.register(id, () -> new SpecimenJarItemBlock(RegistrySupplier.get(), new Item.Properties()));
        return RegistrySupplier;
    }


    private static FoldOutBedBlock createBed() {
        return new FoldOutBedBlock(BlockBehaviour.Properties.of()
                .sound(SoundType.WOOD)
                .strength(0.4f)
                .noOcclusion()
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY));
    }

}
