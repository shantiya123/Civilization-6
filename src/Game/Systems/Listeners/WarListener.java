package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Game.Systems.EventSystem.Events.WarEvent;

/** Presentation hook for dice/result dialogs and battlefield refresh. */
public final class WarListener extends Listener {
    public WarListener(AnimationManager animationManager) { super(animationManager); }
    public void warResolved(WarEvent report) { animationManager.refresh(); }
}
