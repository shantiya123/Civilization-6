package Game.Controller;

import Game.Systems.BoardSystem;
import Game.Systems.ElementSystem.MovementSystem;
import Game.Systems.Listeners.ListenerSystem;
import Game.Systems.SelectSystem;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

public class BoardController {
    private Finder finder;
    private World world;
    private MovementSystem movementSystem;
    private BoardSystem boardSystem;
    private SelectSystem selectSystem;
    private final ListenerSystem listenerSystem;

    public BoardController(World world, MovementSystem movementSystem, BoardSystem boardSystem, SelectSystem selectSystem, ListenerSystem listenerSystem) {
        this.world = world;
        this.movementSystem = movementSystem;
        this.boardSystem = boardSystem;
        this.selectSystem = selectSystem;
        this.finder = new Finder(world);
        this.listenerSystem = listenerSystem;
    }

    public void mouseClicked(int x, int y) {
        Unit unit = finder.findUnit(x, y);
        if (unit != null) {
            selectSystem.selectUnit(unit);
        } else {
            Hex hex = finder.findHex(x, y);
            if (hex != null) {
                selectSystem.selectHex(hex);
            }
        }


        movementSystem.UnitMove();
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
        listenerSystem.getTurnListener().EndTurn();
    }
}