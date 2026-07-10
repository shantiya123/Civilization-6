package Game.Systems;

import Game.Systems.EventSystem.EventSystem;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class SelectSystem {
    private Unit selectedUnit;
    private Hex selectedHex;
    private final EventSystem eventSystem;

    public SelectSystem(EventSystem eventSystem) {
        this.eventSystem = eventSystem;
    }

    public void selectUnit(Unit unit) {
        // If clicking the already selected unit, deselect it
        if (this.selectedUnit == unit) {
            this.selectedUnit = null;
            eventSystem.getSelectEvent().UnitSelected(null);
        } else {
            // Otherwise, select the new unit (even if switching from another unit)
            this.selectedUnit = unit;
            eventSystem.getSelectEvent().UnitSelected(unit);
        }
    }

    public void selectHex(Hex hex) {
        // If clicking the already selected hex, deselect it
        if (this.selectedHex == hex) {
            this.selectedHex = null;
            eventSystem.getSelectEvent().HexSelected(null);
        } else {
            // Otherwise, select the new hex
            this.selectedHex = hex;
            eventSystem.getSelectEvent().HexSelected(hex);
        }
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public Hex getSelectedHex() {
        return selectedHex;
    }

    // Good practice: clear selections entirely when needed (e.g., end of turn)
    public void clearSelection() {
        this.selectedUnit = null;
        this.selectedHex = null;
    }
}