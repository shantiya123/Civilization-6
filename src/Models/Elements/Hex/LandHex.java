package Models.Elements.Hex;

import Models.Elements.Resources.Resource;

public class LandHex extends Hex{
    protected final boolean hasAnimals;

    public LandHex(int q, int r , Class<? extends Resource> additionalResource, boolean hasAnimals) {
        super(q , r , null ,additionalResource);
        this.hasAnimals = hasAnimals;
        setImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\LandImage.png");
    }
}
