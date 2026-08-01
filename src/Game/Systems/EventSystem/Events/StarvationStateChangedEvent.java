package Game.Systems.EventSystem.Events;

/** Published by StarvationSystem whenever starvation changes. */
public class StarvationStateChangedEvent implements Event {
    private boolean starving;

    public StarvationStateChangedEvent(boolean starving) { this.starving = starving; }
    public boolean isStarving() { return starving; }
    public void setStarving(boolean starving) { this.starving = starving; }
}
