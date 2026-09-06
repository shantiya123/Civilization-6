package Game.Client.Managers;

import Base.Request.Request;
import Base.Network.CommitMessage;
import Base.Network.SnapshotMessage;
import Base.Network.SynchronizationRequestMessage;
import Game.Client.Synchronization.ClientSynchronizationService;
import Game.Client.Systems.Network.GameClient;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientServerManager {
    private final GameClient gameClient;
    private volatile String sessionToken;
    private final ExecutorService sender = Executors.newSingleThreadExecutor(runnable -> {
        Thread thread = new Thread(runnable, "GameClient-Sender");
        thread.setDaemon(true);
        return thread;
    });

    public ClientServerManager(GameClient gameClient) {
        this.gameClient = gameClient;
    }
    /** Optional Task 4 wiring; no rendering bootstrap is coupled to it yet. */
    public boolean receiveCommits(ClientSynchronizationService synchronization) {
        return gameClient.receiveLoop(message -> {
            if (message instanceof CommitMessage commit) synchronization.applyCommit(commit.commit());
            if (message instanceof SnapshotMessage snapshot) { sessionToken=snapshot.token(); synchronization.applySnapshot(snapshot.snapshot()); }
        });
    }
    /** Starts the sole inbound reader for non-gameplay screens such as the lobby. */
    public boolean receiveMessages(java.util.function.Consumer<Base.Network.WireMessage> receiver) {
        return gameClient.receiveLoop(receiver);
    }
    /** Starts receive ownership then asks for initial/reconnect synchronization. */
    public void synchronize(ClientSynchronizationService synchronization) {
        receiveCommits(synchronization);
        sender.execute(() -> { try { gameClient.sendWire(new SynchronizationRequestMessage(sessionToken, synchronization.getLastAppliedCommit())); } catch (IOException ignored) {} });
    }
    public String getSessionToken() { return sessionToken; }
    public void setSessionToken(String token) { this.sessionToken = token; }

    /** Used by the lobby before gameplay synchronization begins. */
    public void sendWire(Base.Network.WireMessage message) throws IOException {
        gameClient.sendWire(message);
    }

    public void sendRequest(Request request) {
        sender.execute(() -> {
            try {
                if (request.getToken() == null) request.withToken(sessionToken);
                gameClient.send(request);
            } catch (IOException e) {
                throw new IllegalStateException(
                        "Failed to send " + request.getType() + " to server", e);
            }
        });
    }

    public boolean isConnected() {
        return gameClient.isConnected();
    }

    public void disconnect() {
        sender.shutdownNow();
        try {
            gameClient.disconnect();
        } catch (IOException ignored) {
        }
    }
}
