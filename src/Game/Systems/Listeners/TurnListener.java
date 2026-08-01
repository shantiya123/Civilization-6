package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Game.Managers.TurnManager;
import Game.Systems.RestarterSystem;

public class TurnListener extends Listener {
    private final TurnManager turnManager;
    private final RestarterSystem restarterSystem;
    private final ListenerSystem listenerSystem;

    public TurnListener(AnimationManager animationManager, TurnManager turnManager, RestarterSystem restarterSystem, ListenerSystem listenerSystem) {
        super(animationManager);
        this.turnManager = turnManager;
        this.restarterSystem = restarterSystem;
        this.listenerSystem = listenerSystem;
    }

    public void EndTurn() {
        turnManager.nexTurn();
        restarterSystem.restart();
        animationManager.refresh();

        if (listenerSystem != null) {
            listenerSystem.Notif("Turn Ended");
        }
    }
}