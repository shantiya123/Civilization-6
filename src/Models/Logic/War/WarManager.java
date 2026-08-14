package Models.Logic.War;

import Game.World;
import Models.Elements.Borders.Border;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.TribeCamp;
import Models.Elements.Buildable.Constructure.Wall;
import Models.Elements.Hex.Hex;
import Models.Elements.Ownership.Owner;
import Models.Elements.Ownership.PlayerOwner;
import Models.Elements.Units.CombatUnits.Archer;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Elements.Units.Unit;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;
import Models.Logic.War.Battle.BattleManager;
import java.util.ArrayList;
import java.util.List;

/** Routes an attack to unit combat, direct structure damage, or adjacent empty-hex capture. */
public final class WarManager extends Logic {
    private final Hex offensiveHex;
    private final Hex defensiveHex;

    public WarManager(World world, Hex offensiveHex, Hex defensiveHex) {
        super(world);
        if (offensiveHex == null || defensiveHex == null || offensiveHex == defensiveHex)
            throw new IllegalArgumentException("Offensive and defensive hexes must be different and non-null");
        this.offensiveHex = offensiveHex;
        this.defensiveHex = defensiveHex;
    }

    public WarResult attack() throws Exception {
        return attackAs(PlayerOwner.INSTANCE);
    }

    /** Resolves a unit battle for the supplied faction.  Capture and structure attacks remain player-only. */
    public WarResult attackAs(Owner attackerOwner) throws Exception {
        if (attackerOwner == null) throw new IllegalArgumentException("An attacking owner is required");
        List<CombatUnit> offensiveUnits = combatUnitsIn(offensiveHex);
        if (offensiveUnits.isEmpty()) throw new IllegalStateException("Offensive hex does not contain combat units");
        if (offensiveUnits.stream().anyMatch(unit -> unit.getOwner() != attackerOwner))
            throw new IllegalStateException("Every offensive combat unit must belong to the attacking faction");

        if (offensiveHex == defensiveHex)
            throw new Exception("The offensive hex and defensive hex cannot be same ");

        if (!combatUnitsIn(defensiveHex).isEmpty()) {
            if (combatUnitsIn(defensiveHex).stream().anyMatch(unit -> unit.getOwner() == attackerOwner))
                throw new IllegalStateException("A faction cannot attack its own combat units");
            return new WarResult(WarResult.TargetType.COMBAT_UNITS,
                    new BattleManager(world, offensiveHex, defensiveHex).battle(), 0);
        }

        if (attackerOwner != PlayerOwner.INSTANCE)
            throw new IllegalStateException("Tribe attacks must target player combat units");

        Border border = HexLogic.getBorderBetween(world, offensiveHex, defensiveHex);
        Building building = defensiveHex.getBuilding();
        if (!(border instanceof Wall) && building == null) {
            if (hexDistance(offensiveHex, defensiveHex) != 1)
                throw new IllegalStateException("Only an adjacent empty hex can be captured");
            if (!defensiveHex.isFree())
                throw new IllegalStateException("Only free hexes can be captured");
            defensiveHex.claimForPlayer();
            return new WarResult(WarResult.TargetType.CAPTURED_EMPTY_HEX, null, 0);
        }

        List<CombatUnit> participants = structureAttackers(offensiveUnits);
        int damage = participants.stream().mapToInt(CombatUnit::getCombatPower).sum();
        consumeAP(participants);
        DamageBuildings damageBuildings = new DamageBuildings(world);
        if (border instanceof Wall) {
            damageBuildings.damage(border, damage);
            return new WarResult(WarResult.TargetType.WALL, null, damage);
        }

        if (building instanceof TribeCamp camp) {
            damageBuildings.damage(camp, damage);
            return new WarResult(WarResult.TargetType.CAMP, null, damage);
        }
        if (building != null) {
            damageBuildings.damage(building, damage);
            return new WarResult(WarResult.TargetType.BUILDING, null, damage);
        }

        throw new IllegalStateException("No valid war target was found");
    }

    /** Compatibility alias for callers that use the feature name instead of attack. */
    public WarResult war() throws Exception { return attack(); }

    /** Targets only the wall on the selected edge; no battle dice are rolled. */
    public WarResult attackWall() throws Exception {
        List<CombatUnit> offensiveUnits = combatUnitsIn(offensiveHex);
        if (offensiveUnits.isEmpty()) throw new IllegalStateException("Offensive hex does not contain combat units");
        if (offensiveUnits.stream().anyMatch(unit -> !unit.isPlayerOwned()))
            throw new IllegalStateException("Only player combat units can initiate an attack");

        Border border = HexLogic.getBorderBetween(world, offensiveHex, defensiveHex);
        if (!(border instanceof Wall)) throw new IllegalStateException("There is no wall between these hexes");

        List<CombatUnit> participants = structureAttackers(offensiveUnits);
        int damage = participants.stream().mapToInt(CombatUnit::getCombatPower).sum();
        consumeAP(participants);
        new DamageBuildings(world).damage(border, damage);
        return new WarResult(WarResult.TargetType.WALL, null, damage);
    }

    private List<CombatUnit> structureAttackers(List<CombatUnit> offensiveUnits) {
        int distance = hexDistance(offensiveHex, defensiveHex);
        if (distance != 1 && distance != 2)
            throw new IllegalArgumentException("A target hex must be one or two hexes away");
        List<CombatUnit> participants = distance == 2
                ? offensiveUnits.stream().filter(Archer.class::isInstance).toList()
                : offensiveUnits;
        if (participants.isEmpty()) throw new IllegalStateException("No eligible attacking combat units for this distance");
        return participants;
    }

    private List<CombatUnit> combatUnitsIn(Hex hex) {
        List<CombatUnit> units = new ArrayList<>();
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (unit.getHex() == hex && unit instanceof CombatUnit combatUnit) units.add(combatUnit);
        }
        return units;
    }

    private void consumeAP(List<CombatUnit> units) throws Exception {
        for (CombatUnit unit : units) {
            if (unit.getAP() < 1) throw new Exception("Every participating combat unit needs at least 1 AP");
        }
        for (CombatUnit unit : units) unit.getLogic().cost(1);
    }

    private static int hexDistance(Hex first, Hex second) {
        int firstS = -first.getQ() - first.getR();
        int secondS = -second.getQ() - second.getR();
        return Math.max(Math.abs(first.getQ() - second.getQ()),
                Math.max(Math.abs(first.getR() - second.getR()), Math.abs(firstS - secondS)));
    }
}
