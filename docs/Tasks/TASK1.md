# TASK1.md

# Task 1 — Server-Side Change Tracking Infrastructure

## Objective

Prepare the existing Civilization 6 project for future client-server synchronization.

The purpose of this task is to introduce a server-side mechanism that records which Models were:

- Created.
- Modified.
- Deleted.

This task does **not** implement networking or synchronization.

---

# Phase 0 — Repository and Documentation Investigation

Before changing any code, inspect the complete project environment.

GPT Pro must:

1. Inspect the repository structure.
2. Read all provided documentation.
3. Inspect existing architecture.
4. Inspect `World`.
5. Inspect `WorldState`.
6. Inspect `Model`.
7. Inspect all relevant Records.
8. Inspect Logic classes.
9. Inspect Systems.
10. Inspect Controllers where necessary.
11. Inspect existing save/load behavior.
12. Inspect the existing Model ID mechanism.
13. Search for direct Model mutations.
14. Search for existing mechanisms that could overlap with ChangeTracker.

The implementation must be based on the actual repository rather than assumptions.

---

# Phase 1 — Understand World State

Inspect `World` and classify its fields into:

### A. Global Game State

State shared by the game/server as a whole.

Examples may include:

- Map.
- Global records.
- Global season.
- Other shared game state.

Do not assume a field is global without checking its usage.

### B. Player-Specific State

State belonging to an individual player.

Examples may include:

- Combat unit cap.
- Happiness.
- Player-specific capabilities.
- Other player-specific mutable state.

These belong conceptually to `WorldState`.

### C. Infrastructure

Objects used to operate the game rather than representing synchronized game state.

Examples may include:

- Managers.
- Calculators.
- Utility classes.
- Access helpers.

Do not automatically synchronize these objects.

---

# Phase 2 — WorldState

Inspect the current implementation of `WorldState`.

Ensure that:

```text
WorldState extends Model
```

If it already does, preserve it.

If it does not, make the minimum required change.

Ensure that `WorldState` can represent player-specific state.

Do not blindly move every field currently inside `World`.

For each candidate field, inspect:

- Who reads it?
- Who writes it?
- Is it shared between players?
- Is it authoritative game state?
- Does it logically belong to one player?

Only move fields when the repository confirms that they are player-specific.

---

# Phase 3 — ChangeTracker

Create a dedicated ChangeTracker.

The conceptual structure is:

```java
public class ChangeTracker {

    private Set<Model> created;
    private Set<Model> modified;
    private Set<Model> deleted;

    ...
}
```

The collections must be Sets.

They must contain Models rather than specific subclasses.

The tracker should provide operations equivalent to:

```java
markCreated(Model model)
markModified(Model model)
markDeleted(Model model)
```

and access to the current change sets.

The exact API may be improved if it remains compatible with the architecture.

---

# Phase 4 — Change Transition Rules

Implement correct transition behavior.

## Created → Modified

If an object is created and then modified before synchronization:

```text
created = object
modified = object
```

must result in:

```text
created = object
modified = not present
```

The client does not need a separate modification because it never received the object before synchronization.

---

## Created → Deleted

If an object is created and then deleted before synchronization:

```text
created = object
```

followed by:

```text
deleted = object
```

must result in:

```text
created = not present
deleted = not present
```

The client never received the object, so there is nothing to delete remotely.

---

## Modified → Deleted

If an existing object is modified and then deleted:

```text
modified = object
```

followed by:

```text
deleted = object
```

must result in:

```text
modified = not present
deleted = object
```

---

## Repeated Modification

If the same object is modified multiple times:

```text
markModified(object)
markModified(object)
markModified(object)
```

the object should appear only once in the modified Set.

---

# Phase 5 — Integrate ChangeTracker Into World

`World` is the authoritative server-side game-state container.

Add a ChangeTracker to `World`.

Conceptually:

```java
private ChangeTracker changeTracker;
```

and provide access to it.

The tracker should be initialized correctly for every valid `World` construction path.

Do not introduce networking.

Do not serialize the tracker.

Do not send anything anywhere.

---

# Phase 6 — Existing Model ID System

Inspect the existing Model ID mechanism.

The project already has Model IDs.

Do not replace the mechanism.

Verify that created Models receive IDs correctly.

Verify that deleted Models retain their IDs long enough for future synchronization to identify them.

If the existing ID system has a problem relevant to this task, fix only the minimum necessary issue and document it.

---

# Phase 7 — Inspect Logic Architecture

Inspect the Logic layer.

The intended mutation architecture is:

```text
Controller
      ↓
System
      ↓
Logic
      ↓
Model
```

Logic is responsible for authoritative model changes.

Change tracking should therefore be integrated into Logic rather than Model setters.

Do not modify every Model class to become aware of World or ChangeTracker.

---

# Phase 8 — Do NOT Yet Add Tracking Everywhere

This task establishes the infrastructure.

Do not blindly add:

```java
markModified(...)
```

to every Logic class in this task unless `task1.md` is explicitly extended to include that work.

The next task will integrate tracking into the actual game operations.

However, while inspecting the repository, GPT Pro must understand where those changes will eventually be needed.

---

# Phase 9 — Inspect Systems for Architectural Violations

Search the Systems for direct Model mutation.

Examples include:

```java
unit.setSomething(...)
building.setSomething(...)
hex.setSomething(...)
worldState.setSomething(...)
```

inside Systems.

If a System directly mutates a Model:

1. Determine whether the mutation is authoritative.
2. Determine whether an existing Logic class should own it.
3. If the correction is small and clearly within the task's scope, move it into Logic.
4. If fixing it requires a broad refactor, do not perform the broad refactor.
5. Document it in the final report.

The important rule is:

> Do not solve a System → Model architectural violation by simply adding ChangeTracker calls to the System.

The intended final architecture is:

```text
System
   ↓
Logic
   ↓
Model mutation
   ↓
ChangeTracker
```

---

# Phase 10 — ClientWorld Preparation

Inspect the current repository and determine what data a future ClientWorld needs.

Do not implement the entire client-server architecture in this task.

The agreed design is:

```text
World
    = authoritative server state

ClientWorld
    = client-side state/snapshot
```

`ClientWorld` should eventually contain the game state required for rendering and client interaction.

It should include `Hexutils`, because the client needs hex-related calculations.

It should not blindly duplicate server-only infrastructure.

If implementing the actual `ClientWorld` class is necessary for the current repository structure, make only the minimal compatible implementation.

If it is not required for ChangeTracker infrastructure, do not force an unnecessary implementation into Task 1.

Document the decision.

---

# Phase 11 — No Networking

Absolutely do not implement:

- Server sockets.
- Client sockets.
- HTTP.
- WebSockets.
- JSON packets.
- Packet classes.
- Network serializers.
- Network handlers.
- Synchronization endpoints.
- Client-server message queues.

The only thing being created now is the data required to know what changed.

---

# Phase 12 — Preserve Gameplay

After implementation, gameplay behavior must remain unchanged.

ChangeTracker is observational infrastructure.

It records changes but should not alter the actual operation of the game.

For example:

```text
Unit is created
    ↓
Unit is added normally
    ↓
Unit is marked CREATED
```

The Unit creation itself must behave exactly as before.

---

# Phase 13 — Better Solutions

GPT Pro is allowed to discover a better implementation.

If the better solution:

- Fits the existing architecture.
- Does not contradict documentation.
- Does not unnecessarily expand the scope.

then GPT Pro may implement it.

If it conflicts with an existing architectural decision:

**Do not implement it.**

Instead add it to the final report under:

```text
Potential Future Improvements
```

Explain:

1. What the alternative is.
2. Why it may be better.
3. What current decision it conflicts with.
4. What future task could address it.

---

# Phase 14 — Verification

After implementation:

### Compilation

Compile the complete project.

### Tests

Run relevant tests if they exist.

### Static Inspection

Inspect the final changes and verify:

- ChangeTracker is correctly connected to World.
- Sets are used.
- Duplicate changes are prevented.
- Created/modified/deleted transitions are correct.
- Model IDs remain functional.
- Existing gameplay behavior is preserved.
- No networking was accidentally introduced.
- No unrelated files were modified unnecessarily.

---

# Required Final Report

GPT Pro must finish with a detailed implementation report.

Use this structure:

## 1. Summary

Short explanation of what was implemented.

## 2. Files Changed

For every modified file:

```text
File:
Change:
Reason:
```

## 3. Files Created

For every created file:

```text
File:
Purpose:
```

## 4. ChangeTracker Design

Explain:

- Created Set.
- Modified Set.
- Deleted Set.
- Transition rules.
- How duplicate changes are handled.

## 5. World Integration

Explain how ChangeTracker is connected to `World`.

## 6. WorldState

Explain:

- Whether `WorldState` was changed.
- Which fields were moved, if any.
- Why those fields are player-specific.

## 7. Logic

Explain any Logic changes.

## 8. Systems

List the Systems inspected.

For every direct Model mutation discovered:

```text
System:
Mutation:
Fixed:
How:
```

If not fixed:

```text
Reason:
Recommended future task:
```

## 9. ClientWorld

Explain what was decided about ClientWorld and why.

## 10. Documentation Compatibility

Explain whether the implementation is compatible with the provided documentation.

If there was a conflict, explain it explicitly.

## 11. Alternative Solutions

List any better solutions discovered but not implemented because they conflict with the current architecture.

## 12. Verification

Report:

- Compilation result.
- Test result.
- Other verification performed.

Do not claim success without actually checking it.

## 13. Remaining Work

Clearly separate work that belongs to later tasks.

In particular, future work may include:

```text
Logic → ChangeTracker integration
        ↓
Change serialization
        ↓
Server → Client transport
        ↓
ClientWorld
        ↓
Client-side change application
```

Do not implement those future stages as part of Task 1.