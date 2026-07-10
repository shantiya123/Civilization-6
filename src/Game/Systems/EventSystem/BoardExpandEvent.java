package Game.Systems.EventSystem;

import Models.Elements.Hex.Hex;

public class BoardExpandEvent {
    public void BorderExpanded(Hex hex) {}
    public void BorderExpansionFailed(String reason) {}
}
