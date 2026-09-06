package Base.Network;

/** Public lobby/chat-room line. Server supplies sender and timestamp on broadcast. */
public record LobbyChatMessage(String sender, String timestamp, String text) implements WireMessage { }
