package Models.Logic.TribeLogic.Behaviors;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Draw.UnitPositionCalculator;
import Models.Logic.Logic;
import Models.Logic.TribeLogic.TribeGuardFactory;

/** Spawns the configured no-cost tribe guard; selection/timing remain outside this behavior. */
public final class GenerateUnit extends Logic {

    public GenerateUnit(World world) { super(world); }

    public CombatUnit execute(Tribe tribe) {
        return execute(tribe, tribe.getCampHex());
    }

    /** Spawns at the camp or a decision-selected, valid tribe territory hex. */
    public CombatUnit execute(Tribe tribe, Hex spawnHex) {
        if (spawnHex == null) throw new IllegalStateException("Tribe camp is not placed");
        CombatUnit guard = TribeGuardFactory.create(world, tribe);
        guard.setHex(spawnHex);
        guard.setOwner(tribe);
        // A produced unit is part of the game only after the record owns it.
        world.getUnitRecord().add(guard);
        UnitPositionCalculator.refreshHex(spawnHex, guard);
        return guard;
    }
}
