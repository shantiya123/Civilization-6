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
