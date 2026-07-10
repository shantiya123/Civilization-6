package Models.Logic;

import Game.Generate;
import Models.Records.BuildingRecord;
import Models.Records.HexRecord;
import Models.Records.ResourceRecord;
import Models.Records.UnitRecord;

public abstract class Logic {
    protected UnitRecord unitRecord = Generate.getGame().getWorld().getUnitRecord();
    protected ResourceRecord resourceRecord = Generate.getGame().getWorld().getResourceRecord();
    protected HexRecord hexRecord = Generate.getGame().getWorld().getHexRecord();
    protected BuildingRecord buildingRecord = Generate.getGame().getWorld().getBuildingRecord();

    public UnitRecord getUnitRecord() {
        return unitRecord;
    }

    public ResourceRecord getResourceRecord() {
        return resourceRecord;
    }

    public HexRecord getHexRecord() {
        return hexRecord;
    }

    public BuildingRecord getBuildingRecord() {
        return buildingRecord;
    }
}
