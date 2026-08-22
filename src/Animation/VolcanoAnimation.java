package Animation;

import Game.Systems.Drawers.VolcanoEffectDrawer;
import Models.Elements.NatrualDisasters.Volcano;

/**
 * Purely presentational: eruption burst at the volcano hex followed by
 * lava flowing step-by-step along its lava path. Damage/destruction is
 * already applied by VolcanoLogic before this plays.
 */
public class VolcanoAnimation extends BaseAnimation {

    private final VolcanoEffectDrawer effectDrawer;

    public VolcanoAnimation(Volcano volcano, VolcanoEffectDrawer effectDrawer) {
        super(100);
        this.effectDrawer = effectDrawer;
        effectDrawer.start(volcano.getHex(), volcano.getLavaPath());
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