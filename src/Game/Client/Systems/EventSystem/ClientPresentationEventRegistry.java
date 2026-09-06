package Game.Client.Systems.EventSystem;

import Game.Client.Managers.AnimationManager;
import Game.Client.Presentation.DrawingState;
import Game.Client.Presentation.ViewState;
import Game.Client.Systems.DrawingSystem;
import Game.Client.Systems.EventSystem.Events.BorderSelectionChangedEvent;
import Game.Client.Systems.EventSystem.Events.HexSelectionChangedEvent;
import Game.Client.Systems.EventSystem.Events.MovementPreviewChangedEvent;
import Game.Client.Systems.EventSystem.Listeners.SelectListener;
import Game.Server.Systems.EventSystem.EventBus;
import Game.Server.Systems.EventSystem.Events.UnitSelectionChangedEvent;
import Game.World;

/** Wires presentation-only client input events; it owns no gameplay logic. */
public final class ClientPresentationEventRegistry {
    private ClientPresentationEventRegistry() { }

    public static SelectListener register(EventBus events, AnimationManager animations,
                                DrawingSystem drawing, DrawingState drawingState,
                                ViewState viewState, World world) {
        SelectListener selection = new SelectListener(animations, drawing.getExtraDrawer(),
                drawingState, viewState, world);
        events.subscribe(UnitSelectionChangedEvent.class,
                event -> selection.UnitSelected(event.getSelectedUnit()));
        events.subscribe(HexSelectionChangedEvent.class,
                event -> selection.HexSelected(event.getSelectedHex()));
        events.subscribe(BorderSelectionChangedEvent.class,
                event -> selection.BorderSelected(event.getBorder()));
        events.subscribe(MovementPreviewChangedEvent.class,
                event -> selection.likelyPath(event.getPath(), event.getGoalHex()));
        return selection;
    }
}
