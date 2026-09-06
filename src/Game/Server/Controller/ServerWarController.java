package Game.Server.Controller;

import Base.Request.Request;
import Game.Server.Managers.ServerSystemManager;
import Game.Server.Systems.WarSystem;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Ownership.PlayerOwner;
import Models.Elements.Buildable.Buildings.Building;

/**
 * Server-side handlers for combat Requests. WarAttackRequest/AttackWallRequest
 * both carry Hex ids (not live Hex objects), so this resolves them against
 * World's HexRecord before calling into WarSystem -- HexRecord only exposes
 * getByQR, not a by-id lookup, so the lookup is done here rather than adding
 * one to the record.
 */
public class ServerWarController {
    private final ServerSystemManager serverSystemManager;
    private final WarSystem warSystem;
    private final World world;

    public ServerWarController(ServerSystemManager serverSystemManager) {
        this.serverSystemManager = serverSystemManager;
        this.warSystem = serverSystemManager.getWarSystem();
        this.world = serverSystemManager.getWorld();
    }

    public void attack(Request request) {
        var body = request.getBody();
        Hex offensiveHex = hexById(body.get("offensiveHex"));
        Hex defensiveHex = hexById(body.get("defensiveHex"));
        if (offensiveHex == null || defensiveHex == null) return;

        PlayerOwner attacker = request.getToken() == null ? PlayerOwner.INSTANCE
                : new PlayerOwner(request.getToken(), "Player");
        PlayerOwner defender = playerOwnerAt(defensiveHex);
        if (defender != null && !defender.equals(attacker)
                && world.getSuperWorld().getPlayerDiplomacy().declareWar(attacker.getToken(), defender.getToken())) {
            serverSystemManager.getUpdateDispatcher().broadcast(new Base.Network.LobbyChatMessage("Server",
                    java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")),
                    attacker.getDisplayName() + " declared war on " + defender.getDisplayName() + "."));
        }
        warSystem.attack(attacker, offensiveHex, defensiveHex);
    }

    public void attackWall(Request request) {
        var body = request.getBody();
        Hex offensiveHex = hexById(body.get("offensiveHex"));
        Hex defensiveHex = hexById(body.get("defensiveHex"));
        if (offensiveHex == null || defensiveHex == null) return;

        warSystem.attackWall(new PlayerOwner(request.getToken(), "Player"), offensiveHex, defensiveHex);
    }

    private Hex hexById(String idString) {
        int id = Integer.parseInt(idString);
        return world.getHexRecord().getAll().stream()
                .filter(hex -> hex.getId() == id)
                .findFirst()
                .orElse(null);
    }
    private PlayerOwner playerOwnerAt(Hex hex) {
        for (var unit : world.getUnitRecord().getAll()) {
            if (unit.getHex() == hex && unit.getOwningPlayer() != null) return unit.getOwningPlayer();
        }
        Building building = hex.getBuilding();
        if (building != null && building.getOwner() instanceof PlayerOwner player) return player;
        return hex.getOwningPlayer();
    }
}
