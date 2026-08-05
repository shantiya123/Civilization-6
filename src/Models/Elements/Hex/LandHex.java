package Models.Elements.Hex;

import Models.Elements.Buildings.*;
import Models.Elements.Resources.Food;
import Models.Elements.Resources.Resource;

public class LandHex extends Hex{
    public LandHex(int q, int r , boolean additionalResources) {
        super(q , r , null , Food.class);
        setAdditionalResources(additionalResources);
        BuildableBuildings.add(Settlement.class);
        BuildableBuildings.add(Road.class);
        BuildableBuildings.add(Monument.class);
        BuildableBuildings.add(Dock.class);
        BuildableBuildings.add(Bazaar.class);
        movementCost = 1;
        if (additionalResources){
            BuildableBuildings.add(Stable.class);
            BuildableBuildings.add(MilitaryStable.class);
            setImage("/Images/ExrtraResources/LandWithAnimal.png");
            setDarkerImage("/Images/ExrtraResources/Darker/LandWithAnimal.png");
        }else {
            setImage("/Images/LandImage.png");
            setDarkerImage("/Images/Darker/LandImage.png");
        }

        initializeImages();
    }
}