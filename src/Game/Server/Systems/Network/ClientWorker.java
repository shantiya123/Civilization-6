package Game.Server.Systems.Network;

import Base.Network.Connection;
import Base.Request.Request;
import Base.Network.WireMessage;
import Base.Network.SynchronizationRequestMessage;
import java.util.function.Consumer;
import Game.Server.Systems.RequestSystem.ServerCommandExecutor;

import java.io.IOException;

/**
 * Owns one client's Connection for the lifetime of that connection.
 *
 * Runs on a thread pulled from GameServer's pool. Its whole job is: keep
 * reading Requests off the wire and enqueueing each one for the authoritative
 * game thread. The worker doesn't know or care what a
 * "TradeRequest" is, it just relays it (SRP: transport plumbing here,
 * request handling stays entirely in ServerController/the controllers).
 *
 * The read loop is what keeps the connection "live and open": receive()
 * blocks until either a Request arrives or the peer disconnects, so the
 * worker sits parked on the socket between messages instead of handling
 * one request and closing.
 */
public class ClientWorker implements Runnable {
    private final Connection connection;
    private final ServerCommandExecutor commandExecutor;
    private volatile boolean running = true;
    private final Runnable disconnected;
    private final Consumer<WireMessage> wireHandler;

    public ClientWorker(Connection connection, ServerCommandExecutor commandExecutor) {
        this(connection, commandExecutor, () -> {}, message -> {});
    }
    public ClientWorker(Connection connection, ServerCommandExecutor commandExecutor, Runnable disconnected) { this(connection,commandExecutor,disconnected,message->{}); }
    public ClientWorker(Connection connection, ServerCommandExecutor commandExecutor, Runnable disconnected, Consumer<WireMessage> wireHandler) {
        this.connection = connection;
        this.commandExecutor = commandExecutor;
        this.disconnected = disconnected;
        this.wireHandler=wireHandler;
    }

    @Override
    public void run() {
        handle();
    }

    /** Reads and queues Requests until the connection closes or stop() is called. */
    private void handle() {
        try {
            while (running && connection.isOpen()) {
                WireMessage message = connection.receiveWire();
                if (message == null) break;
                if (message instanceof Request request) commandExecutor.enqueue(request);
                else wireHandler.accept(message);
            }
        } catch (IOException e) {
            // Connection dropped mid-read -- nothing more to do for this client.
        } finally {
            disconnected.run();
            closeQuietly();
        }
    }

    /** Stops the read loop and closes the connection. Safe to call from another thread. */
    public void stop() {
        running = false;
        closeQuietly();
    }

    private void closeQuietly() {
        try {
            connection.close();
        } catch (IOException ignored) {
        }
    }
}
