package Game.Systems.EventSystem;

import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;

public class BuildingEvent {
    public void BuildingConstructed(Building building, Hex hex) {}
    public void BuildingFailed(String reason) {}
}
