package Game.Systems.EventSystem.Events;

import Models.Elements.NatrualDisasters.NaturalDisaster;

/** Published after a natural disaster has applied all of its effects. */
public class NaturalDisasterOccurredEvent implements Event {
    private final NaturalDisaster naturalDisaster;

    public NaturalDisasterOccurredEvent(NaturalDisaster naturalDisaster) {
        this.naturalDisaster = naturalDisaster;
    }

    public NaturalDisaster getNaturalDisaster() {
        return naturalDisaster;
    }
}
