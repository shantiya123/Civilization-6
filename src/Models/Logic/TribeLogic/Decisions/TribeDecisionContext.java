package Models.Logic.TribeLogic.Decisions;

import Game.Server.Systems.EventSystem.EventBus;
import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.TerritoryIntrusionResult;

/** Immutable facts for choosing and executing exactly one active tribe action. */
public record TribeDecisionContext(World world, EventBus eventBus, Tribe tribe,
                                   TerritoryIntrusionResult intrusion, int turnNumber) {
}
