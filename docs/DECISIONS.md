# DECISIONS.md

# Architecture Decision Log

This file records architectural decisions.

These decisions are binding.

---

## D-001

Controllers call Systems directly.

Reason:

Commands should be explicit and easy to trace.

---

## D-002

Systems communicate with each other through EventBus.

Reason:

Avoid direct system dependencies.

---

## D-003

Models remain mostly data-oriented.

Reason:

Gameplay logic belongs in Systems.

---

## D-004

The EventBus is synchronous.

Reason:

The game is turn-based and deterministic.

---

## D-005

Package structure is considered frozen.

Reason:

Minimize refactoring during Phase 2.

---

## D-006

Documentation has higher priority than existing code.

Reason:

The architecture is defined intentionally and should not drift over time.

---

## D-007

Codex is not allowed to make architectural decisions.

Reason:

Architecture is designed by the repository owner and documented here.

---

## D-008 — Client/server responsibility boundary

The server is the referee and owns the authoritative `World`. The client is
the player's local window and owns interaction and presentation state. A
client asks the server to perform an authoritative action; the server validates
that action, changes `World` through its systems/logic, records the result in
`ChangeTracker`, and later synchronizes the resulting game-state delta to the
client's `ClientWorld`.

The architecture is therefore:

```text
Client input/UI -> Client EventBus -> Client systems -> command/request
    -> network -> Server EventBus -> Server systems -> Logic -> World
    -> ChangeTracker -> network -> ClientWorld -> rendering
```

The client and server have separate local EventBus instances. An EventBus is
not a network transport and must not decide whether an event crosses the
network boundary.

Client-owned responsibilities include selection and interaction state
(`selectedUnit`, `selectedHex`, `selectedBorder`, hover state and movement
preview), camera/view state, zoom, panning, drawing, presentation state, and
notification display. Pointer movement, clicks used solely for selection,
camera changes, hover, zoom, and pan must stay local; they are not network
requests. `BoardSystem` must be classified by its actual behavior: its
presentation/camera work is client-side, while any authoritative rule must be
invoked as an explicit server command.

The server owns authoritative movement, combat, building, production,
technology, turn, diplomacy, territory, resource, unit, and building rules.
The client sends commands with stable identifiers (for example,
`MoveUnitRequest(unitId, destinationHexId)`), never arbitrary model mutations
or UI-selection state. The server independently resolves those identifiers in
its own `World` and validates every request.

`DrawingState`, `ViewState`, `ConnectDrawing`, and `ConnectViews` are
client-only presentation infrastructure. `ClientWorld` is only the data needed
to render and interact; it must not become a second authoritative world.

Migration preserves the existing `EventBus -> System -> Logic -> Model` flow.
The change is primarily where a responsibility executes, not a rewrite of its
gameplay implementation.
