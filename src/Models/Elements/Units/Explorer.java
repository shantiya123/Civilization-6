package Models.Elements.Units;

import Models.Logic.UnitLogic.ExplorerLogic;

public class Explorer extends Unit {


    public Explorer() {
        super(1, 8);
        setLogic(new ExplorerLogic(this));
    }

}