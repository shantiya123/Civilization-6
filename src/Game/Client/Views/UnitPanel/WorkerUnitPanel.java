package Game.Client.Views.UnitPanel;


import Models.Elements.Units.Worker;
import Utils.ImageLoader;

import javax.swing.*;

public class WorkerUnitPanel extends UnitPanel {

    private final Worker worker;

    public WorkerUnitPanel(Worker worker, UnitPanelState state) {
        super("Worker", state);
        this.worker = worker;
        backgroundImage = ImageLoader.load("/Images/UnitBackground/ChatGPT Image Jul 13, 2026, 05_33_53 PM.png");
        JButton getInBuildingButton = createThemedButton("Get In Building");
        getInBuildingButton.addActionListener(e -> state.getInBuilding());

        JButton getOffBuildingButton = createThemedButton("Get Off Building");
        getOffBuildingButton.addActionListener(e -> state.getOffBuilding());

        actionPanel.add(getInBuildingButton);
        actionPanel.add(Box.createVerticalStrut(8));
        actionPanel.add(getOffBuildingButton);

        refresh();
    }

    public void refresh() {
        updateStats(worker.getAP(), worker.getFoodNeed());
    }
}