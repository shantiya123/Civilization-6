package Game;

import Models.ConnectDrawing;
import Models.ConnectViews;
import Models.Draw.UnitPositionCalculator;
import Models.Elements.Buildings.TownHall;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.LandHex;
import Models.Logic.BuildingLogic.TownHallGenerateUnit;
import Models.Logic.BuildingLogic.TownHallLogic;
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
    private final ConnectViews connectViews;
    private ConnectDrawing connectDrawing;
    private TownHall townHall;
    private Hex centerHex;

    public World() {
        buildingRecord  = new BuildingRecord();
        resourceRecord  = new ResourceRecord();
        unitRecord      = new UnitRecord();
        hexutils        = new Hexutils();
        connectDrawing = new ConnectDrawing();
        hexRecord  = new HexRecord();
        hexManager = new HexManager(300, 220 , hexRecord , hexutils);
        hexManager.setOnPositionsChanged(() -> UnitPositionCalculator.refreshAll(unitRecord));
        hexRecord.setHexManager(hexManager);
        connectViews = new ConnectViews();

        Generate.publishWorld(this);
        centerHex = new LandHex(0 , 0 , false);
        this.townHall = new TownHall();
        townHall.setHex(centerHex);
        centerHex.setBuilding(this.townHall);
        hexRecord.add(centerHex);
        buildingRecord.add(townHall);
        new TownHallLogic(townHall).AddInitialResources();
    }

    public BuildingRecord getBuildingRecord()  { return buildingRecord; }
    public HexRecord      getHexRecord()       { return hexRecord; }
    public ResourceRecord getResourceRecord()  { return resourceRecord; }
    public UnitRecord     getUnitRecord()      { return unitRecord; }
    public HexManager     getHexManager()      { return hexManager; }
    public Hexutils       getHexutils()        { return hexutils; }

    public ConnectDrawing getConnectDrawing() {
        return connectDrawing;
    }

    public ConnectViews getConnectViews() {
        return connectViews;
    }

    public void setConnectDrawing(ConnectDrawing connectDrawing) {
        this.connectDrawing = connectDrawing;
    }

    public void Start(){
        new Starter(this).start();
    }

    public TownHall getTownHall() {
        return townHall;
    }
}