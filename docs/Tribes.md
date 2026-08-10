
---

# `Tribes.md`

## Architecture Overview

The Tribal System is designed around four decoupled software design patterns:

1. **State Pattern** (`RelationState`) for diplomatic permission control.
2. **Command Pattern** (`TribeInteraction`) to encapsulate action data.
3. **Specification / Strategy Pattern** (`InteractionValidator`) to check game-rule prerequisites.
4. **Strategy Pattern** (`TribeBehavior`) for tribe-specific execution logic.

---

## Architecture Flow

```
Controller / UI
       │
       ▼
tribe.interact(interaction)
       │
       ▼
1. RelationState Check  ──(Throws exception if forbidden by relationship state)
       │
       ▼
2. Validator Check      ──(Throws exception or returns false if prerequisites fail)
       │
       ▼
3. interaction.action()
       │
       ▼
4. TribeBehavior        ──(Executes tribe-specific tribeAction & algorithms)

```

---

## Module Specifications

### 1. Tribe Model (`Tribe.java`)

The primary entity representing a tribal faction on the game map.

```java
package Models.Elements.Tribes;

import Models.Elements.Tribes.Behaviors.TribeBehavior;
import Models.Elements.Tribes.Interactions.*;
import Models.Elements.Tribes.States.*;

public class Tribe {

    private String name;
    private RelationState relationState;
    private TribeBehavior tribeAction;

    public Tribe(String name, TribeBehavior tribeAction) {
        this.name = name;
        this.tribeAction = tribeAction;
        this.relationState = new NeutralState(); // Default relationship
    }

    // Getters and Setters
    public RelationState getRelationState() { return relationState; }
    public void setRelationState(RelationState relationState) { this.relationState = relationState; }
    public TribeBehavior getBehavior() { return tribeAction; }

    // Interaction Delegation Pipeline
    public void interact(TradeInteraction interaction) {
        relationState.trade(interaction);
    }

    public void interact(SendGiftInteraction interaction) {
        relationState.sendGift(interaction);
    }

    public void interact(RequestMissionInteraction interaction) {
        relationState.requestMission(interaction);
    }

    public void interact(DeclareWarInteraction interaction) {
        relationState.declareWar(interaction);
    }

    public void interact(RequestPeaceInteraction interaction) {
        relationState.requestPeace(interaction);
    }
}

```

---

### 2. Base Interaction & Structural Subclasses

#### `TribeInteraction.java`

```java
package Models.Elements.Tribes.Interactions;

import Models.Elements.Tribes.Tribe;
import Models.Elements.Tribes.Validators.InteractionValidator;

public abstract class TribeInteraction {

    protected final Tribe tribe;

    public TribeInteraction(Tribe tribe) {
        this.tribe = tribe;
    }

    public Tribe getTribe() {
        return tribe;
    }

    public abstract InteractionValidator getValidator();
    public abstract void action();
}

```

#### Concrete Interaction Classes (Structure Stubs)

* `TradeInteraction.java`
* `SendGiftInteraction.java`
* `RequestMissionInteraction.java`
* `DeclareWarInteraction.java`
* `RequestPeaceInteraction.java`

```java
package Models.Elements.Tribes.Interactions;

import Models.Elements.Tribes.Tribe;
import Models.Elements.Tribes.Validators.*;

public class TradeInteraction extends TribeInteraction {

    public TradeInteraction(Tribe tribe) {
        super(tribe);
    }

    @Override
    public InteractionValidator getValidator() {
        return new TradeValidator();
    }

    @Override
    public void action() {
        if (!getValidator().validate(this)) {
            throw new IllegalStateException("Trade prerequisites not met!");
        }
        tribe.getBehavior().handleTrade(this);
    }
}

```

---

### 3. Interaction Validators (`InteractionValidator`)

Validates prerequisites (resources, ranges, active units) before executing the interaction command.

#### `InteractionValidator.java` (Interface / Abstract Class)

```java
package Models.Elements.Tribes.Validators;

import Models.Elements.Tribes.Interactions.TribeInteraction;

public interface InteractionValidator<T extends TribeInteraction> {
    boolean validate(T interaction);
}

```

#### Concrete Validators (Empty logic structures for the Logic Phase)

```java
package Models.Elements.Tribes.Validators;

import Models.Elements.Tribes.Interactions.TradeInteraction;

public class TradeValidator implements InteractionValidator<TradeInteraction> {

    @Override
    public boolean validate(TradeInteraction interaction) {
        // TODO: Implement logic check (e.g., player has enough resources, tribe has stock)
        return true;
    }
}

```

---

### 4. Diplomatic Relation States (`RelationState`)

Base state delegates through the validation and action lifecycle. Concrete states override forbidden methods to throw `IllegalStateException`.

#### `RelationState.java`

```java
package Models.Elements.Tribes.States;

import Models.Elements.Tribes.Interactions.*;

public abstract class RelationState {

    public void trade(TradeInteraction interaction) {
        interaction.action();
    }

    public void sendGift(SendGiftInteraction interaction) {
        interaction.action();
    }

    public void requestMission(RequestMissionInteraction interaction) {
        interaction.action();
    }

    public void declareWar(DeclareWarInteraction interaction) {
        interaction.action();
    }

    public void requestPeace(RequestPeaceInteraction interaction) {
        interaction.action();
    }
}

```

#### State Subclasses:

* `EnemyState.java` – Forbids `trade`, `sendGift`, `requestMission`.
* `DispleasedState.java` – Forbids `trade`, `requestMission`.
* `NeutralState.java` – Forbids `requestMission`, `requestPeace`.
* `FriendlyState.java` – Forbids `requestPeace`.
* `AlliedState.java` – Forbids `requestPeace`.

---

### 5. Behavioral Strategies (`TribeBehavior`)

Defines unique outputs per tribal archetype.

```java
package Models.Elements.Tribes.Behaviors;

import Models.Elements.Tribes.Interactions.*;

public interface TribeBehavior {
    void handleTrade(TradeInteraction interaction);
    void handleGift(SendGiftInteraction interaction);
    void handleMission(RequestMissionInteraction interaction);
    void handleWar(DeclareWarInteraction interaction);
    void handlePeace(RequestPeaceInteraction interaction);
}

```

#### Concrete Archetypes:

* `AggressiveTribeBehavior.java`
* `MerchantTribeBehavior.java`
* `IsolationistTribeBehavior.java`