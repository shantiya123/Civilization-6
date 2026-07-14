package Game.Systems;

import Game.Systems.EventSystem.BoardEvent;
import Game.Systems.EventSystem.EventSystem;
import Models.ConnectDrawing;
import Models.Manager.HexManager;

public class BoardSystem {
    private final BoardEvent boardEvent;

    private final HexManager hexManager;

    private final ConnectDrawing connectDrawing;

    public BoardSystem(BoardEvent boardEvent, HexManager hexManager, ConnectDrawing connectDrawing) {
        this.boardEvent = boardEvent;
        this.hexManager = hexManager;
        this.connectDrawing = connectDrawing;
    }


    public void zoom(int rotate) {
        boardEvent.Zoomed(rotate);
    }

    public void moveBoard(int x , int y) {
        hexManager.pan(x , y);
        boardEvent.MoveInBoard();
    }
    public void showTerritory(){
        connectDrawing.setShowBorder(!connectDrawing.isShowBorder());
        boardEvent.Refresh();
    }

}