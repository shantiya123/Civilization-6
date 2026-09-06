package Base.Network;
import Game.Client.Synchronization.FullSnapshot;

public record SnapshotMessage(String token, FullSnapshot snapshot) implements WireMessage { }
