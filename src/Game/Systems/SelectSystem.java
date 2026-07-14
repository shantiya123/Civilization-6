package Game.Systems;

import Game.Managers.AnimationManager;
import Game.Systems.EventSystem.EventSystem;
import Models.ConnectViews;
import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class SelectSystem {
    private Unit selectedUnit;
    private Hex selectedHex;
    private Building selectedBuilding;
    private final EventSystem eventSystem;
    private final AnimationManager animationManager;
    private boolean readyToMove;
    private final ConnectViews connectViews;
    public SelectSystem(EventSystem eventSystem, AnimationManager animationManager, ConnectViews connectViews) {
        this.eventSystem = eventSystem;
        this.animationManager = animationManager;
        this.connectViews = connectViews;
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
//        System.out.println("===========================");
        if (this.selectedHex == hex) {
//            System.out.println("onSelect");
            this.selectedHex = null;
            eventSystem.getSelectEvent().HexSelected(null);
        } else {
//            System.out.println("select");
            this.selectedHex = hex;
            if (selectedUnit != null)
                readyToMove = true;
            else
                readyToMove = false;
            eventSystem.getSelectEvent().HexSelected(hex);
        }
    }

    public void buildingSelect(Building building) {
        if (this.selectedBuilding == building) {
            this.selectedBuilding = null;
        } else {
            this.selectedBuilding = building;

            // Cleanly clear drawing indicators when focus drops to a building
            if (this.selectedUnit != null) {
                this.selectedUnit = null;
                eventSystem.getSelectEvent().UnitSelected(null);
            }
        }
    }
    /**
     * Handles dynamic mouse hover events over valid map tiles.
     */
    public void hoverHex(Hex hex) {
        if (this.selectedUnit != null) {
            var unitLogic = this.selectedUnit.getLogic();
            if (unitLogic != null && unitLogic.canReach(hex)) {
                java.util.List<Hex> path = unitLogic.getBestPath(hex);
                eventSystem.getSelectEvent().likelyPath(path, hex);
            }
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
        eventSystem.getSelectEvent().UnitSelected(null);
        eventSystem.getSelectEvent().HexSelected(null);
    }

    public boolean isReadyToMove() {
        return readyToMove;
    }

    public void setReadyToMove(boolean readyToMove) {
        this.readyToMove = readyToMove;
    }
}