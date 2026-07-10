package Game.Systems;

import Game.Systems.EventSystem.EventSystem;
import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class SelectSystem {
    private Unit selectedUnit;
    private Hex selectedHex;
    private Building selectedBuilding; // Added field
    private final EventSystem eventSystem;

    public SelectSystem(EventSystem eventSystem) {
        this.eventSystem = eventSystem;
    }

    public void selectUnit(Unit unit) {
        if (this.selectedUnit == unit) {
            this.selectedUnit = null;
            eventSystem.getSelectEvent().UnitSelected(null);
        } else {
            this.selectedUnit = unit;
            this.selectedBuilding = null; // Unselect building when selecting a unit
            eventSystem.getSelectEvent().UnitSelected(unit);
        }
    }

    public void selectHex(Hex hex) {
        if (this.selectedHex == hex) {
            this.selectedHex = null;
            eventSystem.getSelectEvent().HexSelected(null);
        } else {
            this.selectedHex = hex;
            eventSystem.getSelectEvent().HexSelected(hex);
        }
    }

    // New selection method supporting mutual exclusivity with units
    public void buildingSelect(Building building) {
        if (this.selectedBuilding == building) {
            this.selectedBuilding = null;
        } else {
            this.selectedBuilding = building;
            this.selectedUnit = null; // Unselect unit when selecting a building
        }
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public Hex getSelectedHex() {
        return selectedHex;
    }

    public Building getSelectedBuilding() {
        return selectedBuilding;
    }

    public void clearSelection() {
        this.selectedUnit = null;
        this.selectedHex = null;
        this.selectedBuilding = null;
    }
}