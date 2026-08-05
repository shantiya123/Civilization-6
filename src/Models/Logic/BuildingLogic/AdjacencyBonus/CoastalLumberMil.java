package Models.Logic.BuildingLogic.AdjacencyBonus;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.LumberMill;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Elements.Resources.Wood;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;

import java.util.ArrayList;

public class CoastalLumberMil extends Logic implements AdjacencyBonus {
    private Building lumberMil;

    public CoastalLumberMil(World world, Building lumberMil) {
        super(world);
        this.lumberMil = lumberMil;
    }

    @Override
    public boolean Condition() {
        if (!(lumberMil instanceof LumberMill) || lumberMil.getHex() == null)
            return false;
        ArrayList<Hex> neighbors = HexLogic.getNeighbors(world , lumberMil.getHex());
        for (Hex hex : neighbors)
            if (hex instanceof SeaHex)
                return true;
        return false;
    }

    @Override
    public void effect() {
        lumberMil.addAdjacencyBonus(Wood.class, 2);
    }
}
