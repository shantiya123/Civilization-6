package Game.Views;

import Game.Presentation.ViewState;
import Game.Views.UnitPanel.UnitPanel;
import Models.Elements.Units.Unit;

import javax.swing.JLayeredPane;

/** Keeps the unit panel synchronized with the currently selected unit. */
final class UnitPanelCoordinator {

    private final ViewState viewState;
    private final UnitPanelFactory unitPanelFactory;
    private final JLayeredPane layeredPane;
    private Unit lastSelectedUnit;
    private UnitPanel activeUnitPanel;

    UnitPanelCoordinator(ViewState viewState, UnitPanelFactory unitPanelFactory,
                         JLayeredPane layeredPane) {
        this.viewState = viewState;
        this.unitPanelFactory = unitPanelFactory;
        this.layeredPane = layeredPane;
    }

    void refresh(int width, int height) {
        Unit currentUnit = viewState.getSelectedUnit();

        if (currentUnit != lastSelectedUnit) {
            if (activeUnitPanel != null) {
                layeredPane.remove(activeUnitPanel);
                activeUnitPanel = null;
            }

            if (currentUnit != null) {
                activeUnitPanel = unitPanelFactory.create(currentUnit);

                if (activeUnitPanel != null) {
                    activeUnitPanel.setBounds(
                            width - UnitPanel.PANEL_WIDTH - 20,
                            height - UnitPanel.PANEL_HEIGHT - 60,
                            UnitPanel.PANEL_WIDTH,
                            UnitPanel.PANEL_HEIGHT
                    );
                    layeredPane.add(activeUnitPanel, JLayeredPane.PALETTE_LAYER);
                }
            }

            lastSelectedUnit = currentUnit;
            layeredPane.revalidate();
            layeredPane.repaint();
        } else if (activeUnitPanel != null) {
            activeUnitPanel.refresh();
        }
    }
}
