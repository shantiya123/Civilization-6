
# combatUnits.md

## 1. Context & Architecture Scope

* **Target Engine**: Terra 5.6 (Light Mode Framework).
* **Domain Context**: Single-player turn-based strategy simulation.
* **Scope Exclusions**: Network/Player IDs, NPC/Factions (Barbarians, Animals), Siege mechanics (Catapults), and multi-tenant persistence are omitted.
* **Core Inheritance Hierarchy**:

```
Unit (Abstract Base)
 └── CombatUnit (Abstract Class)
      ├── Swordsman
      ├── Archer
      └── Cavalry

Prerequisite (Abstract Base)
 ├── SwordsmanPrerequisite
 ├── ArcherPrerequisite
 └── CavalryPrerequisite

```

---

## 2. Prerequisite Polymorphic Framework

The `Prerequisite` structure enforces construction and unlock criteria via lightweight polymorphism.

```java
package models.elements.units.prerequisites;

public abstract class Prerequisite {
    
    /**
     * Evaluates structural, technological, or civic availability.
     * @return true if unit generation criteria are met; false otherwise.
     */
    public abstract boolean check();
}

```

### Concrete Subclass Stubs (`TODO` Implementation)

* **`SwordsmanPrerequisite`**: Evaluates Town Hall Level 1 availability.


* **`ArcherPrerequisite`**: Evaluates Town Hall Level 2 availability.


* **`CavalryPrerequisite`**: Evaluates Town Hall Level 2 and Stable building presence.



---

## 3. Abstract Class: `CombatUnit`

Base domain model for military units engaging in map navigation and direct unit-vs-unit engagement.

```java
package models.elements.units;

import models.elements.Unit;
import models.elements.units.prerequisites.Prerequisite;
import java.util.Map;

public abstract class CombatUnit extends Unit {
    
    protected int combatPower;
    protected int attackRange;
    protected AttackType attackType;
    protected Prerequisite prerequisite;
    protected Map<Class<? extends Unit>, Integer> makingCost;

    public CombatUnit(
        int maxHp, 
        int maxAp, 
        int combatPower, 
        int attackRange, 
        AttackType attackType, 
        Prerequisite prerequisite, 
        Map<Class<? extends Unit>, Integer> makingCost
    ) {
        super(maxHp, maxAp);
        this.combatPower = combatPower;
        this.attackRange = attackRange;
        this.attackType = attackType;
        this.prerequisite = prerequisite;
        this.makingCost = makingCost;
    }

    // Getters & Setters
    public int getCombatPower() { return combatPower; }
    public int getAttackRange() { return attackRange; }
    public AttackType getAttackType() { return attackType; }
    public Prerequisite getPrerequisite() { return prerequisite; }
    public Map<Class<? extends Unit>, Integer> getMakingCost() { return makingCost; }
}

```

---

## 4. Concrete Unit Declarations & Data Parameters

| Concrete Class | HP | AP | Combat Power | Attack Range | Attack Type | Prerequisite | Making Cost Mapping |
| --- | --- | --- | --- | --- | --- | --- | --- |
| **`Swordsman`** | 1* | 2 | 10 | 1 | `MELEE` | `SwordsmanPrerequisite` | `Map<Class<? Unit extends>, Integer>` (20 Food, 10 Wood equivalent)

|
| **`Archer`** | 1* | 2 | 6 | 2 | `RANGED` | `ArcherPrerequisite` | `Map<Class<? Unit extends>, Integer>` (25 Food, 15 Wood equivalent)

|
| **`Cavalry`** | 2* | 4 | 8 | 1 | `MELEE` | `CavalryPrerequisite` | `Map<Class<? Unit extends>, Integer>` (40 Food, 20 Iron equivalent)

|

**HP Metric*: Denotes base hit-count instances for standard dice-based combat calculations.

---

## 5. Hex Multi-Occupancy Rules

Spatial validation inside `Hex` models must enforce strict unit stacking limits per tile instance:

```
Max Stack Capacity per Single Hex:
├── Swordsman : <= 2 instances
├── Archer    : <= 2 instances
└── Cavalry   : <= 1 instance

```

---

## 6. Type Definitions (`AttackType.java`)

```java
package models.elements.units;

public enum AttackType {
    MELEE,
    RANGED
}

```