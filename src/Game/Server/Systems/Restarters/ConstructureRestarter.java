package Game.Server.Systems.Restarters;

import Game.Server.Systems.EventSystem.EventBus;
import Game.Client.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.World;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Buildable.Constructure.Road;
import Models.Elements.Buildable.Constructure.Wall;
import Models.Elements.Resources.Resource;
import Models.Logic.ConstructureLogic.ConstructureLogic;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** Charges upkeep for Wall/Road constructures each turn; same pattern as BuildingRestarter. */
public final class ConstructureRestarter {
    private static final int DECAY_THRESHOLD = 3;

    private final World world;
    private final EventBus eventBus;

    public ConstructureRestarter(World world, EventBus eventBus) {
        this.world = world;
        this.eventBus = eventBus;
    }

    public void CostUpkeep() {
        costUpkeepFor(new ArrayList<>(world.getBorderRecorder().getAll(Wall.class)));
        costUpkeepFor(new ArrayList<>(world.getBorderRecorder().getAll(Road.class)));
    }

    private void costUpkeepFor(List<? extends Constructure> constructures) {
        for (Constructure constructure : constructures) {
            boolean hasEnoughUpkeep = true;

            for (Map.Entry<Class<? extends Resource>, Integer> entry : constructure.getUPKEEP().entrySet()) {
                List<Resource> stock = world.getResourceRecord().getAll(entry.getKey());
                if (stock.size() < entry.getValue()) {
                    hasEnoughUpkeep = false;
                    break;
                }
            }

            if (hasEnoughUpkeep) {
                for (Map.Entry<Class<? extends Resource>, Integer> entry : constructure.getUPKEEP().entrySet()) {
                    List<Resource> stock = world.getResourceRecord().getAll(entry.getKey());
                    for (int i = 0; i < entry.getValue(); i++) {
                        world.getResourceRecord().remove(stock.get(i));
                    }
                }
                constructure.setDecayCountdown(0);
            } else {
                int newCountdown = constructure.getDecayCountdown() + 1;
                constructure.setDecayCountdown(newCountdown);
                eventBus.publish(new NotificationRequestedEvent(
                        constructure.getClass().getSimpleName() + " could not pay upkeep ("
                                + newCountdown + "/" + DECAY_THRESHOLD + ")."));

                if (newCountdown >= DECAY_THRESHOLD) {
                    new ConstructureLogic(constructure, world).decay();
                    eventBus.publish(new NotificationRequestedEvent(
                            constructure.getClass().getSimpleName() + " decayed."));
                }
            }
        }
    }
}