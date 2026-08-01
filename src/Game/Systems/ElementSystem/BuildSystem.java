package Game.Systems.ElementSystem;

import Game.Systems.Listeners.ListenerSystem;
import Game.Systems.SelectSystem;
import Game.Systems.TownHallSystem;
import Models.Elements.Buildings.Building;
import Models.Elements.Buildings.Settlement;
import Models.Elements.Units.Builder;
import Models.Logic.BuildingLogic.BuildingLogic;

public class BuildSystem {
    private final SelectSystem selectSystem;
    private final ListenerSystem listenerSystem;
    private final TownHallSystem townHallSystem;

    public BuildSystem(SelectSystem selectSystem, ListenerSystem listenerSystem, TownHallSystem townHallSystem) {
        this.selectSystem = selectSystem;
        this.listenerSystem = listenerSystem;
        this.townHallSystem = townHallSystem;
    }


    public void buildStructure(Class<? extends Building> buildingClass) {
        if (!(selectSystem.getSelectedUnit() instanceof Builder)) {
            listenerSystem.getNotificationSystem().showNotification("No active Builder selected.");
            return;
        }

        Builder builder = (Builder) selectSystem.getSelectedUnit();
        try {
            Building newBuilding = BuildingLogic.Build(builder, buildingClass);
            if (buildingClass.equals(Settlement.class))
                townHallSystem.addedASettlement();
            listenerSystem.getBuildingEvent().BuildingConstructed(newBuilding, builder.getHex());
        } catch (Exception e) {
//            e.printStackTrace();
           listenerSystem.getNotificationSystem().showNotification(e.getMessage());
        }
    }
}