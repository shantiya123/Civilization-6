package Models.Logic.War.Battle;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Logic.Logic;
import Models.Logic.War.Battle.DamageHandler.ArcherDamageHandler;
import Models.Logic.War.Battle.DamageHandler.CavalryDamageHandler;
import Models.Logic.War.Battle.DamageHandler.SwordsmanDamageHandler;

/** Applies battle hits using the documented priority: Swordsman, Archer, Cavalry. */
public final class Damager extends Logic {
    private final DamageUnit chain;

    public Damager(World world) {
        super(world);
        chain = new SwordsmanDamageHandler(world);
        chain.setNext(new ArcherDamageHandler(world)).setNext(new CavalryDamageHandler(world));
    }

    public void damage(Hex hex, int hits) {
        if (hits < 0) throw new IllegalArgumentException("Hit count cannot be negative");
        for (int index = 0; index < hits; index++) {
            if (!chain.handle(hex, 1)) return;
        }
    }
}
