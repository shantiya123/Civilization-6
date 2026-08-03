package Models.Elements.Tribes.Missions;

import Models.Elements.Buildings.Dock;
import Models.Elements.Resources.Food;
import Models.Elements.Tribes.Missions.Objectives.BuildingConstructionObjective;
import Models.Elements.Tribes.Missions.Rewards.BuildingDiscountReward;
import Models.Elements.Tribes.Missions.Rewards.ResourceReward;
import Models.Elements.Tribes.Missions.States.AvailableMissionState;
import Models.Elements.Tribes.Tribe;

import java.util.List;
import java.util.Map;

public class CoastalDevelopmentMission extends Mission {

    public CoastalDevelopmentMission(Tribe sourceTribe) {
        super(sourceTribe, "Coastal Development", "Build a Dock within 4 hexes of the tribe's camp.", 10,
                new AvailableMissionState(), new BuildingConstructionObjective(Dock.class, 4),
                List.of(new ResourceReward(Map.of(Food.class, 30)), new BuildingDiscountReward(Dock.class)));
    }
}
