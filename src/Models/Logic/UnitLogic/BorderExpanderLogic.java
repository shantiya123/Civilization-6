package Models.Logic.UnitLogic;

import Models.Draw.UnitPositionCalculator;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.BorderExpander;
import Models.Logic.HexLogic.HexLogic;
import Models.Records.UnitRecord;

import java.util.ArrayList;

public class BorderExpanderLogic extends UnitLogic {

    private BorderExpander borderExpander;

    public BorderExpanderLogic(BorderExpander borderExpander) {
        super(borderExpander);
        this.borderExpander = borderExpander;
    }

    // Marks the hex the BorderExpander stands on as part of the empire's
    // border, then consumes the unit (removes it from UnitRecord).
    public void addToBorder() {
        Hex hex = borderExpander.getHex();
        ArrayList<Hex> neighbors = HexLogic.getNeighbors(hex);
        hex.setBorder(true);
        for (Hex hex1:neighbors)
            hex1.setBorder(true);
        unitRecord.remove(borderExpander);
        UnitPositionCalculator.refreshHex(unit.getHex() , unit);
    }
}
