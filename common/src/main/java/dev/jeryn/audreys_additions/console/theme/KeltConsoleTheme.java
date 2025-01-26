package dev.jeryn.audreys_additions.console.theme;

import net.minecraft.world.entity.EntityDimensions;
import org.joml.Vector3f;
import whocraft.tardis_refined.common.tardis.control.ControlSpecification;
import whocraft.tardis_refined.common.tardis.themes.console.ConsoleThemeDetails;
import whocraft.tardis_refined.registry.TRControlRegistry;

public class KeltConsoleTheme extends ConsoleThemeDetails {

    @Override
    public ControlSpecification[] getControlSpecification() {
        return new ControlSpecification[]{
                new ControlSpecification(TRControlRegistry.DOOR_TOGGLE.get(), new Vector3f(-0.27f, 0.51f, -0.99f), EntityDimensions.scalable(0.07f, 0.18f)),
                new ControlSpecification(TRControlRegistry.READOUT.get(), new Vector3f(0.66f, 0.58f, -0.42f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.X.get(), new Vector3f(-0.38f, 0.51f, 0.91f), EntityDimensions.scalable(0.29f, 0.07f)),
                new ControlSpecification(TRControlRegistry.Y.get(), new Vector3f(-0.38f, 0.51f, 1.02f), EntityDimensions.scalable(0.11f, 0.07f)),
                new ControlSpecification(TRControlRegistry.Z.get(), new Vector3f(-0.24f, 0.51f, 1.02f), EntityDimensions.scalable(0.14f, 0.07f)),
                new ControlSpecification(TRControlRegistry.DIMENSION.get(), new Vector3f(-0.02f, 0.51f, 0.95f), EntityDimensions.scalable(0.14f, 0.11f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(-0.70f, 0.58f, -0.42f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.THROTTLE.get(), new Vector3f(-0.38f, 0.51f, -0.99f), EntityDimensions.scalable(0.07f, 0.18f)),
                new ControlSpecification(TRControlRegistry.INCREMENT.get(), new Vector3f(-0.70f, 0.51f, 0.77f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.ROTATE.get(), new Vector3f(-0.67f, 0.51f, 0.88f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.RANDOM.get(), new Vector3f(-0.96f, 0.51f, -0.31f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.FAST_RETURN.get(), new Vector3f(0.45f, 0.61f, -0.52f), EntityDimensions.scalable(0.07f, 0.11f)),
                new ControlSpecification(TRControlRegistry.HANDBRAKE.get(), new Vector3f(1.09f, 0.51f, 0.18f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.FUEL.get(), new Vector3f(-0.06f, 0.65f, -0.52f), EntityDimensions.scalable(0.32f, 0.14f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.09f, 0.58f, -0.67f), EntityDimensions.scalable(0.25f, 0.14f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.30f, 0.54f, -0.81f), EntityDimensions.scalable(0.11f, 0.14f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.88f, 0.51f, -0.52f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.52f, 0.58f, -0.67f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.76f, 0.51f, -0.69f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.88f, 0.51f, 0.34f), EntityDimensions.scalable(0.07f, 0.14f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.45f, 0.65f, 0.25f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.83f, 0.54f, 0.14f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-1.03f, 0.51f, 0.27f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.23f, 0.61f, 0.64f), EntityDimensions.scalable(0.11f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.73f, 0.51f, -0.67f), EntityDimensions.scalable(0.07f, 0.14f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.82f, 0.51f, -0.52f), EntityDimensions.scalable(0.07f, 0.14f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.82f, 0.54f, -0.20f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.80f, 0.56f, -0.09f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.46f, 0.65f, 0.21f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.63f, 0.58f, 0.48f), EntityDimensions.scalable(0.07f, 0.14f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.77f, 0.58f, 0.27f), EntityDimensions.scalable(0.07f, 0.14f))
        };
    }


}
