package Game.Systems.ElementSystem;

import Game.World;
import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.BuildingConstructedEvent;
import Game.Systems.EventSystem.Events.BuildingDecayedEvent;
import Game.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Systems.EventSystem.Events.SettlementConstructedEvent;
import Game.Systems.SelectSystem;
import Game.Systems.PlayerActionGuard;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Settlement;
import Models.Elements.Buildable.Buildings.TradingPost;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Builder;
import Models.Logic.BuildingLogic.BuildingLogic;
import Models.Logic.UnitLogic.BuilderLogic;

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
        if (!new PlayerActionGuard(world, eventBus).allow()) return;
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
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }

    public void decayBuilding() {
        if (!new PlayerActionGuard(world, eventBus).allow()) return;
        if (!(selectSystem.getSelectedUnit() instanceof Builder)) {
            eventBus.publish(new NotificationRequestedEvent("No active Builder selected."));
            return;
        }

        Builder builder = (Builder) selectSystem.getSelectedUnit();
        Building building = builder.getHex() == null ? null : builder.getHex().getBuilding();
        try {
            new BuilderLogic(builder, world).destroy(building);
            eventBus.publish(new BuildingDecayedEvent(building, builder.getHex()));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }

    public void tradeByTradingPost(Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        if (!new PlayerActionGuard(world, eventBus).allow()) return;
        if (!(selectSystem.getSelectedUnit() instanceof Builder)) {
            eventBus.publish(new NotificationRequestedEvent("No active Builder selected."));
            return;
        }

        Builder builder = (Builder) selectSystem.getSelectedUnit();
        Building building = builder.getHex() == null ? null : builder.getHex().getBuilding();
        if (!(building instanceof TradingPost tradingPost)) {
            eventBus.publish(new NotificationRequestedEvent("Builder must be on a Trading Post hex."));
            return;
        }

        try {
            tradingPost.trade(give, receive, amount);
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }
}