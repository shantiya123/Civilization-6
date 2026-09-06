package Game.Server.Systems.Network;

import Base.Network.Connection;
import Base.Network.ConnectionFactory;
import Game.Server.Systems.RequestSystem.ServerCommandExecutor;
import Game.Server.Lobby.LobbyService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/**
 * Accepts client connections and hands each one to a ClientWorker running
 * on the injected thread pool. This class does exactly one thing: turn
 * "a client connected" into "a worker is running for that client" -- it
 * never touches a Request or a controller itself.
 *
 * Every dependency is injected (port aside): the command executor that
 * dispatches on the authoritative game thread, the ExecutorService to run workers on, and the
 * ConnectionFactory to build the wire around each accepted Socket. None of
 * those are constructed here, so swapping the thread pool's sizing policy,
 * the wire format, or the dispatcher all happen at the call site, not by
 * editing this class (DIP/OCP).
 */
public class GameServer implements RequestListener {
    private final int port;
    private final ServerCommandExecutor commandExecutor;
    private final ExecutorService workerPool;
    private final ConnectionFactory connectionFactory;
    private final UpdateDispatcher updateDispatcher;
    private final SynchronizationSessionService sessions;
    private final LobbyService lobby;
    private final List<ClientWorker> activeWorkers = new CopyOnWriteArrayList<>();

    private ServerSocket serverSocket;
    private volatile boolean running;

    public GameServer(int port, ServerCommandExecutor commandExecutor,
                      ExecutorService workerPool, ConnectionFactory connectionFactory) {
        this(port, commandExecutor, new UpdateDispatcher(), workerPool, connectionFactory);
    }

    public GameServer(int port, ServerCommandExecutor commandExecutor, UpdateDispatcher updateDispatcher,
                      ExecutorService workerPool, ConnectionFactory connectionFactory) {
        this(port, commandExecutor, updateDispatcher, workerPool, connectionFactory, null);
    }
    public GameServer(int port, ServerCommandExecutor commandExecutor, UpdateDispatcher updateDispatcher,
                      ExecutorService workerPool, ConnectionFactory connectionFactory, SynchronizationSessionService sessions) {
        this.port = port;
        this.commandExecutor = commandExecutor;
        this.updateDispatcher = updateDispatcher;
        this.workerPool = workerPool;
        this.connectionFactory = connectionFactory;
        this.sessions = sessions;
        this.lobby = null;
    }

    public GameServer(int port, ServerCommandExecutor commandExecutor, UpdateDispatcher updateDispatcher,
                      ExecutorService workerPool, ConnectionFactory connectionFactory,
                      SynchronizationSessionService sessions, LobbyService lobby) {
        this.port = port;
        this.commandExecutor = commandExecutor;
        this.updateDispatcher = updateDispatcher;
        this.workerPool = workerPool;
        this.connectionFactory = connectionFactory;
        this.sessions = sessions;
        this.lobby = lobby;
    }

    /** Binds the listening socket before clients are allowed to connect. */
    public synchronized void open() throws IOException {
        if (serverSocket != null && !serverSocket.isClosed()) return;
        serverSocket = new ServerSocket(port);
        running = true;
    }

    @Override
    public void listen() throws IOException {
        open();

        while (running) {
            Socket socket;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                if (!running) break; // stop() closed the socket while we were blocked in accept()
                continue;
            }
            handle(socket);
        }
    }

    /** Turns one accepted Socket into a running ClientWorker on the pool. */
    private void handle(Socket socket) {
        try {
            Connection connection = connectionFactory.create(socket);
            updateDispatcher.register(connection);
            ClientWorker worker = new ClientWorker(connection, commandExecutor, () -> {
                updateDispatcher.unregister(connection);
                if (lobby != null) commandExecutor.enqueueTask(() -> lobby.disconnected(connection));
            }, message -> {
                if (message instanceof Base.Network.SynchronizationRequestMessage request && sessions != null)
                    commandExecutor.enqueueTask(() -> sessions.handle(connection, request));
                else if (lobby != null)
                    commandExecutor.enqueueTask(() -> lobby.handle(connection, message));
            });
            activeWorkers.add(worker);
            workerPool.submit(worker);
        } catch (IOException e) {
            closeQuietly(socket);
        }
    }

    @Override
    public void stop() throws IOException {
        running = false;
        for (ClientWorker worker : activeWorkers) {
            worker.stop();
        }
        activeWorkers.clear();
        if (serverSocket != null && !serverSocket.isClosed()) {
            serverSocket.close();
        }
    }

    private void closeQuietly(Socket socket) {
        try {
            socket.close();
        } catch (IOException ignored) {
        }
    }
}
