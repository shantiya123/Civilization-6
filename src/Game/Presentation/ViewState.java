package Game.Presentation;

import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.Unit;

public class ViewState {
    private Unit selectedUnit;
    private Hex selectedHex;
    private boolean starvation;
    private TownHall townHall;
    private String message;
    private Tribe selectedTribe;

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public void setSelectedUnit(Unit selectedUnit) {
        this.selectedUnit = selectedUnit;
    }

    public Hex getSelectedHex() {
        return selectedHex;
    }

    public void setSelectedHex(Hex selectedHex) {
        this.selectedHex = selectedHex;
    }

    public boolean isStarvation() {
        return starvation;
    }

    public void setStarvation(boolean starvation) {
        this.starvation = starvation;
    }

    public TownHall getTownHall() {
        return townHall;
    }

    public void setTownHall(TownHall townHall) {
        this.townHall = townHall;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Tribe getSelectedTribe() {
        return selectedTribe;
    }

    public void setSelectedTribe(Tribe selectedTribe) {
        this.selectedTribe = selectedTribe;
    }
}