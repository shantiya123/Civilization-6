package Game.Systems.EventSystem;

import Game.Managers.AnimationManager;
import Game.Managers.TurnManager;
import Game.Systems.RestarterSystem;

public class TurnEvent extends Event{
    private final TurnManager turnManager;
    private final RestarterSystem restarterSystem;
    public TurnEvent(AnimationManager animationManager, TurnManager turnManager, RestarterSystem restarterSystem) {
        super(animationManager);
        this.turnManager = turnManager;
        this.restarterSystem = restarterSystem;
    }

    public void EndTurn() {
        turnManager.nexTurn();
        restarterSystem.restart();
        animationManager.refresh();
    }
}
