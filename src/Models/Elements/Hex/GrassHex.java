package Models.Elements.Hex;

import Models.Elements.Resources.Resource;

public class GrassHex extends Hex{
    public GrassHex(int q, int r,Class<? extends Resource> additionalResource) {
        super(q , r , null , additionalResource);
        setImage("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\GrassImage.png");
    }
}
