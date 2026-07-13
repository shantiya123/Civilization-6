package Game.Views.UnitPanel;

import Game.Views.UnitPanel.UnitPanel;
import Game.Views.UnitPanel.UnitPanelState;
import Models.Elements.Units.Builder;

import javax.swing.*;
import java.awt.*;

public class BuilderUnitPanel extends UnitPanel {

    private final Builder builder;
    private final JLabel chargesLabel;

    public BuilderUnitPanel(Builder builder, UnitPanelState state) {
        super("Builder", state);
        this.builder = builder;
        backgroundImage = new ImageIcon("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\UnitBackground\\ChatGPT Image Jul 13, 2026, 05_50_12 PM.png").getImage();
        chargesLabel = createThemedLabel("", 14f, false);

        JButton buildButton = createThemedButton("Build");
        buildButton.addActionListener(e -> state.build());

        actionPanel.add(chargesLabel);
        actionPanel.add(Box.createVerticalStrut(8));
        actionPanel.add(buildButton);

        refresh();
    }

    public void refresh() {
        updateStats(builder.getAP(), builder.getFoodNeed());
        chargesLabel.setText("Charges: " + builder.getCharges());
    }
}