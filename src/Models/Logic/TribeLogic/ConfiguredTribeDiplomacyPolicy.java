package Models.Logic.TribeLogic;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import java.util.Map;

/** Shared implementation for the five balance configurations. Gift values are per ten resources. */
public class ConfiguredTribeDiplomacyPolicy implements TribeDiplomacyPolicy {
    private final int intrusion;
    private final Map<Class<? extends Resource>, Integer> giftPerTen;
    private final int successfulTrade;
    private final int missionCompleted;
    private final int missionFailed;
    private final int peaceAccepted;

    protected ConfiguredTribeDiplomacyPolicy(int intrusion, Map<Class<? extends Resource>, Integer> giftPerTen,
                                             int successfulTrade, int missionCompleted,
                                             int missionFailed, int peaceAccepted) {
        this.intrusion = intrusion;
        this.giftPerTen = giftPerTen;
        this.successfulTrade = successfulTrade;
        this.missionCompleted = missionCompleted;
        this.missionFailed = missionFailed;
        this.peaceAccepted = peaceAccepted;
    }

    @Override public int territoryIntrusion() { return intrusion; }
    @Override public int gift(Class<? extends Resource> resourceType, int amount) {
        return giftPerTen.getOrDefault(resourceType, 0) * amount / 10;
    }
    @Override public int successfulTrade() { return successfulTrade; }
    @Override public int missionCompleted() { return missionCompleted; }
    @Override public int missionFailed() { return missionFailed; }
    @Override public int peaceAccepted() { return peaceAccepted; }
}
