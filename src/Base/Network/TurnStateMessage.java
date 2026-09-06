package Base.Network;
/** Public turn HUD state pushed by the server. */
public record TurnStateMessage(int round, String activePlayer) implements WireMessage { }
