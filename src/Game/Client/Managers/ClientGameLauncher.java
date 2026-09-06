package Game.Client.Managers;

import Animation.WeatherAnimation;
import Game.Client.Presentation.DrawingState;
import Game.Client.Presentation.UnitPanelRegistry;
import Game.Client.Presentation.ViewState;
import Game.Client.Systems.DrawingSystem;
import Game.Client.Systems.SelectSystem;
import Game.Client.Systems.EventSystem.ClientPresentationEventRegistry;
import Game.Client.Controllers.ClientCommandDispatcher;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Ownership.PlayerOwner;
import Game.Server.Managers.TurnManager;
import Game.Server.Systems.EventSystem.EventBus;
import Game.World;

/** Builds a desktop view exclusively from a received client replica. */
public final class ClientGameLauncher {
    private ClientGameLauncher() { }

    public static ClientGameSession show(ClientServerManager connection, World replica) {
        selectLocalTownHall(connection, replica);
        AnimationManager animations = new AnimationManager();
        EventBus clientEvents = new EventBus();
        SelectSystem selection = new SelectSystem(clientEvents);
        DrawingState drawingState = new DrawingState();
        ViewState viewState = new ViewState();
        UnitPanelRegistry unitPanels = new UnitPanelRegistry();
        DrawingSystem drawing = new DrawingSystem(replica, selection, drawingState);
        // This is the client-rendered board, so ambient weather must live in
        // this client's animation loop rather than the server manager's loop.
        animations.play(new WeatherAnimation(drawing.getWeatherEffectDrawer()));
        ClientControllerManager controllers = new ClientControllerManager(
                connection, replica, animations, selection, viewState);
        ClientPresentationEventRegistry.register(clientEvents, animations, drawing,
                drawingState, viewState, replica);
        TurnManager turns = new TurnManager();
        ViewManager view = new ViewManager(drawing, controllers, replica,
                turns, viewState, unitPanels);
        animations.setGameEngine(view.getGameEngine());
        view.StartGame();
        ClientCommandDispatcher commands = new ClientCommandDispatcher(replica, controllers.getAnimationController());
        return new ClientGameSession(drawing, controllers, view, turns, commands, drawingState,
                connection.getSessionToken());
    }

    /** A replica contains every Town Hall; the permanent panel shows its owner's one. */
    private static void selectLocalTownHall(ClientServerManager connection, World world) {
        String token = connection.getSessionToken();
        if (token == null) return;
        world.getBuildingRecord().getAll(TownHall.class).stream()
                .filter(TownHall.class::isInstance)
                .map(TownHall.class::cast)
                .filter(hall -> hall.getOwner() instanceof PlayerOwner player
                        && token.equals(player.getToken()))
                .findFirst().ifPresent(world::setTownHall);
    }
}
