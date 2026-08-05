package Models.Logic.UnitLogic;

import Game.World;
import Models.Elements.Buildable.Buildings.*;
import Models.Elements.Hex.*;
import Models.Elements.Units.Builder;
import Models.Logic.BuildingLogic.BuildingLogic;

public class BuilderLogic extends UnitLogic {

    private Builder builder;

    public BuilderLogic(Builder builder, World world) {
        super(builder, world);
        this.builder = builder;
    }

    public void build(Building building) throws Exception {
        if (!CheckBuildingHex(building))
            throw new Exception("Invalid building on this hex");
        try {
            BuildingLogic.Build(world, builder, building.getClass());
            new BuilderLogic(builder, world).SpendCharge();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void SpendCharge() {
        if (builder.getCharges() <= 0)
            world.getUnitRecord().remove(builder);
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
