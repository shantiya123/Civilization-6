package Models.Elements.Ownership;

/** A game faction that can own units, buildings, constructures, or territory. */
public interface Owner {
    /** Value-based ownership comparison; tribe owners retain their model identity. */
    default boolean owns(Owner other) { return this.equals(other); }
}
