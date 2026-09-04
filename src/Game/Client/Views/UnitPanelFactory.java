package Game.Client.Views;

import Game.Client.Controllers.UnitPanelController;
import Game.Client.Presentation.UnitPanelRegistry;
import Game.Client.Views.UnitPanel.UnitPanel;
import Game.Client.Views.UnitPanel.UnitPanelState;
import Models.Elements.Units.Unit;

import javax.swing.JPanel;
import java.lang.reflect.Constructor;

/** Creates the unit-specific panel registered for a unit type. */
final class UnitPanelFactory {

    private final UnitPanelRegistry unitPanelRegistry;
    private final UnitPanelController unitPanelController;

    UnitPanelFactory(UnitPanelRegistry unitPanelRegistry, UnitPanelController unitPanelController) {
        this.unitPanelRegistry = unitPanelRegistry;
        this.unitPanelController = unitPanelController;
    }

    UnitPanel create(Unit unit) {
        Class<? extends JPanel> panelClass = unitPanelRegistry.getPanelClass(unit.getClass());
        if (panelClass == null) {
            System.err.println("GameEngine: no UnitPanel registered for "
                    + unit.getClass().getSimpleName());
            return null;
        }

        try {
            Constructor<? extends JPanel> constructor =
                    panelClass.getConstructor(unit.getClass(), UnitPanelState.class);
            UnitPanelState state = new UnitPanelState(unitPanelController);
            return (UnitPanel) constructor.newInstance(unit, state);
        } catch (ReflectiveOperationException exception) {
            throw new RuntimeException(
                    "GameEngine: failed to build " + panelClass.getSimpleName()
                            + " for " + unit.getClass().getSimpleName(), exception);
        }
    }
}
