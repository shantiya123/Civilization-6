package Models.Logic.UnitLogic;

import Game.Generate;
import Models.Elements.Hex.Hex;
import Models.Logic.HexLogic.HexLogic;
import Models.Records.HexRecord;

import java.util.*;

public class FindBestPath {
    private HexRecord hexRecord = Generate.getGame().getWorld().getHexRecord();
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

    public List<Hex> findPath() {

        // Reset before each search
        totalCost = -1;

        if (start == null || goal == null)
            return Collections.emptyList();

        List<Hex> existingHexes = hexRecord.getAll();

        if (!existingHexes.contains(start) || !existingHexes.contains(goal))
            return Collections.emptyList();

        PriorityQueue<PathNode> queue =
                new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));

        Map<Hex, Integer> distance = new HashMap<>();

        queue.add(new PathNode(start, 0, null));
        distance.put(start, 0);

        while (!queue.isEmpty()) {

            PathNode current = queue.poll();

            if (current.hex.equals(goal)) {

                // Save the total movement cost
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

                int newCost = current.cost + neighbor.getMovementCost();

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
}