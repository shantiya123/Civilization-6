package Game.Server.Systems.EventSystem.Events;

/** Published after end-of-turn processing completes. */
public class TurnAdvancedEvent implements Event {
    private int turnNumber;

    public TurnAdvancedEvent(int turnNumber) { this.turnNumber = turnNumber; }
    public int getTurnNumber() { return turnNumber; }
    public void setTurnNumber(int turnNumber) { this.turnNumber = turnNumber; }
}
