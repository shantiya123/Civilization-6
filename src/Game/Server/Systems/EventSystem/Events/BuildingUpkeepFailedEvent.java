package Game.Server.Systems.EventSystem.Events;

import Models.Elements.Buildable.Buildings.Building;

/** Published by BuildingRestarter when a building cannot pay upkeep. */
public class BuildingUpkeepFailedEvent implements Event {
    private Building building;
    private int decayCountdown;

    public BuildingUpkeepFailedEvent(Building building, int decayCountdown) { this.building = building; this.decayCountdown = decayCountdown; }
    public Building getBuilding() { return building; }
    public void setBuilding(Building building) { this.building = building; }
    public int getDecayCountdown() { return decayCountdown; }
    public void setDecayCountdown(int decayCountdown) { this.decayCountdown = decayCountdown; }
}
