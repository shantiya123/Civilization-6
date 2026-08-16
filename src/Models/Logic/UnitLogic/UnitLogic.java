package Models.Logic.UnitLogic;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Unit;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;
import Models.Logic.SeasonLogic.SeasonLogic;

import java.util.ArrayList;
import java.util.List;

public class UnitLogic extends Logic {

    protected Unit unit;

    public UnitLogic(Unit unit, World world) {
        super(world);
        this.unit = unit;
    }

    public void cost(int AP) throws Exception {
        if (unit.getAP() < AP) {
            return;
        }
        unit.setAP(unit.getAP() - AP);
    }

    public void resetAp() {
        unit.setAP(unit.getInitialAP());
    }

    public void feed() throws Exception {
        world.getResourceRecord().consumeFood(1);
    }

    public void moveToHex(Hex targetHex) {
        if (targetHex == null || !targetHex.isVisible()) {
            throw new IllegalArgumentException("Units cannot move to an undiscovered hex");
        }
        unit.setHex(targetHex);
    }

    /** Single-edge AP cost shared by regular movement and pathfinding: terrain, season, then border. */
    public int movementCostBetween(Hex from, Hex to) {
        if (from == null || to == null || !HexLogic.getNeighbors(world, from).contains(to))
            throw new IllegalArgumentException("Movement requires two adjacent hexes");
        return Math.max(0, to.getMovementCost()
                + SeasonLogic.forCurrentSeason(world).getMovementCostModifier(to)
                + HexLogic.getBorderTransitEffect(world, from, to));
    }

    /** Computes a path's AP use from its actual edges, including river/wall/road borders. */
    public int movementCostForPath(List<Hex> path) {
        int cost = 0;
        for (int index = 1; index < path.size(); index++) cost += movementCostBetween(path.get(index - 1), path.get(index));
        return cost;
    }

    /** Applies positive direct damage and removes the unit immediately when it dies. */
    public void damage(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Damage must be positive");
        unit.setHP(unit.getHP() - amount);
        if (unit.getHP() <= 0) die();
    }

    public void die() {
        world.getUnitRecord().remove(unit);
        unit.setHex(null);
    }

    /** Compatibility alias for the naming used by the battle specification. */
    public void Die() { die(); }


    public boolean canReach(Hex targetHex) {
        if (unit.getHex() == null || targetHex == null) return false;
        FindBestPath pathfinder = new FindBestPath(world, unit.getHex(), targetHex);
        return pathfinder.canReach(unit.getAP());
    }


    public List<Hex> getBestPath(Hex targetHex) {
        if (unit.getHex() == null || targetHex == null) return new ArrayList<>();
        FindBestPath pathfinder = new FindBestPath(world, unit.getHex(), targetHex);
        return pathfinder.bestPath(unit.getAP());
    }

    public boolean canProduce(){
        Integer cap = world.getTownHall().getUnitCap().get(unit.getClass());
        if (cap == null) {
            return true;
        }
        int currentCount = 0;
        if (world.getUnitRecord().getAll(unit.getClass()) != null) {
            currentCount = world.getUnitRecord().getAll(unit.getClass()).size();
        }

        return (currentCount < cap) && ExtraConditions();
    }

    public boolean ExtraConditions(){
        return true;
    }
}
