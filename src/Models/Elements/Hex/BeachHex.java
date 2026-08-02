package Models.Elements.Hex;

import Models.Elements.Buildings.Dock;
import Models.Elements.Resources.Resource;

public class BeachHex extends Hex{
    public BeachHex(int q, int r, boolean additionalResource) {
        super(q , r , null , null);
        this.movementCost = 2;
        BuildableBuildings.add(Dock.class);
    }
}
