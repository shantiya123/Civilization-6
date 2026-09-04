package Game.Client.Views.UnitPanel;

import Models.Elements.Units.BorderExpander;
import Utils.ImageLoader;

import javax.swing.*;

public class BorderExpanderUnitPanel extends UnitPanel {

    private final BorderExpander borderExpander;

    public BorderExpanderUnitPanel(BorderExpander borderExpander, UnitPanelState state) {
        super("Border Expander", state);
        this.borderExpander = borderExpander;
        backgroundImage = ImageLoader.load("/Images/UnitBackground/5956229881702059521.jpg");
        JButton addToBorderButton = createThemedButton("Add To Border");
        addToBorderButton.addActionListener(e -> state.addToBorder());

        actionPanel.add(addToBorderButton);

        refresh();
    }

    public void refresh() {
        updateStats(borderExpander.getAP(), borderExpander.getFoodNeed());
    }
}