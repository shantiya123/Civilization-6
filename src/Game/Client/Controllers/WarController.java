package Game.Client.Controllers;

import Base.Request.AttackWallRequest;
import Base.Request.WarAttackRequest;
import Models.Elements.Hex.Hex;

/**
 * Thin adapter from the War Panel's state to the server, per DESIGN.md:
 * it forwards one request per method, contains no gameplay rules, does not
 * mutate models directly, and does not publish gameplay events itself (the
 * server-side {@code WarSystem} does that once the war command completes).
 * Validation and every gameplay rule live server-side in
 * {@code WarValidator}/{@code WarManager}; this class only sends the command.
 */
public class WarController {

    public WarController() {
    }

    /**
     * Requests a full attack between the two hexes: a unit battle, direct structure damage, or
     * capture of an adjacent empty hex, depending on what is on the defensive hex. The server
     * decides the outcome; this method only forwards the command.
     */
    public void attack(Hex offensiveHex, Hex defensiveHex) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        WarAttackRequest request = new WarAttackRequest(null, offensiveHex, defensiveHex);
        // TODO: send `request` to the server once the client-server network connection exists.
    }

    /**
     * Requests that only the wall on the border between the two hexes be targeted, without
     * rolling a unit battle, so the player can breach a wall before engaging any defenders
     * behind it.
     */
    public void attackWall(Hex offensiveHex, Hex defensiveHex) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        AttackWallRequest request = new AttackWallRequest(null, offensiveHex, defensiveHex);
        // TODO: send `request` to the server once the client-server network connection exists.
    }
}