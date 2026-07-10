package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;

public abstract class Event {
    protected AnimationManager animationManager;

    public Event(AnimationManager animationManager) {
        this.animationManager = animationManager;
    }
}
