package Game;

import Base.Player;
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
    private final SuperWorld superWorld;
    private Player player;
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
    private final ChangeTracker changeTracker;
    private TownHall townHall;
    private Hex centerHex;
    private Season season;

    public World() {
        this(new SuperWorld(), true);
    }

    /** Creates a new player world in the supplied authoritative game state. */
    public World(SuperWorld superWorld) {
        this(superWorld, true);
    }

    public World(boolean generateNewGame) {
        this(new SuperWorld(), generateNewGame);
    }

    /** Creates a player-specific world that shares the supplied game's global state. */
    public World(SuperWorld superWorld, boolean generateNewGame) {
        this.superWorld = java.util.Objects.requireNonNull(superWorld, "superWorld");
        buildingRecord = superWorld.getBuildingRecord();
        unitRecord = superWorld.getUnitRecord();
        tribeRecord = superWorld.getTribeRecord();
        hexRecord = superWorld.getHexRecord();
        borderRecorder = superWorld.getBorderRecorder();
        resourceRecord  = new ResourceRecord();
        technologyRecord = new TechnologyRecord();
        hexutils = superWorld.getHexutils();
        progressionAccess = new ProgressionAccess();
        worldCapabilities = new WorldCapabilities();
        changeTracker = superWorld.getChangeTracker();
        season = new Spring();
        hexManager = superWorld.getHexManager();
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
            changeTracker.markCreated(centerHex);
            changeTracker.markCreated(hex2);
            changeTracker.markCreated(hex3);
            changeTracker.markCreated(townHall);
            changeTracker.markCreated(state);
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
        return state.getHappiness();
    }

    public void setHappiness(int happiness) {
        state.setHappiness(happiness);
    }

    public int getCombatUnitCap() {
        return state.getCombatUnitCap();
    }

    public void setCombatUnitCap(int combatUnitCap) {
        state.setCombatUnitCap(combatUnitCap);
    }

    public WorldState getState() {
        return state;
    }

    public ChangeTracker getChangeTracker() {
        return changeTracker;
    }

    public SuperWorld getSuperWorld() { return superWorld; }
}
