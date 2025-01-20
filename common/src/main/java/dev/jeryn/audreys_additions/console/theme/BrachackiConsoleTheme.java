package dev.jeryn.audreys_additions.console.theme;

import net.minecraft.world.entity.EntityDimensions;
import org.joml.Vector3f;
import whocraft.tardis_refined.common.tardis.control.ControlSpecification;
import whocraft.tardis_refined.common.tardis.themes.console.ConsoleThemeDetails;
import whocraft.tardis_refined.registry.TRControlRegistry;

public class BrachackiConsoleTheme extends ConsoleThemeDetails {

    @Override
    public ControlSpecification[] getControlSpecification() {
        return new ControlSpecification[] {
                new ControlSpecification(TRControlRegistry.THROTTLE.get(), new Vector3f(0.28f, 0.42f, -0.81f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.HANDBRAKE.get(), new Vector3f(0.10f, 0.42f, -0.82f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.FAST_RETURN.get(), new Vector3f(-0.17f, 0.50f, -0.51f), EntityDimensions.scalable(0.06f, 0.13f)),
                new ControlSpecification(TRControlRegistry.DOOR_TOGGLE.get(), new Vector3f(0.88f, 0.34f, 0.30f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.INCREMENT.get(), new Vector3f(0.33f, 0.38f, 0.85f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.X.get(), new Vector3f(0.50f, 0.50f, 0.36f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.Y.get(), new Vector3f(0.61f, 0.47f, 0.44f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.Z.get(), new Vector3f(0.74f, 0.44f, 0.50f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.ROTATE.get(), new Vector3f(-0.48f, 0.50f, -0.36f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.ROTATE.get(), new Vector3f(-0.54f, 0.50f, -0.23f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(-0.64f, 0.38f, -0.67f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(-0.89f, 0.38f, -0.23f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(-0.93f, 0.38f, 0.11f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(0.63f, 0.44f, 0.11f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(0.66f, 0.36f, -0.57f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.RANDOM.get(), new Vector3f(-0.64f, 0.38f, 0.46f), EntityDimensions.scalable(0.13f, 0.19f)),
                new ControlSpecification(TRControlRegistry.DIMENSION.get(), new Vector3f(-0.29f, 0.44f, -0.79f), EntityDimensions.scalable(0.25f, 0.13f)),
                new ControlSpecification(TRControlRegistry.READOUT.get(), new Vector3f(-0.73f, 0.42f, 0.19f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.FUEL.get(), new Vector3f(0.68f, 0.50f, -0.11f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.38f, 0.44f, -0.42f), EntityDimensions.scalable(0.13f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.26f, 0.34f, -0.89f), EntityDimensions.scalable(0.31f, 0.13f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.73f, 0.41f, -0.42f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.07f, 0.36f, 0.89f), EntityDimensions.scalable(0.25f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.52f, 0.38f, -0.68f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.86f, 0.36f, -0.29f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.53f, 0.45f, -0.28f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.83f, 0.41f, -0.14f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.96f, 0.38f, -0.09f), EntityDimensions.scalable(0.06f, 0.06f))
        };
    }





}
