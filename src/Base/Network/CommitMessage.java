package Base.Network;
import Game.Synchronization.Commit;
import java.util.Objects;
/** Server-to-client immutable commit message. */
public record CommitMessage(Commit commit) implements WireMessage { public CommitMessage { Objects.requireNonNull(commit); } }
