package Base.Network;

import Base.Request.Request;

import java.io.IOException;


public interface Connection {

    void send(Request request) throws IOException;

    Request receive() throws IOException;

    /** Typed bidirectional extension; legacy Request methods remain compatible. */
    default void sendWire(WireMessage message) throws IOException {
        if (message instanceof Request request) send(request);
        else throw new IOException("Connection does not support this wire message");
    }
    default WireMessage receiveWire() throws IOException { return receive(); }

    boolean isOpen();

    void close() throws IOException;
}
