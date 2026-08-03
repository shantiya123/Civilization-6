package Models.Elements.Tribes.Missions;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;
import Models.Elements.Tribes.Missions.Objectives.ResourcePaymentObjective;
import Models.Elements.Tribes.Missions.Rewards.RelationReward;
import Models.Elements.Tribes.Missions.Rewards.ResourceReward;
import Models.Elements.Tribes.Missions.States.AvailableMissionState;
import Models.Elements.Tribes.Tribe;

import java.util.List;
import java.util.Map;

public class FoodStorageMission extends Mission {

    public FoodStorageMission(Tribe sourceTribe) {
        super(sourceTribe, "Food Storage Assistance", "Pay 20 Wood and 10 Stone to the tribe.", 5,
                new AvailableMissionState(), new ResourcePaymentObjective(Map.of(Wood.class, 20, Stone.class, 10)),
                List.of(new ResourceReward(Map.of(Food.class, 30)), new RelationReward(15)));
    }
}
