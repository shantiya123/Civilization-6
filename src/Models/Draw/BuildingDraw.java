package Models.Draw;

import Models.Elements.Buildings.Building;
import Models.Elements.Hex.Hex;

import javax.swing.*;
import java.awt.*;

public class BuildingDraw implements Draw {
    private final Building building;

    public BuildingDraw(Building building) {
        this.building = building;
    }

    @Override
    public void draw(Graphics g) {
        int drawX = building.getHex().getDrawX();
        int drawY = building.getHex().getDrawY();
        int drawW = building.getHex().getDrawW();
        int drawH = building.getHex().getDrawH();

        g.drawImage(building.getImage(), drawX, drawY, drawW, drawH, null);
    }
}