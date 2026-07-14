package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventSystem;
import Game.Systems.SelectSystem;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Logic.UnitLogic.FindBestPath;

public class MovementSystem {
    private final SelectSystem selectSystem;
    private final EventSystem eventSystem;

    public MovementSystem(SelectSystem selectSystem, EventSystem eventSystem) {
        this.selectSystem = selectSystem;
        this.eventSystem = eventSystem;
    }

    public void UnitMove() {
        Unit currentUnit = selectSystem.getSelectedUnit();
        Hex targetHex = selectSystem.getSelectedHex();
        if (!selectSystem.isReadyToMove())
            return;
        // 1. If no unit is selected, movement is impossible.
        if (currentUnit == null) {
            return;
        }

        // 2. If a unit is selected but no hex is selected, wait for the hex.
        if (targetHex == null) {
            return;
        }

        Hex unitCurrentHex = currentUnit.getHex();

        // 3. ENFORCE SELECTION ORDER:
        // If targetHex equals the unit's current hex, it means the user just clicked
        // the unit to select it. We return early so it doesn't move.
        if (targetHex.equals(unitCurrentHex)) {
            return;
        }

        // 4. If we get here, a unit was already selected, and the user just clicked
        // a NEW, different hex. Trigger the movement animation!
        eventSystem.getUnitEvent().UnitMoved(unitCurrentHex, targetHex, currentUnit);
        FindBestPath bestPath = new FindBestPath(unitCurrentHex , targetHex);
        try {
            currentUnit.getLogic().cost(bestPath.CalculateTotalCost());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Reset selection flags immediately so the next action starts fresh
        selectSystem.selectUnit(null);
        selectSystem.setReadyToMove(false);
        // selectSystem.selectHex(null); // Clear this too if your SelectSystem tracks it
    }
}