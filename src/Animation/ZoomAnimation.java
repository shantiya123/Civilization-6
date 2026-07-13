package Animation;

import Models.Manager.HexManager;

public class ZoomAnimation extends BaseAnimation {
    private final HexManager hexManager;
    private final int startZoom;
    private final int targetZoom;
    private final int totalDZoom;
    private final Runnable callback;

    public ZoomAnimation(int zoomDelta, HexManager hexManager, Runnable callback) {
        super(40);
        this.hexManager = hexManager;
        this.callback = callback;

        int[] zoomLevels = hexManager.getZoom();
        int currentIdx = hexManager.getZoomIndex();
        int targetIdx = Math.max(0, Math.min(zoomLevels.length - 1, currentIdx + zoomDelta));

        this.startZoom = hexManager.getSize();     // actual current visual size, not the table lookup
        this.targetZoom = zoomLevels[targetIdx];
        this.totalDZoom = targetZoom - startZoom;

        hexManager.setZoomIndex(targetIdx);
    }

    @Override
    protected void onTick(double progress) {
        if (totalDZoom == 0) return;

        double smoothProgress = TimerEquations.easeOut(progress);
        int ongoingSize = (int) (startZoom + smoothProgress * totalDZoom);
        hexManager.setSize(ongoingSize);
    }

    @Override
    protected void onComplete() {
        // Guarantee alignment snap
        hexManager.setSize(targetZoom);
        if (callback != null) {
            callback.run();
        }
    }
}