package Models.Elements.Hex;

import Models.Elements.Buildable.Buildings.IronMine;
import Models.Elements.Buildable.Buildings.StoneMine;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Stone;

public class MountainHex extends Hex{
    public MountainHex(int q, int r , boolean additionalResources) {
        super(q , r , Stone.class , Iron.class);
        setAdditionalResources(additionalResources);
        movementCost = 4;
        BuildableBuildings.add(StoneMine.class);
        if (additionalResources){
            BuildableBuildings.add(IronMine.class);
//            System.out.println("fuck");
            setImage("/Images/ExrtraResources/MountainWithIron.png");
            setDarkerImage("/Images/ExrtraResources/Darker/MountainWithIron.png");
        }else {
            setImage("/Images/MountainImage.png");
            setDarkerImage("/Images/Darker/MountainImage.png");
        }

        initializeImages();
    }
}