package Models.Elements.Hex;

import Models.Elements.Buildings.Farm;
import Models.Elements.Buildings.Settlement;
import Models.Elements.Buildings.Stable;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;

public class LandHex extends Hex{
    public LandHex(int q, int r , boolean additionalResources) {
        super(q , r , null , Food.class);
        setAdditionalResources(additionalResources);
        BuildableBuildings.add(Settlement.class);
        movementCost = 1;
        if (additionalResources){
            BuildableBuildings.add(Stable.class);
            setImage("/Images/ExrtraResources/LandWithAnimal.png");
            setDarkerImage("/Images/ExrtraResources/Darker/LandWithAnimal.png");
        }else {
            setImage("/Images/LandImage.png");
            setDarkerImage("/Images/Darker/LandImage.png");
        }

        initializeImages();
    }
}