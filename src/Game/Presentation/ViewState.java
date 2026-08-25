package Game.Presentation;

import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Buildable.Buildings.TradingPost;
import Models.Elements.Buildable.Buildings.Bazaar;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.Unit;
import Game.Systems.EventSystem.Events.WarEvent;

public class ViewState {
    private Unit selectedUnit;
    private Hex selectedHex;
    private boolean starvation;
    private TownHall townHall;
    private String message;
    private Tribe selectedTribe;
    private TradingPost selectedTradingPost;
    private Bazaar selectedBazaar;
    private WarEvent lastWarEvent;
    private Hex proposedOffensiveHex;
    private Hex proposedDefensiveHex;
    private int warProposalVersion = 0;

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public void setSelectedUnit(Unit selectedUnit) {
        this.selectedUnit = selectedUnit;
    }

    public Hex getSelectedHex() {
        return selectedHex;
    }

    public void setSelectedHex(Hex selectedHex) {
        this.selectedHex = selectedHex;
    }

    public boolean isStarvation() {
        return starvation;
    }

    public void setStarvation(boolean starvation) {
        this.starvation = starvation;
    }

    public TownHall getTownHall() {
        return townHall;
    }

    public void setTownHall(TownHall townHall) {
        this.townHall = townHall;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Tribe getSelectedTribe() {
        return selectedTribe;
    }

    public void setSelectedTribe(Tribe selectedTribe) {
        this.selectedTribe = selectedTribe;
    }

    public TradingPost getSelectedTradingPost() {
        return selectedTradingPost;
    }

    public void setSelectedTradingPost(TradingPost selectedTradingPost) {
        this.selectedTradingPost = selectedTradingPost;
    }

    public Bazaar getSelectedBazaar() {
        return selectedBazaar;
    }

    public void setSelectedBazaar(Bazaar selectedBazaar) {
        this.selectedBazaar = selectedBazaar;
    }

    /** Most recently resolved war command, used to pop open the War Panel with a real report. */
    public WarEvent getLastWarEvent() {
        return lastWarEvent;
    }

    public void setLastWarEvent(WarEvent lastWarEvent) {
        this.lastWarEvent = lastWarEvent;
    }

    /**
     * Offensive/defensive hex picked on the board while starting a war (see
     * {@code BoardController#requestWarTargeting()}), not yet confirmed/rolled.
     * {@code warProposalVersion} increments on every new proposal so GameEngine can detect a
     * fresh proposal even if the exact same hex pair is chosen again later.
     */
    public Hex getProposedOffensiveHex() {
        return proposedOffensiveHex;
    }

    public Hex getProposedDefensiveHex() {
        return proposedDefensiveHex;
    }

    public int getWarProposalVersion() {
        return warProposalVersion;
    }

    public void setWarProposal(Hex offensiveHex, Hex defensiveHex) {
        this.proposedOffensiveHex = offensiveHex;
        this.proposedDefensiveHex = defensiveHex;
        this.warProposalVersion++;
    }
}