package Models;

import Game.Views.GameEngine;

public class Generator {
    private static GameEngine engine;

    public Generator() {
    }

    public static GameEngine getEngine() {
        return engine;
    }
}
