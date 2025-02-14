package dev.jeryn.audreys_additions.common.registry;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.common.blocks.*;
import dev.jeryn.audreys_additions.common.item.DyedItemBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;

import java.util.function.Supplier;

public class AudBlocks {

    public static final DeferredRegistry<Block> BLOCKS = DeferredRegistry.create(AudreysAdditions.MODID, Registries.BLOCK);

    public static final RegistrySupplier<Block> KNOSSOS_THRONE = register("knossos_throne", () -> new KnossosChairBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final RegistrySupplier<Block> LIMINTON_MONITOR = register("liminton_monitor", () -> new MonitorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final RegistrySupplier<Block> FOOD_MACHINE = register("food_machine", () -> new FoodMachineBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final RegistrySupplier<Block> LIGHTCOLUMN_LEFT = register("lightcolumn_left", () -> new LightBoxBlock(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).noOcclusion()));
    public static final RegistrySupplier<Block> LIGHTCOLUMN_RIGHT = register("lightcolumn_right", () -> new LightBoxBlock(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).noOcclusion()));
    public static final RegistrySupplier<Block> ARMCHAIR = registerDyed("armchair", () -> new ChairBaseBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD).noOcclusion()));
    public static final RegistrySupplier<Block> ASTRAL_MAP = register("astral_map", () -> new AstralMapBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD).noOcclusion()));
    public static final RegistrySupplier<Block> CEILING_CANOPY  = register("ceiling_canopy", () -> new CeilingCanopyBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).noOcclusion()));
    public static final RegistrySupplier<Block> BRACHACKI_MONITOR = register("brachacki_monitor", () -> new MonitorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final RegistrySupplier<Block> FOLD_OUT_BED = register("fold_out_bed", AudBlocks::createBed);



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


    private static FoldOutBedBlock createBed() {
        return new FoldOutBedBlock(BlockBehaviour.Properties.of()
                .sound(SoundType.WOOD)
                .strength(0.2f)
                .noOcclusion()
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY));
    }

}
