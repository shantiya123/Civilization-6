package Models.Elements.Hex;

import Models.Elements.Buildable.Buildings.MilitaryStable;
import Models.Elements.Buildable.Buildings.Stable;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;

public class SeaHex extends Hex{
    public SeaHex(int q, int r , boolean additionalResources) {
         super(q , r , null , Food.class);
         this.movementCost = 50;
         if (additionalResources){
            setImage("/Images/ExrtraResources/SeaWithFishes.png");
            setDarkerImage("/Images/ExrtraResources/Darker/SeaWithFishes.png");
         }else {
            setImage("/Images/SeaImage.png");
            setDarkerImage("/Images/Darker/SeaImage.png");
         }
         initializeImages();
    }
}
