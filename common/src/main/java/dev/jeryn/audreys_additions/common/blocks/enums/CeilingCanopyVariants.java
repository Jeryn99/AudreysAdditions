package dev.jeryn.audreys_additions.common.blocks.enums;

import net.minecraft.util.StringRepresentable;

public enum CeilingCanopyVariants implements StringRepresentable {
    NORMAL("normal"),
    NORMAL_HANGING("normal_hanging"),
    STONE("stone"),
    STONE_HANGING("stone_hanging"),
    TREMAS("tremas"),
    TREMAS_HANGING("tremas_hanging");

    private final String name;

    private CeilingCanopyVariants(String string2) {
        this.name = string2;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}
