package Game.Client.Systems.EventSystem.Events;

import Game.Server.Systems.EventSystem.Events.Event;
import Models.Elements.Hex.Hex;

/** Published by SelectSystem when the selected hex changes. */
public class HexSelectionChangedEvent implements Event {
    private Hex selectedHex;

    public HexSelectionChangedEvent(Hex selectedHex) { this.selectedHex = selectedHex; }
    public Hex getSelectedHex() { return selectedHex; }
    public void setSelectedHex(Hex selectedHex) { this.selectedHex = selectedHex; }
}
