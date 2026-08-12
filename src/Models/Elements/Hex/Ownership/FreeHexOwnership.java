package Models.Elements.Hex.Ownership;

/** Singleton ownership value for hexes controlled by nobody. */
public final class FreeHexOwnership implements HexOwnership {
    public static final FreeHexOwnership INSTANCE = new FreeHexOwnership();

    private FreeHexOwnership() {
    }
}
