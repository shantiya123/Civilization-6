package Models.Elements.Hex.Ownership;

/** Singleton ownership value for the local player. */
public final class PlayerHexOwnership implements HexOwnership {
    public static final PlayerHexOwnership INSTANCE = new PlayerHexOwnership();

    private PlayerHexOwnership() {
    }
}
