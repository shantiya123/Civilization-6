# RULES.md

# Repository Rules

These rules are mandatory.

## General

* Keep changes minimal.
* Preserve existing behavior.
* Modify only files required for the task.
* Do not add external dependencies.
* Do not perform cleanup unrelated to the task.

## Documentation First

If the specification is unclear:

* ask for clarification,
* do not guess,
* do not invent gameplay values.

## Models

Models contain:

* state
* relationships
* simple validation
* convenience helpers

Models do not contain:

* combat resolution
* pathfinding
* AI
* turn processing
* rendering
* controller logic
* UI logic

## Systems

Systems contain gameplay rules.

Systems may mutate models.

After successful state changes, systems may publish EventBus events.

## Controllers

Controllers receive user input.

Controllers call systems directly.

Controllers remain thin.

## Views

Views only display game state and play animations.

Views never modify game state directly.

## Events

Events describe completed actions.

Good:

* UnitMovedEvent
* TurnEndedEvent
* CityFoundedEvent

Bad:

* MoveUnitCommand
* AttackRequest

Commands go directly to systems.

Events go through EventBus.

## Patterns

Allowed when explicitly specified:

* Strategy
* State
* Command
* Factory Method
* EventBus / Observer

Do not introduce additional patterns without approval.

## Refactoring

Minor compatibility refactors are allowed.

Architectural refactors are forbidden unless explicitly requested.

## Reporting

Every task must end with:

* files created
* files modified
* documentation conflicts
* repository conflicts
* conflicts resolved
* remaining issues
* architecture changes (should normally be "none").
