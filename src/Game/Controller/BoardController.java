package Game.Controller;

import Game.Systems.BoardSystem;
import Game.Systems.ElementSystem.MovementSystem;
import Game.Systems.SelectSystem;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Elements.Buildings.Building;

public class BoardController {
    private Finder finder;
    private World world;
    private MovementSystem movementSystem;
    private BoardSystem boardSystem;
    private SelectSystem selectSystem;

    public BoardController(World world, MovementSystem movementSystem, BoardSystem boardSystem, SelectSystem selectSystem) {
        this.world = world;
        this.movementSystem = movementSystem;
        this.boardSystem = boardSystem;
        this.selectSystem = selectSystem;
        this.finder = new Finder(world);
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

        // THIS LINE MUST BE ACTIVE FOR THE MOVEMENT CHECK TO FIRED:
        movementSystem.UnitMove();
    }

    public void mouseWheelChanged(int rotate) {
        boardSystem.zoom(rotate * -1);
    }

    public void mouseDragged() {
        boardSystem.moveBoard();
    }

    public void mouseMoved(int x, int y) {
        Hex hoveredHex = finder.findHex(x, y);
        if (hoveredHex != null) {
            selectSystem.hoverHex(hoveredHex);
        }
    }
}