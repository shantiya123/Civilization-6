package Game.Systems;

import Game.Systems.EventSystem.BoardEvent;
import Game.Systems.EventSystem.EventSystem;
import Models.Manager.HexManager;

public class BoardSystem {
    private final BoardEvent boardEvent;

    private final HexManager hexManager;

    public BoardSystem(BoardEvent boardEvent, HexManager hexManager) {
        this.boardEvent = boardEvent;
        this.hexManager = hexManager;
    }


    public void zoom(int rotate) {
        boardEvent.Zoomed(rotate);
    }

    public void moveBoard(int x , int y) {
        hexManager.pan(x , y);
        boardEvent.MoveInBoard();
    }
}