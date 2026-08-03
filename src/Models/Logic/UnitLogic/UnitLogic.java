package Models.Logic.UnitLogic;

import Game.World;
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
        unit.setHex(targetHex);
    }


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
}
