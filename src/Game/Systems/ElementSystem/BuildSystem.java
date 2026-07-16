package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventSystem;
import Game.Systems.SelectSystem;
import Game.Systems.TownHallSystem;
import Models.Elements.Buildings.Building;
import Models.Elements.Buildings.Settlement;
import Models.Elements.Units.Builder;
import Models.Logic.BuildingLogic.BuildingLogic;
import Models.Logic.BuildingLogic.TownHallLogic;

public class BuildSystem {
    private final SelectSystem selectSystem;
    private final EventSystem eventSystem;
    private final TownHallSystem townHallSystem;

    public BuildSystem(SelectSystem selectSystem, EventSystem eventSystem, TownHallSystem townHallSystem) {
        this.selectSystem = selectSystem;
        this.eventSystem = eventSystem;
        this.townHallSystem = townHallSystem;
    }


    public void buildStructure(Class<? extends Building> buildingClass) {
        if (!(selectSystem.getSelectedUnit() instanceof Builder)) {
            eventSystem.getNotificationSystem().showNotification("No active Builder selected.");
            return;
        }

        Builder builder = (Builder) selectSystem.getSelectedUnit();
        try {
            Building newBuilding = BuildingLogic.Build(builder, buildingClass);
            if (buildingClass.equals(Settlement.class))
                townHallSystem.addedASettlement();
            eventSystem.getBuildingEvent().BuildingConstructed(newBuilding, builder.getHex());
        } catch (Exception e) {
//            e.printStackTrace();
           eventSystem.getNotificationSystem().showNotification(e.getMessage());
        }
    }
}