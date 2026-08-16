package Game.Views.TownHallPanel;

import Game.Controller.TownHallController;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.TechnologyResearchOrder;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.TownHallOrder;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.UnitProductionOrder;
import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.UpgradeOrder;
import Models.Elements.Units.Builder;
import Models.Elements.Units.BorderExpander;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Models.Elements.Units.CombatUnits.Archer;
import Models.Elements.Units.CombatUnits.Cavalry;
import Models.Elements.Units.CombatUnits.Swordsman;

import java.util.List;
import java.util.Map;

/** View model for the permanent Town Hall overview. */
public final class TownHallState {
    private final TownHall townHall;
    private final TownHallController controller;

    public TownHallState(TownHall townHall, TownHallController controller) {
        this.townHall = townHall;
        this.controller = controller;
    }

    public String getLevelName() {
        return switch (townHall.getTownHallState().getState()) {
            case 1 -> "Base Camp";
            case 2 -> "Settlement";
            case 3 -> "Capital";
            default -> "Town Hall";
        };
    }

    public int getLevel() { return townHall.getTownHallState().getState(); }
    public int getHitPoints() { return townHall.getHP(); }

    public String getOrderSummary() {
        if (townHall.getOrderQueue().isEmpty()) return "No active order";
        TownHallOrder order = townHall.getOrderQueue().getActiveOrder();
        if (order instanceof UnitProductionOrder) return "Unit production";
        if (order instanceof TechnologyResearchOrder) return "Technology research";
        if (order instanceof UpgradeOrder) return "Town Hall upgrade";
        return "Active order";
    }

    public String getOrderProgress() {
        if (townHall.getOrderQueue().isEmpty()) return "Ready for a new order";
        TownHallOrder order = townHall.getOrderQueue().getActiveOrder();
        return "Turn " + order.getCurrentTurns() + " / " + order.getTotalTurns();
    }

    public boolean canUpgrade() {
        return townHall.getTownHallState().getNextState() != null && townHall.getOrderQueue().isEmpty();
    }

    public void requestUpgrade() { controller.requestUpgrade(); }

    public List<Class<? extends Unit>> getOrderableUnitTypes() {
        return List.of(Worker.class, Builder.class, Explorer.class, BorderExpander.class,
                Swordsman.class, Archer.class, Cavalry.class);
    }

    public String getUnitImagePath(Class<? extends Unit> unitClass) {
        return UNIT_IMAGES.get(unitClass);
    }

    public void requestUnitOrder(Class<? extends Unit> unitClass) {
        controller.requestUnitOrder(unitClass);
    }

    private static final Map<Class<? extends Unit>, String> UNIT_IMAGES = Map.of(
            Worker.class, "/Images/Units/Worker.png",
            Builder.class, "/Images/Units/Builder.png",
            Explorer.class, "/Images/Units/Explorer.png",
            BorderExpander.class, "/Images/Units/BorderExpander.png",
            Swordsman.class, "/Images/Units/SowardMan.png",
            Archer.class, "/Images/Units/Archer.png",
            Cavalry.class, "/Images/Units/Cavalry.png"
    );
}
