package Persistence;

import Models.Elements.Resources.Resource;
import Persistence.Json.Json;

import java.util.HashMap;
import java.util.Map;

/** Encodes/decodes a {@code Map<Class<? extends Resource>, Integer>} as a JSON object keyed by simple class name. */
final class MapCodec {
    private MapCodec() { }

    static Json.Obj writeResourceMap(Map<Class<? extends Resource>, Integer> map) {
        Json.Obj json = new Json.Obj();
        for (Map.Entry<Class<? extends Resource>, Integer> entry : map.entrySet()) {
            json.put(entry.getKey().getSimpleName(), entry.getValue());
        }
        return json;
    }

    static Map<Class<? extends Resource>, Integer> readResourceMap(Json.Obj json) throws SaveLoadException {
        Map<Class<? extends Resource>, Integer> map = new HashMap<>();
        for (Map.Entry<String, Json.Value> entry : json.entries()) {
            map.put(ResourceTypes.fromName(entry.getKey()), entry.getValue().asInt());
        }
        return map;
    }
}