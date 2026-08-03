package Models.Elements.Tribes.Missions;

import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;
import Models.Elements.Tribes.Missions.Objectives.ResourcePaymentObjective;
import Models.Elements.Tribes.Missions.Rewards.RelationReward;
import Models.Elements.Tribes.Missions.Rewards.ResourceReward;
import Models.Elements.Tribes.Missions.States.AvailableMissionState;
import Models.Elements.Tribes.Tribe;

import java.util.List;
import java.util.Map;

public class MiningToolsMission extends Mission {

    public MiningToolsMission(Tribe sourceTribe) {
        super(sourceTribe, "Mining Tools", "Pay 15 Wood and 10 Iron to the tribe.", 6,
                new AvailableMissionState(), new ResourcePaymentObjective(Map.of(Wood.class, 15, Iron.class, 10)),
                List.of(new ResourceReward(Map.of(Stone.class, 20)), new RelationReward(15)));
    }
}
