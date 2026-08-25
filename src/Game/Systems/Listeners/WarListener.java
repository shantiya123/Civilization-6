package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Game.Presentation.ViewState;
import Game.Systems.EventSystem.Events.WarEvent;

/** Presentation hook for dice/result dialogs and battlefield refresh. */
public final class WarListener extends Listener {
    private final ViewState viewState;

    public WarListener(AnimationManager animationManager, ViewState viewState) {
        super(animationManager);
        this.viewState = viewState;
    }

    /** Records the resolved battle so the War Panel can pick it up and refresh the board. */
    public void warResolved(WarEvent report) {
        viewState.setLastWarEvent(report);
        animationManager.refresh();
    }
}