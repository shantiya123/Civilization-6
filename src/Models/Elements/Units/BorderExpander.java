package Models.Elements.Units;

import Models.Logic.UnitLogic.BorderExpanderLogic;

import java.awt.*;

public class BorderExpander extends Unit {

    public BorderExpander() {
        super(2, 3 , 3);
        setLogic(new BorderExpanderLogic(this));
        setColor(new Color(218, 11, 208));
    }

}