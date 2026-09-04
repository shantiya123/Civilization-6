package Game.Client.Views;

import Game.Server.Managers.TurnManager;
import Game.World;
import Persistence.SaveLoadException;
import Persistence.SaveManager;

import javax.swing.JOptionPane;
import java.awt.Component;

/** Persists the current game when the window is closed. */
final class GameStateSaver {

    private final Component parent;
    private final World world;
    private final TurnManager turnManager;

    GameStateSaver(Component parent, World world, TurnManager turnManager) {
        this.parent = parent;
        this.world = world;
        this.turnManager = turnManager;
    }

    void save() {
        try {
            new SaveManager().save(world, turnManager.getTurns(), SaveManager.DEFAULT_SAVE_FILE);
        } catch (SaveLoadException exception) {
            JOptionPane.showMessageDialog(parent,
                    "Could not save the game: " + exception.getMessage(),
                    "Save Failed", JOptionPane.WARNING_MESSAGE);
        }
    }
}
