package Game.Client.Systems.EventSystem.Events;

import Game.Server.Systems.EventSystem.Events.Event;

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
