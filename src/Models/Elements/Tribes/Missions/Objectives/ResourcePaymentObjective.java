package Models.Elements.Tribes.Missions.Objectives;

import Models.Elements.Resources.Resource;

import java.util.Map;

public class ResourcePaymentObjective implements MissionObjective {

    private final Map<Class<? extends Resource>, Integer> requiredResources;

    public ResourcePaymentObjective(Map<Class<? extends Resource>, Integer> requiredResources) {
        this.requiredResources = requiredResources;
    }

    public Map<Class<? extends Resource>, Integer> getRequiredResources() {
        return requiredResources;
    }
}
