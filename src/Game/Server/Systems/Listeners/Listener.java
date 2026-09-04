package Game.Server.Systems.Listeners;

import Game.Client.Managers.AnimationManager;

public abstract class Listener {
    protected AnimationManager animationManager;

    public Listener(AnimationManager animationManager) {
        this.animationManager = animationManager;
    }

    public void Refresh(){
        animationManager.refresh();
    }
}
