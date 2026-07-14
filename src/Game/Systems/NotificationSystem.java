package Game.Systems;

import Animation.MessageAnimation;
import Game.Managers.AnimationManager;
import Models.Elements.Messages.Message;

/**
 * A dedicated service class to handle the lifecycle and presentation
 * of on-screen animated notifications.
 */
public class NotificationSystem {

    private final DrawingSystem drawingSystem;
    private final AnimationManager animationManager;

    /**
     * Instantiates the NotificationSystem with the central engine requirements.
     *
     * @param drawingSystem    The drawing system where the message drawer is registered.
     * @param animationManager The animation manager responsible for stepping UI animations.
     */
    public NotificationSystem(DrawingSystem drawingSystem, AnimationManager animationManager) {
        this.drawingSystem = drawingSystem;
        this.animationManager = animationManager;
    }

    /**
     * Triggers a stylized notification toast that slides up from the bottom,
     * hovers in place, and slides back down.
     *
     * @param text The message string to display to the player.
     */
    public void showNotification(String text) {
        if (text == null || text.trim().isEmpty()) {
            return;
        }

        // 1. Instantiate the Message model with your text
        Message message = new Message(text);

        // 2. Register it as the active message inside the DrawingSystem's drawer
        if (drawingSystem.getDrawMessages() != null) {
            drawingSystem.getDrawMessages().setActiveMessage(message);
        }

        // 3. Create the animation sequence
        // 250 steps @ ~16ms/tick translates to roughly 4 seconds total runtime
        // (approx. 0.6s slide up, 2.8s stationary hover, 0.6s slide down).
        MessageAnimation animation = new MessageAnimation(62, message, animationManager);

        // 4. Play the animation using the centralized loop timer
        animationManager.play(animation);
    }
}