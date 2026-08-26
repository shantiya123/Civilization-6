package Persistence;

import Models.Elements.Ownership.Owner;
import Models.Elements.Ownership.PlayerOwner;
import Models.Elements.Tribes.Tribe;
import Persistence.Json.Json;

/** Reads/writes an Owner (the player, or a specific tribe by id). */
final class OwnerIO {
    private OwnerIO() { }

    static Json.Obj write(Owner owner) {
        Json.Obj json = new Json.Obj();
        if (owner instanceof Tribe tribe) {
            json.put("kind", "tribe").put("tribeId", tribe.getId());
        } else {
            json.put("kind", "player");
        }
        return json;
    }

    static Owner read(Json.Obj json, LoadContext context) throws SaveLoadException {
        String kind = json.getString("kind");
        if (kind.equals("tribe")) {
            return context.requireTribe(json.getInt("tribeId"));
        }
        if (kind.equals("player")) {
            return PlayerOwner.INSTANCE;
        }
        throw new SaveLoadException("Unknown owner kind: " + kind);
    }
}