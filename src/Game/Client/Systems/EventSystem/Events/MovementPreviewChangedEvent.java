package Game.Client.Systems.EventSystem.Events;

import Game.Server.Systems.EventSystem.Events.Event;
import Models.Elements.Hex.Hex;
import java.util.List;

/** Published by SelectSystem while hovering a reachable hex. */
public class MovementPreviewChangedEvent implements Event {
    private List<Hex> path;
    private Hex goalHex;

    public MovementPreviewChangedEvent(List<Hex> path, Hex goalHex) { this.path = path; this.goalHex = goalHex; }
    public List<Hex> getPath() { return path; }
    public void setPath(List<Hex> path) { this.path = path; }
    public Hex getGoalHex() { return goalHex; }
    public void setGoalHex(Hex goalHex) { this.goalHex = goalHex; }
}
