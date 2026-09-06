package Base.Network;

import java.io.IOException;
import java.net.Socket;

public interface ConnectionFactory {
    Connection create(Socket socket) throws IOException;
}