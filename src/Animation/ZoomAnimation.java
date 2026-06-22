package Animation;

import Controller.BoardController;
import Models.Generator;
import Models.Manager.HexManager;

import javax.swing.SwingUtilities;

public class ZoomAnimation extends Animation {

    private final int startZoom;
    private final int targetZoom;
    private static ZoomAnimation current;

    public ZoomAnimation(int zoomDelta) {
        this.totalSteps = 40;
        this.currentStep = 0;

        int[] zooms = HexManager.getZoom();
        int currentIndex = HexManager.getZoomIndex();
        int targetIndex = Math.max(0, Math.min(zooms.length - 1, currentIndex + zoomDelta));

        this.startZoom = zooms[currentIndex];
        this.targetZoom = zooms[targetIndex];

        HexManager.setZoomIndex(targetIndex);
    }

    @Override
    protected boolean AnimationStopper() {
        return currentStep >= totalSteps;
    }

    @Override
    public void StartAnimation() {
        if (current != null) current.stopAnimation();
        current = this;

        int totalDZoom = targetZoom - startZoom;
        if (totalDZoom == 0) {
            BoardController.resetZoom(); // nothing to animate, release lock immediately
            return;
        }

        animationThread = new Thread(() -> {
            while (!AnimationStopper()) {
                currentStep++;
                double progress = TimerEquations.easeOut((double) currentStep / totalSteps);
                int newSize = (int) (startZoom + progress * totalDZoom);

                SwingUtilities.invokeLater(() -> {
                    HexManager.setSize(newSize);
                    Generator.getEngine().refresh();
                });

                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    BoardController.resetZoom(); // interrupted — release lock
                    return;
                }
            }

            // Animation done — snap to exact target and release lock
            SwingUtilities.invokeLater(() -> {
                HexManager.setSize(targetZoom);
                Generator.getEngine().refresh();
                current = null;
                BoardController.resetZoom(); // ready for next zoom
            });
        });

        animationThread.setDaemon(true);
        animationThread.start();
    }

    public static void StartZoomAnimation(int zoomDelta) {
        new ZoomAnimation(zoomDelta).StartAnimation();
    }
}