package Persistence;

import Game.Synchronization.ChangeOperation;
import Game.Synchronization.SnapshotValue;
import Game.Synchronization.StateSnapshot;
import Game.World;
import Models.Model;
import Models.Elements.Borders.River;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Constructure.Constructure;
import Models.Elements.Hex.Hex;
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.Unit;
import Persistence.Json.Json;

import java.util.Map;

/**
 * Builds replica-grade, immutable snapshots from the same explicit codecs as
 * saved games. Every supported create/modify payload is a standalone JSON DTO
 * with the exact persistence fields for that model type; no live model object
 * or reflective partial field graph is retained.
 */
public final class SynchronizationSnapshotIO {
    private SynchronizationSnapshotIO() { }

    public static StateSnapshot capture(World world, Model model, ChangeOperation operation) {
        if (operation == ChangeOperation.DELETED) return tombstone(model);
        Json.Obj payload = payloadFor(world, model);
        return new StateSnapshot(Map.of("persistence", new SnapshotValue(
                "persistence-json-v1", Json.write(payload))));
    }

    private static StateSnapshot tombstone(Model model) {
        Json.Obj payload = new Json.Obj();
        payload.put("type", model.getClass().getName());
        payload.put("id", model.getId());
        return new StateSnapshot(Map.of("persistence", new SnapshotValue(
                "deletion-tombstone-v1", Json.write(payload))));
    }

    private static Json.Obj payloadFor(World world, Model model) {
        if (model instanceof Hex hex) return wrap("hex", findById(HexIO.writeHexes(world), hex.getId()));
        if (model instanceof Building building)
            return wrap("building", findById(BuildingIO.writeBuildings(world), building.getId()));
        if (model instanceof Unit unit) return wrap("unit", findById(UnitIO.writeUnits(world), unit.getId()));
        if (model instanceof Tribe tribe) return wrap("tribe", findById(TribeIO.writeTribes(world), tribe.getId()));
        if (model instanceof Constructure constructure)
            return wrap("border", findBorderById(HexIO.writeBorders(world), constructure.getId()));
        if (model instanceof River river)
            return wrap("border", findBorderById(HexIO.writeBorders(world), river.getId()));
        if (model == world.getState()) {
            Json.Obj payload = new Json.Obj();
            payload.put("id", model.getId());
            payload.put("world", WorldStateIO.writeWorldState(world));
            return wrap("world-state", payload);
        }
        if (model instanceof Resource resource) {
            Json.Obj payload = new Json.Obj();
            payload.put("type", resource.getClass().getSimpleName());
            payload.put("id", resource.getId());
            return wrap("resource", payload);
        }
        throw new IllegalArgumentException("No complete synchronization snapshot codec for "
                + model.getClass().getName());
    }

    private static Json.Obj wrap(String kind, Json.Obj state) {
        Json.Obj payload = new Json.Obj();
        payload.put("kind", kind);
        payload.put("state", state);
        return payload;
    }

    private static Json.Obj findById(Json.Arr entries, int id) {
        for (Json.Value value : entries.items()) {
            Json.Obj entry = value.asObject();
            if (entry.getInt("id") == id) return entry;
        }
        throw new IllegalArgumentException("Tracked model " + id + " is not present in its authoritative record");
    }

    private static Json.Obj findBorderById(Json.Obj borders, int id) {
        for (String kind : new String[]{"rivers", "walls", "roads"}) {
            for (Json.Value value : borders.getArrayOrEmpty(kind).items()) {
                Json.Obj entry = value.asObject();
                if (entry.getInt("id") == id) return entry;
            }
        }
        throw new IllegalArgumentException("Tracked border " + id + " is not present in the authoritative record");
    }
}
