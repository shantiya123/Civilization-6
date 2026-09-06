package Game.Client.Controllers;

import Base.Network.LobbyChatMessage;
import Game.Client.Managers.ClientServerManager;

/** Sends player-authored chat lines; the server supplies sender and time. */
public final class ChatController {
    private final ClientServerManager connection;

    public ChatController(ClientServerManager connection) {
        this.connection = connection;
    }

    public void send(String text) {
        if (text == null || text.isBlank()) return;
        connection.sendMessage(new LobbyChatMessage(null, null, text.trim()));
    }
}
