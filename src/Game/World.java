package Game;

import Models.Draw.UnitPositionCalculator;
import Models.Elements.ProgressionAccess;
import Models.Elements.WorldCapabilities;
import Models.Elements.Buildings.TownHall;
import Models.Elements.Hex.ForestHex;
import Models.Elements.Hex.GrassHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallLogic;
import Models.Manager.HexManager;
import Models.Manager.Hexutils;
import Models.Records.BuildingRecord;
import Models.Records.HexRecord;
import Models.Records.ResourceRecord;
import Models.Records.TechnologyRecord;
import Models.Records.UnitRecord;

public class World {
    private final BuildingRecord buildingRecord;
    private final HexRecord hexRecord;
    private final ResourceRecord resourceRecord;
    private final UnitRecord unitRecord;
    private final TechnologyRecord technologyRecord;
    private final HexManager hexManager;
    private final Hexutils hexutils;
    private final ProgressionAccess progressionAccess;
    private final WorldCapabilities worldCapabilities;
    private TownHall townHall;
    private Hex centerHex;

    public World() {
        buildingRecord  = new BuildingRecord();
        resourceRecord  = new ResourceRecord();
        unitRecord      = new UnitRecord();
        technologyRecord = new TechnologyRecord();
        hexutils        = new Hexutils();
        progressionAccess = new ProgressionAccess();
        worldCapabilities = new WorldCapabilities();
        hexRecord  = new HexRecord();
        hexManager = new HexManager(300, 220 , hexRecord , hexutils);
        hexManager.setOnPositionsChanged(() -> UnitPositionCalculator.refreshAll(unitRecord));
        hexRecord.setHexManager(hexManager);

        Generate.publishWorld(this);
        centerHex = new LandHex(0 , 0 , false);
        Hex hex2 = new GrassHex(0 , 1 , false);
        Hex hex3 = new ForestHex( -1 , 1 , false);
        this.townHall = new TownHall(this);
        townHall.setHex(centerHex);
        centerHex.setBuilding(this.townHall);
        hexRecord.add(centerHex);
        hexRecord.add(hex2);
        hexRecord.add(hex3);
        buildingRecord.add(townHall);
        new TownHallLogic(townHall, this).AddInitialResources();
    }

    public BuildingRecord getBuildingRecord()  { return buildingRecord; }
    public HexRecord      getHexRecord()       { return hexRecord; }
    public ResourceRecord getResourceRecord()  { return resourceRecord; }
    public UnitRecord     getUnitRecord()      { return unitRecord; }
    public TechnologyRecord getTechnologyRecord() { return technologyRecord; }
    public HexManager     getHexManager()      { return hexManager; }
    public Hexutils       getHexutils()        { return hexutils; }
    public ProgressionAccess getProgressionAccess() { return progressionAccess; }
    public WorldCapabilities getWorldCapabilities() { return worldCapabilities; }

    public void Start(){
        new Starter(this).start();
    }

    public TownHall getTownHall() {
        return townHall;
    }
}
