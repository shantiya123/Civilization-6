package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventSystem;
import Game.Systems.SelectSystem;
import Models.Elements.Buildings.Building;
import Models.Elements.Units.Builder;
import Models.Logic.BuildingLogic.BuildingLogic;

public class BuildSystem {
    private final SelectSystem selectSystem;
    private final EventSystem eventSystem;

    public BuildSystem(SelectSystem selectSystem, EventSystem eventSystem) {
        this.selectSystem = selectSystem;
        this.eventSystem = eventSystem;
    }

    /**
     * Attempts to build a building at the builder's current location.
     */
    public void buildStructure(Class<? extends Building> buildingClass) {
//        System.out.println("BuildStructure called");
        if (!(selectSystem.getSelectedUnit() instanceof Builder)) {
            eventSystem.getNotificationSystem().showNotification("No active Builder selected.");
            return;
        }

        Builder builder = (Builder) selectSystem.getSelectedUnit();
        try {
            Building newBuilding = BuildingLogic.Build(builder, buildingClass);
            eventSystem.getBuildingEvent().BuildingConstructed(newBuilding, builder.getHex());
        } catch (Exception e) {
           eventSystem.getNotificationSystem().showNotification(e.getMessage());
        }
    }
}