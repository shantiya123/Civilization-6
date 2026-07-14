package Models.Logic.BuildingLogic;

import Models.Elements.Buildings.TownHall;
import Models.Elements.Units.Unit;

public class TownHallGenerateUnit {
    private final TownHall townHall;

    private Unit unit;

    private int totalStep;
    private int step;

    private boolean Finished = true;

    public TownHallGenerateUnit(TownHall townHall) {
        this.townHall = townHall;
    }

    public void startGeneration(Unit unit) throws Exception {
        if (!isFinished())
            throw new Exception("Town Hall hasn't finished it's last creation");
        this.unit = unit;
        this.totalStep = unit.getCreationSteps();
        step = 0;
        Finished = false;   // <-- missing line
    }

    public void newTurn() throws Exception {
        step++;
        Check();
    }

    private void Check() throws Exception {
        if (step >= totalStep) {
            new TownHallLogic(townHall).produceUnit(unit.getClass());
            unit = null;
            Finished = true;
            step = 0;
        }
    }

    public boolean isFinished() {
        return Finished;
    }

    public Unit getUnit() {
        return unit;
    }

    public int getStep() {
        return step;
    }

    public int getTotalStep() {
        return totalStep;
    }
}