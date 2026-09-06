package Game.Server.Systems.Network;

import java.io.IOException;

/**
 * Something that accepts incoming client connections and keeps doing so
 * until told to stop. Kept separate from GameServer's concrete socket
 * details so the accept-loop contract stays swappable (OCP) and testable
 * in isolation from TCP.
 */
public interface RequestListener {
    /** Starts accepting connections. Blocks the calling thread until stop() is called. */
    void listen() throws IOException;

    /** Stops accepting new connections and releases the listening socket. */
    void stop() throws IOException;
}