package Models.Records;

import Models.Elements.Units.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public final class UnitRecord {

    private static final UnitRecord instance = new UnitRecord();

    private final Map<Class<? extends Unit>, List<Unit>> elements;

    private UnitRecord() {
        elements = new HashMap<>();
        elements.put(Worker.class, new ArrayList<>());
        elements.put(Builder.class, new ArrayList<>());
        elements.put(BorderExpander.class, new ArrayList<>());
        elements.put(Explorer.class, new ArrayList<>());
    }

    public static void add(Unit unit) {
        if (unit == null) return;
        List<Unit> list = instance.elements.computeIfAbsent(unit.getClass(), k -> new ArrayList<>());
        list.add(unit);
    }

    public static void remove(Unit unit) {
        if (unit == null) return;
        List<Unit> list = instance.elements.get(unit.getClass());
        if (list != null) {
            list.remove(unit);
        }
    }

    public static List<Unit> getAll(Class<? extends Unit> clazz) {
        List<Unit> list = instance.elements.get(clazz);
        return list != null ? Collections.unmodifiableList(new ArrayList<>(list)) : Collections.emptyList();
    }

    public static List<Unit> getAll() {
        List<Unit> all = new ArrayList<>();
        for (List<Unit> list : instance.elements.values()) {
            all.addAll(list);
        }
        return Collections.unmodifiableList(all);
    }

    public static Unit create(Unit unit) {
        add(unit);
        return unit;
    }
}