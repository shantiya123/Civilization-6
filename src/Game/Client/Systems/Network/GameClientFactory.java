package Game.Client.Systems.Network;

import Base.Network.Connection;
import Base.Network.ConnectionFactory;
import Base.Network.SocketConnectionFactory;

import java.io.IOException;
import java.net.Socket;

/**
 * Opens a Socket to a GameServer and wraps it into a connected GameClient.
 * Kept separate from GameClient itself so GameClient never has to know how
 * its Connection came to exist (mirrors GameServer taking a
 * ConnectionFactory instead of constructing SocketConnection inline).
 */
public final class GameClientFactory {
    private final ConnectionFactory connectionFactory;

    public GameClientFactory() {
        this(new SocketConnectionFactory());
    }

    public GameClientFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public GameClient connect(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        Connection connection = connectionFactory.create(socket);
        return new GameClient(connection);
    }
}