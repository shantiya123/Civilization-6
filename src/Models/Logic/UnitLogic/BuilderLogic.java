package Models.Logic.UnitLogic;

import Models.Elements.Buildings.*;
import Models.Elements.Hex.*;
import Models.Elements.Resources.Stone;
import Models.Elements.Units.Builder;
import Models.Elements.Units.Unit;
import Models.Logic.BuildingLogic.BuildingLogic;
import Models.Records.UnitRecord;

public class BuilderLogic extends UnitLogic {
    public BuilderLogic(Unit unit) {
        super(unit);
    }

    private Builder builder;

    public void build(Building building) throws Exception {
        if (!CheckBuildingHex(building))
            throw new Exception("Invalid building on this hex");
        try {
            BuildingLogic.Build(builder, building.getClass());
            SpendCharge();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void SpendCharge() {
        if (builder.getCharges() <= 0)
            UnitRecord.remove(builder);
        builder.setCharges(builder.getCharges() - 1);
    }

    private boolean CheckBuildingHex(Building building) {
        Hex hex = builder.getHex();
        if (building.getClass().equals(Farm.class)) {
            return hex.getClass().equals(GrassHex.class);
        } else if (building.getClass().equals(StoneMine.class)) {
            return hex.getClass().equals(MountainHex.class);
        } else if (building.getClass().equals(LumberMill.class)) {
            return hex.getClass().equals(ForestHex.class);

        } else if (building.getClass().equals(IronMine.class)) {
            return hex.getClass().equals(MountainHex.class) && hex.isAdditionalResources();
        } else if (building.getClass().equals(Stable.class)) {
            return hex.getClass().equals(LandHex.class) && hex.isAdditionalResources();
        } else if (building.getClass().equals(Settlement.class))
            return hex.getClass().equals(LandHex.class);
        return false;
    }
}
