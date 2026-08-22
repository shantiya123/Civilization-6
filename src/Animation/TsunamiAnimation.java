package Animation;

import Game.Systems.Drawers.TsunamiEffectDrawer;
import Models.Elements.NatrualDisasters.Tsunami;

/** Purely presentational: a violent wave surge across the tsunami's coastal hexes. */
public class TsunamiAnimation extends BaseAnimation {
    private final TsunamiEffectDrawer effectDrawer;

    public TsunamiAnimation(Tsunami tsunami, TsunamiEffectDrawer effectDrawer) {
        super(55);
        this.effectDrawer = effectDrawer;
        effectDrawer.start(tsunami.getHex(), tsunami.getEffectRadius());
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