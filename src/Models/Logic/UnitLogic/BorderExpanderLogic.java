package Models.Logic.UnitLogic;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.BorderExpander;
import Models.Records.UnitRecord;

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
        hex.setBorder(true);
        unitRecord.remove(borderExpander);
    }
}
