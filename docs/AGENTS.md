# AGENTS.md

# Civilization 6 Project Agent Guide

This repository is a Java Civilization 6 clone built as a university project.

The goal is to implement Phase 2 while keeping the architecture stable and easy to explain in a technical interview.

## Source of Truth

The project documentation is the source of truth.

Priority order:

1. docs/PHASE2.md
2. docs/ARCHITECTURE.md
3. docs/DECISIONS.md
4. docs/MODEL_RULES.md
5. Feature specification files (units.md, cities.md, tribes.md, trade.md, etc.)
6. Existing repository code

If the repository conflicts with the documentation, the documentation wins.

## Agent Role

The agent is an implementation engineer.

The repository owner is the architect.

The agent must not redesign the project.

## Required Workflow

For every task:

### Step 1 — Read

Read all relevant documentation.

### Step 2 — Validate against documentation

Compare the task with the project documents.

If any conflict exists between documents:

* stop,
* explain the conflict clearly,
* suggest possible resolutions,
* do not write code.

### Step 3 — Validate against repository

Compare the approved specification with the current codebase.

Minor implementation conflicts may be resolved.

Architectural conflicts must not be resolved automatically.

### Step 4 — Implement

Implement the task with the smallest possible change set.

### Step 5 — Report

Always produce a complete implementation report.

## What the Agent May Change

Allowed:

* create new classes
* add fields
* add constructors
* add methods
* update enums
* update imports
* perform small compatibility refactors

Not allowed unless explicitly requested:

* move packages
* rename major components
* replace architecture
* introduce frameworks
* introduce new patterns
* refactor unrelated systems

## EventBus

The EventBus already exists.

Do not replace it.

Do not create another event system.

Systems publish events.

Systems subscribe to events.

Controllers do not publish gameplay events.

## Development Order

1. Models
2. Game logic
3. Systems
4. Controllers
5. Views and animations

Do not implement later layers before earlier layers are complete.

## Success Criteria

A task is successful when:

* documentation remains consistent,
* architecture remains unchanged,
* code compiles,
* changes are minimal,
* the implementation is easy to explain in an interview.
