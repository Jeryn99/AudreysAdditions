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
                new ControlSpecification(TRControlRegistry.THROTTLE.get(), new Vector3f(0.33f, 0.47f, -0.33f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.X.get(), new Vector3f(0.37f, 0.57f, -0.05f), EntityDimensions.scalable(0.03f, 0.03f)),
                new ControlSpecification(TRControlRegistry.Y.get(), new Vector3f(0.34f, 0.57f, -0.11f), EntityDimensions.scalable(0.03f, 0.03f)),
                new ControlSpecification(TRControlRegistry.Z.get(), new Vector3f(0.31f, 0.57f, -0.16f), EntityDimensions.scalable(0.03f, 0.03f)),
                new ControlSpecification(TRControlRegistry.INCREMENT.get(), new Vector3f(0.28f, 0.52f, 0.34f), EntityDimensions.scalable(0.03f, 0.03f)),
                new ControlSpecification(TRControlRegistry.ROTATE.get(), new Vector3f(0.28f, 0.57f, -0.22f), EntityDimensions.scalable(0.03f, 0.03f)),
                new ControlSpecification(TRControlRegistry.RANDOM.get(), new Vector3f(-0.28f, 0.50f, -0.23f), EntityDimensions.scalable(0.09f, 0.09f)),
                new ControlSpecification(TRControlRegistry.DOOR_TOGGLE.get(), new Vector3f(-0.33f, 0.55f, -0.05f), EntityDimensions.scalable(0.03f, 0.03f)),
                new ControlSpecification(TRControlRegistry.MONITOR.get(), new Vector3f(-0.34f, 0.45f, 0.21f), EntityDimensions.scalable(0.09f, 0.09f)),
                new ControlSpecification(TRControlRegistry.DIMENSION.get(), new Vector3f(-0.40f, 0.50f, 0.11f), EntityDimensions.scalable(0.03f, 0.03f)),
                new ControlSpecification(TRControlRegistry.FAST_RETURN.get(), new Vector3f(-0.34f, 0.53f, 0.10f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.READOUT.get(), new Vector3f(-0.07f, 0.47f, 0.39f), EntityDimensions.scalable(0.06f, 0.06f)),
                new ControlSpecification(TRControlRegistry.HANDBRAKE.get(), new Vector3f(-0.25f, 0.50f, 0.38f), EntityDimensions.scalable(0.03f, 0.03f)),
                new ControlSpecification(TRControlRegistry.FUEL.get(), new Vector3f(-0.07f, 0.47f, -0.34f), EntityDimensions.scalable(0.06f, 0.06f))
        };
    }


}
