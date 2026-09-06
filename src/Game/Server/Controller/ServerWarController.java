package Game.Server.Controller;

import Base.Request.Request;
import Game.Server.Managers.ServerSystemManager;
import Game.Server.Systems.WarSystem;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Ownership.PlayerOwner;

/**
 * Server-side handlers for combat Requests. WarAttackRequest/AttackWallRequest
 * both carry Hex ids (not live Hex objects), so this resolves them against
 * World's HexRecord before calling into WarSystem -- HexRecord only exposes
 * getByQR, not a by-id lookup, so the lookup is done here rather than adding
 * one to the record.
 */
public class ServerWarController {
    private final WarSystem warSystem;
    private final World world;

    public ServerWarController(ServerSystemManager serverSystemManager) {
        this.warSystem = serverSystemManager.getWarSystem();
        this.world = serverSystemManager.getWorld();
    }

    public void attack(Request request) {
        var body = request.getBody();
        Hex offensiveHex = hexById(body.get("offensiveHex"));
        Hex defensiveHex = hexById(body.get("defensiveHex"));
        if (offensiveHex == null || defensiveHex == null) return;

        warSystem.attack(new PlayerOwner(request.getToken(), "Player"), offensiveHex, defensiveHex);
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
}
