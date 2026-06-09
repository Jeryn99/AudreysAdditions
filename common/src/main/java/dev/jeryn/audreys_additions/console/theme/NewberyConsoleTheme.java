package dev.jeryn.audreys_additions.console.theme;

import net.minecraft.world.entity.EntityDimensions;
import org.joml.Vector3f;
import whocraft.tardis_refined.common.tardis.control.ControlSpecification;
import whocraft.tardis_refined.common.tardis.themes.console.ConsoleThemeDetails;
import whocraft.tardis_refined.registry.TRControlRegistry;

public class NewberyConsoleTheme extends ConsoleThemeDetails {

    @Override
    public ControlSpecification[] getControlSpecification() {
        return new ControlSpecification[] {
                new ControlSpecification(TRControlRegistry.THROTTLE, new Vector3f(0.315625f, 0.46875f, -0.325f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.X, new Vector3f(0.35625f, 0.5718749999999999f, -0.06874999999999999f), EntityDimensions.scalable(0.03125f, 0.03125f)),
                new ControlSpecification(TRControlRegistry.Y, new Vector3f(0.325f, 0.5718749999999999f, -0.121875f), EntityDimensions.scalable(0.03125f, 0.03125f)),
                new ControlSpecification(TRControlRegistry.Z, new Vector3f(0.29375f, 0.5718749999999999f, -0.17812499999999998f), EntityDimensions.scalable(0.03125f, 0.03125f)),
                new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(0.284375f, 0.53125f, 0.328125f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.ROTATE, new Vector3f(0.2625f, 0.5718749999999999f, -0.23125f), EntityDimensions.scalable(0.03125000000000003f, 0.03125f)),
                new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(-0.278125f, 0.5f, -0.23125f), EntityDimensions.scalable(0.09375f, 0.09375f)),
                new ControlSpecification(TRControlRegistry.DOOR_TOGGLE, new Vector3f(-0.346875f, 0.53125f, -0.0625f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(-0.340625f, 0.453125f, 0.20625f), EntityDimensions.scalable(0.09375f, 0.09375f)),
                new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(-0.41875f, 0.484375f, 0.09375f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.FAST_RETURN, new Vector3f(-0.340625f, 0.53125f, 0.096875f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.READOUT, new Vector3f(-0.075f, 0.46875f, 0.39375f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.HANDBRAKE, new Vector3f(-0.29375f, 0.421875f, 0.3f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.FUEL, new Vector3f(-0.10625f, 0.46875f, -0.35625f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.THROTTLE, new Vector3f(0.284375f, 0.515625f, -0.29375f), EntityDimensions.scalable(0.0625f, 0.0625f))
        };
    }
}
