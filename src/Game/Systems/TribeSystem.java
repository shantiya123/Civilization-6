package Game.Systems;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.TerritoryIntrusionChecker;
import Models.Logic.TribeLogic.TribeActionManager;

/** End-turn entry point for independent tribe checks and their one main action. */
public final class TribeSystem {
    private final World world;
    private final TerritoryIntrusionChecker intrusionChecker;
    private final TribeActionManager actionManager;

    public TribeSystem(World world) {
        this.world = world;
        intrusionChecker = new TerritoryIntrusionChecker(world);
        actionManager = new TribeActionManager(world);
    }

    public void processTurn(int turnNumber) {
        for (Tribe tribe : world.getTribeRecord().getAll()) {
            actionManager.execute(tribe, intrusionChecker.check(tribe), turnNumber);
        }
    }
}
