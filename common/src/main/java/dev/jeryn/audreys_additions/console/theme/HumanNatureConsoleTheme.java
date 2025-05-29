package dev.jeryn.audreys_additions.console.theme;

import net.minecraft.world.entity.EntityDimensions;
import org.joml.Vector3f;
import whocraft.tardis_refined.common.tardis.control.ControlSpecification;
import whocraft.tardis_refined.common.tardis.themes.console.ConsoleThemeDetails;
import whocraft.tardis_refined.registry.TRControlRegistry;

public class HumanNatureConsoleTheme extends ConsoleThemeDetails {

    @Override
    public ControlSpecification[] getControlSpecification() {
        return new ControlSpecification[] {
                new ControlSpecification(TRControlRegistry.READOUT.get(), new Vector3f(-0.04f, 0.50f, -0.64f), EntityDimensions.scalable(0.19f, 0.19f)),
                new ControlSpecification(TRControlRegistry.THROTTLE.get(), new Vector3f(-0.51f, 0.53f, 0.24f), EntityDimensions.scalable(0.19f, 0.19f)),
                new ControlSpecification(TRControlRegistry.X.get(), new Vector3f(-0.70f, 0.44f, 0.17f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.Y.get(), new Vector3f(-0.62f, 0.44f, 0.36f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.Z.get(), new Vector3f(-0.54f, 0.44f, 0.49f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.INCREMENT.get(), new Vector3f(-0.23f, 0.44f, 0.63f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.ROTATE.get(), new Vector3f(0.21f, 0.50f, 0.68f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.RANDOM.get(), new Vector3f(-0.04f, 0.42f, 0.66f), EntityDimensions.scalable(0.19f, 0.19f)),
                new ControlSpecification(TRControlRegistry.RANDOM.get(), new Vector3f(-0.04f, 0.52f, 0.47f), EntityDimensions.scalable(0.19f, 0.19f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(-0.47f, 0.52f, -0.28f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.HANDBRAKE.get(), new Vector3f(-0.22f, 0.50f, -0.57f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.DIMENSION.get(), new Vector3f(0.17f, 0.38f, -1.01f), EntityDimensions.scalable(0.25f, 0.25f)),
                new ControlSpecification(TRControlRegistry.DIMENSION.get(), new Vector3f(0.55f, 0.44f, -0.39f), EntityDimensions.scalable(0.19f, 0.19f)),
                new ControlSpecification(TRControlRegistry.FAST_RETURN.get(), new Vector3f(0.76f, 0.47f, 0.12f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.DOOR_TOGGLE.get(), new Vector3f(0.48f, 0.47f, 0.61f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.FUEL.get(), new Vector3f(0.52f, 0.47f, 0.38f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(0.22f, 0.50f, -0.64f), EntityDimensions.scalable(0.13f, 0.13f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW.get(), new Vector3f(-0.67f, 0.44f, -0.37f), EntityDimensions.scalable(0.13f, 0.13f))
        };
    }


}
