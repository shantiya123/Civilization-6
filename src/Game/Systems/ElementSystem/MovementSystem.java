package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventSystem;
import Game.Systems.SelectSystem;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class MovementSystem {
    private final SelectSystem selectSystem;
    private final EventSystem eventSystem;

    public MovementSystem(SelectSystem selectSystem, EventSystem eventSystem) {
        this.selectSystem = selectSystem;
        this.eventSystem = eventSystem;
    }

    public void UnitMove() {
        if (selectSystem.getSelectedUnit() == null || selectSystem.getSelectedHex() == null) {
            return;
        }

        Unit unit = selectSystem.getSelectedUnit();
        Hex targetHex = selectSystem.getSelectedHex();
        Hex oldHex = unit.getHex();

        try {
            unit.getLogic().moveToHex(targetHex);
            eventSystem.getUnitEvent().UnitMoved(oldHex, targetHex, unit);
        } catch (Exception e) {
            eventSystem.getUnitEvent().UnitCannotMove(targetHex);
        }
    }
}