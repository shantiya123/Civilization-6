package Animation;

import Models.Draw.UnitPositionCalculator;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Game.Managers.AnimationManager;
import java.awt.Point;

public class UnitMoveAnimation extends BaseAnimation {
    private final Unit unit;
    private final Hex sourceHex;
    private final Hex targetHex;
    private final AnimationManager animationManager;
    private boolean isRunning;

    public UnitMoveAnimation(Unit unit, Hex sourceHex, Hex targetHex, int totalSteps, AnimationManager animationManager) {
        super(totalSteps);
        this.unit = unit;
        this.sourceHex = sourceHex;
        this.targetHex = targetHex;
        this.animationManager = animationManager;
        this.isRunning = true;
    }

    @Override
    protected void onTick(double progress) {
        double eased = progress * progress * (3 - 2 * progress);

        // Recompute live each tick, so a zoom/pan mid-move is reflected immediately
        // instead of tweening toward stale, pre-zoom coordinates.
        Point startPoint = UnitPositionCalculator.computeRestPosition(unit, sourceHex);
        Point endPoint = UnitPositionCalculator.computeRestPosition(unit, targetHex);

        int x = (int) (startPoint.x + (endPoint.x - startPoint.x) * eased);
        int y = (int) (startPoint.y + (endPoint.y - startPoint.y) * eased);

        int startSize = (int) (sourceHex.getSize() * 0.2);
        int endSize = (int) (targetHex.getSize() * 0.2);
        int size = (int) (startSize + (endSize - startSize) * eased);

        unit.setX(x);
        unit.setY(y);
        unit.setSize(size);

        animationManager.refresh();
    }

    @Override
    protected void onComplete() {
        this.isRunning = false;

        try {
            unit.getLogic().moveToHex(targetHex);

            UnitPositionCalculator.refreshHex(sourceHex, unit);
            UnitPositionCalculator.refreshHex(targetHex, unit);
        } catch (Exception e) {
            e.printStackTrace();
        }

        animationManager.refresh();
    }

    public boolean isRunning() { return isRunning; }
    public Unit getUnit() { return unit; }
}