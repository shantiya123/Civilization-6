package Game.Systems.Drawers;

import Game.World;
import Models.ConnectDrawing;
import Models.Elements.Hex.Hex;

import java.awt.*;

public class BorderDrawer {
    private final World world;
    private final ConnectDrawing connectDrawing;

    public BorderDrawer(World world, ConnectDrawing connectDrawing) {
        this.world = world;
        this.connectDrawing = connectDrawing;
    }
    public void draw(Graphics g){
        if (!connectDrawing.isShowBorder())
            return;
        for (Hex hex : world.getHexRecord().getAll())
            if (hex.isBorder())
                drawBorder(hex , g);

    }
    public void drawBorder(Hex hex  , Graphics g){
        int drawX = hex.getDrawX();
        int drawY = hex.getDrawY();
        g.setColor(new Color(246, 212, 97));
        Graphics2D g2 = (Graphics2D)g ;
        g2.setStroke(new BasicStroke(0.3f));
        g2.drawOval((int) (drawX + hex.getSize() * 1.1), (int) (drawY  + hex.getSize() * 0.1), (int) (hex.getSize() *1.6), (int) (hex.getSize() * 1.6));
    }
}
