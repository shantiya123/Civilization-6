package Game.Client.Drawers;

import Game.World;
import Game.Client.Presentation.DrawingState;
import Models.Elements.Hex.Hex;

import java.awt.*;

public class TerritoryDrawer {
    private final World world;
    private final DrawingState drawingState;

    public TerritoryDrawer(World world, DrawingState drawingState) {
        this.world = world;
        this.drawingState = drawingState;
    }
    public void draw(Graphics g){
        if (!drawingState.isShowBorder())
            return;
        for (Hex hex : world.getHexRecord().getAll())
            if (!hex.isFree() && shouldShowTerritory(hex))
                drawBorder(hex , g);

    }
    private boolean shouldShowTerritory(Hex hex) {
        return hex.isPlayerOwned() || (hex.getOwningTribe() != null && hex.getOwningTribe().isVisible());
    }
    public void drawBorder(Hex hex  , Graphics g){
        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        g.setColor(hex.isPlayerOwned()
                ? new Color(246, 212, 97)
                : new Color(187, 110, 82));
        Graphics2D g2 = (Graphics2D)g ;
        g2.setStroke(new BasicStroke(0.3f));
        g2.drawOval((int) (drawX + hex.getSize() * 1.1), (int) (drawY  + hex.getSize() * 0.1), (int) (hex.getSize() *1.6), (int) (hex.getSize() * 1.6));
    }
}
