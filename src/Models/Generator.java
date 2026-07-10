package Models;

import Game.Views.GameEngine;

public class Generator {
    private static GameEngine engine;

    public Generator() {
//        engine = new GameEngine();
    }

    public static GameEngine getEngine() {
        return engine;
    }
}
