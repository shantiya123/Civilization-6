package Models.Records;

import Models.Elements.Resources.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public final class ResourceRecord {


    private final Map<Class<? extends Resource>, List<Resource>> elements;

    public ResourceRecord() {
        elements = new HashMap<>();
        elements.put(Iron.class, new ArrayList<>());
        elements.put(Food.class, new ArrayList<>());
        elements.put(Stone.class, new ArrayList<>());
        elements.put(Wood.class, new ArrayList<>());
    }

    public  void add(Resource resource) {
        if (resource == null) return;
        List<Resource> list = elements.computeIfAbsent(resource.getClass(), k -> new ArrayList<>());
        list.add(resource);
    }

    public void remove(Resource resource) {
        if (resource == null) return;
        List<Resource> list = elements.get(resource.getClass());
        if (list != null) {
            list.remove(resource);
        }
    }

    public void clear(Class<? extends Resource> clazz) {
        List<Resource> list = elements.get(clazz);
        if (list != null) {
            list.clear();
        }
    }

    public  List<Resource> getAll(Class<? extends Resource> clazz) {
        List<Resource> list = elements.get(clazz);
        return list != null ? Collections.unmodifiableList(new ArrayList<>(list)) : Collections.emptyList();
    }

    public List<Resource> getAll() {
        List<Resource> all = new ArrayList<>();
        for (List<Resource> list : elements.values()) {
            all.addAll(list);
        }
        return Collections.unmodifiableList(all);
    }

    public Resource create(Resource resource) {
        add(resource);
        return resource;
    }
}