package Models.Elements.Units;

import Models.Elements.Units.Unit;

public class Builder extends Unit {

    private int charges;

    public Builder() {
        super(1, 4);
        this.charges = 3;
        setLogic();
    }

    public int getCharges() { return charges; }
    public void setCharges(int charges) { this.charges = charges; }
}