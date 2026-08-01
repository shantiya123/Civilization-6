package Game.Systems.ElementSystem;

import Game.Systems.Listeners.ListenerSystem;
import Game.Systems.SelectSystem;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Logic.UnitLogic.FindBestPath;

public class MovementSystem {
    private final SelectSystem selectSystem;
    private final ListenerSystem listenerSystem;

    public MovementSystem(SelectSystem selectSystem, ListenerSystem listenerSystem) {
        this.selectSystem = selectSystem;
        this.listenerSystem = listenerSystem;
    }

    public void UnitMove() {
        Unit currentUnit = selectSystem.getSelectedUnit();
        Hex targetHex = selectSystem.getSelectedHex();
        if (!selectSystem.isReadyToMove())
            return;
        if (currentUnit == null) {
            return;
        }

        if (targetHex == null) {
            return;
        }

        Hex unitCurrentHex = currentUnit.getHex();


        if (targetHex.equals(unitCurrentHex)) {
            return;
        }


        listenerSystem.getUnitListener().UnitMoved(unitCurrentHex, targetHex, currentUnit);
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