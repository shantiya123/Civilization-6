package Game.Systems.ElementSystem;

import Game.Systems.EventSystem.EventSystem;
import Game.Systems.SelectSystem;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.BorderExpander;
import Models.Logic.UnitLogic.ExplorerLogic;
import Models.Logic.UnitLogic.BorderExpanderLogic;

public class ExplorationSystem {
    private final SelectSystem selectSystem;
    private final EventSystem eventSystem;

    public ExplorationSystem(SelectSystem selectSystem, EventSystem eventSystem) {
        this.selectSystem = selectSystem;
        this.eventSystem = eventSystem;
    }

    /**
     * Commands an Explorer unit to discover neighboring tiles.
     */
    public void exploreSurroundings() {
        if (!(selectSystem.getSelectedUnit() instanceof Explorer)) {
            eventSystem.getExplorEvent().ExplorationFailed("No active Explorer selected.");
            return;
        }

        Explorer explorer = (Explorer) selectSystem.getSelectedUnit();
        ExplorerLogic logic = (ExplorerLogic) explorer.getLogic();

        try {
            logic.Explore();
            eventSystem.getExplorEvent().HexExplored(explorer.getHex());
        } catch (Exception e) {
            eventSystem.getExplorEvent().ExplorationFailed(e.getMessage());
        }
    }

    /**
     * Commands a BorderExpander unit to expand the empire borders.
     */
    public void expandBorder() {
        if (!(selectSystem.getSelectedUnit() instanceof BorderExpander)) {
            eventSystem.getBoardExpandEvent().BorderExpansionFailed("No active BorderExpander selected.");
            return;
        }

        BorderExpander expander = (BorderExpander) selectSystem.getSelectedUnit();
        BorderExpanderLogic logic = (BorderExpanderLogic) expander.getLogic();

        try {
            logic.addToBorder();
            eventSystem.getBoardExpandEvent().BorderExpanded(expander.getHex());
        } catch (Exception e) {
            eventSystem.getBoardExpandEvent().BorderExpansionFailed(e.getMessage());
        }
    }
}