package Models.Logic.TribeLogic.Behaviors;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.TribeLogic.TribeGuardFactory;

/** Spawns the configured no-cost tribe guard; selection/timing remain outside this behavior. */
public final class GenerateUnit {
    private final World world;

    public GenerateUnit(World world) { this.world = world; }

    public CombatUnit execute(Tribe tribe) {
        return execute(tribe, tribe.getCampHex());
    }

    /** Spawns at the camp or a decision-selected, valid tribe territory hex. */
    public CombatUnit execute(Tribe tribe, Hex spawnHex) {
        if (spawnHex == null) throw new IllegalStateException("Tribe camp is not placed");
        CombatUnit guard = TribeGuardFactory.create(world, tribe);
        guard.setHex(spawnHex);
        guard.setOwner(tribe);
        world.getUnitRecord().add(guard);
        return guard;
    }
}
