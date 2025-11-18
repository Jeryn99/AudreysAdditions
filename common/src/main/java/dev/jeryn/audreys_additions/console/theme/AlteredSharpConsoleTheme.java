package dev.jeryn.audreys_additions.console.theme;

import net.minecraft.world.entity.EntityDimensions;
import org.joml.Vector3f;
import whocraft.tardis_refined.common.tardis.control.ControlSpecification;
import whocraft.tardis_refined.common.tardis.themes.console.ConsoleThemeDetails;
import whocraft.tardis_refined.registry.TRControlRegistry;

public class AlteredSharpConsoleTheme extends ConsoleThemeDetails {

    @Override
    public ControlSpecification[] getControlSpecification() {
        return new ControlSpecification[] {
                new ControlSpecification(TRControlRegistry.THROTTLE, new Vector3f(0.06796875f, 0.578125f, -0.9921874999999998f), EntityDimensions.scalable(0.10781249999999998f, 0.10781249999999987f)),
                new ControlSpecification(TRControlRegistry.HANDBRAKE, new Vector3f(-0.07578124999999998f, 0.578125f, -0.9921874999999998f), EntityDimensions.scalable(0.10781249999999998f, 0.10781249999999987f)),
                new ControlSpecification(TRControlRegistry.ROTATE, new Vector3f(0.7328125f, 0.6140625f, -0.20156249999999998f), EntityDimensions.scalable(0.14375000000000004f, 0.14375f)),
                new ControlSpecification(TRControlRegistry.FAST_RETURN, new Vector3f(0.53515625f, 0.6140625f, -0.5968749999999999f), EntityDimensions.scalable(0.14375000000000004f, 0.14375000000000004f)),
                new ControlSpecification(TRControlRegistry.DOOR_TOGGLE, new Vector3f(1.0921874999999999f, 0.5062499999999999f, -0.20156249999999998f), EntityDimensions.scalable(0.07187500000000013f, 0.07187499999999997f)),
                new ControlSpecification(TRControlRegistry.DOOR_TOGGLE, new Vector3f(0.9484374999999999f, 0.5062499999999999f, 0.48124999999999996f), EntityDimensions.scalable(0.07187500000000002f, 0.07187499999999997f)),
                new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(0.8765625f, 0.578125f, 0.21171875f), EntityDimensions.scalable(0.07187499999999991f, 0.071875f)),
                new ControlSpecification(TRControlRegistry.X, new Vector3f(-0.2375f, 0.5960937499999999f, 0.8585937499999999f), EntityDimensions.scalable(0.071875f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.Y, new Vector3f(0.014062500000000006f, 0.5960937499999999f, 0.82265625f), EntityDimensions.scalable(0.071875f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.Z, new Vector3f(0.265625f, 0.5960937499999999f, 0.8585937499999999f), EntityDimensions.scalable(0.071875f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(-0.2375f, 0.5062499999999999f, 0.9484374999999999f), EntityDimensions.scalable(0.071875f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(-0.16562499999999997f, 0.5062499999999999f, 0.9484374999999999f), EntityDimensions.scalable(0.071875f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(-0.09374999999999999f, 0.5062499999999999f, 0.9484374999999999f), EntityDimensions.scalable(0.071875f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(-0.02187499999999999f, 0.5062499999999999f, 0.9484374999999999f), EntityDimensions.scalable(0.071875f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(0.05f, 0.5062499999999999f, 0.9484374999999999f), EntityDimensions.scalable(0.071875f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(0.121875f, 0.5062499999999999f, 0.9484374999999999f), EntityDimensions.scalable(0.071875f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(0.19374999999999998f, 0.5062499999999999f, 0.9484374999999999f), EntityDimensions.scalable(0.071875f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(0.265625f, 0.5062499999999999f, 0.9484374999999999f), EntityDimensions.scalable(0.071875f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(-0.8124999999999999f, 0.5062499999999999f, 0.30156249999999996f), EntityDimensions.scalable(0.2875f, 0.28750000000000003f)),
                new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(-1.0101562499999999f, 0.5062499999999999f, 0.33749999999999997f), EntityDimensions.scalable(0.07187500000000002f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(-0.9742187499999999f, 0.5062499999999999f, 0.409375f), EntityDimensions.scalable(0.07187500000000002f, 0.07187499999999997f)),
                new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(-0.9382812499999998f, 0.5062499999999999f, 0.48124999999999996f), EntityDimensions.scalable(0.07187499999999991f, 0.07187499999999997f)),
                new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(-0.9023437499999999f, 0.5062499999999999f, 0.553125f), EntityDimensions.scalable(0.07187500000000002f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(-0.8664062499999999f, 0.5062499999999999f, 0.625f), EntityDimensions.scalable(0.07187500000000002f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.READOUT, new Vector3f(-0.7406249999999999f, 0.5062499999999999f, 0.75078125f), EntityDimensions.scalable(0.07187499999999991f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.HANDBRAKE, new Vector3f(-0.7945312499999999f, 0.6140625f, -0.45312499999999994f), EntityDimensions.scalable(0.07187500000000002f, 0.07187499999999997f)),
                new ControlSpecification(TRControlRegistry.FUEL, new Vector3f(-0.9203124999999999f, 0.578125f, -0.309375f), EntityDimensions.scalable(0.10781249999999998f, 0.10781250000000003f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.16562499999999997f, 0.4882812499999999f, 1.05625f), EntityDimensions.scalable(0.071875f, 0.07187500000000013f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.19374999999999998f, 0.4882812499999999f, 1.05625f), EntityDimensions.scalable(0.071875f, 0.07187500000000013f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.696875f, 0.4882812499999999f, 0.9125f), EntityDimensions.scalable(0.07187500000000002f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.553125f, 0.6320312499999998f, 0.30156249999999996f), EntityDimensions.scalable(0.14375000000000004f, 0.14375f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(1.11015625f, 0.4882812499999999f, 0.1578125f), EntityDimensions.scalable(0.10781250000000009f, 0.10781249999999999f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.8046875f, 0.5062499999999999f, -0.6507812499999999f), EntityDimensions.scalable(0.07187500000000002f, 0.07187499999999991f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.60703125f, 0.52421875f, -0.38125f), EntityDimensions.scalable(0.14374999999999993f, 0.14375f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.02187499999999999f, 0.578125f, -0.7585937499999998f), EntityDimensions.scalable(0.14375f, 0.14374999999999993f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.33749999999999997f, 0.5062499999999999f, -0.9742187499999999f), EntityDimensions.scalable(0.07187500000000002f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.309375f, 0.5062499999999999f, -0.9742187499999999f), EntityDimensions.scalable(0.07187500000000002f, 0.07187500000000002f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.19374999999999998f, 0.5062499999999999f, -1.0640625f), EntityDimensions.scalable(0.14375f, 0.14375000000000004f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.2375f, 0.5062499999999999f, -1.0640625f), EntityDimensions.scalable(0.14375f, 0.14375000000000004f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.7046874999999999f, 0.5421874999999998f, -0.6507812499999999f), EntityDimensions.scalable(0.07187500000000002f, 0.07187499999999991f)),
                new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.6507812499999999f, 0.6140625f, -0.39921874999999996f), EntityDimensions.scalable(0.14374999999999993f, 0.14375f))
        };
    }



}
