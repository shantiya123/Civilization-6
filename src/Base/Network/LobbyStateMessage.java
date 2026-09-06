package Base.Network;

import java.util.List;

/** Immutable public lobby view pushed whenever membership or settings change. */
public record LobbyStateMessage(List<Player> players, String hostName, String selectedMap, boolean started)
        implements WireMessage {
    public LobbyStateMessage { players = List.copyOf(players); }
    /** Spawn coordinates are null until the host starts the ready lobby. */
    public record Player(String name, boolean ready, Integer townHallQ, Integer townHallR) implements java.io.Serializable { }
}
