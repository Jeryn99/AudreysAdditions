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
                new ControlSpecification(TRControlRegistry.DOOR_TOGGLE.get(), new Vector3f(0.76f, 0.58f, 0.44f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.THROTTLE.get(), new Vector3f(0.16f, 0.67f, -0.70f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.READOUT.get(), new Vector3f(0.59f, 0.65f, -0.49f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.READOUT.get(), new Vector3f(0.68f, 0.65f, -0.33f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.RANDOM.get(), new Vector3f(-0.13f, 0.65f, -0.69f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.FUEL.get(), new Vector3f(-0.56f, 0.61f, -0.58f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.HANDBRAKE.get(), new Vector3f(-0.96f, 0.65f, 0.45f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.FAST_RETURN.get(), new Vector3f(0.16f, 0.58f, -1.03f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.ROTATE.get(), new Vector3f(-0.79f, 0.70f, 0.61f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(0.71f, 0.51f, 0.82f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(0.19f, 0.51f, 1.00f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(-0.24f, 0.51f, 1.00f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(-1.01f, 0.51f, -0.35f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.DIMENSION.get(), new Vector3f(-0.74f, 0.70f, 0.70f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.INCREMENT.get(), new Vector3f(0.01f, 0.63f, 1.03f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.X.get(), new Vector3f(-0.13f, 0.78f, 0.77f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.Y.get(), new Vector3f(-0.03f, 0.78f, 0.77f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.Z.get(), new Vector3f(0.06f, 0.78f, 0.77f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.16f, 0.61f, -0.85f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.45f, 0.52f, -1.04f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.45f, 0.52f, -1.08f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.24f, 0.61f, -0.70f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.31f, 0.58f, -0.79f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.82f, 0.51f, -0.72f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.89f, 0.51f, -0.60f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(1.07f, 0.51f, -0.27f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(1.07f, 0.51f, 0.23f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.93f, 0.51f, 0.54f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.61f, 0.56f, 0.64f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.23f, 0.60f, 0.84f), EntityDimensions.scalable(0.07f, 0.14f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.16f, 0.78f, 0.77f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.69f, 0.70f, 0.79f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.63f, 0.70f, 0.88f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.78f, 0.49f, 0.86f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-1.05f, 0.63f, 0.25f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.71f, 0.65f, -0.11f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.57f, 0.65f, -0.33f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.64f, 0.56f, -0.85f), EntityDimensions.scalable(0.07f, 0.07f))
        };
    }


}
