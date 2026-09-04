package Game.Server.Systems.EventSystem.Events;

import Models.Elements.Hex.Hex;
import Models.Elements.Tribes.Tribe;
import Models.Elements.Units.CombatUnits.CombatUnit;

/** Published after a tribe creates its no-cost defensive guard. */
public record TribeGuardProducedEvent(Tribe tribe, CombatUnit guard, Hex spawnHex) implements Event { }
