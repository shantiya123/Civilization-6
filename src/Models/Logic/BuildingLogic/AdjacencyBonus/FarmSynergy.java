package Models.Logic.BuildingLogic.AdjacencyBonus;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Farm;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Food;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;

import java.util.ArrayList;

public class FarmSynergy extends Logic implements AdjacencyBonus{
    private final Building farm;
    public FarmSynergy(World world, Building farm) {
        super(world);
        this.farm = farm;
    }

    @Override
    public boolean Condition() {
        if (!(farm instanceof Farm) || farm.getHex() == null)
            return false;

        ArrayList<Hex> neighbors = HexLogic.getNeighbors(world , farm.getHex());
        for (Hex hex : neighbors) {
            Building neighborBuilding = hex.getBuilding();
            if (neighborBuilding instanceof Farm && isFirstFarmInPair(farm, neighborBuilding)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void effect() {
        for (Hex hex : HexLogic.getNeighbors(world, farm.getHex())) {
            Building neighborBuilding = hex.getBuilding();
            if (neighborBuilding instanceof Farm && isFirstFarmInPair(farm, neighborBuilding)) {
                farm.addAdjacencyBonus(Food.class, 1);
                update(farm);
            }
        }
    }

    /* Assigns each shared edge to one farm, so each pair produces exactly +1 Food. */
    private boolean isFirstFarmInPair(Building first, Building second) {
        Hex firstHex = first.getHex();
        Hex secondHex = second.getHex();
        return firstHex.getQ() < secondHex.getQ()
                || (firstHex.getQ() == secondHex.getQ() && firstHex.getR() < secondHex.getR());
    }
}
