package Game.Server.Systems.ElementSystem;

import Game.Server.Systems.EventSystem.EventBus;
import Game.Server.Systems.EventSystem.Events.BorderExpandedEvent;
import Game.Server.Systems.EventSystem.Events.HexExploredEvent;
import Game.Client.Systems.EventSystem.Events.NotificationRequestedEvent;
import Game.Client.Systems.SelectSystem;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.BorderExpander;
import Models.Logic.UnitLogic.ExplorerLogic;
import Models.Logic.UnitLogic.BorderExpanderLogic;

public class ExplorationSystem {
    private final SelectSystem selectSystem;
    private final EventBus eventBus;

    public ExplorationSystem(SelectSystem selectSystem, EventBus eventBus) {
        this.selectSystem = selectSystem;
        this.eventBus = eventBus;
    }


    public void exploreSurroundings() {

        if (!(selectSystem.getSelectedUnit() instanceof Explorer)) {

            eventBus.publish(new NotificationRequestedEvent("No active Explorer selected."));
            return;
        }

        Explorer explorer = (Explorer) selectSystem.getSelectedUnit();
        ExplorerLogic logic = (ExplorerLogic) explorer.getLogic();

        try {
            logic.Explore();
            eventBus.publish(new HexExploredEvent(explorer, explorer.getHex()));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }
    public void expandBorder() {
        if (!(selectSystem.getSelectedUnit() instanceof BorderExpander)) {
            eventBus.publish(new NotificationRequestedEvent("No active BorderExpander selected."));
            return;
        }

        BorderExpander expander = (BorderExpander) selectSystem.getSelectedUnit();
        BorderExpanderLogic logic = (BorderExpanderLogic) expander.getLogic();

        try {
            logic.addToBorder();
            eventBus.publish(new BorderExpandedEvent(expander, expander.getHex()));
        } catch (Exception e) {
            eventBus.publish(new NotificationRequestedEvent(e.getMessage()));
        }
    }
}
