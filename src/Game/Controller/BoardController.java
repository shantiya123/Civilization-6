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
//        Unit unit = finder.findUnit(x, y);
//        if (unit != null) {
//            selectSystem.selectUnit(unit);
//        } else {
//            Building building = finder.findBuilding(x, y);
//            if (building != null) {
//                selectSystem.buildingSelect(building);
//            } else {
//                Hex hex = finder.findHex(x, y);
//                if (hex != null) {
//                    selectSystem.selectHex(hex);
//                }
//            }
//        }
//
//        // Cascade to pathing or move calculations after selections process
//        movementSystem.UnitMove();
        Hex hex = finder.findHex(x , y);
        selectSystem.selectHex(hex);
    }

    public void mouseWheelChanged(int rotate) {
//        System.out.println("kiir");
        boardSystem.zoom(rotate * -1);
    }

    public void mouseDragged() {
        boardSystem.moveBoard();
    }

    public void mouseMoved(int x , int y) {
        // Left empty intentionally for now
    }
}