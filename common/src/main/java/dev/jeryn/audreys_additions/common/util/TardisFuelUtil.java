package dev.jeryn.audreys_additions.common.util;

public final class TardisFuelUtil {

    private static final double FUEL_DARKEN_THRESHOLD = 500;
    private static final int MAX_STEPS = 50;
    private static final float STEP_SIZE = 0.02f;
    private static final float MIN_FACTOR = 0.2f;

    private TardisFuelUtil() {
    }

    /**
     * Returns a 0.2-1.0 multiplier: 1.0 at full fuel, dropping toward 0.2 as fuel
     * runs out below {@value #FUEL_DARKEN_THRESHOLD}.
     */
    public static float getDarkenFactor(double fuel) {
        if (fuel >= FUEL_DARKEN_THRESHOLD) {
            return 1.0f;
        }

        int steps = (int) ((FUEL_DARKEN_THRESHOLD - fuel) / 10);
        steps = Math.min(steps, MAX_STEPS);

        float factor = 1.0f - (steps * STEP_SIZE);
        return Math.max(MIN_FACTOR, factor);
    }
}
