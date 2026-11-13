package dev.jeryn.audreys_additions.console.theme;

import net.minecraft.world.entity.EntityDimensions;
import org.joml.Vector3f;
import whocraft.tardis_refined.common.tardis.control.ControlSpecification;
import whocraft.tardis_refined.common.tardis.themes.console.ConsoleThemeDetails;
import whocraft.tardis_refined.registry.TRControlRegistry;

import whocraft.tardis_refined.patterns.ConsolePattern;

public class NewberyConsoleTheme extends ConsoleThemeDetails {

    @Override
    public ControlSpecification[] getControlSpecification(ConsolePattern consolePattern) {
        return new ControlSpecification[] {
                new ControlSpecification(TRControlRegistry.THROTTLE, new Vector3f(0.315625f, 0.46875f, -0.325f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.X, new Vector3f(0.35625f, 0.5718749999999999f, -0.06874999999999999f), EntityDimensions.scalable(0.03125f, 0.03125f)),
                new ControlSpecification(TRControlRegistry.Y, new Vector3f(0.325f, 0.5718749999999999f, -0.121875f), EntityDimensions.scalable(0.03125f, 0.03125f)),
                new ControlSpecification(TRControlRegistry.Z, new Vector3f(0.29375f, 0.5718749999999999f, -0.17812499999999998f), EntityDimensions.scalable(0.03125f, 0.03125f)),
                new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(0.284375f, 0.53125f, 0.328125f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.ROTATE, new Vector3f(0.2625f, 0.5718749999999999f, -0.23125f), EntityDimensions.scalable(0.03125000000000003f, 0.03125f)),
                new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(-0.278125f, 0.5f, -0.23125f), EntityDimensions.scalable(0.09375f, 0.09375f)),
                new ControlSpecification(TRControlRegistry.DOOR_TOGGLE, new Vector3f(-0.346875f, 0.53125f, -0.0625f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(-0.28125f, 0.5f, 0.109375f), EntityDimensions.scalable(0.09375f, 0.09375f)),
                new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(-0.21875f, 0.5f, 0.203125f), EntityDimensions.scalable(0.09375f, 0.09375f)),
                new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(-0.4f, 0.46875f, 0.125f), EntityDimensions.scalable(0.03125f, 0.03125f)),
                new ControlSpecification(TRControlRegistry.FAST_RETURN, new Vector3f(-0.365625f, 0.46875f, 0.209375f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.READOUT, new Vector3f(-0.075f, 0.46875f, 0.39375f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.HANDBRAKE, new Vector3f(-0.303125f, 0.46875f, 0.284375f), EntityDimensions.scalable(0.03125f, 0.03125f)),
                new ControlSpecification(TRControlRegistry.FUEL, new Vector3f(-0.10625f, 0.46875f, -0.35625f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.THROTTLE, new Vector3f(0.284375f, 0.515625f, -0.29375f), EntityDimensions.scalable(0.0625f, 0.0625f))
        };
    }
}

