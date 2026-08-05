package Models.Elements.Tribes.Missions.Rewards;

import Models.Elements.Buildable.Buildings.Building;

public class BuildingDiscountReward implements MissionReward {

    private final Class<? extends Building> buildingClass;

    public BuildingDiscountReward(Class<? extends Building> buildingClass) {
        this.buildingClass = buildingClass;
    }

    public Class<? extends Building> getBuildingClass() { return buildingClass; }
}
