package Models.Logic.TribeLogic;

import Models.Elements.Resources.Resource;

import java.util.Map;

/** Reports which camp-loot resources entered storage and which were discarded for lack of capacity. */
public record TribeDefeatLoot(Map<Class<? extends Resource>, Integer> granted,
                              Map<Class<? extends Resource>, Integer> discarded) {
    public TribeDefeatLoot {
        granted = Map.copyOf(granted);
        discarded = Map.copyOf(discarded);
    }
}
