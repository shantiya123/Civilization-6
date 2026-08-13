package Models.Logic.TribeLogic;

import Models.Elements.Resources.*;
import Models.Elements.Tribes.*;

import java.util.Map;

/** Balances a one-time camp reward below the ongoing value of an alliance. */
public final class TribeLootPolicy {
    private TribeLootPolicy() { }

    public static Map<Class<? extends Resource>, Integer> forDefeat(Tribe tribe) {
        if (tribe instanceof FarmerTribe) return Map.of(Food.class, 20);
        if (tribe instanceof WarriorTribe) return Map.of(Iron.class, 10, Wood.class, 5);
        if (tribe instanceof TraderTribe) return Map.of(Food.class, 10, Wood.class, 10, Stone.class, 5, Iron.class, 3);
        if (tribe instanceof MountainTribe) return Map.of(Stone.class, 15, Iron.class, 8);
        if (tribe instanceof CoastalTribe) return Map.of(Food.class, 15, Wood.class, 10);
        throw new IllegalArgumentException("No defeat loot configured for " + tribe.getClass().getSimpleName());
    }
}
