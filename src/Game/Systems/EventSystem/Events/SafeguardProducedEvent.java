package Game.Systems.EventSystem.Events;

import Models.Elements.Resources.Resource;
import java.util.Map;

/** Published by TownHallRestarter after safeguard resources are added. */
public class SafeguardProducedEvent implements Event {
    private Map<Class<? extends Resource>, Integer> amounts;

    public SafeguardProducedEvent(Map<Class<? extends Resource>, Integer> amounts) { this.amounts = amounts; }
    public Map<Class<? extends Resource>, Integer> getAmounts() { return amounts; }
    public void setAmounts(Map<Class<? extends Resource>, Integer> amounts) { this.amounts = amounts; }
}
