package Game;

import Models.Manager.HexManager;
import Models.Manager.Hexutils;
import Models.Records.BuildingRecord;
import Models.Records.HexRecord;
import Models.Records.ResourceRecord;
import Models.Records.UnitRecord;

public class World {
    private BuildingRecord buildingRecord;
    private HexRecord hexRecord;
    private ResourceRecord resourceRecord;
    private UnitRecord unitRecord;
    private HexManager hexManager;
    private Hexutils hexutils;

    public World() {
        buildingRecord = new BuildingRecord();
        hexRecord = new HexRecord();
        resourceRecord = new ResourceRecord();
        unitRecord = new UnitRecord();

    }

    public BuildingRecord getBuildingRecord() {
        return buildingRecord;
    }

    public HexRecord getHexRecord() {
        return hexRecord;
    }

    public ResourceRecord getResourceRecord() {
        return resourceRecord;
    }

    public UnitRecord getUnitRecord() {
        return unitRecord;
    }
}
