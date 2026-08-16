package Models.Manager;

import Models.Elements.Hex.Hex;
import Models.Records.HexRecord;

import java.awt.*;

public class HexManager {

    private int[] zoom = {30, 50, 70, 100, 150 , 200};
    private int zoomIndex = 1;
    private int centerX;
    private int centerY;
    private int size;
    private HexRecord hexRecord;
    private Hexutils hexutils;
    private Runnable onPositionsChanged;
    private int batchUpdateDepth;
    private boolean positionsChangedDuringBatch;
    private int viewportWidth;
    private int viewportHeight;

    public HexManager(int centerX, int centerY, HexRecord hexRecord , Hexutils hexutils) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.hexRecord = hexRecord;
        this.size = zoom[zoomIndex];
        this.hexutils = hexutils;
        this.viewportWidth = centerX * 2;
        this.viewportHeight = centerY * 2;
    }


    public void setOnPositionsChanged(Runnable onPositionsChanged) {
        this.onPositionsChanged = onPositionsChanged;
    }

    private void notifyPositionsChanged() {
        if (onPositionsChanged != null) {
            onPositionsChanged.run();
        }
    }


    public void onHexAdded(Hex hex) {
        hexutils.updateHexPosition(hex, centerX, centerY, size);
        if (batchUpdateDepth > 0) positionsChangedDuringBatch = true;
        else notifyPositionsChanged();
    }

    /** Defers costly unit-position refreshes until a whole generated map section has been added. */
    public void beginBatchUpdate() { batchUpdateDepth++; }
    public void endBatchUpdate() {
        if (batchUpdateDepth == 0) throw new IllegalStateException("No hex batch update is active");
        if (--batchUpdateDepth == 0 && positionsChangedDuringBatch) {
            positionsChangedDuringBatch = false;
            notifyPositionsChanged();
        }
    }

    public void draw(Graphics g) {
        Rectangle viewport = g.getClipBounds();
        for (Hex hex : hexRecord.getAll()) {
            if (viewport != null && !visibleInViewport(hex, viewport)) continue;
            hex.getDraw().draw(g);
        }
    }

    private boolean visibleInViewport(Hex hex, Rectangle viewport) {
        Rectangle bounds = new Rectangle(hex.getDrawX(), hex.getDrawY(), hex.getDrawW(), hex.getDrawH());
        return bounds.intersects(viewport);
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

    /** Changes scale while keeping the world point below the screen center fixed. */
    public void setSizeAroundViewportCenter(int newSize) {
        if (newSize <= 0) throw new IllegalArgumentException("Hex size must be positive");
        if (newSize == size) return;
        // HexDraw doubles the stored x/y coordinates when creating drawX/drawY.
        // Convert the visible screen center back into HexManager's coordinate space first.
        double anchorX = viewportWidth / 4.0;
        double anchorY = viewportHeight / 4.0;
        double scale = (double) newSize / size;
        centerX = (int) Math.round(anchorX - (anchorX - centerX) * scale);
        centerY = (int) Math.round(anchorY - (anchorY - centerY) * scale);
        size = newSize;
        recalculateAll();
    }

    /** Called by the board panel; it is the authoritative visible screen size for zoom anchoring. */
    public void setViewportSize(int width, int height) {
        if (width > 0) viewportWidth = width;
        if (height > 0) viewportHeight = height;
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
    public int getViewportWidth() { return viewportWidth; }
    public int getViewportHeight() { return viewportHeight; }

    public void setZoomIndex(int zoomIndex) {
        this.zoomIndex = zoomIndex;
    }
}
