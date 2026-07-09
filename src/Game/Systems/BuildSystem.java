package Game.Systems;

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
        if (!(selectSystem.getSelectedUnit() instanceof Builder)) {
            eventSystem.BuildingFailed("No active Builder selected.");
            return;
        }

        Builder builder = (Builder) selectSystem.getSelectedUnit();
        try {
            Building newBuilding = BuildingLogic.Build(builder, buildingClass);
            eventSystem.BuildingConstructed(newBuilding, builder.getHex());
        } catch (Exception e) {
            eventSystem.BuildingFailed(e.getMessage());
        }
    }
}