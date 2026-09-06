package Base.Network;

/** A non-fatal server validation error for the lobby UI. */
public record LobbyErrorMessage(String message) implements WireMessage { }
