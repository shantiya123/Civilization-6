package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventSystem;
import Game.Systems.SelectSystem;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class MovementSystem {
    private final SelectSystem selectSystem;
    private final EventSystem eventSystem;
    private boolean unitWasSelectedFirst = false;

    public MovementSystem(SelectSystem selectSystem, EventSystem eventSystem) {
        this.selectSystem = selectSystem;
        this.eventSystem = eventSystem;
    }

    public void UnitMove() {
        Unit currentUnit = selectSystem.getSelectedUnit();
        Hex currentHex = selectSystem.getSelectedHex();

        if (currentUnit == null && currentHex == null) {
            unitWasSelectedFirst = false;
            return;
        }

        if (currentUnit != null && currentHex == null) {
            unitWasSelectedFirst = true;
        }

        if (currentUnit == null || currentHex == null) {
            return;
        }

        if (!unitWasSelectedFirst) {
            return;
        }

        Hex oldHex = currentUnit.getHex();

        // Safety guard: Don't move to the exact same hex
        if (currentHex.equals(oldHex)) {
            return;
        }

        // Trigger the animation event FIRST before changing the state
        eventSystem.getUnitEvent().UnitMoved(oldHex, currentHex, currentUnit);

        // Reset your selection flags immediately
        unitWasSelectedFirst = false;
        selectSystem.selectUnit(null);
    }
}