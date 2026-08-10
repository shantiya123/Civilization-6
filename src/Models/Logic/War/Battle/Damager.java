package Models.Logic.War.Battle;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Logic.Logic;
import Models.Logic.War.Battle.DamageHandler.ArcherDamageHandler;
import Models.Logic.War.Battle.DamageHandler.BuilderDamageHandler;
import Models.Logic.War.Battle.DamageHandler.BuildingDamageHandler;
import Models.Logic.War.Battle.DamageHandler.CavalryDamageHandler;
import Models.Logic.War.Battle.DamageHandler.SwordsmanDamageHandler;
import Models.Logic.War.Battle.DamageHandler.WorkerDamageHandler;

/** Applies hits by priority: combat units, building, Worker, then Builder. */
public final class Damager extends Logic {
    private final DamageUnit chain;

    public Damager(World world) {
        super(world);
        chain = new SwordsmanDamageHandler(world);
        chain.setNext(new ArcherDamageHandler(world))
                .setNext(new CavalryDamageHandler(world))
                .setNext(new BuildingDamageHandler(world))
                .setNext(new WorkerDamageHandler(world))
                .setNext(new BuilderDamageHandler(world));
    }

    public void damage(Hex hex, int hits) {
        if (hits < 0) throw new IllegalArgumentException("Hit count cannot be negative");
        for (int index = 0; index < hits; index++) {
            if (!chain.handle(hex, 1)) return;
        }
    }
}
