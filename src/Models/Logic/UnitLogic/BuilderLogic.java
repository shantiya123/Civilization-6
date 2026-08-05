package Models.Logic.UnitLogic;

import Game.World;
import Models.Elements.Buildable.Buildings.*;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Hex.*;
import Models.Elements.Units.Builder;
import Models.Logic.BuildingLogic.BuildingLogic;
import Models.Logic.ConstructureLogic.ConstructureLogic;

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

    public void destroy(Building building) throws Exception {
        if (building == null || building.getHex() == null
                || building.getHex() != builder.getHex()
                || !world.getBuildingRecord().getAll().contains(building)) {
            throw new Exception("Builder is not standing on this building");
        }
        if (builder.getAP() < 1) {
            throw new Exception("Builder does not have enough AP to destroy a building");
        }

        builder.setAP(builder.getAP() - 1);
        new BuildingLogic(building, world).decay();
    }

    public Constructure createConstructure(Class<? extends Constructure> constructureClass,
                                            Hex secondHex) throws Exception {
        return ConstructureLogic.Build(world, builder, constructureClass, secondHex);
    }

    public void decayConstructure(Constructure constructure) throws Exception {
        if (constructure == null || !world.getBorderRecorder().getAll().contains(constructure)) {
            throw new Exception("Constructure does not exist");
        }
        new ConstructureLogic(constructure, world).decay();
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
