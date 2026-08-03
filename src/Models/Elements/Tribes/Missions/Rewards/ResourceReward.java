package Models.Elements.Tribes.Missions.Rewards;

import Models.Elements.Resources.Resource;

import java.util.Map;

public class ResourceReward implements MissionReward {

    private final Map<Class<? extends Resource>, Integer> resources;

    public ResourceReward(Map<Class<? extends Resource>, Integer> resources) {
        this.resources = resources;
    }

    public Map<Class<? extends Resource>, Integer> getResources() { return resources; }
}
