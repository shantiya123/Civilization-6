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
        if (giftType != Food.class && giftType != Wood.class && giftType != Stone.class && giftType != Iron.class)
            throw new IllegalArgumentException("Only Food, Wood, Stone, and Iron can be gifted");
        if (world.getResourceRecord().getAll(giftType).size() < amount)
            throw new IllegalStateException("Not enough " + giftType.getSimpleName() + " for this gift");
    }
    public void effect(Tribe tribe){
        check();
        for (int i = 0; i < amount; i++) world.getResourceRecord().remove(world.getResourceRecord().getAll(giftType).get(0));
        int relationGain = tribe.getDiplomacyPolicy().gift(giftType, amount);
        RelationshipChangeService.apply(tribe,
                new RelationshipChange(RelationshipChangeReason.GIFT, relationGain));
    }
}
