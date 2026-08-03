package Models.Elements.Tribes.Missions;

import Models.Elements.Tribes.Missions.Objectives.DefeatEnemiesObjective;
import Models.Elements.Tribes.Missions.Rewards.RelationReward;
import Models.Elements.Tribes.Missions.Rewards.UnitReward;
import Models.Elements.Tribes.Missions.States.AvailableMissionState;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.Swordsman;

import java.util.List;

public class MilitaryAidMission extends Mission {

    public MilitaryAidMission(Tribe sourceTribe) {
        super(sourceTribe, "Military Aid", "Defeat 2 enemy units near the tribe's camp.", 8,
                new AvailableMissionState(), new DefeatEnemiesObjective(2, 5),
                List.of(new UnitReward(Swordsman.class, 3), new RelationReward(20)));
    }
}
