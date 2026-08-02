package Models.Elements.Hex;

import Models.Elements.Resources.Resource;

public class BergHex extends Hex{
    public BergHex(int q, int r, boolean additionalResource) {
        super(q, r, null , null);
        this.movementCost = 50;
    }
}
