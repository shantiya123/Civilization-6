package Models.Elements.Hex;

import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;

public class ForestHex extends Hex{
    public ForestHex(int q, int r , boolean additionalResource) {
        super(q , r , Wood.class , null);
        movementCost = 2;
        setImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\JungleImage.png");
    }
}
