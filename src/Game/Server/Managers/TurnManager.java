package Game.Server.Managers;

public class TurnManager {
    private int turns;
    private java.util.List<String> playerTokens = java.util.List.of();
    private java.util.List<String> playerNames = java.util.List.of();
    private int activeIndex;

    public TurnManager() {
        turns = 1;
    }
    public void nexTurn(){
        turns++;
    }

    public int getTurns() {
        return turns;
    }

    /** Restores the turn number from a loaded save. */
    public void setTurns(int turns) {
        this.turns = turns;
    }
    public void configurePlayers(java.util.List<String> tokens, java.util.List<String> names) {
        if (tokens.isEmpty() || tokens.size() != names.size()) throw new IllegalArgumentException("Turn players are required");
        playerTokens = java.util.List.copyOf(tokens); playerNames = java.util.List.copyOf(names); activeIndex = 0;
    }
    public boolean isActive(String token) { return !playerTokens.isEmpty() && playerTokens.get(activeIndex).equals(token); }
    public boolean hasPlayers() { return !playerTokens.isEmpty(); }
    /** @return true when the final player ended and the global round should resolve. */
    public boolean endActivePlayer(String token) {
        if (!isActive(token)) return false;
        activeIndex++;
        if (activeIndex < playerTokens.size()) return false;
        activeIndex = 0; nexTurn(); return true;
    }
    public String getActivePlayerName() { return playerNames.isEmpty() ? "Player" : playerNames.get(activeIndex); }
    public void setActivePlayerName(String name) { playerNames = java.util.List.of(name); activeIndex = 0; }
}
