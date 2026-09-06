package Models.Elements.Hex.Ownership;

import Models.Elements.Ownership.PlayerOwner;
import java.util.Objects;

/** Territory controlled by one specific human player. */
public final class PlayerHexOwnership implements HexOwnership {
    private final PlayerOwner player;

    public PlayerHexOwnership(PlayerOwner player) {
        this.player = Objects.requireNonNull(player, "Player owner is required");
    }

    public PlayerOwner getPlayer() { return player; }
}
