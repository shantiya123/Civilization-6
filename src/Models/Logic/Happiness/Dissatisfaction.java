package Models.Logic.Happiness;

import Game.World;

public class Dissatisfaction extends HappinessState{
    public Dissatisfaction(World world) {
        super(world);
    }

    @Override
    public boolean check() {
        return world.getHappiness() == -3 || world.getHappiness() == -4;
    }

    @Override
    public void effect() {
        applyWorkerProductionPenalty();
    }
}
