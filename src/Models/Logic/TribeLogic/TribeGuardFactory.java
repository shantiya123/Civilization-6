package Models.Logic.TribeLogic;

import Game.World;
import Models.Elements.Tribes.*;
import Models.Elements.Units.CombatUnits.*;

/** Creates the no-cost defensive guard configured for a tribe type. */
public final class TribeGuardFactory {
    private TribeGuardFactory() { }

    public static CombatUnit create(World world, Tribe tribe) {
        if (tribe instanceof FarmerTribe) return new FarmerGuard(world, tribe);
        if (tribe instanceof WarriorTribe) return new WarriorGuard(world, tribe);
        if (tribe instanceof TraderTribe) return new TraderGuard(world, tribe);
        if (tribe instanceof MountainTribe) return new MountainGuard(world, tribe);
        if (tribe instanceof CoastalTribe) return new CoastalGuard(world, tribe);
        throw new IllegalArgumentException("No guard configuration for " + tribe.getClass().getSimpleName());
    }

    public static int capFor(Tribe tribe) {
        return tribe instanceof WarriorTribe ? 5 : 3;
    }
}
