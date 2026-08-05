package Models.Records;

import Models.Elements.Borders.Border;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Stores every edge element that can affect movement between two hexes. */
public final class BorderRecorder {
    private final List<Border> borders = new ArrayList<>();

    public void add(Border border) {
        if (border != null) {
            borders.add(border);
        }
    }

    public void remove(Border border) {
        borders.remove(border);
    }

    public List<Border> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(borders));
    }
}
