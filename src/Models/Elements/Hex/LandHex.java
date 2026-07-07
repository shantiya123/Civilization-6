package Models.Elements.Hex;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;

public class LandHex extends Hex{
    public LandHex(int q, int r , boolean additionalResources) {
        super(q , r , null , Food.class);
        setAdditionalResources(additionalResources);
        movementCost = 1;
        setImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\LandImage.png");

    }
}
