package Models.Elements.Units;

import Models.Elements.Units.Unit;

public class Explorer extends Unit {


    public Explorer(int foodNeed, int initialAP) {
        super(foodNeed, initialAP);
        foodNeed = 1;
        initialAP = 8;
    }

}