package Game.Client.Systems.EventSystem.Events;

import Game.Server.Systems.EventSystem.Events.Event;

public class BoardZoomChangedEvent implements Event {
    private int zoomDelta;

    public BoardZoomChangedEvent(int zoomDelta) { this.zoomDelta = zoomDelta; }
    public int getZoomDelta() { return zoomDelta; }
    public void setZoomDelta(int zoomDelta) { this.zoomDelta = zoomDelta; }
}