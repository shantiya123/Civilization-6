package Game.Client.Drawers;

import Models.Elements.Messages.Message;
import java.awt.Graphics;

public class DrawMessages {
    private Message activeMessage;

    public void setActiveMessage(Message message) {
        this.activeMessage = message;
    }

    public void draw(Graphics g) {
        if (activeMessage != null && activeMessage.isActive()) {
            activeMessage.getDraw().draw(g);
        }
    }
}