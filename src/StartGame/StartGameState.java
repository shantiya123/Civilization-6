package StartGame;

import Game.Generate;

import javax.swing.*;

public class StartGameState {
    private JFrame frameToClose;
    private final MusicSettings musicSettings = new MusicSettings();

    public StartGameState() {
    }

    public boolean isMusic() {
        return musicSettings.isMusicOn();
    }

    public void toggleMusic() {
        musicSettings.toggleMusic();
    }

    public void setFrameToClose(JFrame frame) {
        this.frameToClose = frame;
    }

    public void startGame() {
        // Kept for the existing start-screen button: gameplay may only begin
        // through the host-controlled lobby now.
        hostLobby();
    }

    /** Host a local authoritative server and enter its lobby. */
    public void hostLobby() {
        // Hosting is always a new multiplayer match, never the last saved
        // single-player world. Joining does not construct Game at all.
        Game.Game game = Generate.createFreshLobbyGame();
        if (frameToClose != null) frameToClose.dispose();
        SwingUtilities.invokeLater(() -> new LobbyFrame(game.getClientServerManager(), "Host").setVisible(true));
    }

    /** Join an existing host without constructing another local server. */
    public void joinLobby() {
        String host = JOptionPane.showInputDialog(frameToClose, "Host IP address:", "127.0.0.1");
        if (host == null || host.isBlank()) return;
        String name = JOptionPane.showInputDialog(frameToClose, "Your player name:", "Player");
        if (name == null || name.isBlank()) return;
        try {
            Game.Client.Managers.ClientServerManager connection = new Game.Client.Managers.ClientServerManager(
                    new Game.Client.Systems.Network.GameClientFactory().connect(host.trim(), 52491));
            if (frameToClose != null) frameToClose.dispose();
            new LobbyFrame(connection, name.trim()).setVisible(true);
        } catch (java.io.IOException exception) {
            JOptionPane.showMessageDialog(frameToClose, "Could not connect to " + host + ":52491", "Join failed", JOptionPane.ERROR_MESSAGE);
        }
    }


    public void startNewGame() {
        if (!Generate.getGame().startNewGame()) {
            return;
        }

        hostLobby();
    }

    public MusicSettings getMusicSettings() {
        return musicSettings;
    }
}
