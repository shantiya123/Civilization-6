package Game.Server.Lobby;

import Base.Network.*;
import Game.Server.Systems.Network.UpdateDispatcher;
import Game.Server.Managers.TurnManager;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Authoritative pre-game room. All methods are deliberately invoked through
 * the server command executor, so the ordered map needs no broad locking.
 */
public final class LobbyService {
    private static final String DEFAULT_MAP = "Default";
    private static final DateTimeFormatter TIME = DateTimeFormatter.ofPattern("HH:mm");
    private final UpdateDispatcher dispatcher;
    private final Consumer<List<SpawnPlanner.Spawn>> gameStarter;
    private final TurnManager gameTurns;
    private final Map<Connection, Player> players = new LinkedHashMap<>();
    private String selectedMap = DEFAULT_MAP;
    private boolean started;

    public LobbyService(UpdateDispatcher dispatcher, Runnable gameStarter) {
        this(dispatcher, ignored -> gameStarter.run(), new TurnManager());
    }
    public LobbyService(UpdateDispatcher dispatcher, Consumer<List<SpawnPlanner.Spawn>> gameStarter) {
        this(dispatcher, gameStarter, new TurnManager());
    }
    public LobbyService(UpdateDispatcher dispatcher, Consumer<List<SpawnPlanner.Spawn>> gameStarter, TurnManager gameTurns) {
        this.dispatcher = dispatcher;
        this.gameStarter = gameStarter;
        this.gameTurns = gameTurns;
    }

    public void handle(Connection connection, WireMessage message) {
        if (message instanceof LobbyJoinMessage join) join(connection, join.playerName());
        else if (message instanceof LobbyReadyMessage ready) ready(connection, ready.ready());
        else if (message instanceof LobbyMapMessage map) selectMap(connection, map.mapName());
        else if (message instanceof LobbyStartMessage) start(connection);
        else if (message instanceof LobbyChatMessage chat) chat(connection, chat.text());
    }

    public void disconnected(Connection connection) {
        Player player = players.remove(connection);
        if (player == null) return;
        boolean roundCompleted = started && gameTurns.removePlayer(player.token);
        publish();
        if (started) {
            dispatcher.broadcast(new PlayerDisconnectedMessage(player.name));
            dispatcher.broadcast(new TurnStateMessage(gameTurns.getTurns(), gameTurns.getActivePlayerName()));
            // The server's normal turn-resolution systems are deliberately
            // not run from a socket worker. A skipped last turn is surfaced
            // here; the next authoritative action continues the new round.
            if (roundCompleted) dispatcher.broadcast(new LobbyChatMessage("Server", TIME.format(LocalTime.now()),
                    "Round advanced after " + player.name + " disconnected."));
        }
    }

    private void join(Connection connection, String requestedName) {
        if (started) { error(connection, "The game has already started."); return; }
        String name = requestedName == null ? "" : requestedName.trim();
        if (name.isEmpty()) { error(connection, "Choose a username before joining."); return; }
        if (players.values().stream().anyMatch(player -> player.name.equalsIgnoreCase(name))) {
            error(connection, "That username is already in the lobby."); return;
        }
        players.put(connection, new Player(name));
        dispatcher.send(connection, new PlayerSessionMessage(players.get(connection).token, name));
        publish();
    }

    private void ready(Connection connection, boolean ready) {
        Player player = players.get(connection);
        if (player == null || started) return;
        player.ready = ready;
        publish();
    }

    private void selectMap(Connection connection, String map) {
        if (!isHost(connection) || started) { error(connection, "Only the host can select the map."); return; }
        if (map == null || map.isBlank()) { error(connection, "Select a valid map."); return; }
        selectedMap = map.trim();
        // A changed map needs confirmation from everybody again.
        players.values().forEach(player -> player.ready = false);
        publish();
    }

    private void start(Connection connection) {
        if (!isHost(connection)) { error(connection, "Only the host can start the game."); return; }
        if (players.isEmpty() || players.values().stream().anyMatch(player -> !player.ready)) {
            error(connection, "Every connected player must be Ready before the game starts."); return;
        }
        started = true;
        // Calculate and retain the deterministic, evenly-spaced Town Hall
        // locations at the authoritative start boundary. The game bootstrap
        // consumes this same order when creating player worlds.
        List<SpawnPlanner.Spawn> starts = SpawnPlanner.fairStarts(players.size());
        int index = 0;
        for (Player player : players.values()) {
            player.spawn = starts.get(index++).forPlayer(player.token, player.name);
        }
        gameTurns.configurePlayers(players.values().stream().map(player -> player.token).toList(),
                players.values().stream().map(player -> player.name).toList());
        publish();
        // Pass the roster-bound starts, not the bare geometric list: the
        // player token/name is the ownership identity used by Starter.
        gameStarter.accept(players.values().stream().map(player -> player.spawn).toList());
        dispatcher.broadcast(new TurnStateMessage(gameTurns.getTurns(), gameTurns.getActivePlayerName()));
    }

    private void chat(Connection connection, String text) {
        Player player = players.get(connection);
        if (player == null || text == null || text.isBlank()) return;
        dispatcher.broadcast(new LobbyChatMessage(player.name, LocalTime.now().format(TIME), text.trim()));
    }

    private boolean isHost(Connection connection) { return !players.isEmpty() && players.keySet().iterator().next() == connection; }
    private void error(Connection c, String message) { dispatcher.send(c, new LobbyErrorMessage(message)); }
    private void publish() {
        String host = players.isEmpty() ? null : players.values().iterator().next().name;
        List<LobbyStateMessage.Player> view = players.values().stream()
                .map(player -> new LobbyStateMessage.Player(player.name, player.ready,
                        player.spawn == null ? null : player.spawn.q(), player.spawn == null ? null : player.spawn.r())).toList();
        dispatcher.broadcast(new LobbyStateMessage(view, host, selectedMap, started));
    }
    private static final class Player {
        private final String name; private final String token = java.util.UUID.randomUUID().toString(); private boolean ready; private SpawnPlanner.Spawn spawn;
        private Player(String name) { this.name = name; }
    }
}
