package Models.Logic.TribeLogic.Decisions;

import Game.Server.Systems.WarSystem;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.Archer;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.Logic;

import java.util.Comparator;
import java.util.List;

/** Validates and executes an immobile camp-defense attack. */
public final class DefendTerritoryDecision extends Logic implements TribeDecision {
    private final WarSystem warSystem;

    public DefendTerritoryDecision(World world , WarSystem warSystem) {
        super(world);
        this.warSystem = warSystem; }

    @Override
    public boolean canExecute(TribeDecisionContext context, TribeDecisionType type) {
        return type == TribeDecisionType.DEFEND_TERRITORY
                && defendableIntruder(context.tribe(), context.intrusion().currentIntruders()) != null;
    }

    @Override
    public void execute(TribeDecisionContext context, TribeDecisionType type) {
        CombatUnit intruder = defendableIntruder(context.tribe(), context.intrusion().currentIntruders());
        if (intruder != null) warSystem.attack(context.tribe(), context.tribe().getCampHex(), intruder.getHex());
    }

    private CombatUnit defendableIntruder(Tribe tribe, List<CombatUnit> intruders) {
        if (tribe.getCampHex() == null) return null;
        return intruders.stream().filter(unit -> unit.getHex() != null)
                .filter(unit -> canAttackFromCamp(tribe, unit))
                .min(Comparator.comparingInt(unit -> distance(tribe.getCampHex(), unit.getHex()))).orElse(null);
    }

    private boolean canAttackFromCamp(Tribe tribe, CombatUnit intruder) {
        int distance = distance(tribe.getCampHex(), intruder.getHex());
        if (distance < 1 || distance > 2) return false;
        return tribe.getWorld().getUnitRecord().getAll().stream()
                .filter(CombatUnit.class::isInstance).map(CombatUnit.class::cast)
                .filter(guard -> guard.isOwnedBy(tribe) && guard.getHex() == tribe.getCampHex() && guard.getAP() >= 1)
                .anyMatch(guard -> distance == 1 || guard instanceof Archer);
    }

    private static int distance(Hex first, Hex second) {
        int firstS = -first.getQ() - first.getR(), secondS = -second.getQ() - second.getR();
        return Math.max(Math.abs(first.getQ() - second.getQ()), Math.max(Math.abs(first.getR() - second.getR()),
                Math.abs(firstS - secondS)));
    }
}
