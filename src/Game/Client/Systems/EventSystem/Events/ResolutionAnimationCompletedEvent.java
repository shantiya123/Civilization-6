package Game.Client.Systems.EventSystem.Events;
import Game.Server.Systems.EventSystem.Events.Event;

import java.util.UUID;
public record ResolutionAnimationCompletedEvent(UUID animationId) implements Event { }
