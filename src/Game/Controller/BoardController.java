package Game.Controller;

import Game.Systems.BoardSystem;
import Game.Systems.ElementSystem.MovementSystem;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.EndTurnRequestedEvent;
import Game.Systems.SelectSystem;
import Game.World;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Builder;
import Models.Elements.Units.Unit;
import Models.Logic.ConstructureLogic.ConstructureLogic;

public class BoardController {
    private Finder finder;
    private World world;
    private MovementSystem movementSystem;
    private BoardSystem boardSystem;
    private SelectSystem selectSystem;
    private final EventBus eventBus;
    private boolean borderBuilding;
    private Class<? extends Constructure> pendingConstructureClass;

    public BoardController(World world, MovementSystem movementSystem, BoardSystem boardSystem,
                           SelectSystem selectSystem, EventBus eventBus) {
        this.world = world;
        this.movementSystem = movementSystem;
        this.boardSystem = boardSystem;
        this.selectSystem = selectSystem;
        this.finder = new Finder(world);
        this.eventBus = eventBus;
    }

    public void mouseClicked(int x, int y) {
        Unit unit = finder.findUnit(x, y);
        if (unit != null) {
            selectSystem.selectUnit(unit);
            movementSystem.UnitMove();
        } else {
            Hex hex = finder.findHex(x, y);
            if (hex != null) {
                if (borderBuilding) {
                    resolveBorderBuilding(hex);
                } else {
                    selectSystem.selectHex(hex);
                    movementSystem.UnitMove();
                }
            }
        }
    }

    public void mouseWheelChanged(int rotate) {
        boardSystem.zoom(rotate * -1);
    }

    public void mouseDragged(int x , int y) {
        boardSystem.moveBoard(x , y);
    }

    public void mouseMoved(int x, int y) {
        Hex hoveredHex = finder.findHex(x, y);
        if (hoveredHex != null) {
            selectSystem.hoverHex(hoveredHex);
        }
    }

    public void TurnEnded(){
        eventBus.publish(new EndTurnRequestedEvent());
    }

    /** Enters "pick a neighbor hex" mode for the given constructure type (wall/road). */
    public void requestBorderBuilding(Class<? extends Constructure> constructureClass) {
        this.pendingConstructureClass = constructureClass;
        this.borderBuilding = true;
    }

    /** Leaves border-building mode without building anything. */
    public void cancelBorderBuilding() {
        this.borderBuilding = false;
        this.pendingConstructureClass = null;
    }

    public boolean isBorderBuilding() {
        return borderBuilding;
    }

    private void resolveBorderBuilding(Hex targetHex) {
        Unit selectedUnit = selectSystem.getSelectedUnit();
        if (selectedUnit instanceof Builder builder) {
            try {
                ConstructureLogic.build(world, builder, pendingConstructureClass, targetHex);
            } catch (Exception ignored) {
                // Not a neighbor, already occupied, missing resources, etc. -> just cancel below.
            }
        }
        cancelBorderBuilding();
    }
}