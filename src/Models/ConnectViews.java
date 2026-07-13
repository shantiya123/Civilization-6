package Models;

import Game.Views.UnitPanel.BorderExpanderUnitPanel;
import Game.Views.UnitPanel.BuilderUnitPanel;
import Game.Views.UnitPanel.ExplorerUnitPanel;
import Game.Views.UnitPanel.WorkerUnitPanel;
import Models.Elements.Units.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ConnectViews {
    private Map<Class<? extends Unit> , Class<? extends JPanel>> relatedPanel;
    private Class<? extends Unit> selectedUnitClass;
    private Unit selectedUnit;
    public ConnectViews() {
        relatedPanel = new HashMap<>();
        relatedPanel.put( Worker.class, WorkerUnitPanel.class );
        relatedPanel.put(Explorer.class , ExplorerUnitPanel.class);
        relatedPanel.put(BorderExpander.class , BorderExpanderUnitPanel.class);
        relatedPanel.put(Builder.class , BuilderUnitPanel.class);
    }

    public Map<Class<? extends Unit>, Class<? extends JPanel>> getRelatedPanel() {
        return relatedPanel;
    }

    public Class<? extends Unit> getSelectedUnitClass() {
        return selectedUnitClass;
    }

    public void setSelectedUnitClass(Class<? extends Unit> selectedUnitClass) {
        this.selectedUnitClass = selectedUnitClass;
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public void setSelectedUnit(Unit selectedUnit) {
        this.selectedUnit = selectedUnit;
    }
}
