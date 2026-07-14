package Game.Views.HUDPanel;

import Models.Elements.Units.BorderExpander;
import Models.Elements.Units.Builder;
import Models.Elements.Units.Explorer;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class UnitRosterPanel extends JPanel {

    private final List<UnitRosterButton> buttons = new ArrayList<>();

    UnitRosterPanel(HUDState state) {
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0));

        addButton(Worker.class, state);
        addButton(Builder.class, state);
        addButton(Explorer.class, state);
        addButton(BorderExpander.class, state);
    }

    private void addButton(Class<? extends Unit> unitClass, HUDState state) {
        UnitRosterButton button = new UnitRosterButton(unitClass, state);
        buttons.add(button);
        add(button);
    }

    void refresh() {
        buttons.forEach(UnitRosterButton::refresh);
    }
}