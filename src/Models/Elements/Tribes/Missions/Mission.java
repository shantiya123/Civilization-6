package Models.Elements.Tribes.Missions;

import Models.Elements.Tribes.Missions.Objectives.MissionObjective;
import Models.Elements.Tribes.Missions.Rewards.MissionReward;
import Models.Elements.Tribes.Missions.States.MissionState;
import Models.Elements.Tribes.Tribe;

import java.util.List;

public abstract class Mission {

    protected Tribe sourceTribe;
    protected String title;
    protected String description;
    protected int remainingTurns;
    protected MissionState state;
    protected MissionObjective objective;
    protected List<MissionReward> rewards;

    protected Mission(Tribe sourceTribe, String title, String description, int remainingTurns,
                      MissionState state, MissionObjective objective, List<MissionReward> rewards) {
        this.sourceTribe = sourceTribe;
        this.title = title;
        this.description = description;
        this.remainingTurns = remainingTurns;
        this.state = state;
        this.objective = objective;
        this.rewards = rewards;
    }

    public Tribe getSourceTribe() { return sourceTribe; }
    public void setSourceTribe(Tribe sourceTribe) { this.sourceTribe = sourceTribe; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getRemainingTurns() { return remainingTurns; }
    public void setRemainingTurns(int remainingTurns) { this.remainingTurns = remainingTurns; }
    public MissionState getState() { return state; }
    public void setState(MissionState state) { this.state = state; }
    public MissionObjective getObjective() { return objective; }
    public void setObjective(MissionObjective objective) { this.objective = objective; }
    public List<MissionReward> getRewards() { return rewards; }
    public void setRewards(List<MissionReward> rewards) { this.rewards = rewards; }
}
