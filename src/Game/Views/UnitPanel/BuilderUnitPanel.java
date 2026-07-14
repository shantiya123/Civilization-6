package Game.Views.UnitPanel;

import Models.Elements.Buildings.Building;
import Models.Elements.Units.Builder;

import javax.swing.*;
import java.util.List;

public class BuilderUnitPanel extends UnitPanel {

    private final Builder builder;
    private final JLabel chargesLabel;
    private final JPanel buildButtonsPanel;

    public BuilderUnitPanel(Builder builder, UnitPanelState state) {
        super("Builder", state);
        this.builder = builder;
        backgroundImage = new ImageIcon("C:\\Users\\shantiya\\Desktop\\django\\java\\Civilizatino-6\\src\\Images\\UnitBackground\\ChatGPT Image Jul 13, 2026, 05_50_12 PM.png").getImage();
        chargesLabel = createThemedLabel("", 14f, false);

        buildButtonsPanel = new JPanel();
        buildButtonsPanel.setOpaque(false);
        buildButtonsPanel.setLayout(new BoxLayout(buildButtonsPanel, BoxLayout.Y_AXIS));

        actionPanel.add(chargesLabel);
        actionPanel.add(Box.createVerticalStrut(8));
        actionPanel.add(buildButtonsPanel);

        refresh();
    }

    @Override
    public void refresh() {
        updateStats(builder.getAP(), builder.getFoodNeed());
        chargesLabel.setText("Charges: " + builder.getCharges());
        rebuildBuildButtons();
    }


    private void rebuildBuildButtons() {
        buildButtonsPanel.removeAll();

        var hex = builder.getHex();
        boolean hexOccupied = hex != null && hex.getBuilding() != null;
        List<Class<? extends Building>> buildable = hex != null ? hex.getBuildableBuildings() : null;

        if (!hexOccupied && buildable != null && !buildable.isEmpty()) {
            for (Class<? extends Building> buildingClass : buildable) {
                JButton buildButton = createThemedButton("Build " + displayName(buildingClass));
                buildButton.addActionListener(e -> state.build(buildingClass));
                buildButtonsPanel.add(buildButton);
                buildButtonsPanel.add(Box.createVerticalStrut(6));
            }
        }

        buildButtonsPanel.revalidate();
        buildButtonsPanel.repaint();
    }

    private String displayName(Class<? extends Building> buildingClass) {
        return buildingClass.getSimpleName().replaceAll("(?<!^)(?=[A-Z])", " ");
    }
}