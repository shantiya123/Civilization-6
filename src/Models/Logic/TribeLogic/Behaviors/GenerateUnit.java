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
        Hex campHex = tribe.getCampHex();
        if (campHex == null) throw new IllegalStateException("Tribe camp is not placed");
        CombatUnit guard = TribeGuardFactory.create(world, tribe);
        guard.setHex(campHex);
        guard.setOwner(tribe);
        world.getUnitRecord().add(guard);
        return guard;
    }
}
