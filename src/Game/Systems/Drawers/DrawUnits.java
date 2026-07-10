package Game.Systems.Drawers;

import Models.Elements.Units.Unit;
import Models.Records.UnitRecord;
import java.awt.*;

public class DrawUnits {
    private final UnitRecord unitRecord;

    public DrawUnits(UnitRecord unitRecord) {
        this.unitRecord = unitRecord;
    }

    public void draw(Graphics g) {
        for (Unit unit : unitRecord.getAll())
            unit.getDraw().draw(g);
    }
}