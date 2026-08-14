package Models.Logic.NaturalDisasterLogic;

import Game.World;
import Models.Elements.NatrualDisasters.Flood;
import Models.Elements.NatrualDisasters.NaturalDisaster;
import Models.Elements.Seasons.Autumn;
import Models.Logic.Logic;

/** Validates a proposed disaster before it mutates units, buildings, or terrain. */
public final class NaturalDisasterValidator extends Logic {
    public NaturalDisasterValidator(World world) { super(world); }

    public void validate(NaturalDisaster disaster) {
        if (disaster == null || disaster.getHex() == null)
            throw new IllegalArgumentException("A natural disaster needs an origin hex");
        if (disaster instanceof Flood && !(world.getSeason() instanceof Autumn))
            throw new IllegalStateException("Floods can only occur in autumn");

        NaturalDisasterLogic logic = NaturalDisasterLogicFactory.create(world, disaster);
        if (!logic.isPassableLand(disaster.getHex()))
            throw new IllegalStateException(disaster.getClass().getSimpleName() + " cannot start on this hex");
        logic.calculateEffectRadius();
        if (disaster.getEffectRadius().isEmpty())
            throw new IllegalStateException("Natural disaster must affect at least one hex");
    }

    public boolean isValid(NaturalDisaster disaster) {
        try { validate(disaster); return true; }
        catch (IllegalArgumentException | IllegalStateException exception) { return false; }
    }
}
