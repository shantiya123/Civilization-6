import StartGame.StartGameEngine;
import StartGame.StartGameState;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartGameState state = new StartGameState();
            new StartGameEngine(state).show();
        });
    }
}