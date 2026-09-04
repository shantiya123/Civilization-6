package Game.Client.Views;

import Game.Client.Controllers.BoardController;
import Game.Client.Controllers.WarController;
import Game.Client.Presentation.ViewState;
import Game.Server.Systems.EventSystem.Events.WarEvent;
import Game.Client.Views.BoardPanel.EndTurnButton;
import Game.Client.Views.WarPanel.StartWarButton;
import Game.Client.Views.WarPanel.WarPanel;
import Game.Client.Views.WarPanel.WarPanelState;
import Game.Client.Views.WarPanel.WarReportButton;
import Game.World;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;

import javax.swing.JLayeredPane;

/** Owns war-report controls and synchronizes them with war-related view state. */
final class WarPanelCoordinator {

    private final BoardController boardController;
    private final ViewState viewState;
    private final World world;
    private final WarPanel warPanel;
    private final WarPanelState warPanelState;
    private final WarReportButton warReportButton;
    private final StartWarButton startWarButton;
    private WarEvent lastAppliedWarEvent;
    private int lastAppliedWarProposalVersion;

    WarPanelCoordinator(WarController warController, BoardController boardController,
                        ViewState viewState, World world) {
        this.boardController = boardController;
        this.viewState = viewState;
        this.world = world;

        warPanelState = new WarPanelState(warController);
        warPanel = new WarPanel(warPanelState);
        warPanel.setVisible(false);
        warPanel.setOnClose(() -> warPanel.setVisible(false));
        warPanel.setOnRetreat(() -> warPanel.setVisible(false));
        warReportButton = new WarReportButton();
        warReportButton.addActionListener(event -> toggleWarReport());
        startWarButton = new StartWarButton();
        startWarButton.addActionListener(event -> boardController.requestWarTargeting());
    }

    void addTo(JLayeredPane layeredPane) {
        layeredPane.add(warPanel, JLayeredPane.MODAL_LAYER);
        layeredPane.add(warReportButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(startWarButton, JLayeredPane.PALETTE_LAYER);
    }

    void layout(int width, int height) {
        warPanel.setBounds((width - WarPanel.PANEL_WIDTH) / 2,
                (height - WarPanel.PANEL_HEIGHT) / 2,
                WarPanel.PANEL_WIDTH, WarPanel.PANEL_HEIGHT);
        warReportButton.setBounds(30,
                height - EndTurnButton.DIAMETER - 30 - WarReportButton.HEIGHT - 10,
                WarReportButton.WIDTH, WarReportButton.HEIGHT);
        startWarButton.setBounds(30,
                height - EndTurnButton.DIAMETER - 30 - WarReportButton.HEIGHT - 10
                        - StartWarButton.HEIGHT - 10,
                StartWarButton.WIDTH, StartWarButton.HEIGHT);
    }

    void refresh(int width, int height) {
        layout(width, height);

        int currentWarProposalVersion = viewState.getWarProposalVersion();
        if (currentWarProposalVersion != lastAppliedWarProposalVersion) {
            lastAppliedWarProposalVersion = currentWarProposalVersion;
            Hex proposedOffensiveHex = viewState.getProposedOffensiveHex();
            Hex proposedDefensiveHex = viewState.getProposedDefensiveHex();
            if (proposedOffensiveHex != null && proposedDefensiveHex != null) {
                warPanelState.proposeAttack(proposedOffensiveHex, proposedDefensiveHex,
                        "You", describeDefender(proposedDefensiveHex));
                warPanel.setVisible(true);
            }
        }

        WarEvent currentWarEvent = viewState.getLastWarEvent();
        if (currentWarEvent != null && currentWarEvent != lastAppliedWarEvent) {
            warPanelState.applyWarEvent(currentWarEvent);
            lastAppliedWarEvent = currentWarEvent;
            warPanel.setVisible(true);
        }
        if (warPanel.isVisible()) {
            warPanel.refresh();
        }
    }

    private void toggleWarReport() {
        WarEvent currentWarEvent = viewState.getLastWarEvent();
        if (currentWarEvent != null && currentWarEvent != lastAppliedWarEvent) {
            warPanelState.applyWarEvent(currentWarEvent);
            lastAppliedWarEvent = currentWarEvent;
        }
        warPanel.setVisible(!warPanel.isVisible());
        if (warPanel.isVisible()) {
            warPanel.refresh();
        }
    }

    private String describeDefender(Hex defensiveHex) {
        Tribe owningTribe = defensiveHex.getOwningTribe();
        if (owningTribe != null) {
            return owningTribe.getClass().getSimpleName().replaceAll("(?<!^)(?=[A-Z])", " ");
        }
        if (defensiveHex.getBuilding() != null) {
            return defensiveHex.getBuilding().getClass().getSimpleName();
        }
        boolean hasUnits = world.getUnitRecord().getAll().stream()
                .anyMatch(unit -> unit.getHex() == defensiveHex);
        return hasUnits ? "Hostile Forces" : "Unclaimed Hex";
    }
}
