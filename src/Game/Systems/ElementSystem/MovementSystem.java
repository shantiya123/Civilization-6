package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.MoveEvent;
import Game.Systems.SelectSystem;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Models.Logic.UnitLogic.FindBestPath;

public class MovementSystem {
    private final SelectSystem selectSystem;
    private final EventBus eventBus;
    public MovementSystem(SelectSystem selectSystem,EventBus eventBus) {
        this.selectSystem = selectSystem;
        this.eventBus = eventBus;
    }

    public void UnitMove() {
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

        if (targetHex == null) {
            return;
        }

        Hex unitCurrentHex = currentUnit.getHex();


        if (targetHex.equals(unitCurrentHex)) {
            return;
        }

        eventBus.publish(new MoveEvent(currentUnit , unitCurrentHex , targetHex));
        FindBestPath bestPath = new FindBestPath(unitCurrentHex , targetHex);
        try {
            currentUnit.getLogic().cost(bestPath.CalculateTotalCost());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        selectSystem.selectUnit(null);
        selectSystem.setReadyToMove(false);

    }
}
