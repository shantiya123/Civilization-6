package Game.Systems.EventSystem.Events;

import Models.Elements.Borders.Border;

public class BorderSelectionChangedEvent implements Event{
    private final Border border;

    public BorderSelectionChangedEvent(Border border) {
        this.border = border;
    }

    public Border getBorder() {
        return border;
    }
}
