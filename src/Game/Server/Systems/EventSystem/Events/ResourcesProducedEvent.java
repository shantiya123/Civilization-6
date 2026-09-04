package Game.Server.Systems.EventSystem.Events;

import Models.Elements.Resources.Resource;
import java.util.Map;

/** Published by BuildingRestarter after buildings add resources. */
public class ResourcesProducedEvent implements Event {
    private Map<Class<? extends Resource>, Integer> amounts;

    public ResourcesProducedEvent(Map<Class<? extends Resource>, Integer> amounts) { this.amounts = amounts; }
    public Map<Class<? extends Resource>, Integer> getAmounts() { return amounts; }
    public void setAmounts(Map<Class<? extends Resource>, Integer> amounts) { this.amounts = amounts; }
}
