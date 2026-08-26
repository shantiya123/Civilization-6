package Animation;

import Game.Systems.Drawers.VolcanoEffectDrawer;
import Models.Elements.NatrualDisasters.Volcano;


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