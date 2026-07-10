package Models.Records;

import Models.Elements.Hex.*;
import Models.Manager.HexManager;

import java.util.*;

public final class HexRecord {

    private final Map<Class<? extends Hex>, List<Hex>> elements;
    private HexManager hexManager; // set after World constructs both

    public HexRecord() {
        elements = new HashMap<>();
        elements.put(ForestHex.class,   new ArrayList<>());
        elements.put(LandHex.class,     new ArrayList<>());
        elements.put(MountainHex.class, new ArrayList<>());
        elements.put(GrassHex.class,    new ArrayList<>());
    }

    /** World calls this after constructing HexManager to wire them together. */
    public void setHexManager(HexManager hexManager) {
        this.hexManager = hexManager;
    }

    public void add(Hex hex) {
//        System.out.println("add called ");
        if (hex == null) return;
        List<Hex> list = elements.computeIfAbsent(hex.getClass(), k -> new ArrayList<>());
        list.add(hex);
        // Automatically position the hex on the board
        if (hexManager != null) {
            hexManager.onHexAdded(hex);
        }
    }

    public void remove(Hex hex) {
        if (hex == null) return;
        List<Hex> list = elements.get(hex.getClass());
        if (list != null) list.remove(hex);
    }

    public List<Hex> getAll(Class<? extends Hex> clazz) {
        List<Hex> list = elements.get(clazz);
        return list != null ? Collections.unmodifiableList(new ArrayList<>(list)) : Collections.emptyList();
    }

    public List<Hex> getAll() {
        List<Hex> all = new ArrayList<>();
        for (List<Hex> list : elements.values()) all.addAll(list);
        return Collections.unmodifiableList(all);
    }

    public Hex create(Hex hex) {
        add(hex);
        return hex;
    }
}