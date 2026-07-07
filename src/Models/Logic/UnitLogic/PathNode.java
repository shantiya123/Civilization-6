package Models.Logic.UnitLogic;

import Models.Elements.Hex.Hex;

public class PathNode {

    public Hex hex;
    public int cost;
    public PathNode previous;

    public PathNode(Hex hex, int cost, PathNode previous) {
        this.hex = hex;
        this.cost = cost;
        this.previous = previous;
    }
}