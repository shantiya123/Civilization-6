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
    /**
     * Removes a disconnected player and advances past them if they owned the
     * current turn.  The return value indicates that this skip completed a
     * round, so a caller may run normal end-of-round work if it owns it.
     */
    public boolean removePlayer(String token) {
        int removed = playerTokens.indexOf(token);
        if (removed < 0) return false;
        boolean wasActive = removed == activeIndex;
        java.util.ArrayList<String> tokens = new java.util.ArrayList<>(playerTokens);
        java.util.ArrayList<String> names = new java.util.ArrayList<>(playerNames);
        tokens.remove(removed);
        names.remove(removed);
        playerTokens = java.util.List.copyOf(tokens);
        playerNames = java.util.List.copyOf(names);
        if (playerTokens.isEmpty()) { activeIndex = 0; return false; }
        if (removed < activeIndex) activeIndex--;
        if (!wasActive) return false;
        if (activeIndex >= playerTokens.size()) {
            activeIndex = 0;
            nexTurn();
            return true;
        }
        // activeIndex now names the player who followed the disconnected one.
        return false;
    }
    public String getActivePlayerName() { return playerNames.isEmpty() ? "Player" : playerNames.get(activeIndex); }
    public void setActivePlayerName(String name) { playerNames = java.util.List.of(name); activeIndex = 0; }
}
