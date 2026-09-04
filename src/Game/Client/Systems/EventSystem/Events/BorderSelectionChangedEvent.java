package Game.Client.Systems.EventSystem.Events;

import Game.Server.Systems.EventSystem.Events.Event;
import Models.Elements.Borders.Border;

public class BorderSelectionChangedEvent implements Event {
    private final Border border;

    public BorderSelectionChangedEvent(Border border) {
        this.border = border;
    }

    public Border getBorder() {
        return border;
    }
}
