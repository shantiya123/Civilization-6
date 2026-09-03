package Game;

import Models.Model;

public class WorldState extends Model {
    private int ExtractionEfficiency = 1 ;
    private int SeaMovingCost = 50;
    private TurnPhase turnPhase = TurnPhase.PLAYER_ACTIONS;
    private int happiness = 0;
    private int combatUnitCap = 5;

    public WorldState() {
        generateID();
    }

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

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getCombatUnitCap() {
        return combatUnitCap;
    }

    public void setCombatUnitCap(int combatUnitCap) {
        this.combatUnitCap = combatUnitCap;
    }
}
