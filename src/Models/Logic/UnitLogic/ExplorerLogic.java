package Models.Logic.UnitLogic;

import Game.World;
import Models.Elements.Units.Explorer;
import Models.Logic.HexLogic.HexLogic;

public class ExplorerLogic extends UnitLogic {

    private Explorer explorer;

    public ExplorerLogic(Explorer explorer, World world) {
        super(explorer, world);
        this.explorer = explorer;
    }

    public void Explore() throws Exception {

        cost(1);
        HexLogic.discover(world, explorer.getHex());

    }
}
