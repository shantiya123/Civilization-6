package Game.Systems;

import Game.Managers.AnimationManager;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.HexSelectionChangedEvent;
import Game.Systems.EventSystem.Events.MovementPreviewChangedEvent;
import Game.Systems.EventSystem.Events.UnitSelectionChangedEvent;
import Models.ConnectViews;
import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class SelectSystem {
    private Unit selectedUnit;
    private Hex selectedHex;
    private Building selectedBuilding;
    private final EventBus eventBus;
    private final AnimationManager animationManager;
    private boolean readyToMove;
    private final ConnectViews connectViews;
    public SelectSystem(EventBus eventBus, AnimationManager animationManager, ConnectViews connectViews) {
        this.eventBus = eventBus;
        this.animationManager = animationManager;
        this.connectViews = connectViews;
    }

    public void selectUnit(Unit unit) {
        if (this.selectedUnit == unit) {
            this.selectedUnit = null;
            eventBus.publish(new UnitSelectionChangedEvent(null));
        } else {
            this.selectedUnit = unit;
            this.selectedBuilding = null;
            eventBus.publish(new UnitSelectionChangedEvent(unit));
        }
    }

    public void selectHex(Hex hex) {
        if (this.selectedHex == hex) {
            this.selectedHex = null;
            eventBus.publish(new HexSelectionChangedEvent(null));
        } else {
            this.selectedHex = hex;
            if (selectedUnit != null)
                readyToMove = true;
            else
                readyToMove = false;
            eventBus.publish(new HexSelectionChangedEvent(hex));
        }
    }


    public void hoverHex(Hex hex) {
        if (this.selectedUnit != null) {
            var unitLogic = this.selectedUnit.getLogic();
            if (unitLogic != null && unitLogic.canReach(hex)) {
                java.util.List<Hex> path = unitLogic.getBestPath(hex);
                eventBus.publish(new MovementPreviewChangedEvent(path, hex));
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
