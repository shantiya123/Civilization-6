package Game;

import Models.Draw.UnitPositionCalculator;
import Models.Elements.Hex.*;
import Models.Elements.ProgressionAccess;
import Models.Elements.Seasons.Season;
import Models.Elements.Seasons.Spring;
import Models.Elements.WorldCapabilities;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallLogic;
import Models.Manager.HexManager;
import Models.Manager.Hexutils;
import Models.Records.BuildingRecord;
import Models.Records.BorderRecorder;
import Models.Records.HexRecord;
import Models.Records.ResourceRecord;
import Models.Records.TechnologyRecord;
import Models.Records.UnitRecord;
import Models.Records.TribeRecord;

public class World {
    private final BuildingRecord buildingRecord;
    private final BorderRecorder borderRecorder;
    private final HexRecord hexRecord;
    private final ResourceRecord resourceRecord;
    private final UnitRecord unitRecord;
    private final TechnologyRecord technologyRecord;
    private final HexManager hexManager;
    private final Hexutils hexutils;
    private final ProgressionAccess progressionAccess;
    private final WorldCapabilities worldCapabilities;
    private final TribeRecord tribeRecord;
    private final WorldState state;
    private TownHall townHall;
    private Hex centerHex;
    private Season season;
    private int Happiness = 0;
    private int combatUnitCap = 5 ;

    public World() {
        this(true);
    }

    /**
     * @param generateNewGame when true (the normal case), performs the usual
     *                        new-game bootstrap: default starter hexes, the
     *                        starting TownHall, and its initial resources.
     *                        Save &amp; Load passes false to obtain a bare
     *                        World whose state is then populated entirely
     *                        from a save file, so that bootstrap never runs
     *                        (and never double-grants starting resources).
     */
    public World(boolean generateNewGame) {
        buildingRecord  = new BuildingRecord();
        borderRecorder = new BorderRecorder();
        resourceRecord  = new ResourceRecord();
        unitRecord      = new UnitRecord();
        technologyRecord = new TechnologyRecord();
        hexutils        = new Hexutils();
        progressionAccess = new ProgressionAccess();
        worldCapabilities = new WorldCapabilities();
        tribeRecord = new TribeRecord();
        season = new Spring();
        hexRecord  = new HexRecord();
        hexManager = new HexManager(300, 220 , hexRecord , hexutils);
        hexManager.setOnPositionsChanged(() -> UnitPositionCalculator.refreshAll(unitRecord));
        hexRecord.setHexManager(hexManager);
        state = new WorldState();

        if (generateNewGame) {
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
    }

    public BuildingRecord getBuildingRecord()  { return buildingRecord; }
    public BorderRecorder getBorderRecorder() { return borderRecorder; }
    public HexRecord      getHexRecord()       { return hexRecord; }
    public ResourceRecord getResourceRecord()  { return resourceRecord; }
    public UnitRecord     getUnitRecord()      { return unitRecord; }
    public TechnologyRecord getTechnologyRecord() { return technologyRecord; }
    public HexManager     getHexManager()      { return hexManager; }
    public Hexutils       getHexutils()        { return hexutils; }
    public ProgressionAccess getProgressionAccess() { return progressionAccess; }
    public WorldCapabilities getWorldCapabilities() { return worldCapabilities; }
    public TribeRecord getTribeRecord() { return tribeRecord; }

    public void Start(){
        new Starter(this).start();
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Season getSeason() {
        return season;
    }

    public TownHall getTownHall() {
        return townHall;
    }

    /**
     * Assigns the world's TownHall. Only the constructor's new-game
     * bootstrap and Save &amp; Load's restore path should call this.
     */
    public void setTownHall(TownHall townHall) {
        this.townHall = townHall;
    }

    public int getHappiness() {
        return Happiness;
    }

    public void setHappiness(int happiness) {
        Happiness = happiness;
    }

    public int getCombatUnitCap() {
        return combatUnitCap;
    }

    public void setCombatUnitCap(int combatUnitCap) {
        this.combatUnitCap = combatUnitCap;
    }

    public WorldState getState() {
        return state;
    }
}