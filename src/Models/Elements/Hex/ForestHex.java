package Models.Elements.Hex;

import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;

public class ForestHex extends Hex {
    public ForestHex(int q, int r, boolean additionalResource) {
        super(q, r, Wood.class, null);
        this.movementCost = 2;

        // 1. Assign local absolute resource path strings first
        setImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\JungleImage.png");
        setDarkerImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\Darker\\JungleImage.png");

        // 2. Safely initialize image references now that paths are present
        initializeImages();
    }
}