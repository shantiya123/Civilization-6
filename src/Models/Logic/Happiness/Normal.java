package Models.Logic.Happiness;

import Game.World;

public class Normal extends HappinessState{
    public Normal(World world) {
        super(world);
    }

    @Override
    public boolean check() {
        return world.getHappiness() >= -2 && world.getHappiness() <= 2;
    }

    @Override
    public void effect() {

    }
}
