package Models.Elements.Units;

import Models.Logic.UnitLogic.ExplorerLogic;

import java.awt.*;

public class Explorer extends Unit {


    public Explorer() {
        super(1, 8 , 5);
        setLogic(new ExplorerLogic(this));
        setColor(Color.blue);
    }

}