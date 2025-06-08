package dev.jeryn.audreys_additions.console.theme;

import net.minecraft.world.entity.EntityDimensions;
import org.joml.Vector3f;
import whocraft.tardis_refined.common.tardis.control.ControlSpecification;
import whocraft.tardis_refined.common.tardis.themes.console.ConsoleThemeDetails;
import whocraft.tardis_refined.registry.TRControlRegistry;

public class RaniConsoleTheme extends ConsoleThemeDetails {

    @Override
    public ControlSpecification[] getControlSpecification() {
        return new ControlSpecification[] {
                new ControlSpecification(TRControlRegistry.THROTTLE, new Vector3f(-0.075f, 0.3125f, 0.7375f), EntityDimensions.scalable(0.25f, 0.25f)),
                new ControlSpecification(TRControlRegistry.X, new Vector3f(-0.012499999999999997f, 0.5f, -0.7f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.Y, new Vector3f(0.20625f, 0.375f, -0.91875f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.Z, new Vector3f(-0.23125f, 0.375f, -0.91875f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(-0.012499999999999997f, 0.375f, -0.95f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.ROTATE, new Vector3f(-0.8875f, 0.375f, 0.2375f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.DOOR_TOGGLE, new Vector3f(-0.809375f, 0.375f, 0.45625f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(-0.575f, 0.5f, 0.3f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.READOUT, new Vector3f(-0.66875f, 0.375f, 0.6125f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(-0.8875f, 0.4375f, -0.5125f), EntityDimensions.scalable(0.25f, 0.25f)),
                new ControlSpecification(TRControlRegistry.HANDBRAKE, new Vector3f(0.6125f, 0.375f, -0.48125f), EntityDimensions.scalable(0.25f, 0.25f)),
                new ControlSpecification(TRControlRegistry.FUEL, new Vector3f(0.55f, 0.5f, 0.3f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.FAST_RETURN, new Vector3f(0.8625f, 0.375f, 0.2375f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(0.64375f, 0.375f, 0.6125f), EntityDimensions.scalable(0.125f, 0.125f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.8f, 0.375f, 0.45625f), EntityDimensions.scalable(0.125f, 0.125f))
        };
    }



}
