package Base.Network;

import java.io.IOException;
import java.net.Socket;


public class SocketConnectionFactory implements ConnectionFactory {
    @Override
    public Connection create(Socket socket) throws IOException {
        return new SocketConnection(socket);
    }
}