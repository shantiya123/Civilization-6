package Models.Logic.Happiness;

import Game.World;
import Models.Elements.Buildable.Buildings.Building;
import Models.Elements.Buildable.Buildings.Monument;
import Models.Elements.Buildable.Buildings.Settlement;
import Models.Elements.Units.CombatUnits.CombatUnit;
import Models.Elements.Units.Unit;
import Models.Logic.Logic;

/** Owns Phase 2 Happiness events and the end-of-turn Happiness-state effect. */
public final class HappinessLogic extends Logic {
    public HappinessLogic(World world) { super(world); }

    /** Construction effects occur once, at the moment a building is completed. */
    public void onBuildingConstructed(Building building) {
        if (building instanceof Settlement) change(-1);
    }

    /** Reaching—not remaining at—the global combat-unit cap causes one immediate penalty. */
    public void onCombatUnitProduced() {
        if (combatUnitCount() == world.getCombatUnitCap()) change(-1);
    }

    /** Applies ongoing amenities and then the current Happiness tier exactly once per turn. */
    public void applyEndOfTurn() {
        int monumentCount = world.getBuildingRecord().getAll(Monument.class).size();
        change(monumentCount * 2);
        if (hasCombatUnitInTownHall()) change(1);
        currentState().effect();
    }

    public void change(int amount) { world.setHappiness(world.getHappiness() + amount); }

    public int combatUnitCount() {
        int count = 0;
        for (Unit unit : world.getUnitRecord().getAll()) if (unit instanceof CombatUnit) count++;
        return count;
    }

    private boolean hasCombatUnitInTownHall() {
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (unit instanceof CombatUnit && unit.getHex() == world.getTownHall().getHex()) return true;
        }
        return false;
    }

    /** HUD-facing label for whichever Happiness tier the current total falls into. */
    public String getCurrentStateLabel() {
        return currentState().getLabel();
    }

    private HappinessState currentState() {
        HappinessState goldenAge = new GoldenAge(world);
        if (goldenAge.check()) return goldenAge;
        HappinessState dissatisfaction = new Dissatisfaction(world);
        if (dissatisfaction.check()) return dissatisfaction;
        HappinessState riot = new Riot(world);
        if (riot.check()) return riot;
        return new Normal(world);
    }
}