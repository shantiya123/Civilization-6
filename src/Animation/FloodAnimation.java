package Animation;

import Game.Client.Drawers.FloodEffectDrawer;
import Models.Elements.NatrualDisasters.Flood;


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