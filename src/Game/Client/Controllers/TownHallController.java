package Game.Client.Controllers;

import Base.Request.RequestTechnologyOrderRequest;
import Base.Request.RequestUnitOrderRequest;
import Base.Request.RequestUpgradeRequest;
import Game.Client.Managers.ClientServerManager;
import Models.Logic.Technologies.Technology;
import Models.Elements.Units.Unit;


public final class TownHallController {
    private final ClientServerManager server;

    public TownHallController(ClientServerManager server) { this.server = server; }

    public void requestUpgrade() {
        server.sendRequest(new RequestUpgradeRequest(null));
    }

    public void requestUnitOrder(Class<? extends Unit> unitClass) {
        server.sendRequest(new RequestUnitOrderRequest(null, unitClass));
    }

    public void requestTechnologyOrder(Class<? extends Technology> technologyClass) {
        server.sendRequest(new RequestTechnologyOrderRequest(null, technologyClass));
    }
}
