package Models.Elements.Hex;

import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;

public class MountainHex extends Hex{
    public MountainHex(int q, int r , boolean additionalResources) {
        super(q , r , Stone.class , Iron.class);
        setAdditionalResources(additionalResources);
        movementCost = 4;
        setImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\MountainImage.png");
        setDarkerImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Darker\\MountainImage.png");
        initializeImages();
    }
}
