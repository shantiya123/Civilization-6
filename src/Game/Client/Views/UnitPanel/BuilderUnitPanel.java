package Game.Client.Views.UnitPanel;

import Models.Elements.Units.Builder;
import Utils.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BuilderUnitPanel extends UnitPanel {

    private final Builder builder;
    private final JLabel chargesLabel;
    private final JButton buildButton;
    private final JButton decayButton;
    private JDialog buildDialog;

    public BuilderUnitPanel(Builder builder, UnitPanelState state) {
        super("Builder", state);
        this.builder = builder;
        backgroundImage = ImageLoader.load("/Images/UnitBackground/ChatGPT Image Jul 13, 2026, 05_50_12 PM.png");
        chargesLabel = createThemedLabel("", 14f, false);

        buildButton = createThemedButton("Build");
        buildButton.addActionListener(e -> showBuildDialog());

        decayButton = createThemedButton("Decay");
        decayButton.addActionListener(e -> state.decay());

        actionPanel.add(chargesLabel);
        actionPanel.add(Box.createVerticalStrut(8));
        actionPanel.add(buildButton);
        actionPanel.add(Box.createVerticalStrut(8));
        actionPanel.add(decayButton);

        refresh();
    }

    @Override
    public void refresh() {
        updateStats(builder.getAP(), builder.getFoodNeed());
        chargesLabel.setText("Charges: " + builder.getCharges());
        decayButton.setEnabled(builder.getHex() != null && builder.getHex().getBuilding() != null);
    }

    private void showBuildDialog() {
        Window owner = SwingUtilities.getWindowAncestor(this);
        if (buildDialog != null) {
            buildDialog.dispose();
        }
        buildDialog = new JDialog(owner, "Build", Dialog.ModalityType.MODELESS);
        buildDialog.setContentPane(new BuildOrderPanel(builder, state, () -> buildDialog.setVisible(false)));
        buildDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                state.cancelBorderBuilding();
            }
        });
        buildDialog.pack();
        buildDialog.setLocationRelativeTo(this);
        buildDialog.setVisible(true);
        buildDialog.toFront();
    }
}