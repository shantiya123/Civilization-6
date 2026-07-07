package Models.Logic.UnitLogic;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;
import Models.Logic.HexLogic.HexLogic;

import java.util.ArrayList;
import java.util.List;

public class UnitLogic {
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

    public void MoveToHex(Hex goalHex) throws Exception {
        if (CalculateMovementCost(goalHex) > unit.getAP())
            throw new Exception("not Enough Ap");
        for (Hex hex : path){
           moveToNextHex(hex);
       }
    }

}
