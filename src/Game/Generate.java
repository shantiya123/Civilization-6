package Game;

public class Generate {
    private static Game game;
    private static World bootstrapWorld; // used only while Game/World are still being constructed

    public static synchronized Game getGame() {
        if (game == null) game = new Game();
        return game;
    }

    /** Creates the authoritative host session for a new multiplayer lobby. */
    public static synchronized Game createFreshLobbyGame() {
        if (game != null) {
            game.getClientServerManager().disconnect();
            game.getSystemManager().stopNetworking();
        }
        game = new Game(false);
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
