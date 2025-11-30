package dev.jeryn.audreys_additions.console.theme;

import net.minecraft.world.entity.EntityDimensions;
import org.joml.Vector3f;
import whocraft.tardis_refined.common.tardis.control.ControlSpecification;
import whocraft.tardis_refined.common.tardis.themes.console.ConsoleThemeDetails;
import whocraft.tardis_refined.registry.TRControlRegistry;

public class ChronotisConsoleTheme extends ConsoleThemeDetails {

    @Override
    public ControlSpecification[] getControlSpecification() {
        return new ControlSpecification[] {
                new ControlSpecification(TRControlRegistry.THROTTLE, new Vector3f(0.20625f, 0.75f, -0.7f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.X, new Vector3f(-0.012499999999999997f, 1.359375f, -0.559375f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.Y, new Vector3f(-0.012499999999999997f, 1.28125f, -0.590625f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.Z, new Vector3f(-0.23125f, 1.203125f, -0.6375f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(0.33125f, 1.09375f, -0.5125f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.ROTATE, new Vector3f(-0.04375f, 0.890625f, -0.7f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(0.3f, -0.25f, -0.325f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                new ControlSpecification(TRControlRegistry.DOOR_TOGGLE, new Vector3f(-0.16875f, 0.796875f, -0.809375f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(-0.075f, 0.125f, -0.325f), EntityDimensions.scalable(0.25f, 0.25f)),
                new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(0.20625f, 1.09375f, -0.5125f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.FAST_RETURN, new Vector3f(-0.04375f, 0.78125f, -0.746875f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.READOUT, new Vector3f(-0.45f, 1.5f, -0.45f), EntityDimensions.scalable(1f, 1f)),
                new ControlSpecification(TRControlRegistry.HANDBRAKE, new Vector3f(-0.29375f, 0.8125f, -0.7625f), EntityDimensions.scalable(0.0625f, 0.0625f)),
                new ControlSpecification(TRControlRegistry.FUEL, new Vector3f(0.33125f, 0.75f, -0.7f), EntityDimensions.scalable(0.0625f, 0.0625f))
        };
    }




}
