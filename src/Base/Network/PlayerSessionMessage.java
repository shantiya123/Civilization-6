package Base.Network;
/** Private session identity assigned by the authoritative lobby. */
public record PlayerSessionMessage(String token, String playerName) implements WireMessage { }
