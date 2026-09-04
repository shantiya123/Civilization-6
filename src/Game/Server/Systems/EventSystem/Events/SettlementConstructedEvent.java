package Game.Server.Systems.EventSystem.Events;

import Models.Elements.Buildable.Buildings.Settlement;
import Models.Elements.Hex.Hex;

/** Published by BuildSystem after a Settlement is built. */
public class SettlementConstructedEvent implements Event {
    private Settlement settlement;
    private Hex hex;

    public SettlementConstructedEvent(Settlement settlement, Hex hex) { this.settlement = settlement; this.hex = hex; }
    public Settlement getSettlement() { return settlement; }
    public void setSettlement(Settlement settlement) { this.settlement = settlement; }
    public Hex getHex() { return hex; }
    public void setHex(Hex hex) { this.hex = hex; }
}
