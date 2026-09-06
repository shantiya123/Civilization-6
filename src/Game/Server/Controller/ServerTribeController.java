package Game.Server.Controller;

import Base.Request.Request;
import Game.Server.Managers.ServerSystemManager;
import Game.Server.Systems.TribeSystem;
import Game.World;
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Tribe;

/**
 * Server-side handlers for tribe-relationship Requests (missions, alliances,
 * gifts, war/peace). All resolve to TribeSystem, whose facade methods take a
 * live Tribe -- Requests only carry the Tribe id, so every handler here
 * looks the Tribe up first, same as the client's TribeController is handed
 * an already-resolved Tribe by its caller.
 *
 * declareWar/requestPeace live here rather than on ServerWarController
 * because TribeSystem (not WarSystem) owns them -- same split the client's
 * TribeController/WarController use.
 */
public class ServerTribeController {
    private final TribeSystem tribeSystem;
    private final World world;

    public ServerTribeController(ServerSystemManager serverSystemManager) {
        this.tribeSystem = serverSystemManager.getTribeSystem();
        this.world = serverSystemManager.getWorld();
    }

    public void acceptMission(Request request) {
        Tribe tribe = tribeById(request.getBody().get("tribe"));
        if (tribe == null) return;
        tribeSystem.acceptMission(tribe);
    }

    public void cancelMission(Request request) {
        Tribe tribe = tribeById(request.getBody().get("tribe"));
        if (tribe == null) return;
        tribeSystem.cancelMission(tribe);
    }

    public void claimMissionReward(Request request) {
        Tribe tribe = tribeById(request.getBody().get("tribe"));
        if (tribe == null) return;
        tribeSystem.claimMissionReward(tribe);
    }

    public void payMissionResources(Request request) {
        Tribe tribe = tribeById(request.getBody().get("tribe"));
        if (tribe == null) return;
        tribeSystem.payMissionResources(tribe);
    }

    public void requestAlliance(Request request) {
        Tribe tribe = tribeById(request.getBody().get("tribe"));
        if (tribe == null) return;
        tribeSystem.requestAlliance(tribe);
    }

    public void declareWar(Request request) {
        Tribe tribe = tribeById(request.getBody().get("tribe"));
        if (tribe == null) return;
        tribeSystem.declareWar(tribe);
    }

    public void requestPeace(Request request) {
        Tribe tribe = tribeById(request.getBody().get("tribe"));
        if (tribe == null) return;
        tribeSystem.requestPeace(tribe);
    }

    public void sendGift(Request request) {
        var body = request.getBody();
        Tribe tribe = tribeById(body.get("tribe"));
        if (tribe == null) return;
        Class<? extends Resource> type = resourceClass(body.get("type"));
        int amount = Integer.parseInt(body.get("amount"));

        tribeSystem.sendGift(tribe, type, amount);
    }

    @SuppressWarnings("unchecked")
    private Class<? extends Resource> resourceClass(String fullyQualifiedName) {
        try {
            return (Class<? extends Resource>) Class.forName(fullyQualifiedName);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Unknown Resource class: " + fullyQualifiedName, e);
        }
    }

    private Tribe tribeById(String idString) {
        int id = Integer.parseInt(idString);
        return world.getTribeRecord().getAll().stream()
                .filter(tribe -> tribe.getId() == id)
                .findFirst()
                .orElse(null);
    }
}