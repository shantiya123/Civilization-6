package Game;

public class Generate {
    private static Game game = new Game();
    private static World bootstrapWorld; // used only while Game/World are still being constructed

    public static Game getGame() {
        return game;
    }


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