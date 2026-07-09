package Game.Systems;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class SelectSystem {
    private Unit selectedUnit;
    private Hex selectedHex;
    private EventSystem eventSystem;

    public SelectSystem(EventSystem eventSystem) {
        this.eventSystem = eventSystem;
    }

    public void selectUnit(Unit unit){
        if (selectedUnit == null){
            selectedUnit = unit;
            eventSystem.UnitSelected(unit);
        }
        else {
            selectedUnit = null;
            eventSystem.UnitSelected(null);
        }
    }

    public void selectHex(Hex hex){
        if (selectedHex == null){
            selectedHex = hex;
            eventSystem.HexSelected(hex);
        }
        else {
            selectedHex = null;
            eventSystem.HexSelected(null);
        }
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public Hex getSelectedHex() {
        return selectedHex;
    }
}
