package Models.Logic.Happiness;

import Game.World;
import Models.Elements.Units.Unit;
import Models.Elements.Units.Worker;
import Models.Elements.Units.CombatUnits.CombatUnit;

public class Riot extends HappinessState{
    public Riot(World world) {
        super(world);
    }

    @Override
    public boolean check() {
        return world.getHappiness() <= -5;
    }

    @Override
    public void effect() {
        applyWorkerProductionPenalty();
        for (Unit unit : world.getUnitRecord().getAll()) {
            if (unit instanceof Worker || unit instanceof CombatUnit) {
                unit.setAP(Math.max(0, unit.getAP() - 1));
            }
        }
    }

    @Override
    public String getLabel() {
        return "Riot";
    }
}