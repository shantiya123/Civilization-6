package Game.Server.Systems;

import Game.TurnPhase;
import Game.World;
import Game.Server.Systems.EventSystem.EventBus;
import Game.Client.Systems.EventSystem.Events.NotificationRequestedEvent;

/** Authoritative system-layer gate; UI disabling is only a convenience layer. */
public final class PlayerActionGuard {
    private final World world;
    private final EventBus eventBus;

    public PlayerActionGuard(World world, EventBus eventBus) { this.world = world; this.eventBus = eventBus; }

    public boolean allow() {
        if (world.getState().getTurnPhase() == TurnPhase.PLAYER_ACTIONS) return true;
        eventBus.publish(new NotificationRequestedEvent("Please wait until turn resolution is complete"));
        return false;
    }
}
