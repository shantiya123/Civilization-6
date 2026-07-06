package Animation;

import Models.Generator;
import Models.Elements.Hex.Hex;
import Models.Manager.HexManager;

import javax.swing.SwingUtilities;

public class BoardAnimations extends Animation {

    private final int totalDx;
    private final int totalDy;
    private double previousProgress;
    private final int BoardCenterX = 665;
    private final int BoardCenterY = 335;

    private static BoardAnimations current;

    public BoardAnimations(Hex hex) {
        this.totalSteps = 40;
        this.currentStep = 0;
        this.previousProgress = 0;
        this.totalDx = -(hex.getCenterX() - BoardCenterX);
        this.totalDy = -(hex.getCenterY() - BoardCenterY);
    }

    @Override
    protected boolean AnimationStopper() {
        return currentStep >= totalSteps;
    }

    @Override
    public void StartAnimation() {
        System.out.println("startAnimation called ");
        if (current != null) current.stopAnimation();
        current = this;

        animationThread = new Thread(() -> {
            while (!AnimationStopper()) {
                currentStep++;

                double progress = TimerEquations.easeOut(getProgress());
                int moveX = (int) ((progress - previousProgress) * totalDx) / 2;
                int moveY = (int) ((progress - previousProgress) * totalDy) / 2;

                previousProgress = progress;

                SwingUtilities.invokeLater(() -> {
                    HexManager.pan(moveX, moveY);
                    Generator.getEngine().refresh();
                });

                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        animationThread.setDaemon(true); // dies with the app
        animationThread.start();
    }

    public static void SelectTheHexAnimation(Hex hex) {
        BoardAnimations anim = new BoardAnimations(hex);
        anim.StartAnimation();
    }
}