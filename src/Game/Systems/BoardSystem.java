package Game.Systems;

import Game.Systems.Listeners.BoardListener;
import Models.ConnectDrawing;
import Models.Manager.HexManager;

public class BoardSystem {
    private final BoardListener boardListener;

    private final HexManager hexManager;

    private final ConnectDrawing connectDrawing;

    public BoardSystem(BoardListener boardListener, HexManager hexManager, ConnectDrawing connectDrawing) {
        this.boardListener = boardListener;
        this.hexManager = hexManager;
        this.connectDrawing = connectDrawing;
    }


    public void zoom(int rotate) {
        boardListener.Zoomed(rotate);
    }

    public void moveBoard(int x , int y) {
        hexManager.pan(x , y);
        boardListener.MoveInBoard();
    }
    public void showTerritory(){
        connectDrawing.setShowBorder(!connectDrawing.isShowBorder());
        boardListener.Refresh();
    }

}