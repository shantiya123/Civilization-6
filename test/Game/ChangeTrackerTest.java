package Game;

import Models.Model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeTrackerTest {
    private static final class TestModel extends Model { }

    @Test
    void createdThenModifiedOnlyRemainsCreated() {
        ChangeTracker tracker = new ChangeTracker();
        Model model = new TestModel();
        tracker.markCreated(model);
        tracker.markModified(model);
        assertEquals(java.util.Set.of(model), tracker.getCreated());
        assertTrue(tracker.getModified().isEmpty());
    }

    @Test
    void createdThenDeletedLeavesNoPendingChange() {
        ChangeTracker tracker = new ChangeTracker();
        Model model = new TestModel();
        tracker.markCreated(model);
        tracker.markDeleted(model);
        assertFalse(tracker.hasChanges());
        assertTrue(tracker.getCreated().isEmpty());
        assertTrue(tracker.getDeleted().isEmpty());
    }

    @Test
    void modifiedThenDeletedOnlyRemainsDeleted() {
        ChangeTracker tracker = new ChangeTracker();
        Model model = new TestModel();
        tracker.markModified(model);
        tracker.markDeleted(model);
        assertTrue(tracker.getModified().isEmpty());
        assertEquals(java.util.Set.of(model), tracker.getDeleted());
    }

    @Test
    void repeatedModificationIsDeduplicatedAndReadsDoNotClear() {
        ChangeTracker tracker = new ChangeTracker();
        Model model = new TestModel();
        tracker.markModified(model);
        tracker.markModified(model);
        assertTrue(tracker.hasChanges());
        assertEquals(java.util.Set.of(model), tracker.getModified());
        assertEquals(java.util.Set.of(model), tracker.getModified());
        assertTrue(tracker.hasChanges());
    }
}
