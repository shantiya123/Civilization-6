package Game.Systems.Restarters;

import Models.Elements.Buildings.Building;
import Models.Elements.Buildings.TownHall;
import Models.Logic.BuildingLogic.BuildingLogic;
import Models.Logic.BuildingLogic.TownHallLogic;
import Models.Records.BuildingRecord;

public final class TownHallRestarter {
    private BuildingRecord buildingRecord;

    public TownHallRestarter(BuildingRecord buildingRecord) {
        this.buildingRecord = buildingRecord;
    }

    public void produceSafeguard() {
        for (Building building : buildingRecord.getAll(TownHall.class)) {
            new TownHallLogic((TownHall) building).produceSafeguard();
        }
    }
}
