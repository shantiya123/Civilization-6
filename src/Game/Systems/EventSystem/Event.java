package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Models.ConnectDrawing;

public abstract class Event {
    protected AnimationManager animationManager;

    public Event(AnimationManager animationManager) {
        this.animationManager = animationManager;
    }
}
