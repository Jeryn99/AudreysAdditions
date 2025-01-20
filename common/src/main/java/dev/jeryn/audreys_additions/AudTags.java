package dev.jeryn.audreys_additions;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.Structure;

public class AudTags {

    public static TagKey<Item> FUEL_ITEMS = makeItem(AudreysAdditions.MODID, "food_machine_fuel");


    private static TagKey<Item> makeItem(String domain, String path) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(domain, path));
    }

    private static TagKey<Block> makeBlock(String domain, String path) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(domain, path));
    }

    private static TagKey<EntityType<?>> makeEntityType(String domain, String path) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(domain, path));
    }

    private static TagKey<Structure> makeStructure(String domain, String path) {
        return TagKey.create(Registries.STRUCTURE, new ResourceLocation(domain, path));
    }

    private static TagKey<Biome> makeBiome(String domain, String path) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(domain, path));
    }

}