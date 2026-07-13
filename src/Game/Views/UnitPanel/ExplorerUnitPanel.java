package Game.Views.UnitPanel;

import Game.Views.UnitPanel.UnitPanel;
import Game.Views.UnitPanel.UnitPanelState;
import Models.Elements.Units.Explorer;

import javax.swing.*;

public class ExplorerUnitPanel extends UnitPanel {

    private final Explorer explorer;

    public ExplorerUnitPanel(Explorer explorer, UnitPanelState state) {
        super("Explorer", state);
        this.explorer = explorer;
        backgroundImage = new ImageIcon("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\UnitBackground\\ChatGPT Image Jul 13, 2026, 05_42_04 PM.png").getImage();
        JButton exploreButton = createThemedButton("Explore");
        exploreButton.addActionListener(e -> state.explore());

        actionPanel.add(exploreButton);

        refresh();
    }

    public void refresh() {
        updateStats(explorer.getAP(), explorer.getFoodNeed());
    }
}