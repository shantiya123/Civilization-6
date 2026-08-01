package Game.Systems.EventSystem.Events;

import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;

/** Published by BuildSystem after a building is placed. */
public class BuildingConstructedEvent implements Event {
    private Building building;
    private Hex hex;

    public BuildingConstructedEvent(Building building, Hex hex) { this.building = building; this.hex = hex; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }
    public Hex getHex() { return hex; }
    public void setHex(Hex hex) { this.hex = hex; }
}
