package dev.jeryn.audreys_additions.console.theme;

import net.minecraft.world.entity.EntityDimensions;
import org.joml.Vector3f;
import whocraft.tardis_refined.common.tardis.control.ControlSpecification;
import whocraft.tardis_refined.common.tardis.themes.console.ConsoleThemeDetails;
import whocraft.tardis_refined.registry.TRControlRegistry;

import whocraft.tardis_refined.patterns.ConsolePattern;

public class CoralConsoleTheme extends ConsoleThemeDetails {

    @Override
    public ControlSpecification[] getControlSpecification(ConsolePattern consolePattern) {
            return new ControlSpecification[] {
                    new ControlSpecification(TRControlRegistry.THROTTLE, new Vector3f(-0.04375f, 0.59375f, 0.8625f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                    new ControlSpecification(TRControlRegistry.X, new Vector3f(0.7375f, 0.5f, -0.7625f), EntityDimensions.scalable(0.125f, 0.125f)),
                    new ControlSpecification(TRControlRegistry.Y, new Vector3f(0.6125f, 0.5f, -0.85625f), EntityDimensions.scalable(0.125f, 0.125f)),
                    new ControlSpecification(TRControlRegistry.Z, new Vector3f(0.4875f, 0.5f, -0.95f), EntityDimensions.scalable(0.125f, 0.125f)),
                    new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(-0.04375f, 0.59375f, -1.075f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                    new ControlSpecification(TRControlRegistry.ROTATE, new Vector3f(-1.04375f, 0.53125f, 0.20625f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                    new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(0.8f, 0.5f, -0.075f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                    new ControlSpecification(TRControlRegistry.DOOR_TOGGLE, new Vector3f(-1.29375f, 0.28125f, -0.73125f), EntityDimensions.scalable(0.125f, 0.125f)),
                    new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(-0.575f, 0.8125f, 0.55f), EntityDimensions.scalable(0.375f, 0.375f)),
                    new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(-1.1375f, 0.375f, -0.075f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                    new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(-1.1375f, 0.375f, -0.2625f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                    new ControlSpecification(TRControlRegistry.FAST_RETURN, new Vector3f(0.7375f, 0.6875f, 0.425f), EntityDimensions.scalable(0.125f, 0.125f)),
                    new ControlSpecification(TRControlRegistry.READOUT, new Vector3f(0.83125f, 0.59375f, 0.175f), EntityDimensions.scalable(0.125f, 0.125f)),
                    new ControlSpecification(TRControlRegistry.HANDBRAKE, new Vector3f(1.3f, 0.1875f, -0.7f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                    new ControlSpecification(TRControlRegistry.FUEL, new Vector3f(0.3f, 0.4375f, 0.83125f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                    new ControlSpecification(TRControlRegistry.FUEL, new Vector3f(0.55f, 0.4375f, 0.675f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                    new ControlSpecification(TRControlRegistry.READOUT, new Vector3f(-0.496875f, 0.53125f, -0.73125f), EntityDimensions.scalable(0.125f, 0.125f)),
                    new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(0.3625f, 0.578125f, -0.653125f), EntityDimensions.scalable(0.125f, 0.125f)),
                    new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(-0.715625f, 0.484375f, -0.840625f), EntityDimensions.scalable(0.125f, 0.125f)),
                    new ControlSpecification(TRControlRegistry.HANDBRAKE, new Vector3f(0.9875f, 0.5f, 0.55f), EntityDimensions.scalable(0.1875f, 0.1875f)),
                    new ControlSpecification(TRControlRegistry.HANDBRAKE, new Vector3f(-1.075f, 0.5f, -0.6375f), EntityDimensions.scalable(0.1875f, 0.1875f))
            };
        }




}

