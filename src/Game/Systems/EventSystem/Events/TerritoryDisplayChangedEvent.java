package Game.Systems.EventSystem.Events;

/** Presentation event published by BoardSystem after territory visibility changes. */
public class TerritoryDisplayChangedEvent implements Event {
    private boolean visible;

    public TerritoryDisplayChangedEvent(boolean visible) { this.visible = visible; }
    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }
}
