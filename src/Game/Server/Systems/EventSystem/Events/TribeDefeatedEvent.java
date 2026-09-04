package Game.Server.Systems.EventSystem.Events;

import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.TribeDefeatLoot;

/** Published after a war command destroys a tribe camp and defeats its tribe. */
public record TribeDefeatedEvent(Tribe tribe, TribeDefeatLoot loot) implements Event {
}
