package Game.Systems;

import Game.Systems.EventSystem.BoardEvent;
import Game.Systems.EventSystem.EventSystem;

public class BoardSystem {
    private final BoardEvent boardEvent;

    public BoardSystem(BoardEvent boardEvent) {
        this.boardEvent = boardEvent;
    }


    public void zoom(int rotate) {
        boardEvent.Zoomed(rotate);
    }

    public void moveBoard() {
        // Will be filled out later
    }
}