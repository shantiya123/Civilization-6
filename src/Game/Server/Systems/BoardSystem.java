package Game.Server.Systems;

import Game.Client.Systems.EventSystem.Events.BoardZoomChangedEvent;
import Game.Server.Systems.EventSystem.EventBus;
import Game.Client.Systems.EventSystem.Events.BoardPannedEvent;
import Game.Client.Systems.EventSystem.Events.TerritoryDisplayChangedEvent;
import Game.Client.Presentation.DrawingState;
import Models.Manager.HexManager;

public class BoardSystem {
    private final EventBus eventBus;

    private final HexManager hexManager;

    private final DrawingState drawingState;

    public BoardSystem(EventBus eventBus, HexManager hexManager, DrawingState drawingState) {
        this.eventBus = eventBus;
        this.hexManager = hexManager;
        this.drawingState = drawingState;
    }


    public void zoom(int rotate) {
        eventBus.publish(new BoardZoomChangedEvent(rotate));
    }

    public void moveBoard(int x , int y) {
        hexManager.pan(x , y);
        eventBus.publish(new BoardPannedEvent(x, y));
    }
    public void showTerritory(){
        drawingState.setShowBorder(!drawingState.isShowBorder());
        eventBus.publish(new TerritoryDisplayChangedEvent(drawingState.isShowBorder()));
    }

}
