package Game.Systems.EventSystem.Events;

import Models.Elements.Units.Unit;

/** Published by SelectSystem when the selected unit changes. */
public class UnitSelectionChangedEvent implements Event {
    private Unit selectedUnit;

    public UnitSelectionChangedEvent(Unit selectedUnit) { this.selectedUnit = selectedUnit; }
    public Unit getSelectedUnit() { return selectedUnit; }
    public void setSelectedUnit(Unit selectedUnit) { this.selectedUnit = selectedUnit; }
}
