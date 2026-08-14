package Game;

public class WorldState {
    private int ExtractionEfficiency = 1 ;

    private int SeaMovingCost = 50;
    private TurnPhase turnPhase = TurnPhase.PLAYER_ACTIONS;


    public int getExtractionEfficiency() {
        return ExtractionEfficiency;
    }

    public void setExtractionEfficiency(int extractionEfficiency) {
        ExtractionEfficiency = extractionEfficiency;
    }

    public int getSeaMovingCost() {
        return SeaMovingCost;
    }

    public void setSeaMovingCost(int seaMovingCost) {
        SeaMovingCost = seaMovingCost;
    }

    public TurnPhase getTurnPhase() { return turnPhase; }
    public void setTurnPhase(TurnPhase turnPhase) {
        if (turnPhase == null) throw new IllegalArgumentException("Turn phase is required");
        this.turnPhase = turnPhase;
    }
}
