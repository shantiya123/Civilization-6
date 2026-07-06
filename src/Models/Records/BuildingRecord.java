package Models.Records;

import Models.Elements.Buildings.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public final class BuildingRecord {

    private static final BuildingRecord instance = new BuildingRecord();

    private final Map<Class<? extends Building>, List<Building>> elements;

    private BuildingRecord() {
        elements = new HashMap<>();
        elements.put(Farm.class, new ArrayList<>());
        elements.put(IronMine.class, new ArrayList<>());
        elements.put(LumberMill.class, new ArrayList<>());
        elements.put(Settlement.class, new ArrayList<>());
        elements.put(Stable.class, new ArrayList<>());
        elements.put(StoneMine.class, new ArrayList<>());
        elements.put(TownHall.class, new ArrayList<>());
    }

    public static void add(Building building) {
        if (building == null) return;
        List<Building> list = instance.elements.computeIfAbsent(building.getClass(), k -> new ArrayList<>());
        list.add(building);
    }

    public static void remove(Building building) {
        if (building == null) return;
        List<Building> list = instance.elements.get(building.getClass());
        if (list != null) {
            list.remove(building);
        }
    }

    public static List<Building> getAll(Class<? extends Building> clazz) {
        List<Building> list = instance.elements.get(clazz);
        return list != null ? Collections.unmodifiableList(new ArrayList<>(list)) : Collections.emptyList();
    }

    public static List<Building> getAll() {
        List<Building> all = new ArrayList<>();
        for (List<Building> list : instance.elements.values()) {
            all.addAll(list);
        }
        return Collections.unmodifiableList(all);
    }

    public static Building create(Building building) {
        add(building);
        return building;
    }
}