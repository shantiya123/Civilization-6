package Models.Records;

import Models.Elements.Tribes.Tribe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TribeRecord {
    private final List<Tribe> tribes = new ArrayList<>();

    public void add(Tribe tribe) {
        if (tribe != null && !tribes.contains(tribe)) tribes.add(tribe);
    }

    public List<Tribe> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(tribes));
    }
}
