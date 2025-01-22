package dev.jeryn.audreys_additions.blockentity;

import dev.jeryn.audreys_additions.common.registry.AudBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Arrays;
import java.util.List;

public class KnossosChairBlockEntity extends ChairBlockEntity {

    private String currentVariant;

    private static final List<String> VARIANTS = Arrays.asList(
            "knossos_throne",
            "knossos_throne_acacia",
            "knossos_throne_bamboo",
            "knossos_throne_birch",
            "knossos_throne_cherry",
            "knossos_throne_crimson",
            "knossos_throne_dark_oak",
            "knossos_throne_jungle",
            "knossos_throne_mangrove",
            "knossos_throne_oak",
            "knossos_throne_pale",
            "knossos_throne_warped"
    );

    public KnossosChairBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(AudBlockEntities.KNOSSOS_THRONE.get(), blockPos, blockState);
        this.currentVariant = VARIANTS.get(0);
    }


    public String getCurrentVariant() {
        return currentVariant;
    }

    public void cycleVariant() {
        int currentIndex = VARIANTS.indexOf(currentVariant);
        int nextIndex = (currentIndex + 1) % VARIANTS.size();
        this.currentVariant = VARIANTS.get(nextIndex);
        setChanged();
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("currentVariant", currentVariant);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("currentVariant")) {
            this.currentVariant = tag.getString("currentVariant");
        }
    }
}