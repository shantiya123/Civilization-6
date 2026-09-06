package Base.Network;

/** A player's requested ready state. Identity comes from its TCP connection. */
public record LobbyReadyMessage(boolean ready) implements WireMessage { }
