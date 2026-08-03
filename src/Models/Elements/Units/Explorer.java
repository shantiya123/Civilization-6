package Models.Elements.Units;

import Game.World;
import Models.Logic.UnitLogic.ExplorerLogic;

import java.awt.*;

public class Explorer extends Unit {


    public Explorer(World world) {
        super(1, 8 , 5);
        setLogic(new ExplorerLogic(this, world));
        setColor(Color.blue);
    }

}
