package Models.Logic.BuildingLogic.TownHallLogic;

import Models.Logic.BuildingLogic.TownHallLogic.TownHallOrders.TownHallOrder;

public class TownHallOrderQueue {

    private boolean empty = true;
    private TownHallOrder activeOrder;

    public boolean isEmpty() {
        return empty;
    }

    public TownHallOrder getActiveOrder() {
        return activeOrder;
    }

    public void add(TownHallOrder order) {
        activeOrder = order;
        empty = false;
    }

    public void clear() {
        activeOrder = null;
        empty = true;
    }

}
