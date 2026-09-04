package Game.Client.Presentation;

import Game.Client.Views.UnitPanel.ArcherUnitPanel;
import Game.Client.Views.UnitPanel.BorderExpanderUnitPanel;
import Game.Client.Views.UnitPanel.BuilderUnitPanel;
import Game.Client.Views.UnitPanel.CavalryUnitPanel;
import Game.Client.Views.UnitPanel.ExplorerUnitPanel;
import Game.Client.Views.UnitPanel.SwordsmanUnitPanel;
import Game.Client.Views.UnitPanel.WorkerUnitPanel;
import Models.Elements.Units.BorderExpander;
import Models.Elements.Units.Builder;
import Models.Elements.Units.CombatUnits.Archer;
import Models.Elements.Units.CombatUnits.Cavalry;
import Models.Elements.Units.CombatUnits.Swordsman;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;

import javax.swing.JPanel;
import java.util.HashMap;
import java.util.Map;

public class UnitPanelRegistry {
    private final Map<Class<? extends Unit>, Class<? extends JPanel>> panelByUnitClass = new HashMap<>();

    public UnitPanelRegistry() {
        panelByUnitClass.put(Worker.class, WorkerUnitPanel.class);
        panelByUnitClass.put(Explorer.class, ExplorerUnitPanel.class);
        panelByUnitClass.put(BorderExpander.class, BorderExpanderUnitPanel.class);
        panelByUnitClass.put(Builder.class, BuilderUnitPanel.class);
        panelByUnitClass.put(Swordsman.class, SwordsmanUnitPanel.class);
        panelByUnitClass.put(Archer.class, ArcherUnitPanel.class);
        panelByUnitClass.put(Cavalry.class, CavalryUnitPanel.class);
    }

    public Class<? extends JPanel> getPanelClass(Class<? extends Unit> unitClass) {
        return panelByUnitClass.get(unitClass);
    }

    public void register(Class<? extends Unit> unitClass, Class<? extends JPanel> panelClass) {
        panelByUnitClass.put(unitClass, panelClass);
    }
}