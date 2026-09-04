# Graphics and Panel Design

This document is the required design contract for new graphics, Swing panels,
and panel-related UI code. Read it before implementing or changing UI work.

## Scope

The project uses MVC-style boundaries:

```text
View Panel -> Panel State -> Controller -> System -> Model/Logic
                                 ^
                    EventBus / ViewState refreshes the View
```

## Required Panel Structure

Every feature panel has a focused pair:

* `XxxPanel` is a Swing view. It builds controls, renders values from its state,
  and refreshes itself. It contains no gameplay rule or model mutation.
* `XxxState` is the panel's view model. It exposes display-ready values and
  user-intent methods. It stores only UI state required by that panel and holds
  the corresponding controller reference.
* `XxxController` translates the state method into one system call. It does not
  contain gameplay rules, mutate models directly, or publish gameplay events.

The existing `UnitPanel -> UnitPanelState -> UnitPanelController` and
`HUDPanel -> HUDState -> HUDController` flows are the reference implementations.

## Responsibility Rules

### Views and draw classes

* Read only from their State or supplied render model.
* Never call a `System`, `Logic`, `World`, or record directly.
* Never change gameplay state.
* Keep painting separate from user interaction wiring where practical.
* Respect presentation rules already held by models, such as Fog of War
  visibility.

### Panel states

* Convert model/system information into values suitable for the view.
* Own panel-only selection, tabs, expanded/collapsed state, and formatting.
* Expose named intent methods such as `requestTrade()` or `selectMission()`;
  views must not know system method names.
* Delegate an intent to its controller without embedding game rules.

### Controllers

* Are thin adapters from panel state to an existing system.
* Catch no gameplay decisions; systems remain the source of validation.
* Do not communicate with views directly and do not publish gameplay events.
* Surface invalid actions through the existing notification/event path.

### Systems and logic

* Remain the owner of gameplay mutations and validation.
* Publish domain events only after a completed state change.
* Do not depend on Swing panel or drawing classes.

## Refresh and Events

* A UI action follows `Panel -> State -> Controller -> System`.
* A completed game change follows `System -> EventBus -> Listener/ViewState ->
  AnimationManager.refresh() -> Panel.refresh()/repaint()`.
* Add a new event only when another subsystem or the presentation layer needs
  to react to a completed domain change.
* Do not use UI refresh events as replacements for gameplay events.

## SOLID Checklist

Before adding a panel, verify:

1. The panel has one visual purpose.
2. The state has one panel/view-model purpose.
3. The controller delegates to one or more existing systems without rules.
4. A new unit/building/tribe panel extends the existing panel registry rather
   than changing unrelated panels.
5. Rendering can be tested by supplying State values, without needing a live
   game mutation.

## Naming and Placement

* Panels: `Game.Client.Views.<Feature>.XxxPanel`
* States: next to their panel when feature-specific; shared display state goes
  in `Game.Client.Presentation`.
* Controllers: `Game.Server.Controller.XxxController`
* Rendering helpers: `Game.Client.Drawers` or `Models.Draw`, depending on the
  existing drawing responsibility.

Keep changes small and follow the existing package structure; do not introduce
a second UI event bus, framework, or architectural pattern.
