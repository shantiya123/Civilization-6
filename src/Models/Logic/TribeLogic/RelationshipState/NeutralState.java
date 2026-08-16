package Models.Logic.TribeLogic.RelationshipState;

import Game.World;
import Models.Elements.Tribes.Tribe;
import Models.Logic.TribeLogic.Gift;
import Models.Logic.TribeLogic.Decisions.TribeDecisionType;
import java.util.List;

public class NeutralState extends RelationshipState {
    public NeutralState(World world, Tribe tribe) { super(world, tribe); }
    @Override public boolean check() { return tribe.getRelationship() >= -19 && tribe.getRelationship() <= 19; }
    @Override public void sendGifts() { behavior().SendGifts(); }
    @Override public void sendGift(Gift gift) { behavior().sendGift(gift); }
    @Override public void declareWar() { behavior().declareWar(); }
    @Override public List<TribeDecisionType> availableDecisions() {
        return List.of(TribeDecisionType.GENERATE_GUARD, TribeDecisionType.IDLE);
    }
}
