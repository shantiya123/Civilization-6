package Models.Elements.Units;

import Game.World;
import Models.Logic.UnitLogic.BorderExpanderLogic;

import java.awt.*;

public class BorderExpander extends Unit {
    public BorderExpander(World world) {
        super(2, 3 , 3);
        setLogic(new BorderExpanderLogic(this, world));
        setColor(new Color(218, 11, 208));
        setHP(1);
        setImage("/Images/Units/BorderExpander.png");
    }
}
