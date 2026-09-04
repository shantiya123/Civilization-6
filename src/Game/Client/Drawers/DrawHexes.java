package Game.Client.Drawers;

import Models.Records.HexRecord;
import java.awt.*;

public class DrawHexes {
    private final HexRecord hexRecord;

    public DrawHexes(HexRecord hexRecord) {
        this.hexRecord = hexRecord;
    }

    public void draw(Graphics g) {
        Rectangle viewport = g.getClipBounds();
        for (var hex : hexRecord.getAll()) {
            Rectangle bounds = new Rectangle(hex.getDrawX(), hex.getDrawY(), hex.getDrawW(), hex.getDrawH());
            if (viewport != null && !bounds.intersects(viewport)) continue;
            hex.getDraw().draw(g);
        }
    }
}
