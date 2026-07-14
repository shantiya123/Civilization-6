package Models.Logic.UnitLogic;

import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Unit;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;

import java.util.ArrayList;
import java.util.List;

public class UnitLogic extends Logic {

    protected Unit unit;

    public UnitLogic(Unit unit) {
        this.unit = unit;
    }

    public void cost(int AP) throws Exception {
        if (unit.getAP() < AP) {
            throw new Exception("Not enough AP");
        }
        unit.setAP(unit.getAP() - AP);
    }

    public void resetAp() {
        unit.setAP(unit.getInitialAP());
    }

    public void feed() {
        resourceRecord.getAll(Food.class).remove(0);
    }

    public void moveToHex(Hex targetHex) {
        unit.setHex(targetHex);
    }

    /**
     * Checks if the unit can reach the targeted hex using its remaining current AP.
     */
    public boolean canReach(Hex targetHex) {
        if (unit.getHex() == null || targetHex == null) return false;
        FindBestPath pathfinder = new FindBestPath(unit.getHex(), targetHex);
        return pathfinder.canReach(unit.getAP());
    }

    /**
     * Gets the shortest optimal path list of hexes to the target hex.
     */
    public List<Hex> getBestPath(Hex targetHex) {
        if (unit.getHex() == null || targetHex == null) return new ArrayList<>();
        FindBestPath pathfinder = new FindBestPath(unit.getHex(), targetHex);
        return pathfinder.bestPath(unit.getAP());
    }
}