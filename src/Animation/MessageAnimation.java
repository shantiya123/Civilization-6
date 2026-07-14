package Animation;

import Game.Managers.AnimationManager;
import Models.Elements.Messages.Message;
import javax.swing.FocusManager;
import java.awt.Window;

public class MessageAnimation extends BaseAnimation {

    private final Message message;
    private final AnimationManager animationManager;
    private boolean isRunning;

    private static final int WIDTH = 380;
    private static final int HEIGHT = 60;

    public MessageAnimation(int totalSteps, Message message, AnimationManager animationManager) {
        super(totalSteps);
        this.message = message;
        this.animationManager = animationManager;
        this.isRunning = true;


        this.message.setActive(true);
    }

    @Override
    protected void onTick(double progress) {
        double phase1End = 0.15;
        double phase2End = 0.85;

        double localProgress;
        double eased;

        Window activeWindow = FocusManager.getCurrentManager().getActiveWindow();
        if (activeWindow == null) return;

        int screenWidth = activeWindow.getWidth();
        int screenHeight = activeWindow.getHeight();

        int startX = (screenWidth - WIDTH) / 2;
        int hiddenY = screenHeight + 20;
        int visibleY = screenHeight - HEIGHT - 80;

        message.setX(startX);

        if (progress < phase1End) {
            localProgress = progress / phase1End;
            eased = 1.0 - Math.pow(1.0 - localProgress, 3);
            message.setY((int) (hiddenY + (visibleY - hiddenY) * eased));
            message.setAlpha((float) localProgress);
        } else if (progress < phase2End) {
            message.setY(visibleY);
            message.setAlpha(1.0f);
        } else {
            localProgress = (progress - phase2End) / (1.0 - phase2End);
            eased = localProgress * localProgress * localProgress;
            message.setY((int) (visibleY + (hiddenY - visibleY) * eased));
            message.setAlpha((float) (1.0f - localProgress));
        }

        animationManager.refresh();
    }

    @Override
    protected void onComplete() {
        this.isRunning = false;
        this.message.setActive(false);
        animationManager.refresh();
    }

    public boolean isRunning() {
        return isRunning;
    }

    public Message getMessage() {
        return message;
    }
}