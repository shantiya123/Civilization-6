package Game.Systems.ElementSystem;

import Game.World;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.BuildingConstructedEvent;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.EventSystem.Events.SettlementConstructedEvent;
import Game.Systems.SelectSystem;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Settlement;
import Models.Elements.Units.Builder;
import Models.Logic.BuildingLogic.BuildingLogic;

public class BuildSystem {
    private final SelectSystem selectSystem;
    private final EventBus eventBus;
    private final World world;

    public BuildSystem(World world, SelectSystem selectSystem, EventBus eventBus) {
        this.world = world;
        this.selectSystem = selectSystem;
        this.eventBus = eventBus;
    }


    public void buildStructure(Class<? extends Building> buildingClass) {
        if (!(selectSystem.getSelectedUnit() instanceof Builder)) {
            eventBus.publish(new NotificationRequestedEvent("No active Builder selected."));
            return;
        }

        Builder builder = (Builder) selectSystem.getSelectedUnit();
        try {
            Building newBuilding = BuildingLogic.Build(world, builder, buildingClass);
            if (buildingClass.equals(Settlement.class)) {
                eventBus.publish(new SettlementConstructedEvent((Settlement) newBuilding, builder.getHex()));
            } else {
                eventBus.publish(new BuildingConstructedEvent(newBuilding, builder.getHex()));
            }
        } catch (Exception e) {
//            e.printStackTrace();
           eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }
}
