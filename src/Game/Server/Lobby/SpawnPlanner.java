package Game.Server.Lobby;

import java.util.ArrayList;
import java.util.List;

/**
 * Deterministic, map-independent starting-town-hall coordinates.
 *
 * Axial hex coordinates form a ring: all points are exactly {@code radius}
 * from the centre. Evenly spacing player indices around that ring maximises
 * the minimum pairwise distance for the supplied player count. Map loading
 * can generate/validate terrain at these coordinates before Town Halls are
 * created; it must not choose random, adjacent starts afterwards.
 */
public final class SpawnPlanner {
    private SpawnPlanner() { }

    /** Player fields are filled by the lobby once a roster is accepted. */
    public record Spawn(int q, int r, String playerToken, String playerName) {
        public Spawn(int q, int r) { this(q, r, null, null); }
        public Spawn forPlayer(String token, String name) { return new Spawn(q, r, token, name); }
    }

    public static List<Spawn> fairStarts(int playerCount) {
        if (playerCount < 1) throw new IllegalArgumentException("At least one player is required");
        // A larger lobby uses a larger ring so neighbouring starts retain a
        // meaningful travel distance instead of becoming adjacent.
        int radius = Math.max(5, playerCount * 3);
        List<Spawn> ring = ring(radius);
        List<Spawn> starts = new ArrayList<>(playerCount);
        for (int player = 0; player < playerCount; player++) {
            starts.add(ring.get((int) Math.floor((double) player * ring.size() / playerCount)));
        }
        return List.copyOf(starts);
    }

    private static List<Spawn> ring(int radius) {
        // Standard axial ring walk. Every emitted coordinate has exactly the
        // requested cube/hex distance from (0,0).
        int[][] directions = {{-1, 1}, {-1, 0}, {0, -1}, {1, -1}, {1, 0}, {0, 1}};
        List<Spawn> result = new ArrayList<>(radius * 6);
        int q = radius, r = 0;
        for (int[] direction : directions) {
            for (int i = 0; i < radius; i++) {
                result.add(new Spawn(q, r));
                q += direction[0]; r += direction[1];
            }
        }
        return result;
    }
}
