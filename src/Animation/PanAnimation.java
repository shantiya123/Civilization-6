package Animation;

import Models.Elements.Hex.Hex;
import Models.Manager.HexManager;

public class PanAnimation extends BaseAnimation {
    private final HexManager hexManager;
    private final int totalDx;
    private final int totalDy;
    private double lastProgress = 0.0;

    private static final int CENTER_X = 665;
    private static final int CENTER_Y = 335;

    public PanAnimation(Hex targetHex, HexManager hexManager) {
        super(40); // 40 steps total
        this.hexManager = hexManager;

        // Target calculation logic
        this.totalDx = -(targetHex.getCenterX() - CENTER_X);
        this.totalDy = -(targetHex.getCenterY() - CENTER_Y);
    }

    @Override
    protected void onTick(double progress) {
        // Your smooth curve equation
        double smoothProgress = TimerEquations.easeOut(progress);
        double deltaProgress = smoothProgress - lastProgress;
        lastProgress = smoothProgress;

        // Apply exactly your fractional translation formula
        int moveX = (int) (deltaProgress * totalDx) / 2;
        int moveY = (int) (deltaProgress * totalDy) / 2;

        hexManager.pan(moveX, moveY);
    }
}