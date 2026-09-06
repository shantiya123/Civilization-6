package Game.Synchronization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Lifetime, globally ordered history owned by one authoritative SuperWorld. */
public final class CommitHistory {
    private final List<Commit> commits = new ArrayList<>();
    private int latestCommitId;

    public List<Commit> getCommits() {
        return Collections.unmodifiableList(commits);
    }

    public int getLatestCommitId() {
        return latestCommitId;
    }

    public void append(Commit commit) {
        if (commit.id() != latestCommitId + 1) {
            throw new IllegalArgumentException("Commit ID must immediately follow history");
        }
        commits.add(commit);
        latestCommitId = commit.id();
    }
}
