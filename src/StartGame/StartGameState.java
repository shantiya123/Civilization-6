package StartGame;

import Game.Generate;

import javax.swing.*;

public class StartGameState {
    private JFrame frameToClose;
    private final MusicSettings musicSettings;

    public StartGameState() {
        this.musicSettings = Generate.getGame().getMusicSettings();
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
        if (frameToClose != null) {
            frameToClose.dispose();
        }

        SwingUtilities.invokeLater(() -> Generate.getGame().start());
        if (musicSettings.isMusicOn())
            Generate.getGame().play();
    }

    public MusicSettings getMusicSettings() {
        return musicSettings;
    }
}