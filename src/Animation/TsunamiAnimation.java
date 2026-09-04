package Animation;

import Game.Client.Drawers.TsunamiEffectDrawer;
import Models.Elements.NatrualDisasters.Tsunami;


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