package Models.Elements.Hex;

import Models.Elements.Buildable.Buildings.Dock;
import Models.Elements.Buildable.Buildings.Farm;
import Models.Elements.Resources.Food;

public class GrassHex extends Hex{
    public GrassHex(int q, int r,boolean additionalResources) {
        super(q , r , null , Food.class);
        setAdditionalResources(additionalResources);
        movementCost = 1;
        BuildableBuildings.add(Farm.class);
        BuildableBuildings.add(Dock.class);
        setImage("/Images/GrassImage.png");
        setDarkerImage("/Images/Darker/GrassImage.png");
        initializeImages();
    }
}