package Animation;

import Models.Draw.UnitPositionCalculator;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Game.Managers.AnimationManager;
import java.awt.Point;
import java.util.List;

public class UnitMoveAnimation extends BaseAnimation {
    private final Unit unit;
    private final List<Hex> path; // Dynamically calculated path list
    private final AnimationManager animationManager;
    private boolean isRunning;

    private final int totalSegments;

    public UnitMoveAnimation(Unit unit, Hex sourceHex, Hex targetHex, int totalSteps, AnimationManager animationManager) {
        // 1. Calculate the actual sequential path right inside the constructor
        // This keeps your MovementSystem clean and untouched!
        super(totalSteps);
        this.unit = unit;
        this.animationManager = animationManager;

        // Use your unit's logic to fetch the full sequential path of hexes
        this.path = unit.getLogic().getBestPath(targetHex);

        // Fallback: If no path found, treat the straight line as a single segment
        if (this.path == null || this.path.size() < 2) {
            this.totalSegments = 1;
        } else {
            this.totalSegments = this.path.size() - 1;
        }

        this.isRunning = true;
    }

    @Override
    protected void onTick(double overallProgress) {
        // 1. Map the overall progress (0.0 to 1.0) to our sequential segments
        double exactSegment = overallProgress * totalSegments;
        int currentSegmentIndex = (int) Math.floor(exactSegment);

        if (currentSegmentIndex >= totalSegments) {
            currentSegmentIndex = totalSegments - 1;
        }

        // 2. Get local progress inside this specific hex-to-hex step
        double localProgress = exactSegment - currentSegmentIndex;
        double eased = localProgress * localProgress * (3 - 2 * localProgress);

        // 3. Extract the active segment hexes
        Hex sourceHex;
        Hex targetHex;

        if (path != null && path.size() >= 2) {
            sourceHex = path.get(currentSegmentIndex);
            targetHex = path.get(currentSegmentIndex + 1);
        } else {
            // Fallback safety logic
            sourceHex = this.unit.getHex();
            targetHex = path != null && !path.isEmpty() ? path.get(path.size() - 1) : this.unit.getHex();
        }

        if (sourceHex == null || targetHex == null) return;

        // 4. Calculate visual positions
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
            // Retrieve final target destination
            Hex finalTarget = (path != null && path.size() >= 2) ? path.get(path.size() - 1) : this.unit.getHex();
            Hex originalStart = (path != null && !path.isEmpty()) ? path.get(0) : this.unit.getHex();

            if (finalTarget != null) {
                // Instantly sync the logic engine's internal board state at the finish line
                unit.getLogic().moveToHex(finalTarget);

                UnitPositionCalculator.refreshHex(originalStart, unit);
                UnitPositionCalculator.refreshHex(finalTarget, unit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        animationManager.refresh();
    }

    public boolean isRunning() { return isRunning; }
    public Unit getUnit() { return unit; }
}