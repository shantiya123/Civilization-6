package Models.Elements.Units;

import Game.World;
import Models.Logic.UnitLogic.BuilderLogic;

import java.awt.*;

public class Builder extends Unit {

    private int charges;

    public Builder(World world) {
        super(1, 4 , 3);
        this.charges = 3;
        setLogic(new BuilderLogic(this, world));
        setColor(new Color(179, 78, 17));
        setHP(1);
    }

    public int getCharges() { return charges; }
    public void setCharges(int charges) { this.charges = charges; }
}
