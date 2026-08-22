package Animation;

import Game.Systems.Drawers.TornadoEffectDrawer;
import Models.Elements.Hex.Hex;
import Models.Elements.NatrualDisasters.Tornado;

import java.util.List;

/**
 * Purely presentational: a spinning funnel traveling along the tornado's
 * four-hex path, with orbiting debris. Damage/displacement is already
 * applied by TornadoLogic before this plays.
 */
public class TornadoAnimation extends BaseAnimation {

    private final TornadoEffectDrawer effectDrawer;
    private final List<Hex> path;
    private final int totalSegments;

    public TornadoAnimation(Tornado tornado, TornadoEffectDrawer effectDrawer) {
        super(80);
        this.effectDrawer = effectDrawer;
        this.path = tornado.getEffectRadius();
        this.totalSegments = Math.max(1, path.size() - 1);
        effectDrawer.start(path);
    }

    @Override
    protected void onTick(double progress) {
        double exactSegment = progress * totalSegments;
        int segmentIndex = Math.min((int) Math.floor(exactSegment), totalSegments - 1);
        double localProgress = exactSegment - segmentIndex;
        double eased = localProgress * localProgress * (3 - 2 * localProgress);

        Hex from = path.size() >= 2 ? path.get(segmentIndex) : path.get(0);
        Hex to = path.size() >= 2 ? path.get(segmentIndex + 1) : path.get(0);

        int x = (int) (from.getCenterX() + (to.getCenterX() - from.getCenterX()) * eased);
        int y = (int) (from.getCenterY() + (to.getCenterY() - from.getCenterY()) * eased);

        effectDrawer.setFunnelPosition(x, y);
        effectDrawer.setSpinAngle(currentStep * 0.35);
    }

    @Override
    protected void onComplete() {
        effectDrawer.stop();
    }
}