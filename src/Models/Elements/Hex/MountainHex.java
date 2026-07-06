package Models.Elements.Hex;

import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;

public class MountainHex extends Hex{
    public MountainHex(int q, int r , Class<? extends Resource> additionalResource) {
        super(q , r , Stone.class , additionalResource);
        setImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\MountainImage.png");
    }
}
