package Models.Logic.UnitLogic;

import Game.Generate;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;
import Models.Elements.Units.Unit;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;
import Models.Records.ResourceRecord;
import Models.Records.UnitRecord;

import java.util.ArrayList;
import java.util.List;

public class UnitLogic extends Logic {
    protected Unit unit;
    private FindBestPath bestPath;
    private List<Hex> path;


    public UnitLogic(Unit unit) {
        this.unit = unit;
    }

    public void cost(int Ap) throws Exception {
        if (unit.getAP() < Ap)
            throw new Exception("Ap is not enough");
        unit.setAP(unit.getAP() - Ap);
    }

    public void resetAp(){
        unit.setAP(unit.getInitialAP());
    }

    // Deducts the food this unit needs this turn from ResourceRecord.
    public void feed() {
        List<Resource> foodStock = resourceRecord.getAll(Food.class);
        int need = unit.getFoodNeed();
        for (int i = 0; i < need && i < foodStock.size(); i++) {
            resourceRecord.remove(foodStock.get(i));
        }
    }

    public void moveToNextHex(Hex hex) throws Exception {
        ArrayList<Hex> neighbors = HexLogic.getNeighbors(unit.getHex());
        if (hex.getMovementCost() > unit.getAP()){
            throw new Exception("not enough AP");
        }
        if (neighbors.contains(hex)){
            unit.setHex(hex);
        }
    }

    public int CalculateMovementCost(Hex hex){
        bestPath = new FindBestPath(unit.getHex() , hex);
        path = bestPath.findPath();
        return bestPath.getTotalCost();
    }

    public void moveToHex(Hex goalHex) throws Exception {
        if (CalculateMovementCost(goalHex) > unit.getAP())
            throw new Exception("not Enough Ap");
        for (Hex hex : path){
           moveToNextHex(hex);
       }
    }

}
