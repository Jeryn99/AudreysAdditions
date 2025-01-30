package dev.jeryn.audreys_additions.forge.mixin;

import dev.jeryn.audreys_additions.common.blockentity.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.extensions.IForgeBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import whocraft.tardis_refined.common.blockentity.console.GlobalConsoleBlockEntity;
import whocraft.tardis_refined.common.blockentity.device.ConsoleConfigurationBlockEntity;
import whocraft.tardis_refined.common.blockentity.door.BulkHeadDoorBlockEntity;
import whocraft.tardis_refined.common.blockentity.door.RootShellDoorBlockEntity;
import whocraft.tardis_refined.common.blockentity.life.EyeBlockEntity;
import whocraft.tardis_refined.common.blockentity.shell.GlobalShellBlockEntity;

@Mixin({KnossosChairBlockEntity.class, AstralMapBlockEntity.class, CeilingCanopyBlockEntity.class, FoldOutBedBlockEntity.class, FoodMachineBlockEntity.class})
public class BlockEntityRendererMixin extends BlockEntity implements IForgeBlockEntity {
    public BlockEntityRendererMixin(BlockEntityType<?> arg, BlockPos arg2, BlockState arg3) {
        super(arg, arg2, arg3);
    }

    public AABB getRenderBoundingBox() {
        return INFINITE_EXTENT_AABB;
    }
}
