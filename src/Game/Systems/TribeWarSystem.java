package Game.Systems;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;

/** Tribe-side war entry point. Decision-making stays in tribe behaviors; this class executes the order. */
public final class TribeWarSystem {
    private final World world;
    private final EventBus eventBus;

    public TribeWarSystem(World world, EventBus eventBus) {
        this.world = world;
        this.eventBus = eventBus;
    }

    public void attack(Tribe tribe, Hex offensiveHex, Hex defensiveHex) {
        new WarSystem(world, eventBus).attack(tribe, offensiveHex, defensiveHex);
    }
}
