package Base.Network;

/** Requests admission to the pre-game lobby. */
public record LobbyJoinMessage(String playerName) implements WireMessage { }
