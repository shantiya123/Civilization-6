package Models.Elements.Hex;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;

public class SeaHex extends Hex{
    public SeaHex(int q, int r , boolean additionalResources) {
         super(q , r , null , Food.class);
         this.movementCost = 1;
    }
}
