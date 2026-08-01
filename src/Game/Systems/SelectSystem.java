package Game.Systems;

import Game.Managers.AnimationManager;
import Game.Systems.Listeners.ListenerSystem;
import Models.ConnectViews;
import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class SelectSystem {
    private Unit selectedUnit;
    private Hex selectedHex;
    private Building selectedBuilding;
    private final ListenerSystem listenerSystem;
    private final AnimationManager animationManager;
    private boolean readyToMove;
    private final ConnectViews connectViews;
    public SelectSystem(ListenerSystem listenerSystem, AnimationManager animationManager, ConnectViews connectViews) {
        this.listenerSystem = listenerSystem;
        this.animationManager = animationManager;
        this.connectViews = connectViews;
    }

    public void selectUnit(Unit unit) {
        if (this.selectedUnit == unit) {
            this.selectedUnit = null;
            listenerSystem.getSelectEvent().UnitSelected(null);
        } else {
            this.selectedUnit = unit;
            this.selectedBuilding = null;
            listenerSystem.getSelectEvent().UnitSelected(unit);
        }
    }

    public void selectHex(Hex hex) {
        if (this.selectedHex == hex) {
            this.selectedHex = null;
            listenerSystem.getSelectEvent().HexSelected(null);
        } else {
            this.selectedHex = hex;
            if (selectedUnit != null)
                readyToMove = true;
            else
                readyToMove = false;
            listenerSystem.getSelectEvent().HexSelected(hex);
        }
    }


    public void hoverHex(Hex hex) {
        if (this.selectedUnit != null) {
            var unitLogic = this.selectedUnit.getLogic();
            if (unitLogic != null && unitLogic.canReach(hex)) {
                java.util.List<Hex> path = unitLogic.getBestPath(hex);
                listenerSystem.getSelectEvent().likelyPath(path, hex);
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