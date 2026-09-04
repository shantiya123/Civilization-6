package Game.Client.Views;

import Game.Client.Controllers.TradeController;
import Game.Client.Controllers.TribeController;
import Game.Client.Presentation.ViewState;
import Game.Client.Views.BazzarPanel.BazaarTradePanel;
import Game.Client.Views.BazzarPanel.BazaarTradePanelState;
import Game.Client.Views.HUDPanel.HUDPanel;
import Game.Client.Views.TradingPostPanel.TradingPostPanel;
import Game.Client.Views.TradingPostPanel.TradingPostPanelState;
import Game.Client.Views.TribePanel.TribePanel;
import Game.Client.Views.TribePanel.TribePanelState;
import Game.Client.Views.TribePanel.TribeTradePanel;
import Game.Client.Views.TribePanel.TribeTradePanelState;
import Models.Elements.Buildable.Buildings.Bazaar;
import Models.Elements.Buildable.Buildings.TradingPost;
import Models.Elements.Tribes.Tribe;

import javax.swing.JLayeredPane;

/** Coordinates tribe and building trade panels without owning any gameplay rules. */
final class TradePanelCoordinator {

    private final ViewState viewState;
    private final TribePanel tribePanel;
    private final TribePanelState tribePanelState;
    private final TribeTradePanel tribeTradePanel;
    private final TribeTradePanelState tribeTradePanelState;
    private final TradingPostPanel tradingPostPanel;
    private final TradingPostPanelState tradingPostPanelState;
    private final BazaarTradePanel bazaarTradePanel;
    private final BazaarTradePanelState bazaarTradePanelState;
    private Tribe lastSelectedTribe;
    private TradingPost lastSelectedTradingPost;
    private Bazaar lastSelectedBazaar;

    TradePanelCoordinator(TribeController tribeController, TradeController tradeController,
                          ViewState viewState) {
        this.viewState = viewState;

        tribePanelState = new TribePanelState(tribeController);
        tribePanel = new TribePanel(tribePanelState);

        tribeTradePanelState = new TribeTradePanelState(tribeController);
        tribeTradePanel = new TribeTradePanel(tribeTradePanelState);
        tribeTradePanel.setVisible(false);
        tribePanel.setOnTradeRequested(() -> {
            tribeTradePanelState.setTribe(tribePanelState.getTribe());
            tribeTradePanel.refresh();
            tribeTradePanel.setVisible(true);
        });

        tradingPostPanelState = new TradingPostPanelState(tradeController);
        tradingPostPanel = new TradingPostPanel(tradingPostPanelState);
        tradingPostPanel.setVisible(false);

        bazaarTradePanelState = new BazaarTradePanelState(tradeController);
        bazaarTradePanel = new BazaarTradePanel(bazaarTradePanelState);
        bazaarTradePanel.setVisible(false);
    }

    void addTo(JLayeredPane layeredPane) {
        layeredPane.add(tribePanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(tribeTradePanel, JLayeredPane.MODAL_LAYER);
        layeredPane.add(tradingPostPanel, JLayeredPane.MODAL_LAYER);
        layeredPane.add(bazaarTradePanel, JLayeredPane.MODAL_LAYER);
    }

    void layoutAtStart(int width, int height) {
        tribePanel.setBounds(width - TribePanel.PANEL_WIDTH - 20, HUDPanel.HEIGHT + 20,
                TribePanel.PANEL_WIDTH, TribePanel.PANEL_HEIGHT);
        layoutTradePanels(width, height);
    }

    void refresh(int width, int height) {
        tribePanel.setBounds(width - TribePanel.PANEL_WIDTH - 20, HUDPanel.HEIGHT,
                TribePanel.PANEL_WIDTH, TribePanel.PANEL_HEIGHT);
        Tribe currentTribe = viewState.getSelectedTribe();
        if (currentTribe != lastSelectedTribe) {
            tribePanelState.setTribe(currentTribe);
            lastSelectedTribe = currentTribe;
            tribeTradePanel.setVisible(false);
        }
        tribePanel.refresh();

        tribeTradePanel.setBounds((width - TribeTradePanel.PANEL_WIDTH) / 2,
                (height - TribeTradePanel.PANEL_HEIGHT) / 2,
                TribeTradePanel.PANEL_WIDTH, TribeTradePanel.PANEL_HEIGHT);
        if (tribeTradePanel.isVisible()) {
            tribeTradePanel.refresh();
        }

        tradingPostPanel.setBounds((width - TradingPostPanel.PANEL_WIDTH) / 2,
                height - TradingPostPanel.PANEL_HEIGHT - 40,
                TradingPostPanel.PANEL_WIDTH, TradingPostPanel.PANEL_HEIGHT);
        TradingPost currentTradingPost = viewState.getSelectedTradingPost();
        if (currentTradingPost != lastSelectedTradingPost) {
            tradingPostPanelState.setTradingPost(currentTradingPost);
            lastSelectedTradingPost = currentTradingPost;
            tradingPostPanel.setVisible(currentTradingPost != null);
        }
        if (tradingPostPanel.isVisible()) {
            tradingPostPanel.refresh();
        }

        bazaarTradePanel.setBounds(20, (height - BazaarTradePanel.PANEL_HEIGHT) / 2,
                BazaarTradePanel.PANEL_WIDTH, BazaarTradePanel.PANEL_HEIGHT);
        Bazaar currentBazaar = viewState.getSelectedBazaar();
        if (currentBazaar != lastSelectedBazaar) {
            bazaarTradePanelState.setBazaar(currentBazaar);
            lastSelectedBazaar = currentBazaar;
            bazaarTradePanel.setVisible(currentBazaar != null);
        }
        if (bazaarTradePanel.isVisible()) {
            bazaarTradePanel.refresh();
        }
    }

    private void layoutTradePanels(int width, int height) {
        tribeTradePanel.setBounds((width - TribeTradePanel.PANEL_WIDTH) / 2,
                (height - TribeTradePanel.PANEL_HEIGHT) / 2,
                TribeTradePanel.PANEL_WIDTH, TribeTradePanel.PANEL_HEIGHT);
        tradingPostPanel.setBounds((width - TradingPostPanel.PANEL_WIDTH) / 2,
                height - TradingPostPanel.PANEL_HEIGHT - 40,
                TradingPostPanel.PANEL_WIDTH, TradingPostPanel.PANEL_HEIGHT);
        bazaarTradePanel.setBounds(20, (height - BazaarTradePanel.PANEL_HEIGHT) / 2,
                BazaarTradePanel.PANEL_WIDTH, BazaarTradePanel.PANEL_HEIGHT);
    }
}
