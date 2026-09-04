package Game.Server.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.BorderExpander;

/** Published by ExplorationSystem after territory is claimed. */
public class BorderExpandedEvent implements Event {
    private BorderExpander expander;
    private Hex claimedHex;

    public BorderExpandedEvent(BorderExpander expander, Hex claimedHex) { this.expander = expander; this.claimedHex = claimedHex; }
    public BorderExpander getExpander() { return expander; }
    public void setExpander(BorderExpander expander) { this.expander = expander; }
    public Hex getClaimedHex() { return claimedHex; }
    public void setClaimedHex(Hex claimedHex) { this.claimedHex = claimedHex; }
}
