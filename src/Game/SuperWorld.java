package Game;

import Models.Records.*;
import Models.Manager.HexManager;
import Models.Manager.Hexutils;
import Game.Synchronization.CommitHistory;

public class SuperWorld {
    private final BuildingRecord buildingRecord;
    private final BorderRecorder borderRecorder;
    private final HexRecord hexRecord;
    private final UnitRecord unitRecord;
    private final TribeRecord tribeRecord;
    private final ChangeTracker changeTracker;
    private final CommitHistory commitHistory;
    private final Hexutils hexutils;
    private final HexManager hexManager;

    public SuperWorld() {
        buildingRecord = new BuildingRecord();
        borderRecorder = new BorderRecorder();
        hexRecord = new HexRecord();
        unitRecord = new UnitRecord();
        tribeRecord = new TribeRecord();
        changeTracker = new ChangeTracker();
        commitHistory = new CommitHistory();
        hexutils = new Hexutils();
        hexManager = new HexManager(300, 220, hexRecord, hexutils);
    }

    public BuildingRecord getBuildingRecord() {
        return buildingRecord;
    }

    public BorderRecorder getBorderRecorder() {
        return borderRecorder;
    }

    public HexRecord getHexRecord() {
        return hexRecord;
    }

    public UnitRecord getUnitRecord() {
        return unitRecord;
    }

    public TribeRecord getTribeRecord() {
        return tribeRecord;
    }

    public ChangeTracker getChangeTracker() {
        return changeTracker;
    }

    public CommitHistory getCommitHistory() { return commitHistory; }

    public Hexutils getHexutils() { return hexutils; }
    public HexManager getHexManager() { return hexManager; }
}
