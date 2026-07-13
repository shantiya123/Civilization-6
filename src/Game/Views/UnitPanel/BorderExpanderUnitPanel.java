package Game.Views.UnitPanel;

import Game.Views.UnitPanel.UnitPanel;
import Game.Views.UnitPanel.UnitPanelState;
import Models.Elements.Units.BorderExpander;

import javax.swing.*;

public class BorderExpanderUnitPanel extends UnitPanel {

    private final BorderExpander borderExpander;

    public BorderExpanderUnitPanel(BorderExpander borderExpander, UnitPanelState state) {
        super("Border Expander", state);
        this.borderExpander = borderExpander;
        backgroundImage = new ImageIcon("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\UnitBackground\\5956229881702059521.jpg").getImage();
        JButton addToBorderButton = createThemedButton("Add To Border");
        addToBorderButton.addActionListener(e -> state.addToBorder());

        actionPanel.add(addToBorderButton);

        refresh();
    }

    public void refresh() {
        updateStats(borderExpander.getAP(), borderExpander.getFoodNeed());
    }
}