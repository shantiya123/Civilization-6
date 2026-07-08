package Models.Records;

import Models.Elements.Resources.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public final class ResourceRecord {

    private static final ResourceRecord instance = new ResourceRecord();

    private final Map<Class<? extends Resource>, List<Resource>> elements;

    private ResourceRecord() {
        elements = new HashMap<>();
        elements.put(Iron.class, new ArrayList<>());
        elements.put(Food.class, new ArrayList<>());
        elements.put(Stone.class, new ArrayList<>());
        elements.put(Wood.class, new ArrayList<>());
    }

    public static void add(Resource resource) {
        if (resource == null) return;
        List<Resource> list = instance.elements.computeIfAbsent(resource.getClass(), k -> new ArrayList<>());
        list.add(resource);
    }

    public static void remove(Resource resource) {
        if (resource == null) return;
        List<Resource> list = instance.elements.get(resource.getClass());
        if (list != null) {
            list.remove(resource);
        }
    }

    public static void clear(Class<? extends Resource> clazz) {
        List<Resource> list = instance.elements.get(clazz);
        if (list != null) {
            list.clear();
        }
    }

    public static List<Resource> getAll(Class<? extends Resource> clazz) {
        List<Resource> list = instance.elements.get(clazz);
        return list != null ? Collections.unmodifiableList(new ArrayList<>(list)) : Collections.emptyList();
    }

    public static List<Resource> getAll() {
        List<Resource> all = new ArrayList<>();
        for (List<Resource> list : instance.elements.values()) {
            all.addAll(list);
        }
        return Collections.unmodifiableList(all);
    }

    public static Resource create(Resource resource) {
        add(resource);
        return resource;
    }
}