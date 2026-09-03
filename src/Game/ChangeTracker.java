package Game;

import Models.Model;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class ChangeTracker {
    private final Set<Model> created = new LinkedHashSet<>();
    private final Set<Model> modified = new LinkedHashSet<>();
    private final Set<Model> deleted = new LinkedHashSet<>();

    public void markCreated(Model model) {
        Objects.requireNonNull(model, "model");
        modified.remove(model);
        deleted.remove(model);
        created.add(model);
    }

    public void markModified(Model model) {
        Objects.requireNonNull(model, "model");
        if (created.contains(model) || deleted.contains(model)) {
            return;
        }
        modified.add(model);
    }

    public void markDeleted(Model model) {
        Objects.requireNonNull(model, "model");
        if (created.remove(model)) {
            modified.remove(model);
            deleted.remove(model);
            return;
        }
        modified.remove(model);
        deleted.add(model);
    }

    public Set<Model> getCreated() {
        return Collections.unmodifiableSet(created);
    }

    public Set<Model> getModified() {
        return Collections.unmodifiableSet(modified);
    }

    public Set<Model> getDeleted() {
        return Collections.unmodifiableSet(deleted);
    }

    public void clear() {
        created.clear();
        modified.clear();
        deleted.clear();
    }
}
