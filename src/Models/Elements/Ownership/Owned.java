package Models.Elements.Ownership;

/** Common ownership contract for all attackable/player-controlled game elements. */
public interface Owned {
    Owner getOwner();
    void setOwner(Owner owner);

    default boolean isOwnedBy(Owner owner) {
        return owner != null && getOwner() != null && getOwner().owns(owner);
    }
}
