# AGENTS.md

## Purpose

This repository is a Java Civilization 6 clone.

The current task is part of the transition from the existing local architecture toward a client-server architecture.

The goal of this task is **not** to implement networking.

The goal is to prepare the existing architecture for future synchronization by introducing authoritative change tracking on the server side.

---

## Role of GPT Pro

GPT Pro is responsible for implementing the task described in `task1.md`.

Before modifying anything, GPT Pro **must inspect the entire relevant project environment**.

This includes:

1. The complete repository structure.
2. Existing Java source code.
3. Existing documentation.
4. Existing architecture and design documents.
5. Existing rules and conventions.
6. Existing `Model` classes.
7. `World`.
8. `WorldState`.
9. Records.
10. Logic classes.
11. Systems.
12. Controllers.
13. Any existing save/load mechanisms.
14. Any existing ID mechanisms.
15. Any code that could conflict with the requested architecture.

The provided documentation is authoritative for the existing project design unless this task explicitly changes a requirement.

---

## Documentation First

Before implementing anything, GPT Pro must read all documentation provided with the task.

The documentation should be used to understand:

* Existing architecture.
* Existing responsibilities.
* Existing naming conventions.
* Existing design decisions.
* Existing restrictions.
* Existing assumptions.
* Planned future architecture.

Do not modify the architecture simply because another architecture appears cleaner.

If a better implementation exists and it is compatible with the current architecture, GPT Pro may use it.

If the better implementation requires changing an agreed architectural decision, GPT Pro must **not silently make that change**.

Instead:

1. Keep the implementation compatible with the current architecture.
2. Document the alternative in the final report.
3. Explain why it may be better.
4. Leave it as a future architectural decision.

---

## Minimal-Change Principle

This project is already implemented.

Therefore:

> Do not rewrite working code unless the task explicitly requires it.

GPT Pro should make the smallest reasonable changes necessary to implement the requested functionality.

Do not:

* Rename unrelated classes.
* Reorganize packages unnecessarily.
* Rewrite working systems.
* Rewrite working logic.
* Replace existing architecture without justification.
* Introduce unnecessary frameworks.
* Introduce networking.
* Introduce serialization protocols.
* Introduce unnecessary abstractions.

Preserve existing behavior.

---

## Architectural Principle

The server's `World` is authoritative.

The future architecture will contain:

```text
Server
    World
       |
       +-- authoritative game state
       |
       +-- ChangeTracker
              |
              +-- created
              +-- modified
              +-- deleted

Client
    ClientWorld
       |
       +-- client-side game-state copy
```

This task only implements the server-side preparation.

Actual communication between server and client is a later task.

---

## Model IDs

Models already have an ID mechanism.

IDs are important because future synchronization will identify objects by ID rather than relying on object references.

Do not replace the existing ID system unless there is a concrete bug preventing this task from working.

---

## Change Ownership

The authoritative game-state mutation flow should remain:

```text
Controller
    ↓
System
    ↓
Logic
    ↓
Model
```

Systems should coordinate operations.

Logic classes should perform authoritative model mutations.

Therefore change tracking should normally happen in the **Logic layer**, immediately when authoritative state is changed.

Do not couple every `Model` setter directly to `World` or `ChangeTracker`.

---

## Systems Must Not Directly Mutate Models

While implementing this task, GPT Pro must inspect Systems for direct model mutation.

If a System directly changes a Model, that violates the intended architecture.

Do not merely add a `markModified()` call to the System.

Instead, when practical within the scope of this task:

```text
System
    ↓
Logic
    ↓
Model mutation
    ↓
ChangeTracker
```

The appropriate Logic class should own the mutation.

If fixing the architecture would require a large unrelated refactor, do not expand the task unnecessarily. Report the issue and explain it in the final report.

---

## Player State

`WorldState` represents state specific to a player.

Each player should have its own `WorldState`.

`WorldState` should extend `Model` so that it can participate in the same identification/change-tracking architecture as other models.

Player-specific mutable state should belong to `WorldState` rather than being incorrectly treated as global world state.

Examples include things such as:

* Unit limits/caps.
* Happiness.
* Player-specific capabilities.
* Other state that logically belongs to one player.

However, GPT Pro must inspect the actual implementation before moving fields.

Do not blindly move fields from `World`.

---

## ClientWorld

`ClientWorld` is a future client-side representation of the game state.

It should contain the state required by the client to render and interact with the game.

It should not blindly duplicate server-only infrastructure.

`Hexutils` is explicitly considered client-relevant because the client requires hex-related calculations for rendering/interaction.

Client-only presentation state should remain client-side.

Examples:

* Camera position.
* Zoom.
* Selected hex.
* Selected unit.
* Hover state.
* Menus.
* Animation/UI state.

These are not authoritative game state.

---

## Future Synchronization

The intended future synchronization model is delta-based.

The server will eventually:

```text
Collect changes
      ↓
Serialize changes
      ↓
Send changes
      ↓
Client applies changes
```

The server must not clear changes merely because they were collected.

Future synchronization should clear changes only after successful delivery/acknowledgement according to the synchronization design.

This task does not implement that mechanism.

---

## Final Report Requirement

At the end of the implementation GPT Pro must provide a report containing:

### 1. Files Changed

List every file modified.

For each file explain:

* What changed.
* Why it changed.

### 2. Files Created

List every new file.

Explain its purpose.

### 3. Architecture Changes

Explain any architectural changes made.

### 4. Change Tracking

Explain:

* What objects are marked created.
* What objects are marked modified.
* What objects are marked deleted.
* Where those operations happen.

### 5. Systems

Report every System that was inspected.

If any System directly mutated Models:

* Explain which one.
* Explain whether it was fixed.
* Explain how it was fixed.
* If it was not fixed, explain why.

### 6. Documentation Compatibility

Explain which project documentation was considered and whether the implementation conflicts with any existing design.

### 7. Alternative Improvements

If GPT Pro discovered a better solution that was **not implemented because it would conflict with the agreed architecture**, document it here.

### 8. Verification

Report what was checked after implementation.

At minimum:

* Compilation.
* Relevant tests, if available.
* Existing behavior that was verified.
* Any remaining warnings/errors.

Do not claim something was tested if it was not actually tested.
