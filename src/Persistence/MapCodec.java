package Persistence;

import Models.Elements.Resources.Resource;
import Persistence.Json.Json;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Encodes/decodes a {@code Map<Class<? extends Resource>, Integer>} as a JSON
 * object keyed by simple class name. Keys are written in name order: the game
 * builds these maps as HashMaps, whose iteration order would otherwise reshuffle
 * the save file between runs of the same game state.
 */
final class MapCodec {
    private MapCodec() { }

    static Json.Obj writeResourceMap(Map<Class<? extends Resource>, Integer> map) {
        Map<String, Integer> byName = new TreeMap<>();
        for (Map.Entry<Class<? extends Resource>, Integer> entry : map.entrySet()) {
            byName.put(entry.getKey().getSimpleName(), entry.getValue());
        }
        Json.Obj json = new Json.Obj();
        for (Map.Entry<String, Integer> entry : byName.entrySet()) {
            json.put(entry.getKey(), entry.getValue());
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