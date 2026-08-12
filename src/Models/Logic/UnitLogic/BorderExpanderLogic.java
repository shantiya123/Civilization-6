package Models.Logic.UnitLogic;

import Game.World;
import Models.Draw.UnitPositionCalculator;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.BorderExpander;
import Models.Logic.HexLogic.HexLogic;
import Models.Records.UnitRecord;

import java.util.ArrayList;

public class BorderExpanderLogic extends UnitLogic {

    private BorderExpander borderExpander;

    public BorderExpanderLogic(BorderExpander borderExpander, World world) {
        super(borderExpander, world);
        this.borderExpander = borderExpander;
    }

    public void addToBorder() {
        Hex hex = borderExpander.getHex();
        ArrayList<Hex> neighbors = HexLogic.getNeighbors(world, hex);
        if (!hex.isPlayerOwned() && !hex.isFree()) {
            throw new IllegalStateException("A Border Expander cannot claim tribal territory");
        }

        hex.claimForPlayer();
        for (Hex hex1:neighbors) {
            if (hex1.isFree()) {
                hex1.claimForPlayer();
            }
        }
        world.getUnitRecord().remove(borderExpander);
        UnitPositionCalculator.refreshHex(unit.getHex() , unit);
    }
}
