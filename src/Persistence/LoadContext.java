package Persistence;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.Unit;
import Models.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Id -&gt; object registries populated as each part of the save file is
 * loaded, so later passes can resolve references (a unit's owning tribe, a
 * hex's building, ...) to the actual reconstructed object instead of
 * duplicating it. See docs/SAVE_LOAD_DESIGN.md section 6 - Object
 * References, and section 9 - Loading Order.
 */
final class LoadContext {
    final World world;
    final Map<Integer, Hex> hexById = new HashMap<>();
    final Map<Integer, Tribe> tribeById = new HashMap<>();
    final Map<Integer, Building> buildingById = new HashMap<>();
    final Map<Integer, Unit> unitById = new HashMap<>();
    private int maxIdSeen = 0;

    LoadContext(World world) {
        this.world = world;
    }

    /**
     * Assigns the persisted id to a freshly-constructed Model (overriding
     * the fresh runtime id its constructor generated) and tracks it so the
     * process-wide id counter can be advanced past every id used in this
     * save file once loading finishes.
     */
    void restoreId(Model model, int id) {
        model.setId(id);
        if (id > maxIdSeen) maxIdSeen = id;
    }

    int nextFreeId() {
        return maxIdSeen + 1;
    }

    Hex requireHex(int id) throws SaveLoadException {
        Hex hex = hexById.get(id);
        if (hex == null) throw new SaveLoadException("Save file references unknown hex id " + id);
        return hex;
    }

    Tribe requireTribe(int id) throws SaveLoadException {
        Tribe tribe = tribeById.get(id);
        if (tribe == null) throw new SaveLoadException("Save file references unknown tribe id " + id);
        return tribe;
    }

    Building requireBuilding(int id) throws SaveLoadException {
        Building building = buildingById.get(id);
        if (building == null) throw new SaveLoadException("Save file references unknown building id " + id);
        return building;
    }
}