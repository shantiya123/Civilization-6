package Base.Network;
/** Client-to-server non-authoritative synchronization request. */
public record SynchronizationRequestMessage(String token, int lastAppliedCommit) implements WireMessage { }
