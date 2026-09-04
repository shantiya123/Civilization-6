package Game.Client.Drawers;

import Models.Elements.Buildable.Buildings.Building;
import Models.Records.BuildingRecord;
import java.awt.*;

public class DrawBuildings {
    private final BuildingRecord buildingRecord;

    public DrawBuildings(BuildingRecord buildingRecord) {
        this.buildingRecord = buildingRecord;
    }

    public void draw(Graphics g) {
        for (Building building : buildingRecord.getAll())
            building.getDraw().draw(g);
    }
}