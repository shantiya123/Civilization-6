package Game;

import Models.Draw.UnitPositionCalculator;
import Models.Manager.HexManager;
import Models.Manager.Hexutils;
import Models.Records.BuildingRecord;
import Models.Records.HexRecord;
import Models.Records.ResourceRecord;
import Models.Records.UnitRecord;

public class World {
    private final BuildingRecord buildingRecord;
    private final HexRecord hexRecord;
    private final ResourceRecord resourceRecord;
    private final UnitRecord unitRecord;
    private final HexManager hexManager;
    private final Hexutils hexutils;

    public World() {
        buildingRecord  = new BuildingRecord();
        resourceRecord  = new ResourceRecord();
        unitRecord      = new UnitRecord();
        hexutils        = new Hexutils();

        hexRecord  = new HexRecord();
        hexManager = new HexManager(300, 220 , hexRecord , hexutils);
        hexRecord.setHexManager(hexManager);

        // Keep unit x/y/size in sync whenever hex positions change (zoom/pan/add)
        hexManager.setOnPositionsChanged(() -> UnitPositionCalculator.refreshAll(unitRecord));
    }

    public BuildingRecord getBuildingRecord()  { return buildingRecord; }
    public HexRecord      getHexRecord()       { return hexRecord; }
    public ResourceRecord getResourceRecord()  { return resourceRecord; }
    public UnitRecord     getUnitRecord()      { return unitRecord; }
    public HexManager     getHexManager()      { return hexManager; }
    public Hexutils       getHexutils()        { return hexutils; }
}