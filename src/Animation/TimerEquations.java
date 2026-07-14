package Animation;

public class TimerEquations {


    public static double linear(double t) {
        return t;
    }


    public static double easeOut(double t) {
        return 1 - Math.pow(1 - t, 3);
    }


    public static double easeIn(double t) {
        return t * t * t;
    }


    public static double easeInOut(double t) {
        return t < 0.5 ? 4 * t * t * t : 1 - Math.pow(-2 * t + 2, 3) / 2;
    }


    public static double smoothStep(double t) {
        return t * t * (3 - 2 * t);
    }


    public static double bounce(double t) {
        return 1 - Math.abs(Math.cos(t * Math.PI * 2.5)) * (1 - t);
    }
}