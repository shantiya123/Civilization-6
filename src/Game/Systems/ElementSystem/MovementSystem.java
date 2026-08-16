package Game.Systems.ElementSystem;

import Game.World;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.MoveEvent;
import Game.Systems.SelectSystem;
import Game.Systems.PlayerActionGuard;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Models.Logic.UnitLogic.FindBestPath;

public class MovementSystem {
    private final SelectSystem selectSystem;
    private final EventBus eventBus;
    private final World world;
    public MovementSystem(World world, SelectSystem selectSystem,EventBus eventBus) {
        this.world = world;
        this.selectSystem = selectSystem;
        this.eventBus = eventBus;
    }

    public void UnitMove() {
        if (!new PlayerActionGuard(world, eventBus).allow()) return;
        Unit currentUnit = selectSystem.getSelectedUnit();
        Hex targetHex = selectSystem.getSelectedHex();
        if (!selectSystem.isReadyToMove())
            return;
        if (currentUnit == null) {
            return;
        }

        if (currentUnit instanceof Worker worker && worker.isWorking()) {
            return;
        }

        if (targetHex == null || !targetHex.isVisible()) {
            return;
        }

        Hex unitCurrentHex = currentUnit.getHex();


        if (targetHex.equals(unitCurrentHex)) {
            return;
        }

        FindBestPath bestPath = new FindBestPath(world, unitCurrentHex , targetHex);
        var path = bestPath.findPath(currentUnit.getAP(), Hex::isVisible);
        if (path.isEmpty()) return;
        // The listener captures the affordable path for animation before AP is consumed.
        eventBus.publish(new MoveEvent(currentUnit , unitCurrentHex , targetHex));
        try {
            currentUnit.getLogic().cost(currentUnit.getLogic().movementCostForPath(path));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        selectSystem.selectUnit(null);
        selectSystem.setReadyToMove(false);

    }
}
