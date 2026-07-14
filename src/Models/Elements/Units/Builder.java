package Models.Elements.Units;

import Models.Logic.UnitLogic.BuilderLogic;

import java.awt.*;

public class Builder extends Unit {

    private int charges;

    public Builder() {
        super(1, 4 , 3);
        this.charges = 3;
        setLogic(new BuilderLogic(this));
        setColor(new Color(179, 78, 17));
    }

    public int getCharges() { return charges; }
    public void setCharges(int charges) { this.charges = charges; }
}