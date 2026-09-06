package Game.Client.Managers;

import Game.Client.Systems.DrawingSystem;
import Game.Client.Controllers.ClientCommandDispatcher;
import Game.Client.Presentation.DrawingState;
import Game.World;
import Base.Network.ClientCommand;
import Models.Elements.Buildable.Buildings.TownHall;
import Models.Elements.Ownership.PlayerOwner;
import Base.Network.LobbyChatMessage;
import Game.Client.Systems.EventSystem.Listeners.SelectListener;

/** Long-lived client presentation bound to a replaceable synchronized replica. */
public final class ClientGameSession {
    private final DrawingSystem drawing;
    private final ClientControllerManager controllers;
    private final ViewManager view;
    private final Game.Server.Managers.TurnManager turnManager;
    private final ClientCommandDispatcher commands;
    private final DrawingState drawingState;
    private World pendingReplica;
    private boolean movementAnimationRunning;
    private final String playerToken;
    private final SelectListener presentationSelection;

    ClientGameSession(DrawingSystem drawing, ClientControllerManager controllers, ViewManager view,
                      Game.Server.Managers.TurnManager turnManager,
                      ClientCommandDispatcher commands, DrawingState drawingState, SelectListener presentationSelection,
                      String playerToken) {
        this.drawing = drawing;
        this.controllers = controllers;
        this.view = view;
        this.turnManager = turnManager;
        this.commands = commands;
        this.drawingState = drawingState;
        this.playerToken = playerToken;
        this.presentationSelection = presentationSelection;
    }

    public void replaceReplica(World world) {
        if (movementAnimationRunning) {
            pendingReplica = world;
            return;
        }
        installReplica(world);
    }

    /** Executes a server-originated presentation command, never gameplay logic. */
    public void dispatch(ClientCommand command) {
        if (commands.dispatch(command, this::clearMovementPreview, this::movementAnimationFinished)) {
            movementAnimationRunning = true;
        }
    }

    private void clearMovementPreview() {
        drawingState.clearMovementPreview();
        controllers.getBoardController().clearMoveReadiness();
    }

    private void movementAnimationFinished() {
        movementAnimationRunning = false;
        if (pendingReplica != null) {
            World next = pendingReplica;
            pendingReplica = null;
            installReplica(next);
        } else {
            view.refresh();
        }
    }

    private void installReplica(World world) {
        selectLocalTownHall(world);
        drawing.replaceWorld(world);
        presentationSelection.replaceWorld(world);
        controllers.replaceWorld(world);
        commands.replaceWorld(world);
        view.replaceWorld(world);
        view.refresh();
    }

    private void selectLocalTownHall(World world) {
        if (playerToken == null) return;
        world.getBuildingRecord().getAll(TownHall.class).stream()
                .filter(TownHall.class::isInstance)
                .map(TownHall.class::cast)
                .filter(hall -> hall.getOwner() instanceof PlayerOwner player
                        && playerToken.equals(player.getToken()))
                .findFirst().ifPresent(world::setTownHall);
    }
    public void updateTurn(int round, String activePlayer) {
        turnManager.setTurns(round);
        turnManager.setActivePlayerName(activePlayer);
        view.refresh();
    }
    public void receiveChat(LobbyChatMessage message) { view.receiveChat(message); }
    public void receiveSystemMessage(String text) { view.receiveSystemMessage(text); }
}
