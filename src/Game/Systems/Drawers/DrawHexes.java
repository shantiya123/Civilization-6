package Game.Systems.Drawers;

import Models.Records.HexRecord;
import java.awt.*;

public class DrawHexes {
    private final HexRecord hexRecord;

    public DrawHexes(HexRecord hexRecord) {
        this.hexRecord = hexRecord;
    }

    public void draw(Graphics g) {
        for (var hex : hexRecord.getAll()) {
            hex.getDraw().draw(g);
        }
    }
}