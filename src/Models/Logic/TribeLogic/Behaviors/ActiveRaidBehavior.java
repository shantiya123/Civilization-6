package Models.Logic.TribeLogic.Behaviors;

import Game.World;
import Models.Elements.Hex.BergHex;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.Builder;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.TribeLogic.RelationshipState.EnemyState;
import Models.Logic.UnitLogic.FindBestPath;

import java.util.Comparator;
import java.util.List;

/** Optional enemy raid: one guard may leave territory, clear nearby targets, then return to camp. */
public final class ActiveRaidBehavior {
    private static final int RAID_RADIUS = 5;
    private final World world;

    public ActiveRaidBehavior(World world) { this.world = world; }

    public boolean canExecute(Tribe tribe, boolean underAttack) {
        if (!(tribe.getRelationshipState() instanceof EnemyState) || underAttack || tribe.getCampHex() == null) return false;
        CombatUnit activeRaider = tribe.getRuntimeState().getActiveRaider();
        if (activeRaider != null) return world.getUnitRecord().getAll().contains(activeRaider);
        return guards(tribe).size() >= 2 && findTargetHex(tribe) != null;
    }

    /** Performs one turn of an existing raid or launches a new one. */
    public boolean execute(Tribe tribe) {
        CombatUnit raider = tribe.getRuntimeState().getActiveRaider();
        if (raider == null) {
            Hex targetHex = findTargetHex(tribe);
            if (targetHex == null) return false;
            raider = guards(tribe).stream().filter(unit -> unit.getAP() > 0)
                    .min(Comparator.comparingInt(unit -> distance(unit.getHex(), targetHex))).orElse(null);
            if (raider == null) return false;
            tribe.getRuntimeState().startRaid(raider, targetHex);
        }

        if (raider.getHP() <= 0 || !world.getUnitRecord().getAll().contains(raider)) {
            tribe.getRuntimeState().clearRaid();
            return false;
        }

        if (tribe.getRuntimeState().isReturningRaiderToCamp()) {
            moveToward(raider, tribe.getCampHex(), true);
            if (raider.getHex() == tribe.getCampHex()) tribe.getRuntimeState().clearRaid();
            return true;
        }

        Hex targetHex = tribe.getRuntimeState().getRaidTargetHex();
        if (!isValidTarget(tribe, targetHex)) {
            chooseNextTargetOrReturn(tribe);
            return execute(tribe);
        }

        if (distance(raider.getHex(), targetHex) <= raider.getAttackRange()) {
            attack(raider, targetHex);
            chooseNextTargetOrReturn(tribe);
            return true;
        }

        moveToward(raider, targetHex, false);
        return true;
    }

    private void attack(CombatUnit raider, Hex targetHex)  {
        if (raider.getAP() < 1) return;
        raider.setAP(raider.getAP() - 1);
        Unit target = targetAt(targetHex);
        if (target != null) target.getLogic().damage(raider.getCombatPower());
        else if (targetHex.getBuilding() != null) targetHex.getBuilding().getLogic().damage(raider.getCombatPower());
    }

    private void chooseNextTargetOrReturn(Tribe tribe) {
        Hex nextTarget = findTargetHex(tribe);
        if (nextTarget == null) tribe.getRuntimeState().returnRaiderToCamp();
        else tribe.getRuntimeState().setRaidTargetHex(nextTarget);
    }

    /** Uses an unlimited planning budget but only applies path steps payable by current AP. */
    private void moveToward(CombatUnit raider, Hex destination, boolean returning) {
        if (raider.getHex() == null || destination == null || raider.getAP() <= 0) return;
        int planningBudget = Math.max(1, world.getHexRecord().getAll().size() * 60);
        List<Hex> path = new FindBestPath(world, raider.getHex(), destination)
                .findPath(planningBudget, this::isPassableLand);
        for (int index = 1; index < path.size(); index++) {
            Hex next = path.get(index);
            int cost = movementCost(raider.getHex(), next);
            if (cost > raider.getAP()) break;
            if (!returning && occupiedByOtherUnit(next, raider)) break;
            if (returning && next != destination && occupiedByOtherUnit(next, raider)) break;
            raider.setAP(raider.getAP() - cost);
            raider.setHex(next);
        }
    }

    private Hex findTargetHex(Tribe tribe) {
        List<Unit> candidates = world.getUnitRecord().getAll().stream()
                .filter(Unit::isPlayerOwned).filter(unit -> unit.getHex() != null)
                .filter(unit -> distance(tribe.getCampHex(), unit.getHex()) <= RAID_RADIUS).toList();
        Unit combat = nearest(tribe, candidates.stream().filter(CombatUnit.class::isInstance).toList());
        if (combat != null) return combat.getHex();
        Unit civilian = nearest(tribe, candidates.stream().filter(unit -> unit instanceof Builder || unit instanceof Worker).toList());
        if (civilian != null) return civilian.getHex();
        return world.getBuildingRecord().getAll().stream().map(Models.Elements.Buildable.Buildings.Building::getHex)
                .filter(hex -> hex != null && hex.isPlayerOwned() && distance(tribe.getCampHex(), hex) <= RAID_RADIUS)
                .min(Comparator.comparingInt(hex -> distance(tribe.getCampHex(), hex))).orElse(null);
    }

    private Unit nearest(Tribe tribe, List<Unit> candidates) {
        return candidates.stream().min(Comparator.comparingInt(unit -> distance(tribe.getCampHex(), unit.getHex()))).orElse(null);
    }

    private Unit targetAt(Hex hex) {
        if (hex == null) return null;
        return world.getUnitRecord().getAll().stream().filter(Unit::isPlayerOwned)
                .filter(unit -> unit.getHex() == hex).findFirst().orElse(null);
    }

    private boolean isValidTarget(Tribe tribe, Hex targetHex) {
        if (targetHex == null || distance(tribe.getCampHex(), targetHex) > RAID_RADIUS) return false;
        Unit unit = targetAt(targetHex);
        return unit != null || (targetHex.isPlayerOwned() && targetHex.getBuilding() != null);
    }

    private List<CombatUnit> guards(Tribe tribe) {
        return world.getUnitRecord().getAll().stream().filter(CombatUnit.class::isInstance).map(CombatUnit.class::cast)
                .filter(unit -> unit.isOwnedBy(tribe) && unit.getHex() != null).toList();
    }

    private boolean occupiedByOtherUnit(Hex hex, Unit current) {
        return world.getUnitRecord().getAll().stream().anyMatch(unit -> unit != current && unit.getHex() == hex);
    }
    private boolean isPassableLand(Hex hex) { return !(hex instanceof SeaHex) && !(hex instanceof BergHex); }
    private int movementCost(Hex from, Hex to) { return Math.max(0, to.getMovementCost() + Models.Logic.SeasonLogic.SeasonLogic.forCurrentSeason(world).getMovementCostModifier(to) + HexLogic.getBorderTransitEffect(world, from, to)); }
    private static int distance(Hex first, Hex second) { int firstS = -first.getQ() - first.getR(), secondS = -second.getQ() - second.getR(); return Math.max(Math.abs(first.getQ() - second.getQ()), Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS))); }
}
