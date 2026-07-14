package StartGame;

import Game.Generate;
import javax.swing.*;

public class StartGameState {
    private boolean music;
    private JFrame frameToClose; // Reference to the menu frame

    public boolean isMusic() {
        return music;
    }

    public void toggleMusic() {
        music = !music;
    }

    public void setFrameToClose(JFrame frame) {
        this.frameToClose = frame;
    }

    public void startGame() {
        // Close the start frame instantly
        if (frameToClose != null) {
            frameToClose.dispose();
        }

        SwingUtilities.invokeLater(() -> Generate.getGame().start());
        if (music)
            Generate.getGame().play();
    }
}