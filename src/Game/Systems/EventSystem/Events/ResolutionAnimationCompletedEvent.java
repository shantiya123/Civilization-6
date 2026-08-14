package Game.Systems.EventSystem.Events;
import java.util.UUID;
public record ResolutionAnimationCompletedEvent(UUID animationId) implements Event { }
