package Models.Elements.Units;

import Models.Logic.UnitLogic.BuilderLogic;

public class Builder extends Unit {

    private int charges;

    public Builder() {
        super(1, 4);
        this.charges = 3;
        setLogic(new BuilderLogic(this));
    }

    public int getCharges() { return charges; }
    public void setCharges(int charges) { this.charges = charges; }
}