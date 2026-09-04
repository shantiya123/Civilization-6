package Game.Server.Controller;

import Game.Server.Managers.ServerSystemManager;
import Game.Server.Systems.WarSystem;
import Models.Elements.Hex.Hex;

/**
 * Server-side counterpart of {@code Game.Client.Controllers.WarController}.
 * Receives the action once the client's request reaches the server and calls
 * the real {@code WarSystem}, per DESIGN.md: it delegates to one system call
 * per method, contains no gameplay rules, does not mutate models directly,
 * and does not publish gameplay events itself (the system does that once the
 * war command completes).
 */
public class ServerWarController {
    private final WarSystem warSystem;

    public ServerWarController(ServerSystemManager serverSystemManager) {
        this.warSystem = serverSystemManager.getWarSystem();
    }

    /**
     * Resolves a full attack between the two hexes: a unit battle, direct structure damage, or
     * capture of an adjacent empty hex, depending on what is on the defensive hex. Validation and
     * every gameplay rule live in {@code WarValidator}/{@code WarManager}; this method only
     * forwards the command.
     */
    public void attack(Hex offensiveHex, Hex defensiveHex) {
        warSystem.attack(offensiveHex, defensiveHex);
    }

    /**
     * Targets only the wall on the border between the two hexes, without rolling a unit battle,
     * so the player can breach a wall before engaging any defenders behind it.
     */
    public void attackWall(Hex offensiveHex, Hex defensiveHex) {
        warSystem.attackWall(offensiveHex, defensiveHex);
    }
}