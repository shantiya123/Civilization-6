package Models.Draw;

import Models.Elements.Buildings.Building;
import java.awt.*;

public class BuildingDraw implements Draw {
    private final Building building;

    public BuildingDraw(Building building) {
        this.building = building;
    }

    @Override
    public void draw(Graphics g) {
        // TODO: draw building
    }
}