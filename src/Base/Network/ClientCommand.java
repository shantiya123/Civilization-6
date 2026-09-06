package Base.Network;
/** Server-to-client command; recipient is null for broadcast. */
public interface ClientCommand extends WireMessage { String recipientToken(); }
