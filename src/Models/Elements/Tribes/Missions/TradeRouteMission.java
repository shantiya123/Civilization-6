package Models.Elements.Tribes.Missions;

import Models.Elements.Tribes.Missions.Objectives.RoadConnectionObjective;
import Models.Elements.Tribes.Missions.Rewards.RelationReward;
import Models.Elements.Tribes.Missions.Rewards.TradeRateBonusReward;
import Models.Elements.Tribes.Missions.States.AvailableMissionState;
import Models.Elements.Tribes.Tribe;

import java.util.List;

public class TradeRouteMission extends Mission {

    public TradeRouteMission(Tribe sourceTribe) {
        super(sourceTribe, "Trade Route Connection", "Build a continuous road to the tribe's camp.", 10,
                new AvailableMissionState(), new RoadConnectionObjective(),
                List.of(new TradeRateBonusReward(10), new RelationReward(20)));
    }
}
