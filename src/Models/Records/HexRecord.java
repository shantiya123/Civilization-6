package Models.Records;

import Models.Elements.Hex.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public final class HexRecord {

    private static final HexRecord instance = new HexRecord();

    private final Map<Class<? extends Hex>, List<Hex>> elements;

    private HexRecord() {
        elements = new HashMap<>();
        // Pre-populate lists for each known subclass
        elements.put(ForestHex.class, new ArrayList<>());
        elements.put(LandHex.class, new ArrayList<>());
        elements.put(MountainHex.class, new ArrayList<>());
        elements.put(GrassHex.class, new ArrayList<>());
    }

    // --- Static API ---

    public static void add(Hex hex) {
        if (hex == null) return;
        Class<? extends Hex> clazz = hex.getClass();
        // If the map doesn't have this subclass, create a new list on the fly
        List<Hex> list = instance.elements.computeIfAbsent(clazz, k -> new ArrayList<>());
        list.add(hex);
    }

    public static void remove(Hex hex) {
        if (hex == null) return;
        List<Hex> list = instance.elements.get(hex.getClass());
        if (list != null) {
            list.remove(hex);
        }
    }

    public static List<Hex> getAll(Class<? extends Hex> clazz) {
        List<Hex> list = instance.elements.get(clazz);
        return list != null ? Collections.unmodifiableList(new ArrayList<>(list)) : Collections.emptyList();
    }

    public static List<Hex> getAll() {
        List<Hex> all = new ArrayList<>();
        for (List<Hex> list : instance.elements.values()) {
            all.addAll(list);
        }
        return Collections.unmodifiableList(all);
    }

    // Convenience alias for add
    public static Hex create(Hex hex) {
        add(hex);
        return hex;
    }
}