package Models.Logic.Happiness;

import Game.World;

public class GoldenAge extends HappinessState{
    public GoldenAge(World world) {
        super(world);
    }

    @Override
    public void effect() {
        addGoldenAgeProductionBonus();
    }

    @Override
    public boolean check() {
        return world.getHappiness() >= 3;
    }

    @Override
    public String getLabel() {
        return "Golden Age";
    }
}