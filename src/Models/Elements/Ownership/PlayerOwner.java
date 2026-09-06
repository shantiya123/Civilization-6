package Models.Elements.Ownership;

/** A distinct human player, identified by the server-issued session token. */
public final class PlayerOwner implements Owner {
    /** Compatibility owner for old saves/single-player bootstrap. */
    public static final PlayerOwner INSTANCE = new PlayerOwner("legacy-player", "Player");

    private final String token;
    private final String displayName;

    public PlayerOwner(String token, String displayName) {
        if (token == null || token.isBlank()) throw new IllegalArgumentException("Player token is required");
        this.token = token;
        this.displayName = displayName == null || displayName.isBlank() ? "Player" : displayName;
    }

    public String getToken() { return token; }
    public String getDisplayName() { return displayName; }

    @Override public boolean equals(Object other) {
        return other instanceof PlayerOwner player && token.equals(player.token);
    }
    @Override public int hashCode() { return token.hashCode(); }
    @Override public String toString() { return displayName; }
}
