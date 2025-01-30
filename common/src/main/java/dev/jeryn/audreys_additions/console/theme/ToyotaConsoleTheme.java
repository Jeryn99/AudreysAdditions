package dev.jeryn.audreys_additions.console.theme;

import net.minecraft.world.entity.EntityDimensions;
import org.joml.Vector3f;
import whocraft.tardis_refined.common.tardis.control.ControlSpecification;
import whocraft.tardis_refined.common.tardis.themes.console.ConsoleThemeDetails;
import whocraft.tardis_refined.registry.TRControlRegistry;

public class ToyotaConsoleTheme extends ConsoleThemeDetails {

    @Override
    public ControlSpecification[] getControlSpecification() {
        return new ControlSpecification[] {
                new ControlSpecification(TRControlRegistry.THROTTLE.get(), new Vector3f(0.24f, 0.69f, 0.93f), EntityDimensions.scalable(0.25f, 0.25f)),
                new ControlSpecification(TRControlRegistry.HANDBRAKE.get(), new Vector3f(-0.39f, 0.56f, 0.99f), EntityDimensions.scalable(0.19f, 0.19f)),
                new ControlSpecification(TRControlRegistry.DOOR_TOGGLE.get(), new Vector3f(-0.34f, 0.72f, -1.04f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(0.68f, 0.63f, -0.51f), EntityDimensions.scalable(0.25f, 0.25f)),
                new ControlSpecification(TRControlRegistry.ROTATE.get(), new Vector3f(-0.89f, 0.56f, -0.57f), EntityDimensions.scalable(0.38f, 0.38f)),
                new ControlSpecification(TRControlRegistry.DIMENSION.get(), new Vector3f(-0.14f, 0.69f, -0.92f), EntityDimensions.scalable(0.19f, 0.19f)),
                new ControlSpecification(TRControlRegistry.X.get(), new Vector3f(-0.12f, 0.75f, 0.68f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.Y.get(), new Vector3f(-0.03f, 0.75f, 0.71f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.Z.get(), new Vector3f(0.07f, 0.75f, 0.68f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.INCREMENT.get(), new Vector3f(-0.76f, 0.66f, 0.28f), EntityDimensions.scalable(0.19f, 0.19f)),
                new ControlSpecification(TRControlRegistry.RANDOM.get(), new Vector3f(0.64f, 0.75f, 0.21f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.RANDOM.get(), new Vector3f(0.77f, 0.72f, 0.21f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.RANDOM.get(), new Vector3f(0.61f, 0.72f, 0.55f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.RANDOM.get(), new Vector3f(0.77f, 0.63f, 0.42f), EntityDimensions.scalable(0.19f, 0.19f)),
                new ControlSpecification(TRControlRegistry.RANDOM.get(), new Vector3f(1.08f, 0.56f, 0.27f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.RANDOM.get(), new Vector3f(0.77f, 0.56f, 0.77f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.READOUT.get(), new Vector3f(0.71f, 1.22f, -0.47f), EntityDimensions.scalable(0.25f, 0.25f)),
                new ControlSpecification(TRControlRegistry.READOUT.get(), new Vector3f(-0.73f, 1.22f, 0.58f), EntityDimensions.scalable(0.25f, 0.25f)),
                new ControlSpecification(TRControlRegistry.FUEL.get(), new Vector3f(-0.64f, 0.78f, -0.14f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.FAST_RETURN.get(), new Vector3f(0.16f, 0.75f, 0.68f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.DIMENSION.get(), new Vector3f(0.05f, 0.69f, -0.92f), EntityDimensions.scalable(0.19f, 0.19f)),
                new ControlSpecification(TRControlRegistry.RANDOM.get(), new Vector3f(0.52f, 0.75f, 0.46f), EntityDimensions.scalable(0.13f, 0.13f))
        };
    }


}
