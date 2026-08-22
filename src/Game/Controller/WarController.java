package Game.Controller;

import Game.Managers.SystemManager;
import Models.Elements.Hex.Hex;

/**
 * Thin adapter from the War Panel's state to the existing {@code WarSystem}, per DESIGN.md:
 * it delegates to one system call per method, contains no gameplay rules, does not mutate
 * models directly, and does not publish gameplay events itself (the system does that once the
 * war command completes).
 */
public class WarController {
    private final SystemManager systemManager;

    public WarController(SystemManager systemManager) {
        this.systemManager = systemManager;
    }

    /**
     * Resolves a full attack between the two hexes: a unit battle, direct structure damage, or
     * capture of an adjacent empty hex, depending on what is on the defensive hex. Validation and
     * every gameplay rule live in {@code WarValidator}/{@code WarManager}; this method only
     * forwards the command.
     */
    public void attack(Hex offensiveHex, Hex defensiveHex) {
        systemManager.getWarSystem().attack(offensiveHex, defensiveHex);
    }

    /**
     * Targets only the wall on the border between the two hexes, without rolling a unit battle,
     * so the player can breach a wall before engaging any defenders behind it.
     */
    public void attackWall(Hex offensiveHex, Hex defensiveHex) {
        systemManager.getWarSystem().attackWall(offensiveHex, defensiveHex);
    }
}