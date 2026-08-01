package Game.Systems;

import Game.Systems.EventSystem.EventBus;
import Game.Systems.EventSystem.Events.BoardPannedEvent;
import Game.Systems.EventSystem.Events.BoardZoomChangedEvent;
import Game.Systems.EventSystem.Events.TerritoryDisplayChangedEvent;
import Models.ConnectDrawing;
import Models.Manager.HexManager;

public class BoardSystem {
    private final EventBus eventBus;

    private final HexManager hexManager;

    private final ConnectDrawing connectDrawing;

    public BoardSystem(EventBus eventBus, HexManager hexManager, ConnectDrawing connectDrawing) {
        this.eventBus = eventBus;
        this.hexManager = hexManager;
        this.connectDrawing = connectDrawing;
    }


    public void zoom(int rotate) {
        eventBus.publish(new BoardZoomChangedEvent(rotate));
    }

    public void moveBoard(int x , int y) {
        hexManager.pan(x , y);
        eventBus.publish(new BoardPannedEvent(x, y));
    }
    public void showTerritory(){
        connectDrawing.setShowBorder(!connectDrawing.isShowBorder());
        eventBus.publish(new TerritoryDisplayChangedEvent(connectDrawing.isShowBorder()));
    }

}
