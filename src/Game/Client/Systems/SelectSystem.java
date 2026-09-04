package Game.Client.Systems;

import Game.Server.Systems.EventSystem.EventBus;
import Game.Client.Systems.EventSystem.Events.BorderSelectionChangedEvent;
import Game.Client.Systems.EventSystem.Events.HexSelectionChangedEvent;
import Game.Client.Systems.EventSystem.Events.MovementPreviewChangedEvent;
import Game.Server.Systems.EventSystem.Events.UnitSelectionChangedEvent;
import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class SelectSystem {
    private Unit selectedUnit;
    private Hex selectedHex;
    private Building selectedBuilding;
    private Border selectedBorder;
    private final EventBus eventBus;
    private boolean readyToMove;
    public SelectSystem(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void selectUnit(Unit unit) {
        if (this.selectedUnit == unit) {
            this.selectedUnit = null;
            eventBus.publish(new UnitSelectionChangedEvent(null));
        } else {
            this.selectedUnit = unit;
            this.selectedBuilding = null;
            this.selectedBorder = null;
            eventBus.publish(new UnitSelectionChangedEvent(unit));
        }
    }

    public void selectHex(Hex hex) {
        if (this.selectedHex == hex) {
            this.selectedHex = null;
            eventBus.publish(new HexSelectionChangedEvent(null));
        } else {
            this.selectedHex = hex;
            this.selectedBorder = null;

            if (selectedUnit != null)
                readyToMove = true;
            else
                readyToMove = false;

            eventBus.publish(new HexSelectionChangedEvent(hex));
        }
    }

    public void selectBorder(Border border) {
//        System.out.println("the selectBorder called ");
        if (this.selectedBorder == border) {
            this.selectedBorder = null;
//            System.out.println("this.selectedBorder == border");
            eventBus.publish(new BorderSelectionChangedEvent(null));
        } else {
            this.selectedBorder = border;
            this.selectedUnit = null;
            this.selectedHex = null;
            this.selectedBuilding = null;
            this.readyToMove = false;
            eventBus.publish(new BorderSelectionChangedEvent(border));
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

    public Border getSelectedBorder() {
        return selectedBorder;
    }

    public boolean isReadyToMove() {
        return readyToMove;
    }

    public void setReadyToMove(boolean readyToMove) {
        this.readyToMove = readyToMove;
    }
}