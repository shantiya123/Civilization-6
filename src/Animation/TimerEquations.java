package Animation;

public class TimerEquations {

    /**
     * Linear — constant speed, no easing.
     * t goes from 0.0 to 1.0
     */
    public static double linear(double t) {
        return t;
    }

    /**
     * Ease out — starts fast, slows down at the end. (most natural for panning)
     */
    public static double easeOut(double t) {
        return 1 - Math.pow(1 - t, 3);
    }

    /**
     * Ease in — starts slow, speeds up at the end.
     */
    public static double easeIn(double t) {
        return t * t * t;
    }

    /**
     * Ease in-out — slow start, fast middle, slow end.
     */
    public static double easeInOut(double t) {
        return t < 0.5 ? 4 * t * t * t : 1 - Math.pow(-2 * t + 2, 3) / 2;
    }

    /**
     * Smooth step — similar to ease in-out but simpler curve.
     */
    public static double smoothStep(double t) {
        return t * t * (3 - 2 * t);
    }

    /**
     * Bounce — overshoots and snaps back.
     */
    public static double bounce(double t) {
        return 1 - Math.abs(Math.cos(t * Math.PI * 2.5)) * (1 - t);
    }
}