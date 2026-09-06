package Game.Server.Lobby;

import Base.Network.*;
import Base.Request.Request;
import Game.Server.Systems.Network.UpdateDispatcher;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class LobbyServiceTest {
    @Test void onlyHostCanStartAndAllPlayersMustBeReady() {
        UpdateDispatcher dispatcher = new UpdateDispatcher(c -> new DirectExecutor());
        FakeConnection host = new FakeConnection(), player = new FakeConnection();
        dispatcher.register(host); dispatcher.register(player);
        boolean[] started = {false};
        LobbyService lobby = new LobbyService(dispatcher, () -> started[0] = true);

        lobby.handle(host, new LobbyJoinMessage("Host"));
        lobby.handle(player, new LobbyJoinMessage("Player"));
        lobby.handle(player, new LobbyStartMessage());
        assertFalse(started[0]);
        assertTrue(player.messages.stream().anyMatch(LobbyErrorMessage.class::isInstance));

        lobby.handle(host, new LobbyReadyMessage(true));
        lobby.handle(player, new LobbyReadyMessage(true));
        lobby.handle(host, new LobbyStartMessage());
        assertTrue(started[0]);
        assertTrue(host.latestState().started());
    }

    @Test void mapChangeResetsEveryReadyStateAndchatIsStampedByServer() {
        UpdateDispatcher dispatcher = new UpdateDispatcher(c -> new DirectExecutor());
        FakeConnection host = new FakeConnection(), player = new FakeConnection(); dispatcher.register(host); dispatcher.register(player);
        LobbyService lobby = new LobbyService(dispatcher, () -> {});
        lobby.handle(host, new LobbyJoinMessage("Host")); lobby.handle(player, new LobbyJoinMessage("Player"));
        lobby.handle(host, new LobbyReadyMessage(true)); lobby.handle(player, new LobbyReadyMessage(true));
        lobby.handle(host, new LobbyMapMessage("Map 2"));
        assertTrue(host.latestState().players().stream().noneMatch(LobbyStateMessage.Player::ready));
        lobby.handle(player, new LobbyChatMessage("forged", "00:00", "hello"));
        LobbyChatMessage message = (LobbyChatMessage) host.messages.get(host.messages.size() - 1);
        assertEquals("Player", message.sender()); assertEquals("hello", message.text()); assertNotNull(message.timestamp());
    }

    @Test void disconnectNotifiesRemainingPlayersAndSkipsTheActiveTurn() {
        UpdateDispatcher dispatcher = new UpdateDispatcher(c -> new DirectExecutor());
        FakeConnection host = new FakeConnection(), player = new FakeConnection();
        dispatcher.register(host); dispatcher.register(player);
        Game.Server.Managers.TurnManager turns = new Game.Server.Managers.TurnManager();
        LobbyService lobby = new LobbyService(dispatcher, ignored -> {}, turns);
        lobby.handle(host, new LobbyJoinMessage("Host"));
        lobby.handle(player, new LobbyJoinMessage("Player"));
        lobby.handle(host, new LobbyReadyMessage(true));
        lobby.handle(player, new LobbyReadyMessage(true));
        lobby.handle(host, new LobbyStartMessage());

        dispatcher.unregister(host);
        lobby.disconnected(host);

        assertTrue(player.messages.stream().anyMatch(PlayerDisconnectedMessage.class::isInstance));
        assertEquals("Player", turns.getActivePlayerName());
    }

    private static final class FakeConnection implements Connection {
        final List<WireMessage> messages = new ArrayList<>();
        public void send(Request request) {} public Request receive() { return null; }
        public void sendWire(WireMessage message) { messages.add(message); }
        public boolean isOpen() { return true; } public void close() {}
        LobbyStateMessage latestState() { for (int i=messages.size()-1;i>=0;i--) if(messages.get(i) instanceof LobbyStateMessage state) return state; throw new AssertionError("No lobby state"); }
    }
    private static final class DirectExecutor extends AbstractExecutorService {
        private boolean shutdown; public void shutdown(){shutdown=true;} public List<Runnable> shutdownNow(){shutdown=true;return List.of();}
        public boolean isShutdown(){return shutdown;} public boolean isTerminated(){return shutdown;} public boolean awaitTermination(long timeout, TimeUnit unit){return shutdown;}
        public void execute(Runnable command){if(!shutdown) command.run();}
    }
}
