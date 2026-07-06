package Models.Elements.Units;

import Models.Elements.Units.Unit;

public class Builder extends Unit {

    private int charges;

    public Builder(int foodNeed, int initialAP, int charges) {
        super(foodNeed, initialAP);
        this.charges = charges;
    }

    public int getCharges() { return charges; }
    public void setCharges(int charges) { this.charges = charges; }
}