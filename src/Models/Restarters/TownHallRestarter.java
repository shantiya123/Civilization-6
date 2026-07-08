package Models.Restarters;

import Models.Elements.Buildings.Building;
import Models.Elements.Buildings.TownHall;
import Models.Logic.BuildingLogic.TownHallLogic;
import Models.Records.BuildingRecord;

public final class TownHallRestarter {

    private TownHallRestarter() {}

    public static void produceSafeguard() {
        for (Building building : BuildingRecord.getAll(TownHall.class)) {
            new TownHallLogic((TownHall) building).produceSafeguard();
        }
    }
}
