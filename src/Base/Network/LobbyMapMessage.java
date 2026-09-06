package Base.Network;

/** Host-only map selection request. */
public record LobbyMapMessage(String mapName) implements WireMessage { }
