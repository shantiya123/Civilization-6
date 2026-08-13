package Models.Logic.UnitLogic;

import Game.World;
import Models.Elements.Hex.Hex;
import Models.Logic.HexLogic.HexLogic;
import Models.Logic.SeasonLogic.SeasonLogic;
import Models.Records.HexRecord;

import java.util.*;
import java.util.function.Predicate;

public class FindBestPath {

    private final HexRecord hexRecord;

    private final Hex start;
    private final Hex goal;

    private int totalCost = -1;

    private final World world;

    public FindBestPath(World world, Hex start, Hex goal) {
        this.hexRecord = world.getHexRecord();
        this.start = start;
        this.goal = goal;
        this.world = world;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public boolean canReach(int maxCost) {
        return !findPath(maxCost).isEmpty();
    }

    public List<Hex> findPath(int maxCost) {
        return findPath(maxCost, hex -> true);
    }

    /**
     * Finds a route using a planning budget independent of a unit's current AP.
     * The caller supplies terrain/faction passability rules; no unit state is changed.
     */
    public List<Hex> findPath(int maxCost, Predicate<Hex> canEnter) {

        totalCost = -1;

        if (start == null || goal == null || canEnter == null)
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

            for (Hex neighbor : HexLogic.getNeighbors(world, current.hex)) {

                if (neighbor == null || !canEnter.test(neighbor))
                    continue;

                int transitionCost = neighbor.getMovementCost()
                        + SeasonLogic.forCurrentSeason(world).getMovementCostModifier(neighbor)
                        + HexLogic.getBorderTransitEffect(world, current.hex, neighbor);
                int newCost = current.cost + Math.max(0, transitionCost);

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
    public int CalculateTotalCost(){
        findPath(70);
        return totalCost;
    }
}
