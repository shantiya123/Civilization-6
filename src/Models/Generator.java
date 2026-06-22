package Models;

import BoardGame.BoardEngine;

public class Generator {
    private static BoardEngine engine;

    public Generator() {
        engine = new BoardEngine();
    }

    public static BoardEngine getEngine() {
        return engine;
    }
}
