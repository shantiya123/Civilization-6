package Models;

import Game.Client.Views.GameEngine;

public class Generator {
    private static GameEngine engine;

    public Generator() {
    }

    public static GameEngine getEngine() {
        return engine;
    }
}
