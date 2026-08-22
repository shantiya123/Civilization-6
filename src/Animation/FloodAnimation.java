package Animation;

import Game.Systems.Drawers.FloodEffectDrawer;
import Models.Elements.NatrualDisasters.Flood;

/**
 * Purely presentational: flowing/rising water for an active Flood.
 * Damage is already applied by FloodLogic before this plays.
 */
public class FloodAnimation extends BaseAnimation {

    private final FloodEffectDrawer effectDrawer;

    public FloodAnimation(Flood flood, FloodEffectDrawer effectDrawer) {
        super(90);
        this.effectDrawer = effectDrawer;
        effectDrawer.start(flood.getHex(), flood.getEffectRadius());
    }

    @Override
    protected void onTick(double progress) {
        effectDrawer.setProgress(progress);
    }

    @Override
    protected void onComplete() {
        effectDrawer.stop();
    }
}