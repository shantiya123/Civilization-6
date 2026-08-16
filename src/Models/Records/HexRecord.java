package Models.Records;

import Models.Elements.Hex.*;
import Models.Manager.HexManager;

import java.util.*;

public final class HexRecord {

    private final Map<Class<? extends Hex>, List<Hex>> elements;
    private final Map<HexCoordinate, Hex> coordinates = new HashMap<>();
    private final List<Hex> allHexes = new ArrayList<>();
    private HexManager hexManager;

    public HexRecord() {
        elements = new HashMap<>();
        elements.put(ForestHex.class,   new ArrayList<>());
        elements.put(LandHex.class,     new ArrayList<>());
        elements.put(MountainHex.class, new ArrayList<>());
        elements.put(GrassHex.class,    new ArrayList<>());
        elements.put(SeaHex.class,      new ArrayList<>());
        elements.put(BergHex.class,     new ArrayList<>());
    }


    public void setHexManager(HexManager hexManager) {
        this.hexManager = hexManager;
    }

    public void add(Hex hex) {

        if (hex == null) return;
        HexCoordinate coordinate = new HexCoordinate(hex.getQ(), hex.getR());
        if (coordinates.containsKey(coordinate)) return;
        List<Hex> list = elements.computeIfAbsent(hex.getClass(), k -> new ArrayList<>());
        list.add(hex);
        coordinates.put(coordinate, hex);
        allHexes.add(hex);
        if (hexManager != null) {
            hexManager.onHexAdded(hex);
        }
    }

    public void remove(Hex hex) {
        if (hex == null) return;
        List<Hex> list = elements.get(hex.getClass());
        if (list != null) list.remove(hex);
        coordinates.remove(new HexCoordinate(hex.getQ(), hex.getR()));
        allHexes.remove(hex);
    }

    public List<Hex> getAll(Class<? extends Hex> clazz) {
        List<Hex> list = elements.get(clazz);
        return list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
    }

    public List<Hex> getAll() {
        return Collections.unmodifiableList(allHexes);
    }

    public Hex create(Hex hex) {
        add(hex);
        return hex;
    }


    public List<Hex> getNeighbors(Hex hex) {

        int[][] directions = {
                {1, 0}, {-1, 0},
                {0, 1}, {0, -1},
                {1, -1}, {-1, 1}
        };

        List<Hex> neighbors = new ArrayList<>();
        for (int[] dir : directions) {
            Hex neighbor = getByQR(hex.getQ() + dir[0], hex.getR() + dir[1]);
            if (neighbor != null) neighbors.add(neighbor);
        }
        return neighbors;
    }

    public Hex getByQR(int q, int r) {
        return coordinates.get(new HexCoordinate(q, r));
    }

    public record HexCoordinate(int q, int r) { }
}
