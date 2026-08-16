package Models.Logic.TribeLogic.Decisions;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;
import Models.Logic.TribeLogic.Behaviors.GenerateUnit;
import Models.Logic.TribeLogic.TribeGuardFactory;
import Game.Systems.EventSystem.Events.TribeGuardProducedEvent;

/** Owns guard timing, capacity, spawn selection, and guard production. */
public final class GenerateGuardDecision extends Logic implements TribeDecision {
    private static final int GUARD_SPAWN_INTERVAL = 3;

    GenerateGuardDecision(World world) {
        super(world);
    }


    @Override
    public boolean canExecute(TribeDecisionContext context, TribeDecisionType type) {
        Tribe tribe = context.tribe();
        return type == TribeDecisionType.GENERATE_GUARD
                && tribe.getRuntimeState().getGuardProductionTurns() >= GUARD_SPAWN_INTERVAL
                && guards(tribe) < TribeGuardFactory.capFor(tribe)
                && findSpawnHex(tribe) != null;
    }

    @Override
    public void execute(TribeDecisionContext context, TribeDecisionType type) {
        Tribe tribe = context.tribe();
        Hex spawnHex = findSpawnHex(tribe);
        if (spawnHex == null) return;
        CombatUnit guard = new GenerateUnit(context.world()).execute(tribe, spawnHex);
        tribe.getRuntimeState().resetGuardProductionTurns();
        guard.setHex(tribe.getCampHex());
        world.getUnitRecord().add(guard);
        System.out.println(guard);
        context.eventBus().publish(new TribeGuardProducedEvent(tribe, guard, spawnHex));
    }

    private Hex findSpawnHex(Tribe tribe) {
        if (tribe.getCampHex() == null) return null;
        if (isEmpty(tribe, tribe.getCampHex())) return tribe.getCampHex();
        return HexLogic.getNeighbors(tribe.getWorld(), tribe.getCampHex()).stream()
                .filter(hex -> hex.isOwnedBy(tribe)).filter(hex -> isEmpty(tribe, hex)).findFirst().orElse(null);
    }

    private int guards(Tribe tribe) {
        return (int) tribe.getWorld().getUnitRecord().getAll().stream()
                .filter(CombatUnit.class::isInstance).map(CombatUnit.class::cast)
                .filter(unit -> unit.isOwnedBy(tribe)).count();
    }

    private boolean isEmpty(Tribe tribe, Hex hex) {
        return hex != null && (hex.getBuilding() == null || hex == tribe.getCampHex())
                && tribe.getWorld().getUnitRecord().getAll().stream().noneMatch(unit -> unit.getHex() == hex);
    }
}
