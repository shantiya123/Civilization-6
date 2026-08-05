package Models.Records;

import Models.Elements.Buildable.Buildings.*;
import Models.Elements.Buildable.Buildings.TownHall;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public final class BuildingRecord {

    private final Map<Class<? extends Building>, List<Building>> elements;

    public BuildingRecord() {
        elements = new HashMap<>();
        elements.put(Farm.class, new ArrayList<>());
        elements.put(IronMine.class, new ArrayList<>());
        elements.put(LumberMill.class, new ArrayList<>());
        elements.put(Settlement.class, new ArrayList<>());
        elements.put(Stable.class, new ArrayList<>());
        elements.put(StoneMine.class, new ArrayList<>());
        elements.put(TownHall.class, new ArrayList<>());
    }

    public  void add(Building building) {
        if (building == null) return;
        List<Building> list = elements.computeIfAbsent(building.getClass(), k -> new ArrayList<>());
        list.add(building);
    }

    public  void remove(Building building) {
        if (building == null) return;
        List<Building> list = elements.get(building.getClass());
        if (list != null) {
            list.remove(building);
        }
    }

    public List<Building> getAll(Class<? extends Building> clazz) {
        List<Building> list = elements.get(clazz);
        return list != null ? Collections.unmodifiableList(new ArrayList<>(list)) : Collections.emptyList();
    }

    public List<Building> getAll() {
        List<Building> all = new ArrayList<>();
        for (List<Building> list : elements.values()) {
            all.addAll(list);
        }
        return Collections.unmodifiableList(all);
    }

    public  Building create(Building building) {
        add(building);
        return building;
    }
}