package Models.Logic.TribeLogic.RelationshipState;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.Gift;

public class DispleasedState extends RelationshipState {
    public DispleasedState(World world, Tribe tribe) {
        super(world, tribe); }

    @Override public boolean check() {
        return tribe.getRelationship() >= -49 && tribe.getRelationship() <= -20; }

    @Override public void sendGifts() {
        behavior().SendGifts(); }
    @Override public void sendGift(Gift gift) { behavior().sendGift(gift); }


    @Override public void declareWar() {
        behavior().declareWar(); }
}
