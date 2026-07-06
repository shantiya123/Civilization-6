package Models.Elements.Hex;

import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;

public class ForestHex extends Hex{
    public ForestHex(int q, int r , Class<? extends Resource> additionalResource) {
        super(q , r , Wood.class , additionalResource);
        setImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\JungleImage.png");
    }
}
