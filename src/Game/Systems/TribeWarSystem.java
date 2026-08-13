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
        try {
            if (tribe == null || offensiveHex == null || defensiveHex == null)
                throw new IllegalArgumentException("Tribe and battle hexes are required");
            if (world.getUnitRecord().getAll().stream().noneMatch(unit -> unit.getHex() == offensiveHex && unit.isOwnedBy(tribe)))
                throw new IllegalStateException("The offensive hex does not contain a unit owned by this tribe");
            if (world.getUnitRecord().getAll().stream().noneMatch(unit -> unit.getHex() == defensiveHex && unit.isPlayerOwned()))
                throw new IllegalStateException("The defensive hex does not contain a player-owned unit");
            // Tribe battle resolution will share the WarManager result/report pipeline next.
        } catch (Exception exception) {
            eventBus.publish(new NotificationRequestedEvent(exception.getMessage()));
        }
    }
}
