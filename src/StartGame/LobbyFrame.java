package StartGame;

import Base.Network.*;
import Game.Client.Managers.ClientServerManager;
import Game.Client.Managers.ClientGameLauncher;
import Game.Client.Managers.ClientGameSession;
import Game.Client.Synchronization.ClientSynchronizationService;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/** Client-only pre-game room. The server remains the owner of all lobby state. */
public final class LobbyFrame extends JFrame {
    private final ClientServerManager connection;
    private final String playerName;
    private final DefaultListModel<String> players = new DefaultListModel<>();
    private final JList<String> playerList = new JList<>(players);
    private final JButton ready = new JButton("Ready");
    private final JButton start = new JButton("Start Game");
    private final JComboBox<String> maps = new JComboBox<>(new String[]{"Default", "Map 1", "Map 2", "Map 3"});
    private final JTextArea chat = new JTextArea();
    private boolean isReady;
    private boolean host;
    /** Prevent programmatic state rendering from re-sending map-selection requests. */
    private boolean applyingServerState;
    private final ClientSynchronizationService synchronization = new ClientSynchronizationService(null);
    private boolean gameOpened;
    private ClientGameSession gameSession;
    /** Snapshot waits for the private lobby token before building controllers. */
    private SnapshotMessage pendingSnapshot;

    public LobbyFrame(ClientServerManager connection, String playerName) {
        super("Civilization VI — Lobby");
        this.connection = connection;
        this.playerName = playerName;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(720, 460);
        setLocationByPlatform(true);
        build();
        connection.receiveMessages(this::received);
        send(new LobbyJoinMessage(playerName));
    }

    private void build() {
        JPanel root = new JPanel(new BorderLayout(12, 12)); root.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        root.add(new JScrollPane(playerList), BorderLayout.WEST);
        playerList.setPreferredSize(new Dimension(220, 0));
        chat.setEditable(false); root.add(new JScrollPane(chat), BorderLayout.CENTER);
        JPanel controls = new JPanel(new GridLayout(0, 1, 6, 6));
        controls.add(new JLabel("Map")); controls.add(maps); controls.add(ready); controls.add(start);
        JTextField text = new JTextField(); JButton send = new JButton("Send chat");
        controls.add(text); controls.add(send); root.add(controls, BorderLayout.EAST);
        ready.addActionListener(e -> { isReady = !isReady; send(new LobbyReadyMessage(isReady)); });
        maps.addActionListener(e -> {
            if (host && !applyingServerState) send(new LobbyMapMessage((String) maps.getSelectedItem()));
        });
        start.addActionListener(e -> send(new LobbyStartMessage()));
        send.addActionListener(e -> { send(new LobbyChatMessage(null, null, text.getText())); text.setText(""); });
        start.setEnabled(false); maps.setEnabled(false);
        setContentPane(root);
    }

    private void received(WireMessage message) {
        // JSON reconstruction can involve hundreds of map objects. Never run
        // it on Swing's EDT or the freshly opened board cannot pan/zoom.
        if (message instanceof SnapshotMessage snapshot) {
            // A PlayerSessionMessage and snapshot are ordered on the socket,
            // but their Swing/background hand-off used to race. Starting the
            // board without its token makes every owned-unit selection look
            // like another player's unit.
            SwingUtilities.invokeLater(() -> {
                pendingSnapshot = snapshot;
                openPendingGame();
            });
            return;
        }
        SwingUtilities.invokeLater(() -> {
            if (message instanceof LobbyStateMessage state) update(state);
            else if (message instanceof PlayerSessionMessage session) {
                connection.setSessionToken(session.token());
                openPendingGame();
            }
            else if (message instanceof TurnStateMessage turn && gameSession != null) gameSession.updateTurn(turn.round(), turn.activePlayer());
            else if (message instanceof CommitMessage commit
                    && synchronization.applyCommit(commit.commit()) == Game.Client.Synchronization.ApplyResult.APPLIED
                    && gameSession != null) {
                gameSession.replaceReplica(synchronization.getClientWorld().getWorld());
            }
            else if (message instanceof ClientCommand command && gameSession != null) {
                gameSession.dispatch(command);
            }
            else if (message instanceof LobbyChatMessage line) chat.append("[" + line.timestamp() + "] " + line.sender() + ": " + line.text() + "\n");
            else if (message instanceof LobbyErrorMessage error) JOptionPane.showMessageDialog(this, error.message(), "Lobby", JOptionPane.WARNING_MESSAGE);
        });
    }
    private void openPendingGame() {
        if (gameOpened || pendingSnapshot == null || connection.getSessionToken() == null) return;
        SnapshotMessage snapshot = pendingSnapshot;
        pendingSnapshot = null;
        openGameInBackground(snapshot);
    }
    private void openGameInBackground(SnapshotMessage snapshot) {
        if (gameOpened) return;
        Thread decoder = new Thread(() -> {
            if (synchronization.applySnapshot(snapshot.snapshot()) != Game.Client.Synchronization.ApplyResult.APPLIED) return;
            SwingUtilities.invokeLater(() -> {
                if (gameOpened) return;
                gameOpened = true;
                dispose();
                gameSession = ClientGameLauncher.show(connection, synchronization.getClientWorld().getWorld());
            });
        }, "Lobby-Snapshot-Decoder");
        decoder.setDaemon(true);
        decoder.start();
    }

    private void update(LobbyStateMessage state) {
        applyingServerState = true;
        try {
            players.clear();
            for (LobbyStateMessage.Player player : state.players()) {
                String spawn = player.townHallQ() == null ? "" : " — Town Hall: (" + player.townHallQ() + ", " + player.townHallR() + ")";
                players.addElement(player.name() + (player.ready() ? " — Ready" : " — Not ready") + spawn);
                if (player.name().equals(playerName)) isReady = player.ready();
            }
            host = playerName.equals(state.hostName()); start.setEnabled(host && !state.started()); maps.setEnabled(host && !state.started());
            maps.setSelectedItem(state.selectedMap());
            ready.setEnabled(!state.started()); ready.setText(isReady ? "Not Ready" : "Ready");
            if (state.started()) { chat.append("Game is starting…\n"); ready.setEnabled(false); start.setEnabled(false); }
        } finally {
            applyingServerState = false;
        }
    }
    private void send(WireMessage message) { try { connection.sendWire(message); } catch (IOException e) { JOptionPane.showMessageDialog(this, "Lost connection to the lobby.", "Lobby", JOptionPane.ERROR_MESSAGE); } }
}
