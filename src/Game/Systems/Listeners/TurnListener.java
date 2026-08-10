package Game.Systems.Listeners;

import Game.Managers.AnimationManager;
import Game.Managers.TurnManager;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.TurnAdvancedEvent;
import Game.Systems.RestarterSystem;

public class TurnListener extends Listener {
    private final TurnManager turnManager;
    private final RestarterSystem restarterSystem;
    private final EventBus eventBus;


    public TurnListener(AnimationManager animationManager, TurnManager turnManager,
                        RestarterSystem restarterSystem, EventBus eventBus) {
        super(animationManager);
        this.turnManager = turnManager;
        this.restarterSystem = restarterSystem;
        this.eventBus = eventBus;
    }

    public void EndTurn() {
        turnManager.nexTurn();
        restarterSystem.restart();
        animationManager.refresh();

        eventBus.publish(new TurnAdvancedEvent(turnManager.getTurns()));
    }
}
