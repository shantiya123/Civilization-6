package Models.Elements.Tribes.Missions.Objectives;

import Models.Elements.Buildable.Buildings.Building;

public class BuildingConstructionObjective implements MissionObjective {

    private final Class<? extends Building> buildingClass;
    private final int maximumDistance;

    public BuildingConstructionObjective(Class<? extends Building> buildingClass, int maximumDistance) {
        this.buildingClass = buildingClass;
        this.maximumDistance = maximumDistance;
    }

    public Class<? extends Building> getBuildingClass() { return buildingClass; }
    public int getMaximumDistance() { return maximumDistance; }
}
