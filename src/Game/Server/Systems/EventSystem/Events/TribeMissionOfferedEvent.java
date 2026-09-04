package Game.Server.Systems.EventSystem.Events;

import Models.Elements.Tribes.Missions.Mission;
import Models.Elements.Tribes.Tribe;

/** Published when a tribe has made one of its missions available to the player. */
public record TribeMissionOfferedEvent(Tribe tribe, Mission mission) implements Event {
}
