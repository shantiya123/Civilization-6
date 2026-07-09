package Game.Systems;

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
            eventSystem.ExplorationFailed("No active Explorer selected.");
            return;
        }

        Explorer explorer = (Explorer) selectSystem.getSelectedUnit();
        ExplorerLogic logic = (ExplorerLogic) explorer.getLogic();

        try {
            logic.Explore();
            eventSystem.HexExplored(explorer.getHex());
        } catch (Exception e) {
            eventSystem.ExplorationFailed(e.getMessage());
        }
    }

    /**
     * Commands a BorderExpander unit to expand the empire borders.
     */
    public void expandBorder() {
        if (!(selectSystem.getSelectedUnit() instanceof BorderExpander)) {
            eventSystem.BorderExpansionFailed("No active BorderExpander selected.");
            return;
        }

        BorderExpander expander = (BorderExpander) selectSystem.getSelectedUnit();
        BorderExpanderLogic logic = (BorderExpanderLogic) expander.getLogic();

        try {
            logic.addToBorder();
            eventSystem.BorderExpanded(expander.getHex());
        } catch (Exception e) {
            eventSystem.BorderExpansionFailed(e.getMessage());
        }
    }
}