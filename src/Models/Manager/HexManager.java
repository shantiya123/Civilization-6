package Models.Manager;

import Models.Hex.Hex;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HexManager {

    private static final ArrayList<Hex> hexes = new ArrayList<>();

    // The pixel position of the center hex (q=0, r=0) on the panel
    private static int centerX;
    private static int centerY;

    // Current hex size — changes on zoom
    private static int size;

    public HexManager(int centerx, int centery, int Size) {
        centerX = centerx;
        centerY = centery;
        size = Size;
    }

    /**
     * Adds a hex to the manager and immediately calculates its x,y
     * based on current centerX, centerY and size.
     */
    public void addHex(Hex hex) {
        Hexutils.updateHexPosition(hex, centerX, centerY, size);
        hexes.add(hex);
        System.out.println(hex.getQ() + " >> " + hex.getR() + " >< " + hex.getCenterX() + " <><><>" + hex.getCenterY());
    }

    public void draw(Graphics g) {

        for (Hex hex : hexes) {
            hex.getLogic().draw(g);

        }
    }

    public static void recalculateAll() {
        for (Hex hex : hexes) {
            Hexutils.updateHexPosition(hex, centerX, centerY, size);
//            hex.SetDrawing();
        }
    }

    public void setSize(int newSize) {
        this.size = newSize;
        recalculateAll();
    }

    /**
     * Moves the camera (pan) by a delta and recalculates all positions.
     */
    public static  void pan(int dx, int dy) {
        centerX += dx;
        centerY += dy;
        recalculateAll();
    }

    /**
     * Moves the camera to an absolute position.
     */
    public void setCenter(int x, int y) {
        this.centerX = x;
        this.centerY = y;
        recalculateAll();
    }

    // --- Getters ---

    public static ArrayList<Hex> getHexes() { return hexes; }
    public static int getCenterX() { return centerX; }
    public static int getCenterY() { return centerY; }
    public static int getSize() { return size; }

    /**
     * Finds a hex by its axial coordinates.
     */
    public Hex getHex(int q, int r) {
        for (Hex hex : hexes) {
            if (hex.getQ() == q && hex.getR() == r) return hex;
        }
        return null;
    }

    public static void setCenterX(int centerX) {
        HexManager.centerX = centerX;
    }

    public static void setCenterY(int centerY) {
        HexManager.centerY = centerY;
    }
}