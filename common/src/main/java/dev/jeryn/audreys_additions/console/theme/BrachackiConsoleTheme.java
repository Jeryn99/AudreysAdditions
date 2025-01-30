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
                new ControlSpecification(TRControlRegistry.THROTTLE.get(), new Vector3f(0.32f, 0.56f, -0.94f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.HANDBRAKE.get(), new Vector3f(0.10f, 0.56f, -0.96f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.FAST_RETURN.get(), new Vector3f(-0.20f, 0.65f, -0.58f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.DOOR_TOGGLE.get(), new Vector3f(1.00f, 0.47f, 0.34f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.INCREMENT.get(), new Vector3f(0.37f, 0.51f, 0.97f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.X.get(), new Vector3f(0.57f, 0.65f, 0.41f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.Y.get(), new Vector3f(0.70f, 0.61f, 0.50f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.Z.get(), new Vector3f(0.84f, 0.58f, 0.57f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.ROTATE.get(), new Vector3f(-0.56f, 0.65f, -0.42f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.ROTATE.get(), new Vector3f(-0.63f, 0.65f, -0.27f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(-0.74f, 0.51f, -0.78f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(-1.03f, 0.51f, -0.27f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(-1.08f, 0.51f, 0.12f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(0.71f, 0.58f, 0.12f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(0.75f, 0.49f, -0.67f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.RANDOM.get(), new Vector3f(-0.74f, 0.51f, 0.55f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.DIMENSION.get(), new Vector3f(-0.35f, 0.58f, -0.92f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.READOUT.get(), new Vector3f(-0.85f, 0.56f, 0.21f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.FUEL.get(), new Vector3f(0.77f, 0.65f, -0.13f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.46f, 0.59f, -0.49f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.09f, 0.47f, -1.03f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.85f, 0.54f, -0.49f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.09f, 0.49f, 1.02f), EntityDimensions.scalable(0.03f, 0.03f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.59f, 0.51f, -0.79f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.98f, 0.49f, -0.35f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.61f, 0.60f, -0.33f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.95f, 0.54f, -0.17f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(1.09f, 0.51f, -0.11f), EntityDimensions.scalable(0.07f, 0.07f)),
                new ControlSpecification(TRControlRegistry.DIMENSION.get(), new Vector3f(-0.20f, 0.58f, -0.92f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.31f, 0.47f, -1.03f), EntityDimensions.scalable(0.14f, 0.14f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.02f, 0.49f, 1.02f), EntityDimensions.scalable(0.03f, 0.03f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.12f, 0.49f, 1.02f), EntityDimensions.scalable(0.03f, 0.03f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.05f, 0.49f, 1.02f), EntityDimensions.scalable(0.03f, 0.03f))
        };
    }


}
