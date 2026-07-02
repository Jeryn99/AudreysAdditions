package dev.jeryn.audreys_additions.console.theme;

import net.minecraft.world.entity.EntityDimensions;
import org.joml.Vector3f;
import whocraft.tardis_refined.common.tardis.control.ControlSpecification;
import whocraft.tardis_refined.common.tardis.themes.console.ConsoleThemeDetails;
import whocraft.tardis_refined.registry.TRControlRegistry;

import whocraft.tardis_refined.patterns.ConsolePattern;

public class SilenceConsoleTheme extends ConsoleThemeDetails {

    @Override
    public ControlSpecification[] getControlSpecification(ConsolePattern consolePattern) {
        return new ControlSpecification[] {
                new ControlSpecification(TRControlRegistry.THROTTLE, new Vector3f(-0.04375f, 0.6875f, -1.1375f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                new ControlSpecification(TRControlRegistry.X, new Vector3f(0.190625f, 0.75f, -0.95f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.Y, new Vector3f(0.018750000000000003f, 0.875f, -0.91875f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.Z, new Vector3f(-0.153125f, 0.75f, -0.95f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(-1.1375f, 0.6875f, -0.04375f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                new ControlSpecification(TRControlRegistry.ROTATE, new Vector3f(1.175f, 0.53125f, -0.075f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(1.175f, 0.53125f, 0.1125f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.DOOR_TOGGLE, new Vector3f(-0.075f, 0.53125f, 1.175f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(1.05f, 0.6875f, -0.04375f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(-1.1375f, 0.53125f, -0.075f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.FAST_RETURN, new Vector3f(-1.1375f, 0.53125f, 0.1125f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.READOUT, new Vector3f(0.89375f, 0.84375f, -0.012499999999999997f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.HANDBRAKE, new Vector3f(-0.012499999999999997f, 0.84375f, 0.89375f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.FUEL, new Vector3f(-0.04375f, 0.6875f, 1.05f), EntityDimensions.scalable(0.1875f, 0.1875f))
        };
    }





}

