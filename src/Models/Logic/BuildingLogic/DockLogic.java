package Models.Logic.BuildingLogic;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Dock;
import Models.Elements.Hex.Hex;
import Models.Elements.Hex.SeaHex;
import Models.Logic.HexLogic.HexLogic;

import javax.print.Doc;

public class DockLogic extends BuildingLogic{
    private Dock dock;
    public DockLogic(Dock dock, World world) {
        super(dock, world);
        this.dock = dock;
    }

    @Override
    public void Supply() {
        for (Hex hex : HexLogic.getNeighbors(world , dock.getHex()))
            if (hex instanceof SeaHex && hex.isAdditionalResources()){
                new BuildingLogic(dock , world).Supply();
                return;
            }

    }
}
