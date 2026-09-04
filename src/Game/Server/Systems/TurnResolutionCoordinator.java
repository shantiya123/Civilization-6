package Game.Server.Systems;

import Game.TurnPhase;
import Game.World;
import Game.Server.Systems.EventSystem.EventBus;
import Game.Client.Systems.EventSystem.Events.ResolutionAnimationCompletedEvent;
import Game.Server.Systems.EventSystem.Events.TurnResolutionCompletedEvent;
import Game.Server.Systems.EventSystem.Events.TurnResolutionStartedEvent;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/** Locks player commands until synchronous turn logic and registered one-shot animations are done. */
public final class TurnResolutionCoordinator {
    private final World world;
    private final EventBus eventBus;
    private final Set<UUID> pendingAnimations = new HashSet<>();
    private boolean logicFinished;

    public TurnResolutionCoordinator(World world, EventBus eventBus) {
        this.world = world;
        this.eventBus = eventBus;
        eventBus.subscribe(ResolutionAnimationCompletedEvent.class, event -> animationCompleted(event.animationId()));
    }

    public boolean beginResolution() {
        if (world.getState().getTurnPhase() == TurnPhase.RESOLVING_TURN) return false;
        pendingAnimations.clear();
        logicFinished = false;
        world.getState().setTurnPhase(TurnPhase.RESOLVING_TURN);
        eventBus.publish(new TurnResolutionStartedEvent());
        return true;
    }

    public UUID registerOneShotAnimation() {
        if (world.getState().getTurnPhase() != TurnPhase.RESOLVING_TURN)
            throw new IllegalStateException("Resolution animations may only be registered during turn resolution");
        UUID id = UUID.randomUUID();
        pendingAnimations.add(id);
        return id;
    }

    public void finishLogic() { logicFinished = true; tryFinish(); }
    private void animationCompleted(UUID animationId) { pendingAnimations.remove(animationId); tryFinish(); }
    private void tryFinish() {
        if (logicFinished && pendingAnimations.isEmpty()) {
            world.getState().setTurnPhase(TurnPhase.PLAYER_ACTIONS);
            eventBus.publish(new TurnResolutionCompletedEvent());
        }
    }
}
