package dev.jeryn.audreys_additions.console.theme;

import net.minecraft.world.entity.EntityDimensions;
import org.joml.Vector3f;
import whocraft.tardis_refined.common.tardis.control.ControlSpecification;
import whocraft.tardis_refined.common.tardis.themes.console.ConsoleThemeDetails;
import whocraft.tardis_refined.registry.TRControlRegistry;

import whocraft.tardis_refined.patterns.ConsolePattern;

public class ToyotaConsoleTheme extends ConsoleThemeDetails {

    @Override
    public ControlSpecification[] getControlSpecification(ConsolePattern consolePattern) {
        return new ControlSpecification[] {
                new ControlSpecification(TRControlRegistry.THROTTLE, new Vector3f(0.2375f, 0.6875f, 0.925f), EntityDimensions.scalable(0.25f, 0.25f)),
                new ControlSpecification(TRControlRegistry.HANDBRAKE, new Vector3f(-0.3875f, 0.5625f, 0.9875f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                new ControlSpecification(TRControlRegistry.DOOR_TOGGLE, new Vector3f(-0.340625f, 0.71875f, -1.04375f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(0.675f, 0.625f, -0.5125f), EntityDimensions.scalable(0.25f, 0.25f)),
                new ControlSpecification(TRControlRegistry.ROTATE, new Vector3f(-0.8875f, 0.5625f, -0.575f), EntityDimensions.scalable(0.375f, 0.375f)),
                new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(-0.1375f, 0.6875f, -0.91875f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                new ControlSpecification(TRControlRegistry.X, new Vector3f(-0.121875f, 0.75f, 0.675f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.Y, new Vector3f(-0.028124999999999997f, 0.75f, 0.70625f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.Z, new Vector3f(0.065625f, 0.75f, 0.675f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(-0.7625f, 0.65625f, 0.284375f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(0.64375f, 0.75f, 0.20625f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(0.76875f, 0.71875f, 0.20625f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(0.6125f, 0.71875f, 0.55f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(0.76875f, 0.625f, 0.425f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(1.08125f, 0.5625f, 0.26875f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(0.76875f, 0.5625f, 0.76875f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.FUEL, new Vector3f(-0.6375f, 0.78125f, -0.1375f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.FAST_RETURN, new Vector3f(0.159375f, 0.75f, 0.675f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(0.05f, 0.6875f, -0.91875f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(0.51875f, 0.75f, 0.45625f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.READOUT, new Vector3f(0.70625f, 1.203125f, 0.284375f), EntityDimensions.scalable(0.25f, 0.25f)),
                new ControlSpecification(TRControlRegistry.READOUT, new Vector3f(-0.73125f, 1.234375f, -0.48125f), EntityDimensions.scalable(0.25f, 0.25f))
        };
    }



}

