package Models.Logic.TribeLogic.Behaviors;

import Game.Server.Systems.TribeWarSystem;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;

/** Executes a tribe's selected attack. It deliberately does not choose targets. */
public final class Attack {
    private final TribeWarSystem tribeWarSystem;

    public Attack(TribeWarSystem tribeWarSystem) {
        this.tribeWarSystem = tribeWarSystem;
    }

    public void execute(Tribe tribe, Hex offensiveHex, Hex defensiveHex) {
        tribeWarSystem.attack(tribe, offensiveHex, defensiveHex);
    }
}
