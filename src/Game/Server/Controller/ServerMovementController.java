package Game.Server.Controller;

import Base.Request.Request;
import Game.Server.Managers.ServerSystemManager;
import Game.Server.Systems.ElementSystem.MovementSystem;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Elements.Ownership.PlayerOwner;

/** Resolves the requested IDs in the authoritative world before moving. */
public final class ServerMovementController {
    private final World world;
    private final MovementSystem movementSystem;

    public ServerMovementController(ServerSystemManager serverSystemManager) {
        world = serverSystemManager.getWorld();
        movementSystem = serverSystemManager.getMovementSystem();
    }

    public void move(Request request) {
        int unitId = Integer.parseInt(request.getBody().get("unitId"));
        int destinationHexId = Integer.parseInt(request.getBody().get("destinationHexId"));
        Unit unit = world.getUnitRecord().getAll().stream()
                .filter(candidate -> candidate.getId() == unitId)
                .findFirst().orElse(null);
        Hex destination = world.getHexRecord().getAll().stream()
                .filter(candidate -> candidate.getId() == destinationHexId)
                .findFirst().orElse(null);
        if (unit == null || destination == null) return;
        if (!(unit.getOwner() instanceof PlayerOwner player)
                || !(player.getToken().equals(request.getToken())
                || (player.equals(PlayerOwner.INSTANCE) && request.getToken() == null))) return;
        movementSystem.move(unit, destination);
    }
}
