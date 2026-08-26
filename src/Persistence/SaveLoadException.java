package Persistence;

/**
 * Reports a failure to save or load a game. Covers: the file not existing or
 * not being readable/writable, malformed or non-JSON content, missing
 * required fields, an unrecognized save version, and object references in
 * the save file that cannot be resolved (e.g. a unit's hex id that does not
 * appear anywhere in the "hexes" section).
 *
 * Per the Save & Load design (section 11), the original game state must
 * never be silently replaced by a partially loaded or corrupted one:
 * SaveManager.load either returns a fully reconstructed World or throws -
 * it never returns a half-built one.
 */
public class SaveLoadException extends Exception {
    public SaveLoadException(String message) {
        super(message);
    }

    public SaveLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}