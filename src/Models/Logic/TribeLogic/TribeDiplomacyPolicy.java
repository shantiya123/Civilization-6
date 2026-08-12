package Models.Logic.TribeLogic;

import Models.Elements.Resources.Resource;

/** Tribe-specific relationship values for the same player action. */
public interface TribeDiplomacyPolicy {
    int territoryIntrusion();
    int gift(Class<? extends Resource> resourceType, int amount);
    int successfulTrade();
    int missionCompleted();
    int missionFailed();
    int peaceAccepted();
}
