package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Models.Elements.NatrualDisasters.NaturalDisaster;

public class NaturalDisasterListener extends Listener {
    public NaturalDisasterListener(AnimationManager animationManager) {
        super(animationManager);
    }

    public void naturalDisasterOccurred(NaturalDisaster naturalDisaster) {
        animationManager.refresh();
    }
}
