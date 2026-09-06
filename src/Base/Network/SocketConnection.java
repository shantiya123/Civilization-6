package Base.Network;

import Base.Request.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Connection backed by a plain TCP Socket, using Java object serialization
 * to frame each Request on the wire (Request is a flat Serializable value:
 * a few Strings and a Map<String,String>, so no custom codec is needed).
 *
 * The ObjectOutputStream is always constructed (and flushed) before the
 * ObjectInputStream on both ends -- ObjectInputStream's constructor blocks
 * reading the peer's stream header, so if both sides opened the input
 * stream first they'd deadlock waiting on each other.
 */
public class SocketConnection implements Connection {
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public SocketConnection(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.out.flush();
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public synchronized void send(Request request) throws IOException {
        sendWire(request);
    }
    @Override public synchronized void sendWire(WireMessage message) throws IOException {
        out.writeObject(message);
        out.flush();
        // Prevents ObjectOutputStream from caching every previously-sent
        // Request by reference, which would otherwise leak memory on a
        // long-lived, high-traffic connection.
        out.reset();
    }

    @Override
    public Request receive() throws IOException {
        WireMessage message = receiveWire();
        return message instanceof Request request ? request : null;
    }
    @Override public WireMessage receiveWire() throws IOException {
        try {
            Object received = in.readObject();
            return received instanceof WireMessage message ? message : null;
        } catch (ClassNotFoundException e) {
            throw new IOException("Received an unknown wire object", e);
        }
    }

    @Override
    public boolean isOpen() {
        return socket.isConnected() && !socket.isClosed();
    }

    @Override
    public void close() throws IOException {
        if (!socket.isClosed()) {
            socket.close();
        }
    }
}
