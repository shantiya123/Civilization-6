package Game.Systems;

import Game.World;
import Game.Systems.EventSystem.EventBus;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.TerritoryIntrusionChecker;
import Models.Logic.TribeLogic.TribeActionManager;

/** End-turn entry point for independent tribe checks and their one main action. */
public final class TribeSystem {
    private final World world;
    private final TerritoryIntrusionChecker intrusionChecker;
    private final TribeActionManager actionManager;

    public TribeSystem(World world, EventBus eventBus) {
        this.world = world;
        intrusionChecker = new TerritoryIntrusionChecker(world);
        actionManager = new TribeActionManager(world, eventBus);
    }

    public void processTurn(int turnNumber) {
        for (Tribe tribe : world.getTribeRecord().getAll()) {
            actionManager.execute(tribe, intrusionChecker.check(tribe), turnNumber);
        }
    }
}
