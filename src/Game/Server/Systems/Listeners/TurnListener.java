package Game.Server.Systems.Listeners;

import Game.Client.Managers.AnimationManager;
import Game.Server.Managers.TurnManager;
import Game.Server.Systems.EventSystem.EventBus;
import Game.Server.Systems.EventSystem.Events.TurnAdvancedEvent;
import Game.Server.Systems.RestarterSystem;
import Game.Server.Systems.TurnResolutionCoordinator;

public class TurnListener extends Listener {
    private final TurnManager turnManager;
    private final RestarterSystem restarterSystem;
    private final EventBus eventBus;
    private final TurnResolutionCoordinator resolutionCoordinator;


    public TurnListener(AnimationManager animationManager, TurnManager turnManager,
                        RestarterSystem restarterSystem, EventBus eventBus, TurnResolutionCoordinator resolutionCoordinator) {
        super(animationManager);
        this.turnManager = turnManager;
        this.restarterSystem = restarterSystem;
        this.eventBus = eventBus;
        this.resolutionCoordinator = resolutionCoordinator;
    }

    public void EndTurn() {
        if (!resolutionCoordinator.beginResolution()) return;
        turnManager.nexTurn();
        restarterSystem.restart();
        animationManager.refresh();

        eventBus.publish(new TurnAdvancedEvent(turnManager.getTurns()));
        restarterSystem.processTribeTurn(turnManager.getTurns());
        resolutionCoordinator.finishLogic();
    }
}
