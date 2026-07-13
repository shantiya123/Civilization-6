package Models.Logic.UnitLogic;

import Game.Generate;
import Models.Elements.Hex.Hex;
import Models.Logic.HexLogic.HexLogic;
import Models.Records.HexRecord;

import java.util.*;

public class FindBestPath {

    private final HexRecord hexRecord =
            Generate.getGame().getWorld().getHexRecord();

    private final Hex start;
    private final Hex goal;

    private int totalCost = -1;

    public FindBestPath(Hex start, Hex goal) {
        this.start = start;
        this.goal = goal;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public boolean canReach(int maxCost) {
        return !findPath(maxCost).isEmpty();
    }

    public List<Hex> findPath(int maxCost) {

        totalCost = -1;

        if (start == null || goal == null)
            return Collections.emptyList();

        List<Hex> existing = hexRecord.getAll();

        if (!existing.contains(start) || !existing.contains(goal))
            return Collections.emptyList();

        PriorityQueue<PathNode> queue =
                new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));

        Map<Hex, Integer> distance = new HashMap<>();

        queue.add(new PathNode(start, 0, null));
        distance.put(start, 0);

        while (!queue.isEmpty()) {

            PathNode current = queue.poll();

            // Dijkstra optimization
            if (current.cost > maxCost)
                break;

            if (current.hex.equals(goal)) {

                totalCost = current.cost;

                ArrayList<Hex> path = new ArrayList<>();

                while (current != null) {
                    path.add(0, current.hex);
                    current = current.previous;
                }

                return path;
            }

            for (Hex neighbor : HexLogic.getNeighbors(current.hex)) {

                if (neighbor == null)
                    continue;

                int newCost =
                        current.cost + neighbor.getMovementCost();

                // AP optimization
                if (newCost > maxCost)
                    continue;

                Integer oldCost = distance.get(neighbor);

                if (oldCost == null || newCost < oldCost) {

                    distance.put(neighbor, newCost);

                    queue.add(new PathNode(
                            neighbor,
                            newCost,
                            current
                    ));
                }
            }
        }

        return Collections.emptyList();
    }
    public List<Hex> bestPath(int maxCost) {

        if (!canReach(maxCost))
            return Collections.emptyList();

        return findPath(maxCost);
    }
}