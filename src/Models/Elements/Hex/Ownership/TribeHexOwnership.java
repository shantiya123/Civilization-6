package Models.Elements.Hex.Ownership;

import Models.Elements.Tribes.Tribe;

import java.util.Objects;

/** Ownership value for a hex controlled by one specific tribe. */
public final class TribeHexOwnership implements HexOwnership {
    private final Tribe tribe;

    public TribeHexOwnership(Tribe tribe) {
        this.tribe = Objects.requireNonNull(tribe, "Tribe owner is required");
    }

    public Tribe getTribe() {
        return tribe;
    }
}
