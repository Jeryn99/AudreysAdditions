package dev.jeryn.audreys_additions.common.registry;

import dev.jeryn.audreys_additions.AudreysAdditions;
import dev.jeryn.audreys_additions.blocks.ChairBlock;
import dev.jeryn.audreys_additions.blocks.MonitorBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import whocraft.tardis_refined.registry.DeferredRegistry;
import whocraft.tardis_refined.registry.RegistrySupplier;

import java.util.function.Supplier;

public class AudBlocks {

    public static final DeferredRegistry<Block> BLOCKS = DeferredRegistry.create(AudreysAdditions.MODID, Registries.BLOCK);

    public static final RegistrySupplier<Block> KNOSSOS_THRONE = register("knossos_throne", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final RegistrySupplier<Block> LIMINTON_MONITOR = register("liminton_monitor", () -> new MonitorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));


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

}
