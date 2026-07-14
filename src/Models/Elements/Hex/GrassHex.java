package Models.Elements.Hex;

import Models.Elements.Buildings.Farm;
import Models.Elements.Buildings.Stable;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;

public class GrassHex extends Hex{
    public GrassHex(int q, int r,boolean additionalResources) {
        super(q , r , null , Food.class);
        setAdditionalResources(additionalResources);
        movementCost = 1;
        BuildableBuildings.add(Farm.class);
        setImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\GrassImage.png");
        setDarkerImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Darker\\GrassImage.png");
        initializeImages();
    }
}
