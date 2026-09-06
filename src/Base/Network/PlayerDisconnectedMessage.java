package Base.Network;

/** Server-authoritative announcement that a lobby/game player disconnected. */
public record PlayerDisconnectedMessage(String playerName) implements WireMessage { }
