package Game.Systems.EventSystem.Events;

/** Presentation event published by BoardSystem after a zoom request. */
public class BoardZoomChangedEvent implements Event {
    private int zoomDelta;

    public BoardZoomChangedEvent(int zoomDelta) { this.zoomDelta = zoomDelta; }
    public int getZoomDelta() { return zoomDelta; }
    public void setZoomDelta(int zoomDelta) { this.zoomDelta = zoomDelta; }
}
