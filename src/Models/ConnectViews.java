package Models;

import Game.Views.UnitPanel.BorderExpanderUnitPanel;
import Game.Views.UnitPanel.BuilderUnitPanel;
import Game.Views.UnitPanel.ExplorerUnitPanel;
import Game.Views.UnitPanel.WorkerUnitPanel;
import Models.Elements.Buildings.TownHall;
import Models.Elements.Hex.Hex;
import Models.Elements.Units.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ConnectViews {
    private Map<Class<? extends Unit> , Class<? extends JPanel>> relatedPanel;
    private Class<? extends Unit> selectedUnitClass;
    private Unit selectedUnit;
    private Hex selectedHex;
    private boolean starvation;
    private TownHall townHall;

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

    public boolean isStarvation() {
        return starvation;
    }

    public void setRelatedPanel(Map<Class<? extends Unit>, Class<? extends JPanel>> relatedPanel) {
        this.relatedPanel = relatedPanel;
    }

    public void setStarvation(boolean starvation) {
        this.starvation = starvation;
    }

    public Hex getSelectedHex() {
        return selectedHex;
    }

    public void setSelectedHex(Hex selectedHex) {
        this.selectedHex = selectedHex;
    }

    public TownHall getTownHall() {
        return townHall;
    }

    public void setTownHall(TownHall townHall) {
        this.townHall = townHall;
    }
}
