package Game.Systems.Listeners;

import Game.Managers.AnimationManager;

public abstract class Listener {
    protected AnimationManager animationManager;

    public Listener(AnimationManager animationManager) {
        this.animationManager = animationManager;
    }

    public void Refresh(){
        animationManager.refresh();
    }
}
