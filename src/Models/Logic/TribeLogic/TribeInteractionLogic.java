package Models.Logic.TribeLogic;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;
import Models.Elements.Tribes.Tribe;
import java.util.List;
import java.util.Map;

/** Implements state-authorized tribe interactions that are independent of combat AI. */
public final class TribeInteractionLogic {
    private static final Map<Class<? extends Resource>, Integer> PEACE_COST = Map.of(Food.class, 30, Wood.class, 30, Iron.class, 30);
    private TribeInteractionLogic() { }

    public static void declareWar(Tribe tribe) {
        if (tribe.isAllianceActive()) tribe.getWorld().setHappiness(tribe.getWorld().getHappiness() - 15);
        else if (tribe.getRelationship() >= 20) tribe.getWorld().setHappiness(tribe.getWorld().getHappiness() - 5);
        MissionLogic.cancel(tribe, false);
        tribe.setPeaceRequested(false);
        tribe.setRelationship(-100);
        tribe.getRuntimeState().markHostileActivity();
    }

    /** Pays the documented peace cost. Finalizing peace remains a separate turn-based event. */
    public static void requestPeace(Tribe tribe) throws Exception {
        if (tribe.isPeaceRequested()) throw new IllegalStateException("Peace has already been requested");
        for (Map.Entry<Class<? extends Resource>, Integer> entry : PEACE_COST.entrySet()) {
            if (tribe.getWorld().getResourceRecord().getAll(entry.getKey()).size() < entry.getValue())
                throw new Exception("Not enough " + entry.getKey().getSimpleName() + " to request peace");
        }
        for (Map.Entry<Class<? extends Resource>, Integer> entry : PEACE_COST.entrySet()) {
            List<Resource> resources = tribe.getWorld().getResourceRecord().getAll(entry.getKey());
            for (int index = 0; index < entry.getValue(); index++) tribe.getWorld().getResourceRecord().remove(resources.get(index));
        }
        tribe.setPeaceRequested(true);
    }

    /** Call when the required no-attack waiting condition has been satisfied. */
    public static void finalizePeace(Tribe tribe) {
        if (!tribe.isPeaceRequested()) throw new IllegalStateException("No peace request is pending");
        tribe.setPeaceRequested(false);
        tribe.setRelationship(tribe.getDiplomacyPolicy().peaceAccepted());
    }
}
