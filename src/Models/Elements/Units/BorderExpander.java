package Models.Elements.Units;

import Models.Logic.UnitLogic.BorderExpanderLogic;

public class BorderExpander extends Unit {

    public BorderExpander() {
        super(2, 3);
        setLogic(new BorderExpanderLogic(this));
    }

}