package Models.Logic.BuildingLogic.AdjacencyBonus;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.IronMine;
import Models.Elements.Buildable.Buildings.StoneMine;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.MountainHex;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.Logic;

import java.util.ArrayList;

public class DeepMines extends Logic implements AdjacencyBonus {
    private final Building mine;

    public DeepMines(World world, Building mine) {
        super(world);
        this.mine = mine;
    }

    @Override
    public boolean Condition() {
        if (!(mine instanceof StoneMine) && !(mine instanceof IronMine) || mine.getHex() == null)
            return false;
        int ans =0;
        ArrayList<Hex> neighbors = HexLogic.getNeighbors(world , mine.getHex());
        for (Hex hex : neighbors)
            if (hex instanceof MountainHex)
                ans++;
        return ans >= 2;
    }

    @Override
    public void effect() {
        Class<? extends Resource> output = mine instanceof StoneMine ? Stone.class : Iron.class;
        mine.addAdjacencyBonus(output, 1);
        update(mine);
    }
}
