# CODEX_WORKFLOW.md

# Civilization 6 Phase 2 — Codex Workflow and Responsibilities

This document defines exactly how development will work in this repository.

Read this file before performing any task.

## Project Context

This repository is a Java Civilization 6 clone built as a university project.

Phase 1 already exists.

Phase 2 will be implemented incrementally.

The primary goal is **a clean, understandable architecture that can be explained in a technical interview**.

## Roles

### Repository Owner

The repository owner is the **architect**.

The owner defines:

* architecture
* package structure
* model structure
* gameplay rules
* documentation
* feature specifications

### Codex

Codex is the **implementation engineer**.

Codex implements exactly what is requested.

Codex must not make architectural decisions.

## Source of Truth

The project documentation is authoritative.

Priority order:

1. docs/PHASE2.md
2. docs/ARCHITECTURE.md
3. docs/DECISIONS.md
4. docs/MODEL_RULES.md
5. Feature specification documents
6. Existing repository code

If code conflicts with documentation, the documentation wins.

## Task Groups (TG)

All work is organized into **Task Groups (TG)**.

Examples:

* TG001 — Unit Models
* TG002 — City Models
* TG003 — Tribe Relations
* TG004 — Trade System

A TG contains:

* the relevant documentation
* the required files
* the implementation boundaries
* the expected deliverables

Codex should treat each TG as an isolated implementation unit.

## Required Workflow For Every TG

### Step 1 — Read

Read all documents referenced by the TG.

### Step 2 — Documentation Validation

Compare the TG specification with the main project documentation.

If any documentation conflict exists:

* stop immediately
* explain the conflict
* identify the conflicting documents
* provide possible resolutions
* do not modify code

### Step 3 — Repository Validation

Compare the approved specification with the current repository.

Detect:

* naming conflicts
* type conflicts
* package conflicts
* relationship conflicts
* API conflicts

Minor compatibility fixes are allowed.

Architectural changes are not allowed.

### Step 4 — Implementation

Implement the TG with the smallest possible change set.

Requirements:

* preserve package structure
* preserve architecture
* preserve existing systems
* avoid unnecessary refactoring
* avoid new abstractions
* avoid new patterns unless specified

Implement only what the TG requests.

### Step 5 — Report

After implementation, produce a complete report.

## Implementation Report Format

# TG Report

## Task Group

TG001 — Unit Models

## Documents Read

* docs/PHASE2.md
* docs/ARCHITECTURE.md
* docs/MODEL_RULES.md
* docs/units.md

## Files Created

* Game/Models/Units/Unit.java
* Game/Models/Units/UnitType.java

## Files Modified

* Game/Models/Player.java

## Documentation Conflicts

* none

## Repository Conflicts Detected

1. Player previously referenced Soldier instead of Unit

## Repository Conflicts Resolved

1. Replaced Soldier references with Unit

## Architecture Changes

None

## Summary

Implemented Unit model exactly as specified.

## Architectural Boundaries

Codex may:

* create classes
* add fields
* add constructors
* add methods
* update enums
* perform small compatibility refactors

Codex may not:

* redesign architecture
* move packages
* rename major components
* introduce frameworks
* introduce dependency injection
* introduce new architectural patterns
* replace EventBus
* refactor unrelated code

## EventBus

The EventBus already exists.

Rules:

* Systems publish events.
* Systems subscribe to events.
* Controllers call Systems directly.
* Controllers do not publish gameplay events.

Do not create another event system.

## Models

Models should remain mostly data-oriented.

Models may contain:

* state
* relationships
* validation
* helper methods

Models should not contain:

* combat logic
* movement logic
* AI logic
* turn processing
* rendering logic
* controller logic

## Systems

Gameplay rules belong inside Systems.

Cross-entity mutations belong inside Systems.

Systems communicate through EventBus.

## Controllers

Controllers are thin.

Controllers translate user actions into System calls.

Controllers should not contain gameplay rules.

## Views

Views display state and play animations.

Views should never modify game state directly.

## If Something Is Unclear

Never guess.

Stop and ask for clarification.

Assumptions are forbidden when they affect:

* architecture
* gameplay rules
* data relationships
* public APIs
* package structure

## Final Principle

The owner designs.

Codex implements.

When in doubt, preserve the existing architecture and wait for instructions.
