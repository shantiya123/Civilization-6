package Game.Systems.ElementSystem;

import Game.Systems.Listeners.ListenerSystem;
import Game.Systems.SelectSystem;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.BorderExpander;
import Models.Logic.UnitLogic.ExplorerLogic;
import Models.Logic.UnitLogic.BorderExpanderLogic;

public class ExplorationSystem {
    private final SelectSystem selectSystem;
    private final ListenerSystem listenerSystem;

    public ExplorationSystem(SelectSystem selectSystem, ListenerSystem listenerSystem) {
        this.selectSystem = selectSystem;
        this.listenerSystem = listenerSystem;
    }


    public void exploreSurroundings() {

        if (!(selectSystem.getSelectedUnit() instanceof Explorer)) {

            listenerSystem.getNotificationSystem().showNotification("No active Explorer selected.");
            return;
        }

        Explorer explorer = (Explorer) selectSystem.getSelectedUnit();
        ExplorerLogic logic = (ExplorerLogic) explorer.getLogic();

        try {
            logic.Explore();
            listenerSystem.getExplorEvent().HexExplored(explorer.getHex());
        } catch (Exception e) {
            listenerSystem.getNotificationSystem().showNotification(e.getMessage());
        }
    }
    public void expandBorder() {
        if (!(selectSystem.getSelectedUnit() instanceof BorderExpander)) {
            listenerSystem.getNotificationSystem().showNotification("No active BorderExpander selected.");
            return;
        }

        BorderExpander expander = (BorderExpander) selectSystem.getSelectedUnit();
        BorderExpanderLogic logic = (BorderExpanderLogic) expander.getLogic();

        try {
            logic.addToBorder();
            listenerSystem.getBoardExpandListener().BorderExpanded(expander.getHex());
        } catch (Exception e) {
            listenerSystem.getNotificationSystem().showNotification(e.getMessage());
        }
    }
}