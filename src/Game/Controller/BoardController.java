package Game.Controller;

import Animation.BoardAnimations;
import Animation.ZoomAnimation;
import Game.Systems.BoardSystem;
import Game.Systems.ElementSystem.MovementSystem;
import Game.Systems.SelectSystem;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Manager.HexManager;

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

    public void mouseClicked(int x , int y){


    }
    public void mouseWheelChanged(int rotate){


    }
    public void mouseDragged(){

    }
    public void mouseMoved(){

    }
}