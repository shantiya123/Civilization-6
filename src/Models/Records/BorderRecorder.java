package Models.Records;

import Models.Elements.Borders.Border;
import Models.Elements.Borders.River;
import Models.Elements.Buildable.Constructure.Road;
import Models.Elements.Buildable.Constructure.Wall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/** Typed edge record: rivers, walls, and roads remain independently queryable. */
public final class BorderRecorder {
    private final Map<Class<? extends Border>, List<Border>> elements = new HashMap<>();

    public BorderRecorder() {
        elements.put(River.class, new ArrayList<>());
        elements.put(Wall.class, new ArrayList<>());
        elements.put(Road.class, new ArrayList<>());
    }

    public void add(Border border) {
        if (border != null) elements.computeIfAbsent(border.getClass(), key -> new ArrayList<>()).add(border);
    }

    public void remove(Border border) {
        if (border == null) return;
        List<Border> borders = elements.get(border.getClass());
        if (borders != null) borders.remove(border);
    }

    /** Returns one typed, immutable border collection (for example getAll(Wall.class)). */
    @SuppressWarnings("unchecked")
    public <T extends Border> List<T> getAll(Class<T> borderClass) {
        List<Border> borders = elements.get(borderClass);
        if (borders == null) return Collections.emptyList();
        return Collections.unmodifiableList(borders.stream().map(borderClass::cast).toList());
    }

    /** Compatibility combined view for logic that deliberately examines every border type. */
    public List<Border> getAll() {
        List<Border> borders = new ArrayList<>();
        for (List<Border> typedBorders : elements.values()) borders.addAll(typedBorders);
        return Collections.unmodifiableList(borders);
    }

    public boolean contains(Border border) {
        return border != null && elements.getOrDefault(border.getClass(), List.of()).contains(border);
    }
}
