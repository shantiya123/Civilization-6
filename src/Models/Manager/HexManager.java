package Models.Manager;

import Models.Elements.Hex.Hex;
import Models.Records.HexRecord;

import java.awt.*;

public class HexManager {

    private int[] zoom = {30, 50, 70, 100, 150};
    private int zoomIndex = 1;
    private int centerX;
    private int centerY;
    private int size;
    private HexRecord hexRecord;
    private Hexutils hexutils;
    private Runnable onPositionsChanged;

    public HexManager(int centerX, int centerY, HexRecord hexRecord , Hexutils hexutils) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.hexRecord = hexRecord;
        this.size = zoom[zoomIndex];
        this.hexutils = hexutils;
    }

    /** Register a callback to run whenever hex positions/sizes are recalculated (zoom, pan, initial add). */
    public void setOnPositionsChanged(Runnable onPositionsChanged) {
        this.onPositionsChanged = onPositionsChanged;
    }

    private void notifyPositionsChanged() {
        if (onPositionsChanged != null) {
            onPositionsChanged.run();
        }
    }

    /** Called by HexRecord.add() automatically — no need to call manually. */
    public void onHexAdded(Hex hex) {
        hexutils.updateHexPosition(hex, centerX, centerY, size);
        notifyPositionsChanged();
    }

    public void draw(Graphics g) {
        for (Hex hex : hexRecord.getAll()) {
            hex.getDraw().draw(g);
        }
    }

    public void recalculateAll() {
        for (Hex hex : hexRecord.getAll()) {
            hexutils.updateHexPosition(hex, centerX, centerY, size);
        }
        notifyPositionsChanged();
    }

    public void setSize(int newSize) {
        this.size = newSize;
        recalculateAll();
    }

    public void pan(int dx, int dy) {
        this.centerX += dx;
        this.centerY += dy;
        recalculateAll();
    }

    public void setCenter(int x, int y) {
        this.centerX = x;
        this.centerY = y;
        recalculateAll();
    }

    public int getCenterX() { return centerX; }
    public int getCenterY() { return centerY; }
    public int getSize()    { return size; }
    public int[] getZoom()  { return zoom; }
    public int getZoomIndex() { return zoomIndex; }

    public void setZoomIndex(int zoomIndex) {
        this.zoomIndex = zoomIndex;
    }
}