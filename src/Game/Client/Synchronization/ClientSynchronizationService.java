package Game.Client.Synchronization;

import Game.Synchronization.Commit;
import Persistence.CommitReplicaIO;
import Persistence.SaveLoadException;
import Persistence.SaveManager;

import java.util.ArrayList;
import java.util.List;

/** Ordered, atomic client-side snapshot/commit application with no server references. */
public final class ClientSynchronizationService {
    private final ClientWorld clientWorld = new ClientWorld();
    private final String token;
    private final List<Runnable> completionListeners = new ArrayList<>();
    private int lastAppliedCommit;

    public ClientSynchronizationService(String token) { this.token = token; }
    public ClientWorld getClientWorld() { return clientWorld; }
    public int getLastAppliedCommit() { return lastAppliedCommit; }
    public void onSynchronizationCompleted(Runnable listener) { completionListeners.add(listener); }

    public ApplyResult applySnapshot(FullSnapshot snapshot) {
        try {
            var rebuilt = SaveManager.decodeWorld(snapshot.stateJson()).world();
            clientWorld.replace(rebuilt);
            lastAppliedCommit = snapshot.baselineCommitId();
            completed();
            return ApplyResult.APPLIED;
        } catch (SaveLoadException | RuntimeException exception) { return ApplyResult.FAILED; }
    }

    public ApplyResult applyCommit(Commit commit) {
        if (commit.id() <= lastAppliedCommit) return ApplyResult.DUPLICATE_OR_OLDER;
        if (commit.id() != lastAppliedCommit + 1 || clientWorld.getWorld() == null) return ApplyResult.GAP;
        try {
            var rebuilt = CommitReplicaIO.apply(clientWorld.getWorld(), commit, token);
            clientWorld.replace(rebuilt);
            lastAppliedCommit = commit.id();
            completed();
            return ApplyResult.APPLIED;
        } catch (Exception exception) { return ApplyResult.FAILED; }
    }
    /** Presentation callbacks are observers; a broken observer cannot change applied state/result. */
    private void completed() {
        for (Runnable listener : List.copyOf(completionListeners)) {
            try { listener.run(); } catch (RuntimeException ignored) { }
        }
    }
}
