package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Game.Managers.TurnManager;
import Game.Systems.RestarterSystem;

public class TurnEvent extends Event{
    private final TurnManager turnManager;
    private final RestarterSystem restarterSystem;
    private final EventSystem eventSystem; // FIXED: Now references parent EventSystem

    public TurnEvent(AnimationManager animationManager, TurnManager turnManager, RestarterSystem restarterSystem, EventSystem eventSystem) {
        super(animationManager);
        this.turnManager = turnManager;
        this.restarterSystem = restarterSystem;
        this.eventSystem = eventSystem; // FIXED
    }

    public void EndTurn() {
        turnManager.nexTurn();
        restarterSystem.restart();
        animationManager.refresh();

        // FIXED: Safely routed through parent's dynamic Notif utility
        if (eventSystem != null) {
            eventSystem.Notif("Turn Ended");
        }
    }
}