package Game;

public class Generate {
    private static Game game = new Game();
    private static World bootstrapWorld; // used only while Game/World are still being constructed

    public static Game getGame() {
        return game;
    }

    // Called once by World's constructor, before it builds any Elements,
    // so Logic classes can resolve records even while Generate's own
    // static init hasn't finished assigning `game` yet.
    public static void publishWorld(World world) {
        bootstrapWorld = world;
    }

    public static World getWorld() {
        if (game != null && game.getWorld() != null) {
            return game.getWorld();
        }
        return bootstrapWorld;
    }
}