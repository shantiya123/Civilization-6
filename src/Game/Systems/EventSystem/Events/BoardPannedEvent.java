package Game.Systems.EventSystem.Events;

/** Presentation event published by BoardSystem after panning. */
public class BoardPannedEvent implements Event {
    private int deltaX;
    private int deltaY;

    public BoardPannedEvent(int deltaX, int deltaY) { this.deltaX = deltaX; this.deltaY = deltaY; }
    public int getDeltaX() { return deltaX; }
    public void setDeltaX(int deltaX) { this.deltaX = deltaX; }
    public int getDeltaY() { return deltaY; }
    public void setDeltaY(int deltaY) { this.deltaY = deltaY; }
}
