package Game.Server.Systems.EventSystem.Events;

import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.RelationshipChangeReason;

/** Immutable diplomacy update for panels, notifications, and future replay/save integration. */
public record RelationshipChangedEvent(Tribe tribe, int previousValue, int currentValue,
                                       RelationshipChangeReason reason) implements Event { }
