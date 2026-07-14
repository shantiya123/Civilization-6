package Models.Logic.UnitLogic;

import Models.Elements.Units.Explorer;
import Models.Logic.HexLogic.HexLogic;

public class ExplorerLogic extends UnitLogic {

    private Explorer explorer;

    public ExplorerLogic(Explorer explorer) {
        super(explorer);
        this.explorer = explorer;
    }

    public void Explore() throws Exception {
//        System.out.println("Explore inside the logic called ");
        cost(1);
        HexLogic.discover(explorer.getHex());
    }
}
