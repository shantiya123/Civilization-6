package Game.Client.Systems;

import Animation.MessageAnimation;
import Game.Client.Managers.AnimationManager;
import Models.Elements.Messages.Message;

public class NotificationSystem {

    private final DrawingSystem drawingSystem;
    private final AnimationManager animationManager;

    public NotificationSystem(DrawingSystem drawingSystem, AnimationManager animationManager) {
        this.drawingSystem = drawingSystem;
        this.animationManager = animationManager;
    }

    public void showNotification(String text) {
        if (text == null || text.trim().isEmpty()) {
            return;
        }

        Message message = new Message(text);

        if (drawingSystem.getDrawMessages() != null) {
            drawingSystem.getDrawMessages().setActiveMessage(message);
        }

        MessageAnimation animation = new MessageAnimation(80, message, animationManager);

        animationManager.play(animation);
    }
}