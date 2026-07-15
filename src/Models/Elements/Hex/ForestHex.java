package Models.Elements.Hex;

import Models.Elements.Buildings.LumberMill;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Wood;

public class ForestHex extends Hex {
    public ForestHex(int q, int r, boolean additionalResource) {
        super(q, r, Wood.class, null);
        this.movementCost = 2;
        BuildableBuildings.add(LumberMill.class);
        setImage("/Images/JungleImage.png");
        setDarkerImage("/Images/Darker/JungleImage.png");

        initializeImages();
    }
}