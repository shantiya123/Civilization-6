package Models;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Model {

    private static final AtomicInteger NEXT_ID = new AtomicInteger(1);

    private int id;
    private boolean idAssigned;

    /**
     * Assigns a fresh, process-unique id to this instance. Called once from
     * each concrete subclass constructor. Safe to call again (e.g. by
     * mistake from a subclass hierarchy) - it will not overwrite an id that
     * was already assigned.
     */
    public void generateID() {
        if (!idAssigned) {
            id = NEXT_ID.getAndIncrement();
            idAssigned = true;
        }
    }

    public int getId() {
        return id;
    }

    /**
     * Overrides this instance's id. Intended for Save & Load: after
     * reconstructing an object via its normal constructor (which assigns a
     * fresh runtime id via {@link #generateID()}), the loader restores the
     * id that was persisted in the save file so identity is stable across a
     * save/load round trip.
     */
    public void setId(int id) {
        this.id = id;
        this.idAssigned = true;
    }

    /**
     * Advances the process-wide id counter so that ids generated after a
     * load (e.g. newly created units) never collide with ids restored from
     * a save file. The loader should call this once with the highest id
     * found in the save file.
     */
    public static void ensureNextIdAtLeast(int minimumNextId) {
        NEXT_ID.updateAndGet(current -> Math.max(current, minimumNextId));
    }
}