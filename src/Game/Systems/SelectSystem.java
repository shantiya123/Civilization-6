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
            this.selectedBuilding = null;
            eventSystem.getSelectEvent().UnitSelected(unit);
        }
    }

    public void selectHex(Hex hex) {
        if (this.selectedHex == hex) {
            this.selectedHex = null;
            eventSystem.getSelectEvent().HexSelected(null);
        } else {
            this.selectedHex = hex;
            if (selectedUnit != null)
                readyToMove = true;
            else
                readyToMove = false;
            eventSystem.getSelectEvent().HexSelected(hex);
        }
    }


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

    public boolean isReadyToMove() {
        return readyToMove;
    }

    public void setReadyToMove(boolean readyToMove) {
        this.readyToMove = readyToMove;
    }
}