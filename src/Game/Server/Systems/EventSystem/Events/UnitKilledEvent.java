package Game.Server.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;
import Models.Elements.Units.Unit;

/** Published for every unit removed during a resolved war command. */
public record UnitKilledEvent(Unit unit, Hex defeatedAt) implements Event {
}
