package Models.Logic.TribeLogic;

import Game.World;
import Models.Elements.Resources.*;
import Models.Logic.Logic;

import Models.Elements.Tribes.Tribe;

public class Gift extends Logic {
    private final Class<? extends Resource> giftType;
    private final int amount;

    public Gift(Class<? extends Resource> giftType, int amount , World world) {
        super(world);
        this.giftType = giftType;
        this.amount = amount;

    }
    public void check(){
        if (amount <= 0) throw new IllegalArgumentException("Gift amount must be positive");
        if (world.getResourceRecord().getAll(giftType).size() < amount)
            throw new IllegalStateException("Not enough " + giftType.getSimpleName() + " for this gift");
    }
    public void effect(Tribe tribe){
        check();
        for (int i = 0; i < amount; i++) world.getResourceRecord().remove(world.getResourceRecord().getAll(giftType).get(0));
        int relationGain = giftType == Iron.class ? amount / 5 * 3
                : giftType == Stone.class ? amount / 10 * 3 : amount / 10 * 2;
        tribe.changeRelationship(relationGain);
    }
}
