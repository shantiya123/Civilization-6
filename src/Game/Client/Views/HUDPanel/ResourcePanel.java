package Game.Client.Views.HUDPanel;

import Models.Elements.Resources.Food;
import Models.Elements.Resources.Iron;
import Models.Elements.Resources.Resource;
import Models.Elements.Resources.Stone;
import Models.Elements.Resources.Wood;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class ResourcePanel extends JPanel {

    private final List<ResourceEntryComponent> entries = new ArrayList<>();
    private final HappinessEntryComponent happinessEntry;

    ResourcePanel(HUDState state) {
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.LEFT, 14, 0));

        addEntry(Food.class, state);
        addEntry(Wood.class, state);
        addEntry(Stone.class, state);
        addEntry(Iron.class, state);

        happinessEntry = new HappinessEntryComponent(state);
        add(happinessEntry);
    }

    private void addEntry(Class<? extends Resource> resourceClass, HUDState state) {
        ResourceEntryComponent entry = new ResourceEntryComponent(resourceClass, state);
        entries.add(entry);
        add(entry);
    }

    void refresh() {
        entries.forEach(ResourceEntryComponent::refresh);
        happinessEntry.refresh();
    }
}