package Models.Elements.Ownership;

/** Singleton owner representing the player. */
public final class PlayerOwner implements Owner {
    public static final PlayerOwner INSTANCE = new PlayerOwner();
    private PlayerOwner() { }
}
