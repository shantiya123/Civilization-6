package Models.Elements.Units;

import Models.Elements.Units.Unit;

public class Explorer extends Unit {

    private final int visionRadius;

    public Explorer(int foodNeed, int initialAP, int visionRadius) {
        super(foodNeed, initialAP);
        this.visionRadius = visionRadius;
    }

    public int getVisionRadius() { return visionRadius; }
}