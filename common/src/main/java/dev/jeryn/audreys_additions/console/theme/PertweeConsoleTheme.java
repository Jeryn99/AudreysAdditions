package dev.jeryn.audreys_additions.console.theme;

import net.minecraft.world.entity.EntityDimensions;
import org.joml.Vector3f;
import whocraft.tardis_refined.common.tardis.control.ControlSpecification;
import whocraft.tardis_refined.common.tardis.themes.console.ConsoleThemeDetails;
import whocraft.tardis_refined.registry.TRControlRegistry;

public class PertweeConsoleTheme extends ConsoleThemeDetails {

    @Override
    public ControlSpecification[] getControlSpecification() {
        return new ControlSpecification[] {
                new ControlSpecification(TRControlRegistry.THROTTLE, new Vector3f(0.14f, 0.52f, -0.61f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.READOUT, new Vector3f(0.52f, 0.50f, -0.42f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.READOUT, new Vector3f(0.60f, 0.50f, -0.28f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(-0.11f, 0.50f, -0.64f), EntityDimensions.scalable(0.06f, 0.13f)),
                new ControlSpecification(TRControlRegistry.FUEL, new Vector3f(-0.48f, 0.47f, -0.50f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.HANDBRAKE, new Vector3f(-0.82f, 0.50f, 0.39f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.FAST_RETURN, new Vector3f(0.14f, 0.44f, -0.89f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.ROTATE, new Vector3f(-0.68f, 0.55f, 0.53f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(0.63f, 0.38f, 0.72f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(0.17f, 0.38f, 0.88f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(-0.87f, 0.38f, -0.29f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(-0.20f, 0.38f, 0.88f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(-0.64f, 0.55f, 0.61f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(0.02f, 0.48f, 0.83f), EntityDimensions.scalable(0.06f, 0.19f)),
                new ControlSpecification(TRControlRegistry.X, new Vector3f(-0.11f, 0.61f, 0.68f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.Y, new Vector3f(-0.02f, 0.61f, 0.68f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.Z, new Vector3f(0.06f, 0.61f, 0.68f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.14f, 0.47f, -0.73f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.36f, 0.39f, -0.93f), EntityDimensions.scalable(0.06f, 0.13f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.23f, 0.41f, -0.82f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.20f, 0.47f, -0.61f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.60f, 0.38f, -0.75f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.21f, 0.45f, 0.74f), EntityDimensions.scalable(0.06f, 0.13f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.14f, 0.61f, 0.68f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.64f, 0.50f, -0.07f), EntityDimensions.scalable(0.13f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.26f, 0.44f, -0.68f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.39f, 0.39f, -0.93f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.72f, 0.38f, -0.62f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.78f, 0.38f, -0.51f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.94f, 0.38f, -0.23f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.94f, 0.38f, 0.21f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.82f, 0.38f, 0.47f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.53f, 0.42f, 0.57f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.59f, 0.55f, 0.69f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.54f, 0.55f, 0.77f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.67f, 0.36f, 0.75f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.90f, 0.48f, 0.22f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.54f, 0.50f, -0.28f), EntityDimensions.scalable(0.13f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.59f, 0.42f, -0.75f), EntityDimensions.scalable(0.13f, 0.06f)),
                new ControlSpecification(TRControlRegistry.DOOR_TOGGLE, new Vector3f(0.79f, 0.44f, 0.21f), EntityDimensions.scalable(0.06f, 0.06f))
        };
    }



}
